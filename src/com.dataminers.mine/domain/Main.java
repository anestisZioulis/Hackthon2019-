package domain;
import database.DatabaseConnection;
import database.DatabaseData;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String [] arg)
    {
        DatabaseConnection dc = new DatabaseConnection();
        Connection connection = dc.connectDatabase();

        DatabaseData dbdata = new DatabaseData();
        try {
            System.out.println("Incoming Server Traffic: "+dbdata.getIncomingServerTraffic(connection)+"\n Sum of 500 errors: "+
                    dbdata.getServerErrorRequests(connection) + "\n Unique ips: " + dbdata.getUniqueIps(connection) );
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
