package main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import main.model.CoronaData;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Controller {
    private ObservableList<String> selectedItems;
    private List<CoronaData> listTableData;
    private List<CoronaData> listCoronaData;


    @FXML
    private LineChart<String, Integer> lChartTotalDeaths;

    @FXML
    private LineChart<String, Integer> lChartTotalCases;


    @FXML
    private TextField txtUrl;

    @FXML
    private TableView myTable;


    @FXML
    private ListView<String> listView;


    @FXML
    private void onGetCountryClicked() {

        LineChartTotalDeaths();
        LineChartTotalCases();
    }

    @FXML
    private void onGetUrlClicked() throws MalformedURLException {
       listCoronaData = DataParser.parseEntry(new URL(txtUrl.getText()));
        TableView();

    }


    private void LineChartTotalDeaths() {
        selectedItems = listView.getSelectionModel().getSelectedItems();


        lChartTotalDeaths.getData().clear();
        lChartTotalDeaths.getData().removeAll();
        XYChart.Series<String, Integer> series;

        for (String s : selectedItems) {
            series = new XYChart.Series<>();
            for (CoronaData cd: listCoronaData) {

                if(cd.getCountry().equals(s) && cd.getTotalDeath()>0){

                    series.getData().add(new XYChart.Data<>(cd.getTime(), cd.getTotalDeath()));
                    series.setName(s);

                }

            }
//            lChartTotalDeaths.setLegendVisible(false);
            lChartTotalDeaths.setCreateSymbols(false);
            lChartTotalDeaths.getData().addAll(series);
        }


    }
    private void LineChartTotalCases() {
        selectedItems = listView.getSelectionModel().getSelectedItems();


        lChartTotalCases.getData().clear();
        lChartTotalCases.getData().removeAll();
        XYChart.Series<String, Integer> series;

        for (String s : selectedItems) {
            series = new XYChart.Series<>();
            for (CoronaData cd: listCoronaData) {

                if(cd.getCountry().equals(s) && cd.getTotalDeath()>0){

                    series.getData().add(new XYChart.Data<>(cd.getTime(), cd.getTotalCases()));
                    series.setName(s);

                }

            }
//          lChartTotalCases.setLegendVisible(false);
            lChartTotalCases.setCreateSymbols(false);
            lChartTotalCases.getData().addAll(series);
        }


    }



    private void TableView() {
        myTable.getItems().clear();
        myTable.getColumns().clear();
        listTableData = null;
        listTableData = DataParser.countryTableData();

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


}
