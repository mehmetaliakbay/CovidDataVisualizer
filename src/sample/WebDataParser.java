package sample;

import java.io.InputStream;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WebDataParser {
    private static Map<String, ArrayList<CoronaData>> map = new HashMap<String, ArrayList<CoronaData>>();
    private static List<CoronaData> list = new ArrayList<CoronaData>();

    public static List<CoronaData> parseEntry(URL url) throws Exception {
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
//      System.out.println(recordList.size());
//        int index;
        for (String s : recordList) {
//            System.out.println(s);
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


            list.add(new CoronaData(time,day,month,year,newCase,newDeath,country,population,continent));

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


}
