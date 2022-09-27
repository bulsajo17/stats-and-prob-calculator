package calculator;

import java.util.Arrays;
import java.util.HashMap;

public class Calculator {

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

    static class Operations {


        /**
         * Calculates the intersection of two independent events
         *
         * @param a event one
         * @param b event two
         * @return the probability that both events happen
         */
        public static double intersection(double a, double b)
        {
            double i;
            i = a * b;
            return i;
        }

        /**
         * Calculates the union of two independent events
         *
         * @param a event one
         * @param b event two
         * @return the probability that either both events happen or just one event happens
         */
        public static double union (double a, double b)
        {
            double u = a + b;
            u -= intersection(a, b);
            return u;
        }

        /**
         * Returns the conditional probability of b, given a has happened.
         *
         * @param a the event that has happened
         * @param b the event that is conditionally dependent on a
         * @return the conditional probability
         */
        public static double conditional(double a, double b)
        {
            double p;
            p = intersection(a, b)/a;
            return p;
        }

        public static double exclusive(double a, double b)
        {
            return union(a, b) - intersection(a, b);
        }

        /**
         * Calculates the probability that event a happens, but NOT event b
         *
         * @param a the event to occur
         * @param b the event that should not occur
         * @return the probability of a not b
         */
        public static double single(double a, double b)
        {
            return a * (1-b);
        }
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
            return (double)(factorial(n)) / (factorial(r) * (factorial(n - r)));
        }

        /**
         * Calculates number of selections that results in all selections being from posSelection
         *
         * @param objects the list of selection choices
         * @param numSelection the number of selections to be made
         * @param posSelection which selection we want
         * @return the number of selections that result in all selections being from posSelection
         */
        public static double sAllSame(int[] objects, int numSelection, int posSelection)
        {
           return nCr(objects[posSelection], numSelection);
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
            }
            p /= nCr(sum(objects), numSelection);
            //System.out.println(p);
            return p;
        }

        /**
         * Calculates probability that all selections have the same outcome
         *
         * @param objects      array of events
         * @param numSelection number of selections to make
         * @param posSelection which event we want the selections to be
         * @return the probability that all selections are from posSelection
         */
        public static double pAllSame(int[] objects, int numSelection, int posSelection)
        {
            double p = 0.0;
            p += nCr(objects[posSelection], numSelection);
            p /= nCr(sum(objects), numSelection);
            System.out.println(sum(objects));
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

        public static double pCol(int col)
        {
            double p = 0.0;
            for (double[] x : pMatrix)
            {
                p += x[col];
            }
            return p;
        }

        public static double retrieveValue(int row, int col)
        {
            return pMatrix[row][col];
        }

    }
}

