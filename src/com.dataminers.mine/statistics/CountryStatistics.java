package statistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class CountryStatistics
{
    public ArrayList<String> getCountries(ArrayList<String> arrayList, ResultSet resultSet)
    {
        ArrayList<String> country = new ArrayList<>();
        try {
            for (int i = 0; i < arrayList.size(); i++) {
                while (resultSet.next())
                {
                    if(resultSet.getString(1).contains(arrayList.get(i)))
                    {
                       country.add(resultSet.getString(3));
                    }
                }
            }

            return country;
        }catch (SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    public HashMap<String,Integer> getCountryCounts(ArrayList<String> arrayList)
    {
        int countThai= Collections.frequency(arrayList,"Thailand");
        int countInd=Collections.frequency(arrayList,"India");
        int countCh=Collections.frequency(arrayList,"China");
        int countUSA=Collections.frequency(arrayList,"USA");
        int countRuss=Collections.frequency(arrayList,"Russia");
        int countPaki=Collections.frequency(arrayList,"Pakistan");
        int countRom=Collections.frequency(arrayList,"Romania");
        int countFr=Collections.frequency(arrayList,"France");
        int countGr=Collections.frequency(arrayList,"Greece");
        

        HashMap<String,Integer> hsmap = new HashMap<String,Integer>();
        hsmap.put("Thailand",countThai);
        hsmap.put("India",countInd);
        hsmap.put("China",countCh);
        hsmap.put("USA",countUSA);
        hsmap.put("Russia", countRuss);
        hsmap.put("Pakistan", countPaki);
        hsmap.put("Romania", countRom);
        hsmap.put("France", countFr);
        hsmap.put("Greece",countGr);

        return hsmap;
    }

}
