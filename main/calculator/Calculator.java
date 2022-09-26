package calculator;

import java.util.Arrays;
import java.util.HashMap;

public class Calculator {

    static int id = 0;

    public Calculator()
    {
        id++;
    }

    public int getId()
    {
        return id;
    }

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

    private static long factorial(int n)
    {
        long fact = n;
        for (int i = 1; i < n; i++)
        {
            fact *= i;
        }
        return fact;
    }

    private static int sum(int[] array)
    {
        int total = 0;
        for (int num: array) {
            total += num;
        }
        return total;
    }

    private static int multCombine(int[] array)
    {
        int total = 1;
        for(int num: array)
        {
            total *= num;
        }
        return total;
    }

    public static double nPr(int n, int r) {
        return ((double) factorial(n)) / factorial(n - r);
    }

    static class Combination {

        /**
         * Calculates a combination
         *
         * @param n number of objects to choose from
         * @param r number of objects to choose
         * @return the value of the combination
         */
        public static double nCr(int n, int r) {
            return ((double) factorial(n)) / (factorial(r) * (factorial(n - r)));
        }

        /**
         * Calculates probability that all selections have the same outcome
         *
         * @param objects      array of events
         * @param numSelection number of selections to make
         * @return the probability that all selections are the same
         */
        public static double pAllSame(int[] objects, int numSelection) {
            double p = 0.0;
            for (int object : objects) {
                p += nCr(object, numSelection);
                //System.out.println(p);
            }
            p /= nCr(sum(objects), numSelection);
            return p;
        }

        /**
         * Calculates probability that exactly numSame of posSame objects are chosen from objects,
         * given numSelected are chosen
         *
         * @param objects      array of events
         * @param numSelection number of selections to make
         * @param numSame      number of same objects that we want
         * @param posSame      event position in @objects that we want
         * @return the probability that exactly numSame of posSame objects are chosen
         */
        public static double pExactlySame(int[] objects, int numSelection, int numSame, int posSame) {
            double p = 0.0;
            p += nCr(objects[posSame], numSame);
            p *= (sum(objects) - objects[posSame]);
            p /= nCr(sum(objects), numSelection);
            return p;
        }

        public static double pOneEach(int[] objects) {
            double p = multCombine(objects);
            p /= nCr(sum(objects), objects.length);
            return p;
        }

        public static double pNSelections(int[] objects, int numSelection, int posSelection) {
            double p = 0.0;
            p = nCr(sum(objects) - objects[posSelection], numSelection);
            p /= nCr(sum(objects), numSelection);
            return p;
        }

    }

    public static class Matrix {

        private static double[][] pMatrix;

        public static void setup(double[] values, int row, int col)
        {
            pMatrix = new double[row][col];
            for (int i = 0; i < row; i++)
            {
                System.arraycopy(values, i * col, pMatrix[i], 0, col);
            }

            print();
        }

        public static void print()
        {
            for (double[] matrix : pMatrix) {
                for (int j = 0; j < pMatrix[0].length; j++) {
                    System.out.print(matrix[j] + ", ");
                }
                System.out.println();
            }
        }

        public static double pRow(int row) {
            double p = 0.0;
            for (double x: pMatrix[row]) {
                p += x;
            }
            return p;
        }

    }
}

