package regex;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XSSRegex {
    public int numberOfXSSAttacksSimple(ResultSet resultSet)
    {
        int counter=0;
        try{
            String regex = "/((\\%3C)|<)((\\%2F)|\\/)*[a-z0-9\\%]+((\\%3E)|>)/ix";
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
    public int numberOfXSSAttacksImages(ResultSet resultSet)
    {
        int counter=0;
        try{
            String regex = "/((\\%3C)|<)((\\%69)|i|(\\%49))((\\%6D)|m|(\\%4D))((\\%67)|g|(\\%47))[^\\n]+((\\%3E)|>)/I";
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
    public int numberOfXSSAttacksHTMLTag(ResultSet resultSet)
    {
        int counter=0;
        try{
            String regex = "/((\\%3C)|<)[^\\n]+((\\%3E)|>)/I";
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
