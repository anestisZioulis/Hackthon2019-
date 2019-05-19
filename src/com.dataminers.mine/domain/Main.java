package domain;
import database.DatabaseConnection;
import database.DatabaseData;
import regex.LFIRegex;
import regex.SQLInjectionRegex;
import regex.XSSRegex;
import statistics.Attacks;
import statistics.CountryStatistics;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String [] arg)
    {
        DatabaseConnection dc = new DatabaseConnection();
        Connection connection = dc.connectDatabase();
        DatabaseData dbdata = new DatabaseData();
        SQLInjectionRegex SQLr = new SQLInjectionRegex();
        LFIRegex LFIr = new LFIRegex();
        XSSRegex XSSr = new XSSRegex();
        Attacks attacks = new Attacks();
        CountryStatistics cs = new CountryStatistics();
        ArrayList<String> arrayAttacks;
        ArrayList<String> countries;
        HashMap<String,Integer> hsmap;
        try {
            System.out.println("General\n=============\n");
            System.out.println("Incoming Server Traffic: "+dbdata.getIncomingServerTraffic(connection)+"\nSum of 5xx errors: "+
                    dbdata.getServerErrorRequests(connection) + "\nUnique ips: " + dbdata.getUniqueIps(connection) );
            ArrayList sqli = SQLr.SQLinjection(dbdata.getRequests(connection));
            ArrayList xss = XSSr.XSSAttacksSimple(dbdata.getRequests(connection));
            ArrayList lfi = LFIr.LFIAttack(dbdata.getRequests(connection));
            arrayAttacks = attacks.totalAttacks(sqli,lfi,xss);
            System.out.println("\nData Mining\n=============\n");
            System.out.println("Number of Attacks : " + attacks.numberOfAttacks(sqli,lfi,xss));
            System.out.println("Percentage of Attacks : "+attacks.attacksPercentage(attacks.numberOfAttacks(sqli,lfi,xss))+"%");
            System.out.println("SQL Injection Attacks : "+SQLr.numberOfSQLInjections(sqli));
            System.out.println("XSS Attacks : "+XSSr.numberOfXSSSimple(xss));
            System.out.println("LFI Attacks : "+LFIr.numberOfLFIAttacks(lfi)+"\n\n");
            countries = cs.getCountries(arrayAttacks, dbdata.getRequests(connection));
            hsmap = cs.getCountryCounts(countries);


            for (String country: hsmap.keySet())
            {
                String key = country;
                String value = hsmap.get(country).toString();
                System.out.println(key + " " + value);
            }


            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
