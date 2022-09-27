package calculator;

import org.junit.jupiter.api.Test;
import calculator.Calculator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    double delta = 0.0001;

    @Test
    public void testOperationsSuite()
    {
        double[] probabilities = {0.14, 0.10, 0.06};

        double p;

        p = Operations.intersection(probabilities[0], probabilities[1]);

        assertEquals(0.014, p, delta);

        p = Operations.union(probabilities[0], probabilities[1]);

        assertEquals(0.226, p, delta);

        p = Operations.exclusive(probabilities[0], probabilities[1]);

        assertEquals(0.212, p, delta);

        p = Operations.single(probabilities[0], probabilities[1]);

        assertEquals(0.126, p, delta);

        p = Operations.conditional(probabilities[0], probabilities[1]);

        assertEquals(0.1, p, delta);

    }

    @Test
    public void testCombinationSuite()
    {
        int[] events = {6, 7, 5};

        double p;

        p = Combination.pAllSame(events, 3);
        assertEquals(0.07965686274509803, p);

        p = Combination.pExactlySame(events, 3, 2, 2);
        assertEquals(0.15931372549019607, p);

        p = Combination.pOneEach(events);
        assertEquals(0.25735294117647056, p);

        p = Combination.pNSelections(events, 5, 2);
        assertEquals(0.15021008403361344, p);

        events = new int[]{10, 8, 6};

        p = Combination.sAllSame(events, 3, 0);
        assertEquals(120, p, delta);
    }

    @Test
    public void testMatrixSuite()
    {
        double[] values = {.16, .20, .24, .20, .10, .10};
        Matrix.setup(values, 2, 3);
        double p;
        p = Matrix.pRow(1);
        assertEquals(.40, p);

        p = Matrix.pCol(0);
        assertEquals(.36, p);

        values = new double[]{.03, 0.02, 0.03, 0.05, 0.15, 0.07, 0.04, 0.02, 0.08};
        Matrix.setup(values, 3, 3);


    }

    @Test
    public void testPMFSuite()
    {
        double[] inputPMF = {0.11, 0.15, .2, .25, .19, .09, .01};

        PMF.setup(inputPMF);

        double p;

        p = PMF.pLessThan(4);
        assertEquals(0.71, p);

        p = PMF.pMoreThan(3);
        assertEquals(0.54, p);

        p = PMF.pBetween(2, 6);
        assertEquals(0.73, p);
    }


}
