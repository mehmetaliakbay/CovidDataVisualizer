package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.model.CoronaData;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.lang.Math;

public class Controller implements Initializable {
    ObservableList selectedItems;
    List<CoronaData> listTableData;
    List<CoronaData> listCoronaData;
    //Line Chart
    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private LineChart<String, Integer> lineChart;

    //TableView
    @FXML
    private TextField txtUrl;

    @FXML
    private TableView myTable;

    //ListView
    @FXML
    private ListView<String> listView;


    @FXML
    private void onGetCountryClicked() {

        LineChart();
    }

    @FXML
    private void onGetUrlClicked() throws Exception {
       listCoronaData = WebDataParser.parseEntry(new URL(txtUrl.getText()));
        TableView();
        LineChart();
    }


    private void LineChart() {
        selectedItems = listView.getSelectionModel().getSelectedItems();


        lineChart.getData().clear();
        lineChart.getData().removeAll();
        XYChart.Series<String, Integer> series;

        for (Object o : selectedItems) {
            series = new XYChart.Series<String, Integer>();
            for (CoronaData cd: listCoronaData) {

                if(cd.getCountry().equals(o.toString()) && cd.getTotalDeath()>0){

                    series.getData().add(new XYChart.Data<String, Integer>(cd.getTime(), cd.getTotalDeath()));
                    series.setName(o.toString());

                }

            }
//            lineChart.setLegendVisible(false);
            lineChart.setCreateSymbols(false);
            lineChart.getData().addAll(series);
        }


    }


    private void TableView() {
        myTable.getItems().clear();
        myTable.getColumns().clear();
        listTableData = null;
        listTableData = WebDataParser.countryTableData();

        ObservableList<CoronaData> olistTableData = FXCollections.observableList(listTableData);
        TableColumn country = new TableColumn("Country");
        TableColumn totalCases = new TableColumn("Total Cases");
        TableColumn newCases = new TableColumn("New Cases");
        TableColumn totalDeath = new TableColumn("Total Death");
        TableColumn newDeath = new TableColumn("New Death");
        TableColumn population = new TableColumn("Population");
        TableColumn mortality = new TableColumn("Mortality");
        TableColumn attackRate = new TableColumn("Attack Rate");
        myTable.getColumns().addAll(country, totalCases, newCases, totalDeath, newDeath, population, mortality, attackRate);

        country.setCellValueFactory(new PropertyValueFactory<CoronaData, String>("country"));
        totalCases.setCellValueFactory(new PropertyValueFactory<CoronaData, Integer>("totalCases"));
        newCases.setCellValueFactory(new PropertyValueFactory<CoronaData, Integer>("newCase"));
        totalDeath.setCellValueFactory(new PropertyValueFactory<CoronaData, Integer>("totalDeath"));
        newDeath.setCellValueFactory(new PropertyValueFactory<CoronaData, Integer>("newDeath"));
        population.setCellValueFactory(new PropertyValueFactory<CoronaData, Integer>("population"));
        mortality.setCellValueFactory(new PropertyValueFactory<CoronaData, Double>("mortality"));
        attackRate.setCellValueFactory(new PropertyValueFactory<CoronaData, Double>("attackRate"));

        myTable.setItems(olistTableData);

        //ListView
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ObservableList<String> data = FXCollections.observableArrayList();
        for (CoronaData list : listTableData) {
            data.add(list.getCountry());
        }

        listView.setItems(data);


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

}
