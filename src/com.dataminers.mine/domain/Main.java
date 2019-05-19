package domain;
import database.DatabaseConnection;
import database.DatabaseData;
import regex.LFIRegex;
import regex.SQLInjectionRegex;
import regex.XSSRegex;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String [] arg)
    {
        DatabaseConnection dc = new DatabaseConnection();
        Connection connection = dc.connectDatabase();
        DatabaseData dbdata = new DatabaseData();
        SQLInjectionRegex SQLr = new SQLInjectionRegex();
        LFIRegex LFIr = new LFIRegex();
        XSSRegex XSSr = new XSSRegex();
        try {
            System.out.println("Incoming Server Traffic: "+dbdata.getIncomingServerTraffic(connection)+"\n Sum of 500 errors: "+
                    dbdata.getServerErrorRequests(connection) + "\n Unique ips: " + dbdata.getUniqueIps(connection) );
            System.out.println("Number of SQL Injections : "+SQLr.numberOfSQLInjections(SQLr.SQLinjection(dbdata.getRequests(connection))));
            System.out.println("Number of XSS Attacks : "+XSSr.numberOfXSSSimple(XSSr.XSSAttacksSimple(dbdata.getRequests(connection))));

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
