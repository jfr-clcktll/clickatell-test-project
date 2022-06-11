package calculator;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void add2and2_checkTotal_shouldBeEqualTo4() {

        Calculator calculator = new Calculator();

        calculator.add(2);

        calculator.add(2);

        assertEquals(4, calculator.getTotal());
    }
}
