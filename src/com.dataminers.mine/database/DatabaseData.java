package database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseData {

    public ResultSet getRequests(Connection connection){
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT request, ip FROM logs");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
