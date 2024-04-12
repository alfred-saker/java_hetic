import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {
        double result = Calculator.add(10, 5);
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        double result = Calculator.subtract(10, 5);
        assertEquals(5, result);
    }

    @Test
    public void testMultiplication() {
        double result = Calculator.multiply(10, 5);
        assertEquals(50, result);
    }
}
