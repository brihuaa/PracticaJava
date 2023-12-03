package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controlador para la gestión de gráficos en la interfaz gráfica del juego.
 */
public class ControllerGraficos implements Initializable {

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart barChart;

    @FXML
    private CategoryAxis EjeX;

    @FXML
    private NumberAxis EjeY;

    private static double miraza;
    private static double razaRival;

    /**
     * Inicializa la clase ControllerGraficos.
     *
     * @param url             URL.
     * @param resourceBundle ResourceBundle.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Mi raza", miraza),
                        new PieChart.Data("Raza Rival", razaRival));
        pieChart.setData(pieChartData);
        pieChart.getData().forEach(this::installTooltip);

        barChart.setTitle("NVeces seleccionado un raza");
        EjeY.setLabel("N_Veces");
    }

    /**
     * Recibe los datos de daño de las razas aliada y rival.
     *
     * @param daniorazaAmigo Daño acumulado de la raza aliada.
     * @param daniorazaRival Daño acumulado de la raza rival.
     */
    
    @FXML
    public static void recibirDatosDanios(double daniorazaAmigo, double daniorazaRival) {
        miraza = daniorazaAmigo;
        razaRival = daniorazaRival;
        System.out.println("Datos recibidos " + razaRival);
    }

    /**
     * Instala un Tooltip personalizado para un segmento de datos en el gráfico circular (PieChart).
     *
     * @param d Datos del segmento en el gráfico circular.
     */
    
    public void installTooltip(PieChart.Data d) {
        String msg = String.format("%s : %s", d.getName(), d.getPieValue());
        Tooltip tt = new Tooltip(msg);
        tt.setStyle("-fx-background-color: gray; -fx-text-fill: whitesmoke;");
        Tooltip.install(d.getNode(), tt);
    }

    /**
     * Controla la creación de barras en el gráfico de barras (BarChart) a partir de los datos del controlador
     * de la pantalla de selección.
     *
     * @param controller Controlador de la pantalla de selección.
     */
    
    public void controlbarras(ControllerPantallaSeleccion controller) {
        XYChart.Series raza1 = new XYChart.Series<>();
        raza1.setName(controller.nombre.getText());
        raza1.getData().add(new XYChart.Data("", controller.cont));
        barChart.getData().addAll(raza1);

        XYChart.Series raza2 = new XYChart.Series<>();
        raza2.setName(controller.nombre2.getText());
        raza2.getData().add(new XYChart.Data("", controller.cont2));
        barChart.getData().addAll(raza2);

        XYChart.Series raza3 = new XYChart.Series<>();
        raza3.setName(controller.nombre3.getText());
        raza3.getData().add(new XYChart.Data("", controller.cont3));
        barChart.getData().addAll(raza3);

        XYChart.Series raza4 = new XYChart.Series<>();
        raza4.setName(controller.nombre4.getText());
        raza4.getData().add(new XYChart.Data("", controller.cont4));
        barChart.getData().addAll(raza4);

        XYChart.Series raza5 = new XYChart.Series<>();
        raza5.setName(controller.nombre5.getText());
        raza5.getData().add(new XYChart.Data("", controller.cont5));
        barChart.getData().addAll(raza5);

        XYChart.Series raza6 = new XYChart.Series<>();
        raza6.setName(controller.nombre6.getText());
        raza6.getData().add(new XYChart.Data("", controller.cont6));
        barChart.getData().addAll(raza6);
    }
}
