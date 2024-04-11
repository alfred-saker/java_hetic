public class Calculateur {
    public static void main(String[] args) {
        // Vérification du nombre d'arguments
        if (args.length != 3) {
            System.out.println("Usage: java Calculateur <nombre1> <nombre2> <opérateur>");
            return;
        }

        // Conversion des arguments en nombres
        double nombre1, nombre2;
        try {
            nombre1 = Double.parseDouble(args[0]);
            nombre2 = Double.parseDouble(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Les deux premiers arguments doivent être des nombres valides.");
            return;
        }

        // Récupération de l'opérateur
        String operateur = args[2];

        // Vérification de l'opérateur et exécution de l'opération correspondante
        double resultat = 0;
        switch (operateur) {
            case "+":
                resultat = nombre1 + nombre2;
                break;
            case "-":
                resultat = nombre1 - nombre2;
                break;
            case "*":
                resultat = nombre1 * nombre2;
                break;
            default:
                System.out.println("Opérateur non reconnu. Les opérateurs valides sont +, - et *.");
                return;
        }

        // Affichage du résultat
        System.out.println("Résultat : " + resultat);
    }
}
