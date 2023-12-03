package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.Optional;


public class ControllerPantallaLucha {

    private ControllerPantallaSeleccion ventana1Controller;
    ControllerGraficos controlDanio;

    @FXML
    public Label idNombre;

    @FXML
    public Label idNombreRival;

    @FXML
    public ImageView idImagen;

    @FXML
    public ImageView idImagenRival;

    @FXML
    public ImageView idGenero;

    @FXML
    public ImageView idGeneroRival;

    @FXML
    public GridPane idLayout;

    @FXML
    public Label idNivel;

    @FXML
    public Label idNivelRival;

    @FXML
    public ProgressBar idPb;

    @FXML
    public ProgressBar idPbRival;

    @FXML
    public Button atacar;

    @FXML
    public Button curar;

    @FXML
    public Label idPS;

    @FXML
    public Label idPSRival;

    @FXML
    public Button idAtaque1;

    @FXML
    public Button idAtaque2;

    @FXML
    public Button idAtaque3;

    @FXML
    public Button idCancelar;

    public static int vidaPokemon;
    public static int vidaTotalPokemon;
    public static int vidaPokemonRival;
    public static int vidaTotalPokemonRival;
    public static double danioTotalAmigo;
    public static double danioTotalRival;


    public void initialize(){
        idPbRival.setStyle("-fx-accent: green");
        if(vidaPokemonRival == vidaTotalPokemonRival){
            idPbRival.setProgress(1);
        }else{
            idPbRival.setProgress((double)vidaPokemonRival/100);
            cambioColorPb();
        }

        idAtaque1.setVisible(false);
        idAtaque2.setVisible(false);
        idAtaque3.setVisible(false);
        idCancelar.setVisible(false);


    }

    public void mandarInfoDesdeVentana(Pokemon pokemon,Pokemon pokemonRival, Image imagenRecibida) {
        idNombre.setText(pokemon.getNombre());
        idImagen.setImage(imagenRecibida);
        if(pokemon.getGenero() == 'M'){
            idGenero.setImage(ControllerPantallaSeleccion.masculino);
        }
        else{
            idGenero.setImage(ControllerPantallaSeleccion.femenino);
        }
        idNivel.setText("Nv "+pokemon.getNivel());
        idPb.setStyle("-fx-accent: green");
        idNombreRival.setText(pokemonRival.getNombre());
        idNivelRival.setText("Nv "+pokemonRival.getNivel());
        if(pokemonRival.getGenero() == 'M'){
            idGeneroRival.setImage(ControllerPantallaSeleccion.masculino);
        }
        else{
            idGeneroRival.setImage(ControllerPantallaSeleccion.femenino);
        }
        vidaPokemon = pokemon.getVida();
        vidaTotalPokemon = pokemon.getVida_total();
        vidaPokemonRival = pokemonRival.getVida();
        vidaTotalPokemonRival = pokemonRival.getVida_total();



    }

    public void setVentana1(ControllerPantallaSeleccion ventana1){
        ventana1Controller = ventana1;
        ventana1Controller.recibirInformacion(vidaPokemon, vidaPokemonRival, idPb.getProgress());

    }


    @FXML
    private void botonAtacar(){
        idAtaque1.setVisible(true);
        idAtaque2.setVisible(true);
        idAtaque3.setVisible(true);
        idCancelar.setVisible(true);
        atacar.setVisible(false);
        curar.setVisible(false);
    }

