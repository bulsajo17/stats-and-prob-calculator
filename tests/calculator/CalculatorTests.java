package calculator;

import org.junit.jupiter.api.Test;
import calculator.Calculator.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    int[] objects = {6, 7, 5};

    @Test
    public void testCombinationSuite()
    {
        double p;
        p = Combination.pAllSame(objects, 3);
        assertEquals(0.07965686274509803, p);

        p = Combination.pExactlySame(objects, 3, 2, 2);
        assertEquals(0.15931372549019607, p);

        p = Combination.pOneEach(objects);
        assertEquals(0.25735294117647056, p);

        p = Combination.pNSelections(objects, 5, 2);
        assertEquals(0.15021008403361344, p);
    }

    @Test
    public void testMatrixSuite()
    {
        double[] values = {.16, .20, .24, .20, .10, .10};
        Matrix.setup(values, 2, 3);
        double p;
        p = Matrix.pRow(1);
    }


}
