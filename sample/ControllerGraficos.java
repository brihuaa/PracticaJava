package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class ControllerGraficos implements Initializable {

    @FXML
    private PieChart pieChart;

    @FXML
    private BarChart barChart;

    @FXML
    private CategoryAxis EjeX;

    @FXML
    private NumberAxis EjeY;

    private static double miPokemon;
    private static double pokemonRival;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Mi Pokemon", miPokemon),
                        new PieChart.Data("Pokemon Rival", pokemonRival));
        pieChart.setData(pieChartData);
        pieChart.getData().forEach(this::installTooltip);

        barChart.setTitle("NVeces seleccionado un Pokemon");
        EjeY.setLabel("N_Veces");

    }
    @FXML
    public static void recibirDatosDanios(double danioPokemonAmigo, double danioPokemonRival) {
        miPokemon = danioPokemonAmigo;
        pokemonRival = danioPokemonRival;
        System.out.println("Datos recibidos "+pokemonRival);
    }

    public void installTooltip(PieChart.Data d) {
        String msg = String.format("%s : %s", d.getName(), d.getPieValue());
        Tooltip tt = new Tooltip(msg);
        tt.setStyle("-fx-background-color: gray; -fx-text-fill: whitesmoke;");
        Tooltip.install(d.getNode(), tt);
    }

    public void controlbarras(ControllerPantallaSeleccion controller) {
        XYChart.Series pokemon1 = new XYChart.Series<>();
        pokemon1.setName(controller.nombre.getText());
        pokemon1.getData().add(new XYChart.Data("", controller.cont));
        barChart.getData().addAll(pokemon1);

        XYChart.Series pokemon2 = new XYChart.Series<>();
        pokemon2.setName(controller.nombre2.getText());
        pokemon2.getData().add(new XYChart.Data("", controller.cont2));
        barChart.getData().addAll(pokemon2);

        XYChart.Series pokemon3 = new XYChart.Series<>();
        pokemon3.setName(controller.nombre3.getText());
        pokemon3.getData().add(new XYChart.Data("", controller.cont3));
        barChart.getData().addAll(pokemon3);

        XYChart.Series pokemon4 = new XYChart.Series<>();
        pokemon4.setName(controller.nombre4.getText());
        pokemon4.getData().add(new XYChart.Data("", controller.cont4));
        barChart.getData().addAll(pokemon4);

        XYChart.Series pokemon5 = new XYChart.Series<>();
        pokemon5.setName(controller.nombre5.getText());
        pokemon5.getData().add(new XYChart.Data("", controller.cont5));
        barChart.getData().addAll(pokemon5);

        XYChart.Series pokemon6 = new XYChart.Series<>();
        pokemon6.setName(controller.nombre6.getText());
        pokemon6.getData().add(new XYChart.Data("", controller.cont6));
        barChart.getData().addAll(pokemon6);
    }

}



