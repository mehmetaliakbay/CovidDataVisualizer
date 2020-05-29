package sample;

import java.net.URL;
import java.util.*;

public class DataAnalyzer {
    URL url;
    List<CoronaData> recordList;
    Map<String, TableData> tableMap;

    public DataAnalyzer(URL url) throws Exception {
        this.url = url;
        this.recordList = WebDataParser.parseEntry(url);
        this.tableMap = new HashMap<String, TableData>();
    }

    // creating table data according to country
    public List<TableData> countryTableData() {

        for (CoronaData data : recordList) {
            if (tableMap.containsKey(data.getCountry())) {
                Integer totalCases = tableMap.get(data.getCountry()).getTotalCases() + data.getNewCase();
                Integer totalDeath = tableMap.get(data.getCountry()).getTotalDeath() + data.getNewDeath();
                Integer population = data.getPopulation();
                Integer newDeath = data.getNewDeath();
                Double mortality = 0.0;
                if (totalCases != 0)
                    mortality = Double.valueOf(totalDeath) / Double.valueOf(totalCases);

                Double attackRate = 0.0;
                if (population != 0)
                    attackRate = Double.valueOf(totalCases) / Double.valueOf(population);

                tableMap.put(data.getCountry(), new TableData(data.getNewCase(), data.getNewDeath(), data.getCountry(), data.getPopulation(),
                        totalCases, totalDeath, mortality, attackRate));
            } else {
                tableMap.put(data.getCountry(), new TableData(data.getNewCase(), data.getNewDeath(), data.getCountry(), data.getPopulation(),
                        data.getNewCase(), data.getNewDeath(), 0.0, 0.0));
            }
        }
//        System.out.println(tableMap.get("Turks_and_Caicos_islands"));
//        System.out.println(recordList.size());
        Collection<TableData> values = tableMap.values();
        List<TableData> tableData = new ArrayList<TableData>(values);

        return tableData;

    }
}
