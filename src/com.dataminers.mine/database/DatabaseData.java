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
            ResultSet result = statement.executeQuery("SELECT requests, ip, country, latitude, longtitude, date FROM logs");
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public int getIncomingServerTraffic (Connection connection) {
        int result=0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT COUNT(requests) AS SUM FROM `logs` WHERE requests LIKE 'GET%'");
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getServerErrorRequests (Connection connection) {
        int result=0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT COUNT(error) as SUM From `logs` WHERE error>=500 AND error<600");
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

    public int getUniqueIps (Connection connection) {
        int result=0;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery( "SELECT COUNT(ip) as sum FROM (SELECT ip FROM `logs` GROUP BY ip) as ip");
            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return result;
        }
    }

}
