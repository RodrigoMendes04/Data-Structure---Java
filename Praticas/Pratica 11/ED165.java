import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ED165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler o número de elementos no conjunto
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Ler o número de perguntas
        int P = scanner.nextInt();
        int[] questions = new int[P];
        for (int i = 0; i < P; i++) {
            questions[i] = scanner.nextInt();
        }

        // Usar um Set para armazenar os números do conjunto
        Set<Integer> numberSet = new HashSet<>();
        for (int number : numbers) {
            numberSet.add(number);
        }

        // Verificar cada pergunta
        for (int question : questions) {
            boolean found = false;
            for (int number : numbers) {
                int complement = question - number;
                if (numberSet.contains(complement)) {
                    found = true;
                    break;
                }
            }
            if (found) {
                System.out.println(question + ": sim");
            } else {
                System.out.println(question + ": nao");
            }
        }

        scanner.close();
    }
}