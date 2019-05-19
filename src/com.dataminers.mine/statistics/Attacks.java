package statistics;

import java.util.ArrayList;

public class Attacks
{
    public ArrayList getAllAttackRequests(ArrayList sqli, ArrayList lfi, ArrayList xss)
    {
        sqli.addAll(lfi);
        sqli.addAll(xss);
        return sqli;
    }

    public int numberOfAttacks(ArrayList attacks)
    {
        int numberOfAttacks=0;
        numberOfAttacks=attacks.size();
        return numberOfAttacks;
    }
}
