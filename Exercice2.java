import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class SyntaxErrorException extends Exception {
    public SyntaxErrorException(String message) {
        super(message);
    }
}

class UnsupportedOperatorException extends Exception {
    public UnsupportedOperatorException(String message) {
        super(message);
    }
}

public class Calculator {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Calculator <directory>");
            System.exit(1);
        }

        String directoryPath = args[0];
        File directory = new File(directoryPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory");
            System.exit(1);
        }

        File[] files = directory.listFiles((dir, name) -> name.endsWith(".op"));

        if (files == null || files.length == 0) {
            System.out.println("No .op files found in the directory");
            System.exit(1);
        }

        for (File file : files) {
            processFile(file);
        }
    }

    private static void processFile(File file) {
        File outputFile = new File(file.getParent(), file.getName().replace(".op", ".res"));

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    double result = processLine(line);
                    writer.write(String.valueOf(result));
                    writer.newLine();
                } catch (SyntaxErrorException | UnsupportedOperatorException e) {
                    writer.write("ERROR: " + e.getMessage());
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static double processLine(String line) throws SyntaxErrorException, UnsupportedOperatorException {
        String[] parts = line.split(";");
        if (parts.length != 3) {
            throw new SyntaxErrorException("Invalid syntax");
        }

        double num1, num2;
        try {
            num1 = Double.parseDouble(parts[0]);
            num2 = Double.parseDouble(parts[1]);
        } catch (NumberFormatException e) {
            throw new SyntaxErrorException("Invalid numbers");
        }

        char operator = parts[2].charAt(0);
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            default:
                throw new UnsupportedOperatorException("Unsupported operator: " + operator);
        }

        return result;
    }
}
