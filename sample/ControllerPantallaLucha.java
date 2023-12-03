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

/**
 * Controlador para la pantalla de combate del juego.
 */

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
    
    // Variables para el seguimiento de la información de vida y daño.

    public static int vidaAliado;
    public static int vTotalAliado;
    public static int vidaEnemigo;
    public static int vTotalEnemigo;
    public static double danioTotalAmigo;
    public static double danioTotalRival;

    /**
     * Inicializa la pantalla de combate.
     */
    
    public void initialize(){
        idPbRival.setStyle("-fx-accent: green");
        if(vidaEnemigo== vTotalEnemigo){
            idPbRival.setProgress(1);
        }else{
            idPbRival.setProgress((double)vidaEnemigo/100);
            cambioColorPb();
        }

        idAtaque1.setVisible(false);
        idAtaque2.setVisible(false);
        idAtaque3.setVisible(false);
        idCancelar.setVisible(false);

    }
    
    /**
     * Método para recibir información de la ventana de selección de personajes.
     *
     * @param personaje Personaje seleccionado por el jugador.
     * @param enemigo   Enemigo al que se enfrentará el jugador.
     * @param imgn      Imagen del personaje seleccionado.
     */
    
    public void mandarInfoDesdeVentana(Raza personaje,Raza enemigo, Image imgn) {
        idNombre.setText(personaje.getNombre());
        idImagen.setImage(imgn);
        if(personaje.getGenero() == 'M'){
            idGenero.setImage(ControllerPantallaSeleccion.masculino);
        }
        else{
            idGenero.setImage(ControllerPantallaSeleccion.femenino);
        }
        idNivel.setText("Nv "+personaje.getNivel());
        idPb.setStyle("-fx-accent: green");
        idNombreRival.setText(enemigo.getNombre());
        idNivelRival.setText("Nv "+enemigo.getNivel());
        if(enemigo.getGenero() == 'M'){
            idGeneroRival.setImage(ControllerPantallaSeleccion.masculino);
        }
        else{
            idGeneroRival.setImage(ControllerPantallaSeleccion.femenino);
        }
        vidaAliado = personaje.getVida();
        vTotalAliado = personaje.getVida_total();
        vidaEnemigo = enemigo.getVida();   
        vTotalEnemigo = enemigo.getVida_total();
    }
    
    /**
     * Establece el controlador de la ventana de selección.
     *
     * @param ventana1 Controlador de la ventana de selección.
     */
    
    public void setVentana1(ControllerPantallaSeleccion ventana1){
        ventana1Controller = ventana1;
        ventana1Controller.recibirInformacion(vidaAliado, vidaEnemigo, idPb.getProgress());

    }

    /**
     * Maneja el evento del botón de ataque, mostrando las opciones de ataque.
     */
    
    @FXML
    private void botonAtacar(){
        idAtaque1.setVisible(true);
        idAtaque2.setVisible(true);
        idAtaque3.setVisible(true);
        idCancelar.setVisible(true);
        atacar.setVisible(false);
        curar.setVisible(false);
    }
    
    /**
     * Realiza un ataque con un nombre específico y valores de daño.
     *
     * @param ataque         Nombre del ataque.
     * @param vidaQuitar     Cantidad de vida a quitar al enemigo.
     * @param vidaQuitarRival Cantidad de vida a quitar al aliado.
     * @throws IOException Excepción de E/S.
     */
    
    private void ataque (String ataque, double vidaQuitar, double vidaQuitarRival) throws IOException {
        if(vidaEnemigo>0) {
            double progressRival = idPbRival.getProgress();
            int vidaRival = (int) (vidaEnemigo - vidaQuitar);
            if(vidaRival <= 0){
                vidaEnemigo=0;
                idPbRival.setProgress(0);
                danioTotalRival+=vidaQuitar;
                System.out.println("El daño total que ha recibido el rival es "+danioTotalRival);
                System.out.println("Has hecho un "+ataque+", la vida del rival ha bajado "+vidaQuitar);
                System.out.println("El enemigo se ha debilitado");
                Alert customAlert = new Alert(Alert.AlertType.NONE);
                customAlert.setTitle("¡Enhorabuena!");
                customAlert.setHeaderText(idNombreRival.getText()+" ha sido debilitado");
                customAlert.getDialogPane().setGraphic(idImagenRival);
                customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH);
                showAlert(customAlert);
            }else {
                vidaEnemigo=vidaRival;
                idPbRival.setProgress(progressRival - (vidaQuitar/100));
                danioTotalRival+=vidaQuitar;
                System.out.println("El daño total que ha recibido el rival es "+danioTotalRival);
                System.out.println("Has hecho un "+ataque+", la vida del rival ha bajado "+vidaQuitar+" PS");
                if(vidaAliado > 0) {
                    double progress = idPb.getProgress();
                    vidaAliado -= vidaQuitarRival;
                    if(vidaAliado <= 0){
                        vidaAliado=0;
                        idPb.setProgress(0);
                        setVentana1(ventana1Controller);
                        danioTotalAmigo+=vidaQuitarRival;
                        System.out.println("El enemigo te ha hecho un "+ataque+", tu vida ha bajado " +vidaQuitarRival);
                        System.out.println("Tu aliado se ha debilitado");
                        Alert customAlert = new Alert(Alert.AlertType.NONE);
                        customAlert.setTitle("Aliado debilitado");
                        customAlert.setHeaderText(idNombre.getText()+" ha sido debilitado");
                        customAlert.getDialogPane().setGraphic(idImagen);
                        customAlert.getDialogPane().getButtonTypes().addAll(ButtonType.FINISH, ButtonType.PREVIOUS);
                        showAlert(customAlert);
                    }else {
                        idPb.setProgress(progress - (vidaQuitarRival/100));
                        danioTotalAmigo+=vidaQuitarRival;
                        System.out.println("El Raza Rival te ha hecho un "+ataque+", tu vida ha bajado " +vidaQuitarRival+" PS");
                        setVentana1(ventana1Controller);
                    }
                }
            }
        }
        controlDanio.recibirDatosDanios(danioTotalAmigo, danioTotalRival);
        cambioColorPb();
    }
  
    /**
     * Maneja el evento del botón de ataque cuerpo a cuerpo.
     *
     * @throws IOException Excepción de E/S.
     */
    
    @FXML
    private void ataqueCuerpoACuerpo() throws IOException {
        ataque("Ataque Cuerpo a cuerpo", 20, 20);
    }

    /**
     * Maneja el evento del botón de ataque a distancia.
     *
     * @throws IOException Excepción de E/S.
     */
    
    @FXML
    private void ataqueADistancia() throws IOException {
        double ataqueAleatorio = Math.floor(Math.random()*(25-10+1)+10);
        double ataqueAleatorioRival = Math.floor(Math.random()*(25-10+1)+10);
        ataque("Ataque a distancia", ataqueAleatorio, ataqueAleatorioRival);
    }
    
    /**
     * Muestra un cuadro de diálogo personalizado.
     *
     * @param alert Cuadro de diálogo a mostrar.
     * @throws IOException Excepción de E/S.
     */

    private void showAlert(Alert alert) throws IOException {
        Optional<ButtonType> resultado = alert.showAndWait();
        if(!resultado.equals(resultado)) {
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
    
    /**
     * Cambia el color de la barra de progreso en función de su valor.
     */
    
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
    
    /**
     * Maneja el evento del botón de cancelar ataque, ocultando las opciones de ataque.
     */
    
    @FXML
    private void cancelar(){
        idAtaque1.setVisible(false);
        idAtaque2.setVisible(false);
        idAtaque3.setVisible(false);
        idCancelar.setVisible(false);
        atacar.setVisible(true);
        curar.setVisible(true);
    }

    /**
     * Maneja el evento del botón de curar, restaurando la vida de los personajes.
     */
    
    @FXML
    private void botonCurar(){
        //Cura Raza
        double vidaAleatoria = Math.floor(Math.random()*(75-25+1)+25);
        double progress = idPb.getProgress();
        double progressRival = idPbRival.getProgress();
        if (vidaAliado < vTotalAliado){
            //Para que la vida nunca sea mayor que la vidaTotal
            double vidaASumar = vTotalAliado - vidaAliado;
            if(vidaASumar < vidaAleatoria){
                vidaAliado += vidaASumar;
                idPb.setProgress(progress+(vidaASumar/100));
                setVentana1(ventana1Controller);
                System.out.println("Tu aliado ha recuperado "+vidaASumar+" PS");
            }else{
                vidaAliado += vidaAleatoria;
                idPb.setProgress(progress+(vidaAleatoria/100));
                setVentana1(ventana1Controller);
                System.out.println("Tu aliado ha recuperado "+vidaAleatoria+" PS");
            }
        }else{
            System.out.println("Los PS de la Raza ya están al máximo");
        }
        //Cura PokemonRival
        vidaAleatoria = Math.floor(Math.random()*(75-25+1)+25);
        if (vidaEnemigo < vTotalEnemigo){
            //Para que la vida nunca sea mayor que la vidaTotal
            int vidaASumar = (vTotalEnemigo - vidaEnemigo);
            if(vidaASumar < vidaAleatoria){
                vidaEnemigo+=vidaASumar;
                idPbRival.setProgress(progressRival+((double)vidaASumar/100));
                System.out.println("El enemigo ha recuperado "+vidaASumar+" PS");
            }else{
                vidaEnemigo+=vidaAleatoria;
                idPbRival.setProgress(progressRival+(vidaAleatoria/100));
                System.out.println("El enemigo ha recuperado "+vidaAleatoria+" PS");
            }
        }else{
            System.out.println("Los puntos de vida del aliado ya están al máximo");
        }
        cambioColorPb();
    }

    /**
     * Muestra la vida del aliado.
     */
    
    @FXML
    private void mostrarVida(){
        idPS.setText(String.valueOf(vidaAliado));
    }

    /**
     * Muestra el mensaje de puntos de vida.
     */
    
    @FXML
    private void mostrarPS(){
        idPS.setText("Puntos de vida");
    }
    
    /**
     * Muestra la vida del enemigo.
     */
    
    @FXML
    private void mostrarVidaRival(){
        idPSRival.setText(String.valueOf(vidaEnemigo));
    }
    
    /**
     * Muestra el mensaje de puntos de vida del enemigo.
     */
    
    @FXML
    private void mostrarPSRival(){
        idPSRival.setText("Puntos de vida");
    }
}
