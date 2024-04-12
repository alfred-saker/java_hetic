public class CalculatorApp {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java CalculatorApp <nombre1> <nombre2> <opérateur>");
            return;
        }

        try {
            double nombre1 = InputParser.parseNumber(args[0]);
            double nombre2 = InputParser.parseNumber(args[1]);
            String operator = args[2];

            Operation operation = OperationFactory.createOperation(operator);
            if (operation == null) {
                System.out.println("Opérateur non reconnu. Les opérateurs valides sont +, - et *.");
                return;
            }

            double result = operation.execute(nombre1, nombre2);
            System.out.println("Résultat : " + result);
        } catch (CalculatorException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

public interface Operation {
    double execute(double operand1, double operand2);
}


public class Addition implements Operation {
    @Override
    public double execute(double operand1, double operand2) {
        return operand1 + operand2;
    }
}

public class Subtraction implements Operation {
    @Override
    public double execute(double operand1, double operand2) {
        return operand1 - operand2;
    }
}

public class Multiplication implements Operation {
    @Override
    public double execute(double operand1, double operand2) {
        return operand1 * operand2;
    }
}


public class OperationFactory {
    public static Operation createOperation(String operator) {
        switch (operator) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            default:
                return null;
        }
    }
}


public class InputParser {
    public static double parseNumber(String input) throws SyntaxErrorException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new SyntaxErrorException("Les arguments doivent être des nombres valides.");
        }
    }
}


public abstract class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
    }
}

public class SyntaxErrorException extends CalculatorException {
    public SyntaxErrorException(String message) {
        super(message);
    }
}
