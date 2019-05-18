package database;

import java.sql.*;

public class DatabaseConnection {
    public boolean connectDatabase()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logfiles","root","");
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }
}
