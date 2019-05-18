package domain;
import database.DatabaseConnection;
import database.DatabaseData;
import regex.RegexMatches;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String [] arg)
    {
        DatabaseConnection dc = new DatabaseConnection();
        Connection connection = dc.connectDatabase();
        DatabaseData dbdata = new DatabaseData();
        RegexMatches rm = new RegexMatches();
        try {
            System.out.println("Incoming Server Traffic: "+dbdata.getIncomingServerTraffic(connection)+"\n Sum of 500 errors: "+
                    dbdata.getServerErrorRequests(connection) + "\n Unique ips: " + dbdata.getUniqueIps(connection) );
            System.out.println("Number of SQL Injections : "+rm.numberOfSQLinjection(dbdata.getRequests(connection)));
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
