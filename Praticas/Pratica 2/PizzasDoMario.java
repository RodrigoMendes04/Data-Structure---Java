import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PizzasDoMario {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Set<Integer> ingredientesQueNaoGosta = new HashSet<>();
        for (int i = 0; i < n; i++) {
            ingredientesQueNaoGosta.add(scanner.nextInt());
        }

        int p = scanner.nextInt();
        int pizzasQueMarioPodeEncomendar = 0;

        for (int i = 0; i < p; i++) {
            int k = scanner.nextInt();
            Set<Integer> ingredientesDaPizza = new HashSet<>();
            for (int j = 0; j < k; j++) {
                ingredientesDaPizza.add(scanner.nextInt());
            }

            if (naoContemIngredientesQueNaoGosta(ingredientesDaPizza, ingredientesQueNaoGosta)) {
                pizzasQueMarioPodeEncomendar++;
            }
        }

        System.out.println(pizzasQueMarioPodeEncomendar);
    }

    private static boolean naoContemIngredientesQueNaoGosta(Set<Integer> ingredientesDaPizza, Set<Integer> ingredientesQueNaoGosta) {
        for (int ingrediente : ingredientesQueNaoGosta) {
            if (ingredientesDaPizza.contains(ingrediente)) {
                return false;
            }
        }
        return true;
    }
}