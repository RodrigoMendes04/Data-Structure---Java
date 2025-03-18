import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ED164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler o número de palavras
        int N = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha após o número

        // Usar um Set para armazenar palavras únicas
        Set<String> uniqueWords = new HashSet<>();

        // Ler as palavras e adicioná-las ao Set
        for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();
            uniqueWords.add(word);
        }

        // O tamanho do Set é o número de palavras diferentes
        System.out.println(uniqueWords.size());

        scanner.close();
    }
}