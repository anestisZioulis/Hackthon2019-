package domain;
import database.DatabaseConnection;

public class Main {
    public static void main(String [] arg)
    {
        DatabaseConnection dc = new DatabaseConnection();
        boolean connected = dc.connectDatabase();
    }
}
