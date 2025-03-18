import java.util.Scanner;
import java.util.LinkedList;

public class ED172 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BSTMap<String, Integer> wordCount = new BSTMap<>();

        // Ler o texto e contar as ocorrências de cada palavra
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] words = line.split(" ");
            for (String word : words) {
                Integer count = wordCount.get(word);
                if (count == null) {
                    wordCount.put(word, 1);
                } else {
                    wordCount.put(word, count + 1);
                }
            }
        }

        // Obter as palavras em ordem alfabética
        LinkedList<String> keys = wordCount.keys();

        // Imprimir as palavras e suas contagens
        for (String key : keys) {
            System.out.println(key + ": " + wordCount.get(key));
        }

        scanner.close();
    }
}