    private void ataque (String ataque, double vidaQuitar, double vidaQuitarRival) throws IOException {
        if(vidaPokemonRival>0) {
            double progressRival = idPbRival.getProgress();
            int vidaRival = (int) (vidaPokemonRival - vidaQuitar);
            if(vidaRival <= 0){
                vidaPokemonRival=0;
                idPbRival.setProgress(0);
                danioTotalRival+=vidaQuitar;
                System.out.println("El daño total que ha recibido el rival es "+danioTotalRival);
                System.out.println("Has hecho un "+ataque+", la vida del rival ha bajado "+vidaQuitar+" PS");
                System.out.println("El Pokemon Rival se ha debilitado");
                Alert customAlert = new Alert(Alert.AlertType.NONE);
                customAlert.setTitle("¡Enhorabuena!");
                customAlert.setHeaderText(idNombreRival.getText()+" ha sido debilitado");
                customAlert.getDialogPane().setGraphic(idImagenRival);
                customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH);
                showAlert(customAlert);
            }else {
                vidaPokemonRival=vidaRival;
                idPbRival.setProgress(progressRival - (vidaQuitar/100));
                danioTotalRival+=vidaQuitar;
                System.out.println("El daño total que ha recibido el rival es "+danioTotalRival);
                System.out.println("Has hecho un "+ataque+", la vida del rival ha bajado "+vidaQuitar+" PS");
                if(vidaPokemon > 0) {
                    double progress = idPb.getProgress();
                    vidaPokemon -= vidaQuitarRival;
                    if(vidaPokemon <= 0){
                        vidaPokemon=0;
                        idPb.setProgress(0);
                        setVentana1(ventana1Controller);
                        danioTotalAmigo+=vidaQuitarRival;
                        System.out.println("El Pokemon Rival te ha hecho un "+ataque+", tu vida ha bajado " +vidaQuitarRival+" PS");
                        System.out.println("Tu Pokemon se ha debilitado");
                        Alert customAlert = new Alert(Alert.AlertType.NONE);
                        customAlert.setTitle("Pokemon debilitado");
                        customAlert.setHeaderText(idNombre.getText()+" ha sido debilitado");
                        customAlert.getDialogPane().setGraphic(idImagen);
                        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.PREVIOUS);
                        showAlert(customAlert);
                    }else {
                        idPb.setProgress(progress - (vidaQuitarRival/100));
                        danioTotalAmigo+=vidaQuitarRival;
                        System.out.println("El Pokemon Rival te ha hecho un "+ataque+", tu vida ha bajado " +vidaQuitarRival+" PS");
                        setVentana1(ventana1Controller);
                    }
                }
            }
        }
        controlDanio.recibirDatosDanios(danioTotalAmigo, danioTotalRival);
        cambioColorPb();
    }

    @FXML
    private void ataqueSeguro() throws IOException {
        ataque("Ataque Seguro", 20, 20);
    }

    @FXML
    private void ataqueArriesgado() throws IOException {
        double ataqueAleatorio = Math.floor(Math.random()*(25-10+1)+10);
        double ataqueAleatorioRival = Math.floor(Math.random()*(25-10+1)+10);
        ataque("Ataque Arriesgado", ataqueAleatorio, ataqueAleatorioRival);
    }

    @FXML
    private void ataqueMuyArriesgado() throws IOException {
        double ataqueAleatorio = Math.floor(Math.random()*(50+1)+0);
        double ataqueAleatorioRival = Math.floor(Math.random()*(50+1)+0);
       ataque("Ataque muy Arriesgado", ataqueAleatorio, ataqueAleatorioRival);
    }

    private void showAlert(Alert alert) throws IOException {
        Optional<ButtonType> resultado = alert.showAndWait();
        if(resultado.isEmpty()) {
            System.out.println("Ha presionado la X");
        } else if(resultado.get() == ButtonType.PREVIOUS) {
            //Esto vuelve a la pantalla inicial, pero la carga de nuevo no sé como volver a la anterior con la informacion cambiada
            /*Parent root = FXMLLoader.load(getClass().getResource("PantallaSeleccion.fxml"));
            Scene newScene = new Scene(root);
            Main.getStage().setScene(newScene);*/
        } else if (resultado.get() == ButtonType.FINISH) {
            Platform.exit();
        } else {
            System.out.println("Resultado = OTROS: " + resultado.get().getText());
        }
    }

    private void cambioColorPb(){
        if(idPb.getProgress()<=0.6 && idPb.getProgress()>=0.25){
            idPb.setStyle("-fx-accent: yellow");
        }else
        if(idPb.getProgress()<0.25 && idPb.getProgress()>0){
            idPb.setStyle("-fx-accent: red");

        }else{
            idPb.setStyle("-fx-accent: green");
        }

        if(idPbRival.getProgress()<=0.6 && idPbRival.getProgress()>=0.25){
            idPbRival.setStyle("-fx-accent: yellow");
        }else
        if(idPbRival.getProgress()<0.25 && idPbRival.getProgress()>0){
            idPbRival.setStyle("-fx-accent: red");

        }else{
            idPbRival.setStyle("-fx-accent: green");
        }
    }

    @FXML
    private void cancelar(){
        idAtaque1.setVisible(false);
        idAtaque2.setVisible(false);
        idAtaque3.setVisible(false);
        idCancelar.setVisible(false);
        atacar.setVisible(true);
        curar.setVisible(true);
    }

    @FXML
    private void botonCurar(){
        //Cura Pokemon
        var vidaAleatoria = Math.floor(Math.random()*(75-25+1)+25);
        double progress = idPb.getProgress();
        double progressRival = idPbRival.getProgress();
        if (vidaPokemon < vidaTotalPokemon){
            //Para que la vida nunca sea mayor que la vidaTotal
            double vidaASumar = vidaTotalPokemon - vidaPokemon;
            if(vidaASumar < vidaAleatoria){
                vidaPokemon += vidaASumar;
                idPb.setProgress(progress+(vidaASumar/100));
                setVentana1(ventana1Controller);
                System.out.println("Tu Pokemon ha recuperado "+vidaASumar+" PS");
            }else{
                vidaPokemon += vidaAleatoria;
                idPb.setProgress(progress+(vidaAleatoria/100));
                setVentana1(ventana1Controller);
                System.out.println("Tu Pokemon ha recuperado "+vidaAleatoria+" PS");
            }
        }else{
            System.out.println("Los PS del Pokemon ya están al máximo");
        }
        //Cura PokemonRival
        vidaAleatoria = Math.floor(Math.random()*(75-25+1)+25);
        if (vidaPokemonRival < vidaTotalPokemonRival){
            //Para que la vida nunca sea mayor que la vidaTotal
            int vidaASumar = (int)(vidaTotalPokemonRival - vidaPokemonRival);
            if(vidaASumar < vidaAleatoria){
                vidaPokemonRival+=vidaASumar;
                idPbRival.setProgress(progressRival+((double)vidaASumar/100));
                System.out.println("El Pokemon Rival ha recuperado "+vidaASumar+" PS");
            }else{
                vidaPokemonRival+=vidaAleatoria;
                idPbRival.setProgress(progressRival+(vidaAleatoria/100));
                System.out.println("El Pokemon Rival ha recuperado "+vidaAleatoria+" PS");
            }
        }else{
            System.out.println("Los PS del Pokemon ya están al máximo");
        }
        cambioColorPb();
    }

    @FXML
    private void mostrarVida(){
        idPS.setText(String.valueOf(vidaPokemon));
    }

    @FXML
    private void mostrarPS(){
        idPS.setText("PS");
    }

    @FXML
    private void mostrarVidaRival(){
        idPSRival.setText(String.valueOf(vidaPokemonRival));
    }

    @FXML
    private void mostrarPSRival(){
        idPSRival.setText("PS");
    }
}
