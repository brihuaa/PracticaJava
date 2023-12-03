/**
 * Controlador para la pantalla de selección de personajes.
 * Permite al usuario elegir entre diferentes razas de personajes para participar en la lucha.
 */
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
    
    private final Raza p = new Raza("Gnomo", 100, 100, 40, 'M');
    private final Raza p2 = new Raza("Humano", 80, 80, 35, 'F');
    private final Raza p3 = new Raza("Orco", 350, 350,70, 'M');
    private final Raza p4 = new Raza("Elfo", 95, 95,42, 'M');
    private final Raza p5 = new Raza("Hada", 105, 105,50, 'M');
    private final Raza p6 = new Raza("Enano", 87,87, 38, 'F');
    Raza enemigo = new Raza("Archidemonio", 100,100, 60, 'F');

    public boolean GnomoSeleccionado = false;
    public boolean HumanoSeleccionado = false;
    public boolean EnanoSeleccionado = false;
    public boolean HadaSeleccionado = false;
    public boolean OrcoSeleccionado = false;
    public boolean ElfoSeleccionado = false;

    public static Image masculino = new Image("img/masculino.png");
    public static Image femenino =  new Image("img/hembra.png");


    public static int cont;
    public static int cont2;
    public static int cont3;
    public static int cont4;
    public static int cont5;
    public static int cont6;




    /**
     * Método de inicialización que se llama después de cargar la interfaz de usuario.
     * Configura las estadísticas y la apariencia de las razas en la pantalla de selección.
     */
    
    @FXML
    public void initialize() {
        // Configuración de la Raza 1
        dRaza(nombre, nivel, vida, gen, pb, p);
        // Configuración de la Raza 2
        dRaza(nombre2, nivel2, vida2, gen2, pb2, p2);
        // Configuración de la Raza 3
        dRaza(nombre3, nivel3, vida3, gen3, pb3, p3);
        // Configuración de la Raza 4
        dRaza(nombre4, nivel4, vida4, gen4, pb4, p4);
        // Configuración de la Raza 5
        dRaza(nombre5, nivel5, vida5, gen5, pb5, p5);
        // Configuración de la Raza 6
        dRaza(nombre6, nivel6, vida6, gen6, pb6, p6);

        mensaje.setText("Elige una Raza");
    }

    /**
     * Maneja el evento de hacer clic en el botón de estadísticas.
     * Abre una nueva ventana con estadísticas gráficas y actualiza los datos en esa ventana.
     *
     * @throws IOException Si hay un problema al cargar la ventana de estadísticas.
     */
    @FXML
    private void clickBotonGraficos() throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Graficos.fxml"));
        VBox root = (VBox) loader.load();
        Scene scene = new Scene(root, 700, 700);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        ControllerGraficos controller = loader.getController();
        controller.controlbarras(this);
    }

    /**
     * Maneja el evento de hacer clic en el botón para abrir la pantalla de lucha.
     * Abre una nueva ventana de lucha, enviando los datos del personaje seleccionado a esa ventana.
     *
     * @param event Evento de clic en el botón.
     */
    
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

            if(GnomoSeleccionado) {
                controller.mandarInfoDesdeVentana(p, enemigo, new Image("img/gnomo.png"));
                cont+=1;
            }else
                if(HumanoSeleccionado){
                    controller.mandarInfoDesdeVentana(p2, enemigo, new Image("img/humano.png"));
                    cont2+=1;
                }else
                    if(EnanoSeleccionado){
                        controller.mandarInfoDesdeVentana(p3, enemigo, new Image("img/enano.png"));
                        cont3+=1;
                    }else
                        if (HadaSeleccionado){
                            controller.mandarInfoDesdeVentana(p4, enemigo, new Image("img/hada.png"));
                            cont4+=1;
                        }else
                            if (OrcoSeleccionado){
                                controller.mandarInfoDesdeVentana(p5, enemigo, new Image("img/orco.png"));
                                cont5+=1;
                            }else
                                if (ElfoSeleccionado){
                                    controller.mandarInfoDesdeVentana(p6, enemigo, new Image("img/elfo.png"));
                                    cont6+=1;
                            }
            controller.setVentana1(this);

        } catch(Exception e) {
            e.printStackTrace();
        }
        
    /**
     * Configura la apariencia de una raza en la pantalla de selección.
     *
     * @param nombre   Etiqueta de nombre de la raza.
     * @param nivel    Etiqueta de nivel de la raza.
     * @param vida     Etiqueta de vida de la raza.
     * @param genero   Imagen del género de la raza.
     * @param pb       Barra de progreso de la raza.
     * @param raza     Objeto Raza que contiene la información de la raza.
     */
    
        public void dRaza (Label nombre, Label nivel, Label vida, ImageView genero, ProgressBar pb, Raza p){
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
        
        /**
         * Maneja el evento de elegir al gnomo como personaje.
         * Si el gnomo seleccionado tiene vida restante, cambia la apariencia y permite avanzar.
         * Si el gnomo está debilitado, muestra un mensaje y deshabilita el botón.
         */
        
        @FXML
        public void elegirGnomo(){
            if(p.getVida() > 0) {
                cambioValores(imagen, nombre, nivel, vida, boton);
                GnomoSeleccionado=true;
                boton.setDisable(false);
                mensaje.setText("Pulsa Siguiente");

                valoresIniciales(imagen2, nombre2, nivel2, vida2);
                HumanoSeleccionado=false;
                valoresIniciales(imagen3, nombre3, nivel3, vida3);
                EnanoSeleccionado=false;
                valoresIniciales(imagen4, nombre4, nivel4, vida4);
                HadaSeleccionado=false;
                valoresIniciales(imagen5, nombre5, nivel5, vida5);
                OrcoSeleccionado=false;
                valoresIniciales(imagen6, nombre6, nivel6, vida6);
                ElfoSeleccionado=false;
            }
            else{
                mensaje.setText("aliado debilitado.");
                boton.setDisable(true);
            }
        }
        
        /**
         * Maneja el evento de elegir al humano como personaje.
         * Si el humano seleccionado tiene vida restante, cambia la apariencia y permite avanzar.
         * Si el humano está debilitado, muestra un mensaje y deshabilita el botón.
         */
        
        @FXML
        public void elegirHumano(){
            if(p2.getVida() > 0) {
                cambioValores(imagen2, nombre2, nivel2, vida2, boton);
                HumanoSeleccionado=true;
                boton.setDisable(false);
                mensaje.setText("Pulsa Siguiente");

                valoresIniciales(imagen, nombre, nivel, vida);
                GnomoSeleccionado=false;
                valoresIniciales(imagen3, nombre3, nivel3, vida3);
                EnanoSeleccionado=false;
                valoresIniciales(imagen4, nombre4, nivel4, vida4);
                HadaSeleccionado=false;
                valoresIniciales(imagen5, nombre5, nivel5, vida5);
                OrcoSeleccionado=false;
                valoresIniciales(imagen6, nombre6, nivel6, vida6);
                ElfoSeleccionado=false;
            }else{
                mensaje.setText("aliado debilitado.");
                boton.setDisable(true);
            }
        }
        
        /**
         * Maneja el evento de elegir al enano como personaje.
         * Si el enano seleccionado tiene vida restante, cambia la apariencia y permite avanzar.
         * Si el enano está debilitado, muestra un mensaje y deshabilita el botón.
         */
        
        @FXML
        public void elegirEnano(){
            if(p3.getVida() > 0) {
                cambioValores(imagen3, nombre3, nivel3, vida3, boton);
                EnanoSeleccionado=true;
                boton.setDisable(false);
                mensaje.setText("Pulsa Siguiente");

                valoresIniciales(imagen, nombre, nivel, vida);
                GnomoSeleccionado=false;
                valoresIniciales(imagen2, nombre2, nivel2, vida2);
                HumanoSeleccionado=false;
                valoresIniciales(imagen4, nombre4, nivel4, vida4);
                HadaSeleccionado=false;
                valoresIniciales(imagen5, nombre5, nivel5, vida5);
                OrcoSeleccionado=false;
                valoresIniciales(imagen6, nombre6, nivel6, vida6);
                ElfoSeleccionado=false;
            }else{
                mensaje.setText("aliado debilitado.");
                boton.setDisable(true);
            }
        }
        
        /**
         * Maneja el evento de elegir a la hada como personaje.
         * Si la hada seleccionada tiene vida restante, cambia la apariencia y permite avanzar.
         * Si la hada está debilitada, muestra un mensaje y deshabilita el botón.
         */
        
        @FXML
        public void elegirHada(){
            if(p4.getVida() > 0) {
                cambioValores(imagen4, nombre4, nivel4, vida4, boton);
                HadaSeleccionado=true;
                boton.setDisable(false);
                mensaje.setText("Pulsa Siguiente");

                valoresIniciales(imagen, nombre, nivel, vida);
                GnomoSeleccionado=false;
                valoresIniciales(imagen2, nombre2, nivel2, vida2);
                HumanoSeleccionado=false;
                valoresIniciales(imagen3, nombre3, nivel3, vida3);
                EnanoSeleccionado=false;
                valoresIniciales(imagen5, nombre5, nivel5, vida5);
                OrcoSeleccionado=false;
                valoresIniciales(imagen6, nombre6, nivel6, vida6);
                ElfoSeleccionado=false;
            }else{
                mensaje.setText("aliado debilitado.");
                boton.setDisable(true);
            }
        }

        /**
         * Maneja el evento de elegir al orco como personaje.
         * Si el orco seleccionado tiene vida restante, cambia la apariencia y permite avanzar.
         * Si el orco está debilitado, muestra un mensaje y deshabilita el botón.
         */
        
        @FXML
        public void elegirOrco(){
            if(p5.getVida() > 0) {
                cambioValores(imagen5, nombre5, nivel5, vida5, boton);
                OrcoSeleccionado=true;
                boton.setDisable(false);
                mensaje.setText("Pulsa Siguiente");

                valoresIniciales(imagen, nombre, nivel, vida);
                GnomoSeleccionado=false;
                valoresIniciales(imagen2, nombre2, nivel2, vida2);
                HumanoSeleccionado=false;
                valoresIniciales(imagen3, nombre3, nivel3, vida3);
                EnanoSeleccionado=false;
                valoresIniciales(imagen4, nombre4, nivel4, vida4);
                HadaSeleccionado=false;
                valoresIniciales(imagen6, nombre6, nivel6, vida6);
                ElfoSeleccionado=false;
            }else{
                mensaje.setText("aliado debilitado.");
                boton.setDisable(true);
            }
        }
        
        /**
         * Maneja el evento de elegir al elfo como personaje.
         * Si el elfo seleccionado tiene vida restante, cambia la apariencia y permite avanzar.
         * Si el elfo está debilitado, muestra un mensaje y deshabilita el botón.
         */
        
        @FXML
        public void elegirElfo(){
            if(p6.getVida() > 0) {
                cambioValores(imagen6, nombre6, nivel6, vida6, boton);
                ElfoSeleccionado=true;
                boton.setDisable(false);
                mensaje.setText("Pulsa Siguiente");

                valoresIniciales(imagen, nombre, nivel, vida);
                GnomoSeleccionado=false;
                valoresIniciales(imagen2, nombre2, nivel2, vida2);
                HumanoSeleccionado=false;
                valoresIniciales(imagen3, nombre3, nivel3, vida3);
                EnanoSeleccionado=false;
                valoresIniciales(imagen4, nombre4, nivel4, vida4);
                HadaSeleccionado=false;
                valoresIniciales(imagen5, nombre5, nivel5, vida5);
                OrcoSeleccionado=false;
            }else{
                mensaje.setText("aliado debilitado.");
                boton.setDisable(true);
            }
        }
        
        /**
         * Cambia los valores de apariencia al elegir un personaje.
         * Aplica sombra y desactiva el botón de "Siguiente".
         *
         * @param imagen Imagen del personaje seleccionado.
         * @param nombre Etiqueta del nombre del personaje.
         * @param nivel  Etiqueta del nivel del personaje.
         * @param vida   Etiqueta de la vida del personaje.
         * @param boton  Botón de "Siguiente".
         */
        
        public void cambioValores(ImageView imagen, Label nombre, Label nivel, Label vida, Button boton){
            imagen.setEffect(new DropShadow(20, Color.rgb(0, 0, 0, 1)));
            boton.setText("Siguiente");
            nombre.setTextFill(Color.BLACK);
            nivel.setTextFill(Color.BLACK);
            vida.setTextFill(Color.BLACK);
        }
        
        /**
         * Restaura los valores iniciales de apariencia al cancelar la selección de un personaje.
         * Elimina la sombra y restablece el color de las etiquetas.
         *
         * @param imagen Imagen del personaje no seleccionado.
         * @param nombre Etiqueta del nombre del personaje no seleccionado.
         * @param nivel  Etiqueta del nivel del personaje no seleccionado.
         * @param vida   Etiqueta de la vida del personaje no seleccionado.
         */
        
        public void valoresIniciales (ImageView imagen, Label nombre, Label nivel, Label vida){
            imagen.setEffect(null);
            nombre.setTextFill(Color.WHITE);
            nivel.setTextFill(Color.WHITE);
            vida.setTextFill(Color.WHITE);
        }
        
        /**
         * Recibe información sobre la batalla y actualiza los datos del aliado y enemigo.
         *
         * @param vidaAliado   Vida actual del aliado.
         * @param vidaEnemigo  Vida actual del enemigo.
         * @param progresoPb   Progreso de la barra de vida del aliado.
         */
        
        public void recibirInformacion(int vidaAliado, int vidaEnemigo, double progresoPb) {
            enemigo.setVida(vidaEnemigo);
            if(GnomoSeleccionado){
                if(p.getVida() > vidaAliado){
                    p.setVida(vidaAliado);
                    pb.setProgress(progresoPb);
                    dRaza(nombre, nivel, vida, gen, pb, p);
                }
            }else
                if(HumanoSeleccionado){
                    if(p2.getVida() > vidaAliado){
                        p2.setVida(vidaAliado);
                        pb2.setProgress(progresoPb);
                        dRaza(nombre2, nivel2, vida2, gen2, pb2, p2);

                    }
                }else
                    if(EnanoSeleccionado){
                        if(p3.getVida() > vidaAliado){
                            p3.setVida(vidaAliado);
                            pb3.setProgress(progresoPb);
                            dRaza(nombre3, nivel3, vida3, gen3, pb3, p3);
                        }
                    }else
                        if(HadaSeleccionado){
                            if(p4.getVida() > vidaAliado){
                                p4.setVida(vidaAliado);
                                pb4.setProgress(progresoPb);
                                dRaza(nombre4, nivel4, vida4, gen4, pb4, p4);
                            }
                        }else
                            if(OrcoSeleccionado){
                                if(p5.getVida() > vidaAliado){
                                    p5.setVida(vidaAliado);
                                    pb5.setProgress(progresoPb);
                                    dRaza(nombre5, nivel5, vida5, gen5, pb5, p5);
                                }
                            }else
                                if(ElfoSeleccionado){
                                    if(p6.getVida() > vidaAliado){
                                        p6.setVida(vidaAliado);
                                        pb6.setProgress(progresoPb);
                                        dRaza(nombre6, nivel6, vida6, gen6, pb6, p6);
                                    }
                                }

        }
    }
