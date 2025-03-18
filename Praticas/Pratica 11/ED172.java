import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ED172 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordCount = new TreeMap<>();

        // Ler o texto linha por linha
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");

            // Contar as ocorrências de cada palavra
            for (String word : words) {
                if (!word.isEmpty()) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }
        }

        // Imprimir as palavras e suas contagens em ordem alfabética
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}