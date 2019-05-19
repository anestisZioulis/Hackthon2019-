package statistics;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TimeStatistics {
    public ArrayList<String> getTimestamp(ArrayList<String> arrayList, ResultSet resultSet)
    {
        ArrayList<String> timestamp = new ArrayList<>();
        try {
            for (int i = 0; i < arrayList.size(); i++) {
                while (resultSet.next())
                {
                    if(resultSet.getString(2).contains(arrayList.get(i)))
                    {
                        timestamp.add(resultSet.getString(4));
                    }
                }
            }

            return timestamp;
        }catch (SQLException e)
        {
            System.out.println(e);
            return null;
        }
    }
    public ArrayList<String[]> getTime(ArrayList<String> timestamps)
    {
        ArrayList<String[]> time = new ArrayList<>();
        for (int i = 0; i < timestamps.size() ; i++) {
            time.add(timestamps.get(i).split(":",1));
        }
        return time;
    }


}
