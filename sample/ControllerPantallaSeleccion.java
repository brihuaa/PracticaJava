package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerPantallaSeleccion {

    @FXML
    public Button boton;

    @FXML
    public Label nombre;

    @FXML
    public Label nivel;

    @FXML
    public Label vida;

    @FXML
    public ImageView gen;

    @FXML
    public ProgressBar pb;

    @FXML
    public ImageView imagen;

    @FXML
    public Label nombre2;

    @FXML
    public Label nivel2;

    @FXML
    public Label vida2;

    @FXML
    public ImageView gen2;

    @FXML
    public ProgressBar pb2;

    @FXML
    public ImageView imagen2;

    @FXML
    public Label nombre3;

    @FXML
    public Label nivel3;

    @FXML
    public Label vida3;

    @FXML
    public ImageView gen3;

    @FXML
    public ProgressBar pb3;

    @FXML
    public ImageView imagen3;

    @FXML
    public Label nombre4;

    @FXML
    public Label nivel4;

    @FXML
    public Label vida4;

    @FXML
    public ImageView gen4;

    @FXML
    public ProgressBar pb4;

    @FXML
    public ImageView imagen4;

    @FXML
    public Label nombre5;

    @FXML
    public Label nivel5;

    @FXML
    public Label vida5;

    @FXML
    public ImageView gen5;

    @FXML
    public ProgressBar pb5;

    @FXML
    public ImageView imagen5;

    @FXML
    public Label nombre6;

    @FXML
    public Label nivel6;

    @FXML
    public Label vida6;

    @FXML
    public ImageView gen6;

    @FXML
    public ProgressBar pb6;

    @FXML
    public ImageView imagen6;

    @FXML
    public Label mensaje;

    @FXML
    public Button botonGraficos;

    private final Pokemon p = new Pokemon("Psyduck", 100, 100, 40, 'M');
    private final Pokemon p2 = new Pokemon("Meowth", 80, 80, 35, 'F');
    private final Pokemon p3 = new Pokemon("Snorlax", 350, 350,70, 'M');
    private final Pokemon p4 = new Pokemon("Bulbasaur", 95, 95,42, 'M');
    private final Pokemon p5 = new Pokemon("Pikachu", 105, 105,50, 'M');
    private final Pokemon p6 = new Pokemon("Rattata", 87,87, 38, 'F');
    Pokemon pokemonRival = new Pokemon("Dratini", 100,100, 60, 'F');

    public boolean psyduckSeleccionado = false;
    public boolean meowthSeleccionado = false;
    public boolean snorlaxSeleccionado = false;
    public boolean bulbasaurSeleccionado = false;
    public boolean pikachuSeleccionado = false;
    public boolean rattataSeleccionado = false;

    public static Image masculino = new Image("img/masculino.png");
    public static Image femenino =  new Image("img/hembra.png");


    public static int cont;
    public static int cont2;
    public static int cont3;
    public static int cont4;
    public static int cont5;
    public static int cont6;



    @FXML
    public void initialize(){
        //Pokemon 1
        datosPokemon(nombre, nivel, vida, gen, pb, p);
        //Pokemon 2
        datosPokemon(nombre2, nivel2, vida2, gen2, pb2, p2);
        //Pokemon 3
        datosPokemon(nombre3, nivel3, vida3, gen3, pb3, p3);
        //Pokemon 4
        datosPokemon(nombre4, nivel4, vida4, gen4, pb4, p4);
        //Pokemon 5
        datosPokemon(nombre5, nivel5, vida5, gen5, pb5, p5);
        //Pokemon 6
        datosPokemon(nombre6, nivel6, vida6, gen6, pb6, p6);

        mensaje.setText("Elige un Pokemon");

    }


    @FXML
    private void clickBotonGraficos () throws IOException {
        //Solo se actualizan los graficos al darle al boton estadisticas, no consigo que se actualicen en tiempo real
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Graficos.fxml"));
        VBox root = (VBox) loader.load();
        Scene scene = new Scene(root,700,700);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        ControllerGraficos controller = loader.getController();
        controller.controlbarras(this);

    }



    @FXML
    private void onButtonAbrirClicked(ActionEvent event) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PantallaLucha.fxml"));
            GridPane root = (GridPane) loader.load();
            Scene scene = new Scene(root,570,400);
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();

            //Envio a la otra pantalla los datos del pokemon seleccionado
            ControllerPantallaLucha controller = loader.getController();

            if(psyduckSeleccionado) {
                controller.mandarInfoDesdeVentana(p, pokemonRival, new Image("img/psyduck.png"));
                cont+=1;
            }else
                if(meowthSeleccionado){
                    controller.mandarInfoDesdeVentana(p2, pokemonRival, new Image("img/meowth.png"));
                    cont2+=1;
                }else
                    if(snorlaxSeleccionado){
                        controller.mandarInfoDesdeVentana(p3, pokemonRival, new Image("img/snorlax.png"));
                        cont3+=1;
                    }else
                        if (bulbasaurSeleccionado){
                            controller.mandarInfoDesdeVentana(p4, pokemonRival, new Image("img/bullbasaur.png"));
                            cont4+=1;
                        }else
                            if (pikachuSeleccionado){
                                controller.mandarInfoDesdeVentana(p5, pokemonRival, new Image("img/pikachu.png"));
                                cont5+=1;
                            }else
                                if (rattataSeleccionado){
                                    controller.mandarInfoDesdeVentana(p6, pokemonRival, new Image("img/rattata.png"));
                                    cont6+=1;
                            }
            controller.setVentana1(this);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void datosPokemon (Label nombre, Label nivel, Label vida, ImageView genero, ProgressBar pb, Pokemon p){
        nombre.setText(p.getNombre());
        nivel.setText("Nv "+p.getNivel());
        vida.setText(p.getVida()+"/"+ p.getVida_total());
        if(p.getGenero() == 'M'){
            genero.setImage(masculino);
        }
        else{
            genero.setImage(femenino);
        }
        genero.setEffect(new DropShadow(5, Color.rgb(0, 0, 0, 0.5)));
        pb.setStyle("-fx-accent: green");
    }

    @FXML
    public void elegirPsyduck(){
        if(p.getVida() > 0) {
            cambioValores(imagen, nombre, nivel, vida, boton);
            psyduckSeleccionado=true;
            boton.setDisable(false);
            mensaje.setText("Pulsa Siguiente");

            valoresIniciales(imagen2, nombre2, nivel2, vida2);
            meowthSeleccionado=false;
            valoresIniciales(imagen3, nombre3, nivel3, vida3);
            snorlaxSeleccionado=false;
            valoresIniciales(imagen4, nombre4, nivel4, vida4);
            bulbasaurSeleccionado=false;
            valoresIniciales(imagen5, nombre5, nivel5, vida5);
            pikachuSeleccionado=false;
            valoresIniciales(imagen6, nombre6, nivel6, vida6);
            rattataSeleccionado=false;
        }
        else{
            mensaje.setText("Pokemon debilitado.");
            boton.setDisable(true);
        }
    }

    @FXML
    public void elegirMeowth(){
        if(p2.getVida() > 0) {
            cambioValores(imagen2, nombre2, nivel2, vida2, boton);
            meowthSeleccionado=true;
            boton.setDisable(false);
            mensaje.setText("Pulsa Siguiente");

            valoresIniciales(imagen, nombre, nivel, vida);
            psyduckSeleccionado=false;
            valoresIniciales(imagen3, nombre3, nivel3, vida3);
            snorlaxSeleccionado=false;
            valoresIniciales(imagen4, nombre4, nivel4, vida4);
            bulbasaurSeleccionado=false;
            valoresIniciales(imagen5, nombre5, nivel5, vida5);
            pikachuSeleccionado=false;
            valoresIniciales(imagen6, nombre6, nivel6, vida6);
            rattataSeleccionado=false;
        }else{
            mensaje.setText("Pokemon debilitado.");
            boton.setDisable(true);
        }
    }

    @FXML
    public void elegirSnorlax(){
        if(p3.getVida() > 0) {
            cambioValores(imagen3, nombre3, nivel3, vida3, boton);
            snorlaxSeleccionado=true;
            boton.setDisable(false);
            mensaje.setText("Pulsa Siguiente");

            valoresIniciales(imagen, nombre, nivel, vida);
            psyduckSeleccionado=false;
            valoresIniciales(imagen2, nombre2, nivel2, vida2);
            meowthSeleccionado=false;
            valoresIniciales(imagen4, nombre4, nivel4, vida4);
            bulbasaurSeleccionado=false;
            valoresIniciales(imagen5, nombre5, nivel5, vida5);
            pikachuSeleccionado=false;
            valoresIniciales(imagen6, nombre6, nivel6, vida6);
            rattataSeleccionado=false;
        }else{
            mensaje.setText("Pokemon debilitado.");
            boton.setDisable(true);
        }
    }

    @FXML
    public void elegirBulbasaur(){
        if(p4.getVida() > 0) {
            cambioValores(imagen4, nombre4, nivel4, vida4, boton);
            bulbasaurSeleccionado=true;
            boton.setDisable(false);
            mensaje.setText("Pulsa Siguiente");

            valoresIniciales(imagen, nombre, nivel, vida);
            psyduckSeleccionado=false;
            valoresIniciales(imagen2, nombre2, nivel2, vida2);
            meowthSeleccionado=false;
            valoresIniciales(imagen3, nombre3, nivel3, vida3);
            snorlaxSeleccionado=false;
            valoresIniciales(imagen5, nombre5, nivel5, vida5);
            pikachuSeleccionado=false;
            valoresIniciales(imagen6, nombre6, nivel6, vida6);
            rattataSeleccionado=false;
        }else{
            mensaje.setText("Pokemon debilitado.");
            boton.setDisable(true);
        }
    }

    @FXML
    public void elegirPikachu(){
        if(p5.getVida() > 0) {
            cambioValores(imagen5, nombre5, nivel5, vida5, boton);
            pikachuSeleccionado=true;
            boton.setDisable(false);
            mensaje.setText("Pulsa Siguiente");

            valoresIniciales(imagen, nombre, nivel, vida);
            psyduckSeleccionado=false;
            valoresIniciales(imagen2, nombre2, nivel2, vida2);
            meowthSeleccionado=false;
            valoresIniciales(imagen3, nombre3, nivel3, vida3);
            snorlaxSeleccionado=false;
            valoresIniciales(imagen4, nombre4, nivel4, vida4);
            bulbasaurSeleccionado=false;
            valoresIniciales(imagen6, nombre6, nivel6, vida6);
            rattataSeleccionado=false;
        }else{
            mensaje.setText("Pokemon debilitado.");
            boton.setDisable(true);
        }
    }

    @FXML
    public void elegirRattata(){
        if(p6.getVida() > 0) {
            cambioValores(imagen6, nombre6, nivel6, vida6, boton);
            rattataSeleccionado=true;
            boton.setDisable(false);
            mensaje.setText("Pulsa Siguiente");

            valoresIniciales(imagen, nombre, nivel, vida);
            psyduckSeleccionado=false;
            valoresIniciales(imagen2, nombre2, nivel2, vida2);
            meowthSeleccionado=false;
            valoresIniciales(imagen3, nombre3, nivel3, vida3);
            snorlaxSeleccionado=false;
            valoresIniciales(imagen4, nombre4, nivel4, vida4);
            bulbasaurSeleccionado=false;
            valoresIniciales(imagen5, nombre5, nivel5, vida5);
            pikachuSeleccionado=false;
        }else{
            mensaje.setText("Pokemon debilitado.");
            boton.setDisable(true);
        }
    }

    public void cambioValores(ImageView imagen, Label nombre, Label nivel, Label vida, Button boton){
        imagen.setEffect(new DropShadow(20, Color.rgb(0, 0, 0, 1)));
        boton.setText("Siguiente");
        nombre.setTextFill(Color.BLACK);
        nivel.setTextFill(Color.BLACK);
        vida.setTextFill(Color.BLACK);
    }

    public void valoresIniciales (ImageView imagen, Label nombre, Label nivel, Label vida){
        imagen.setEffect(null);
        nombre.setTextFill(Color.WHITE);
        nivel.setTextFill(Color.WHITE);
        vida.setTextFill(Color.WHITE);
    }

    public void recibirInformacion(int vidaPokemon, int vidaPokemonRival, double progresoPb) {
        pokemonRival.setVida(vidaPokemonRival);
        if(psyduckSeleccionado){
            if(p.getVida() > vidaPokemon){
                p.setVida(vidaPokemon);
                pb.setProgress(progresoPb);
                datosPokemon(nombre, nivel, vida, gen, pb, p);
            }
        }else
            if(meowthSeleccionado){
                if(p2.getVida() > vidaPokemon){
                    p2.setVida(vidaPokemon);
                    pb2.setProgress(progresoPb);
                    datosPokemon(nombre2, nivel2, vida2, gen2, pb2, p2);

                }
            }else
                if(snorlaxSeleccionado){
                    if(p3.getVida() > vidaPokemon){
                        p3.setVida(vidaPokemon);
                        pb3.setProgress(progresoPb);
                        datosPokemon(nombre3, nivel3, vida3, gen3, pb3, p3);
                    }
                }else
                    if(bulbasaurSeleccionado){
                        if(p4.getVida() > vidaPokemon){
                            p4.setVida(vidaPokemon);
                            pb4.setProgress(progresoPb);
                            datosPokemon(nombre4, nivel4, vida4, gen4, pb4, p4);
                        }
                    }else
                        if(pikachuSeleccionado){
                            if(p5.getVida() > vidaPokemon){
                                p5.setVida(vidaPokemon);
                                pb5.setProgress(progresoPb);
                                datosPokemon(nombre5, nivel5, vida5, gen5, pb5, p5);
                            }
                        }else
                            if(rattataSeleccionado){
                                if(p6.getVida() > vidaPokemon){
                                    p6.setVida(vidaPokemon);
                                    pb6.setProgress(progresoPb);
                                    datosPokemon(nombre6, nivel6, vida6, gen6, pb6, p6);
                                }
                            }

    }
}
