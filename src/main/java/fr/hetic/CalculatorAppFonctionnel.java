package fr.hetic;

public class CalculatorAppFonctionnel {
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
        } catch (SyntaxErrorException e) {
            System.out.println("Erreur de syntaxe : " + e.getMessage());
        // } catch (CalculatorException e) {
        //     System.out.println("Erreur de calcul : " + e.getMessage());
        }
    }    
}

