package regex;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    public int numberOfSQLinjection(ResultSet resultSet)
    {
        int counter=0;
        try{
            String regex = "/(%27)|(\\')|(\\-\\-)|(\\%23)|(#)/ix";
            Pattern pattern = Pattern.compile(regex);

            while(resultSet.next())
            {
                Matcher matcher = pattern.matcher(resultSet.getString(1));
                if(matcher.find())
                {
                    counter++;
                }
            }
            return counter;
        }catch(SQLException e)
        {
            System.out.println(e);
            return 0;
        }
    }
}
