package fr.hetic;

public class OperationFactory {
    private static final Operation ADDITION = (a, b) -> a + b;
    private static final Operation SUBTRACTION = (a, b) -> a - b;
    private static final Operation MULTIPLICATION = (a, b) -> a * b;

    public static Operation createOperation(String operator) {
        switch (operator) {
            case "+":
                return ADDITION;
            case "-":
                return SUBTRACTION;
            case "*":
                return MULTIPLICATION;
            default:
                return null;
        }
    }
}
