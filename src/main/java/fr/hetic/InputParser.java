package fr.hetic;

public class InputParser {
    public static double parseNumber(String input) throws SyntaxErrorException {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new SyntaxErrorException("Les arguments doivent être des nombres valides.");
        }
    }
}