package database;

import java.sql.*;

public class DatabaseConnection {
    public Connection connectDatabase()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/logfiles","root","");
            return connection;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }
}
