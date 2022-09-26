
import java.util.HashMap;

public class Calculator {

    public double cProb(int PLCHLDR)
    {
        return PLCHLDR;
    }

    public double cProb(int PLCHLDR1, int PLCHLDR2)
    {
        return PLCHLDR1 + PLCHLDR2;
    }

    public HashMap<String, Double> cProbDependent(double eA, double eB, double eAorB)
    {
        HashMap<String, Double> outcomes = new HashMap<>();

        double both = eA + eB - eAorB;

        outcomes.put("both", both);

        double neither = 1 - eAorB;

        outcomes.put("neither", neither);

        return outcomes;
    }

    private int factorial(int n)
    {
        int fact = n;
        for (int i = n; i > 0; i--)
        {
            fact *= i;
        }
        return fact;
    }

    public double nCr(int n, int r)
    {
        return ((double)factorial(n))/(factorial(r)*(factorial(n-r)));
    }

    public double nPr(int n, int r)
    {
        return ((double)factorial(n))/factorial(n-r);
    }
}

