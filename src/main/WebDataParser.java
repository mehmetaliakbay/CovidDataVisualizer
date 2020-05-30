package main;

import main.model.CoronaData;

import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebDataParser {
    private static List<CoronaData> list;

    //Map values according to country
    //country is key
    private static Map<String, CoronaData> tableMap;

    // List for LineChart data
    private static List<CoronaData> lineData;

    public static List<CoronaData> parseEntry(URL url) throws Exception {
        list = new ArrayList<CoronaData>();
        InputStream in = url.openStream();
        Scanner scan = new Scanner(in);
        StringBuilder sb = new StringBuilder();


        while (scan.hasNext()) {
            String str = scan.nextLine();
            sb.append(str);

        }
        scan.close();

        //split <record> </record> pattern
        Pattern groupPattern = Pattern.compile("(<record>)(.*?)(</record>)");
        Matcher groupMatcherRecord = groupPattern.matcher(sb);
        List<String> recordList = new ArrayList<String>();
        while (groupMatcherRecord.find()) {
            recordList.add(groupMatcherRecord.group(2));
        }
        Collections.reverse(recordList);

        for (String s : recordList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s);

            // for time parsing
            String time = parseRecord(stringBuilder,"(<dateRep>)(.*?)(</dateRep>)");


            // for day parsing
            Integer day = Integer.parseInt(parseRecord(stringBuilder,"(<day>)(.*?)(</day>)"));


            // for month parsing
            Integer month = Integer.parseInt(parseRecord(stringBuilder,"(<month>)(.*?)(</month>)"));

            // for year parsing
            Integer year =  Integer.parseInt(parseRecord(stringBuilder,"(<year>)(.*?)(</year>)"));

            // for newcase parsing
            Integer newCase =  Integer.parseInt(parseRecord(stringBuilder,"(<cases>)(.*?)(</cases>)"));

            // for newdeath parsing
            Integer newDeath= Integer.parseInt(parseRecord(stringBuilder,"(<deaths>)(.*?)(</deaths>)"));

            // for country parsing
            String country = parseRecord(stringBuilder,"(<countriesAndTerritories>)(.*?)(</countriesAndTerritories>)");

            //for population parsing
            Integer population;
            int populationLength = parseRecord(stringBuilder,"(<popData2018>)(.*?)(</popData2018>)").length();
            if(populationLength<2){
                population = 0;
            }else{
                population = Integer.parseInt(parseRecord(stringBuilder,"(<popData2018>)(.*?)(</popData2018>)"));

            }

            //for continent
            String continent = parseRecord(stringBuilder,"(<continentExp>)(.*?)(</continentExp>)");
            Integer totalDeath=0;
            Integer totalCases=0;
            if(list !=null){
                for (CoronaData cd : list) {
                    if (cd.getCountry().equals(country)){
                        totalDeath += cd.getNewDeath();
                        totalCases += cd.getNewCase();

                    }
                }
            }

            list.add(new CoronaData(time,day,month,year,newCase,newDeath,country,population,continent,totalDeath,totalCases));

        }

        return list;
    }



    private static String parseRecord(StringBuilder stringBuilder,String regEx) {
        Pattern groupPattern = Pattern.compile(regEx);
        String record = null;
        Matcher groupMatcher = groupPattern.matcher(stringBuilder);
        while (groupMatcher.find()) {
            record = groupMatcher.group(2);
        }
        return record;
    }

    // creating table data according to country
    public static List<CoronaData> countryTableData() {
        tableMap = new HashMap<String, CoronaData>();

        for (CoronaData data : list) {
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

                tableMap.put(data.getCountry(), new CoronaData(data.getNewCase(), data.getNewDeath(), data.getCountry(), data.getPopulation(),
                        totalCases, totalDeath, mortality, attackRate));
            } else {
                tableMap.put(data.getCountry(), new CoronaData(data.getNewCase(), data.getNewDeath(), data.getCountry(), data.getPopulation(),
                        data.getNewCase(), data.getNewDeath(), 0.0, 0.0));
            }
        }

        Collection<CoronaData> values = tableMap.values();
        List<CoronaData> tableData = new ArrayList<CoronaData>(values);

        return tableData;

    }

//    public static List<CoronaData> countryTotalCasesLineChart(){
//        lineData = new ArrayList<CoronaData>();
//
//        for (CoronaData data: list) {
//
//
//        }
//        return null;
//    }


}
