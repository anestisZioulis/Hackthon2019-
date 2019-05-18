package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseData {
    private Statement statement = null;

    public ResultSet getRequests(Connection connection){
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT request, ip FROM logs");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet getIncomingServerTraffic (Connection connection) {
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery( "SELECT * FROM `logs` WHERE requests LIKE 'GET%'");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getServerErrorRequests (Connection connection) {
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery( "SELECT COUNT (requests) AS SUM FROM ``logs" +
                    "WHERE requests LIKE 'GET%'");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getUniqueIps (Connection connection) {
        try {
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery( "SELECT COUNT(ip) as sum FROM (SELECT ip FROM `logs` GROUP BY ip) as ip");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
