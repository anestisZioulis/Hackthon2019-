package statistics;

import java.util.ArrayList;

public class Attacks
{
    public ArrayList<String> totalAttacks(ArrayList sqli, ArrayList lfi, ArrayList xss)
    {
        ArrayList<String> total = new ArrayList<>();
        total.addAll(sqli);
        total.addAll(lfi);
        total.addAll(xss);
        return total;
    }
    public int numberOfAttacks(ArrayList sqli, ArrayList lfi, ArrayList xss)
    {
        int numberOfAttacks=0;
        numberOfAttacks+=sqli.size();
        numberOfAttacks+=lfi.size();
        numberOfAttacks+=xss.size();
        return numberOfAttacks;
    }
    public float attacksPercentage(int numOfAttacks)
    {
        float percentage=0;
        percentage = (float)818200/85354;
        return percentage;
    }
}
