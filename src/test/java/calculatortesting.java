import calculator.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculatortesting {
    private static final double DELTA = 1e-15;
    Calculator calc=new Calculator();
    @Test
    public void factorialTruePositive(){
        assertEquals("Checking factorial for True Positive", 24.0, calc.factorial(4),DELTA);
        assertEquals("Checking factorial for True Positive", Double.NaN, calc.factorial(-4),DELTA);
    }
    @Test
    public void factorialFalsePositive(){
        assertEquals("Checking factorial for True Positive", 1.0, calc.factorial(4),DELTA);
        assertEquals("Checking factorial for True Positive", 24.0, calc.factorial(-4),DELTA);
    }
    @Test
    public void logarithmTruePositive(){
        assertEquals("Checking Natural log for True Positive", 1.0, calc.logarithm(Math.exp(1)),DELTA);
        assertEquals("Checking Natural log for True Positive", Double.NaN, calc.logarithm(-1.0),DELTA);
        assertEquals("Checking Natural log for True Positive", Double.NaN, calc.logarithm(0.0),DELTA);
    }
    @Test
    public void logarithmFalsePositive(){
        assertEquals("Checking Natural log for True Positive", Double.NaN, calc.logarithm(Math.exp(1)),DELTA);
        assertEquals("Checking Natural log for True Positive", 1.0, calc.logarithm(((-1)*Math.exp(1))),DELTA);
        assertEquals("Checking Natural log for True Positive", 0.0, calc.logarithm(0.0),DELTA);
    }
    @Test
    public void powerTruePositive(){
        assertEquals("Checking x raised to y for True Positive", 16.0, calc.power(4,2),DELTA);
        assertEquals("Checking x raised to y for True Positive", Double.NaN, calc.power(-4,2.3),DELTA);
    }
    @Test
    public void powerFalsePositive(){
        assertEquals("Checking x raised to y for True Positive", 10.0, calc.power(4,2),DELTA);
        assertEquals("Checking x raised to y for True Positive", 16.0, calc.power(-4,2.3),DELTA);
    }
    @Test
    public void squarerootTruePositive(){
        assertEquals("Checking square root for True Positive", 8.0, calc.Sqroot(64),DELTA);
        assertEquals("Checking square root for True Positive", Double.NaN, calc.Sqroot(-4),DELTA);
    }
    @Test
    public void squarerootTFalsePositive(){
        assertEquals("Checking square root for True Positive", 6.0, calc.Sqroot(64),DELTA);
        assertEquals("Checking square root for True Positive", 2.0, calc.Sqroot(-4),DELTA);
    }
}
