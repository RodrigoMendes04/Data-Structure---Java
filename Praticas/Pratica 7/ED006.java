import java.util.Scanner;

public class ED006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();  // Número de casos a analisar
        scanner.nextLine(); // Consumir a quebra de linha pendente

        for (int caseNumber = 1; caseNumber <= N; caseNumber++) {
            System.out.println("Caso #" + caseNumber);

            // Leitura da frase
            String frase = scanner.nextLine().trim();

            // Leitura do número de crianças e seus nomes
            int K = scanner.nextInt();
            String[] nomes = new String[K];
            for (int i = 0; i < K; i++) {
                nomes[i] = scanner.next();
            }

            scanner.nextLine(); // Consumir a quebra de linha após os nomes

            // Verifica quem se livrou
            int indexCarlos = getIndexCarlos(nomes);
            int indexLivrou = getIndexLivrou(frase, K, indexCarlos);

            // Output
            if (indexCarlos == indexLivrou) {
                System.out.println("O Carlos nao se livrou");
            } else {
                System.out.println("O Carlos livrou-se (coitado do " + nomes[indexLivrou] + "!)");
            }

            System.out.println();  // Linha em branco entre casos
        }

        scanner.close();
    }

    private static int getIndexCarlos(String[] nomes) {
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals("Carlos")) {
                return i;
            }
        }
        return -1;  // Não deveria acontecer
    }

    private static int getIndexLivrou(String frase, int K, int indexCarlos) {
        String[] palavras = frase.trim().split("\\s+");
        int indiceAtual = indexCarlos;

        for (String palavra : palavras) {
            int incremento = palavra.length();
            indiceAtual = (indiceAtual + incremento) % K;
        }

        return indiceAtual;
    }
}
