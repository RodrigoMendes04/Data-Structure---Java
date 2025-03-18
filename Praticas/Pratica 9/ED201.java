import java.util.Scanner;

public class ED201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler a duração máxima da viagem (D) e o número de músicas disponíveis (N)
        int D = scanner.nextInt();
        int N = scanner.nextInt();

        // Ler a duração de cada música
        int[] musicas = new int[N];
        for (int i = 0; i < N; i++) {
            musicas[i] = scanner.nextInt();
        }

        // Calcular a melhor playlist
        System.out.println(melhorPlaylist(D, N, musicas));
    }

    public static int melhorPlaylist(int D, int N, int[] musicas) {
        // Vetor dp para armazenar os melhores resultados
        int[] dp = new int[D + 1];

        // Processar cada música
        for (int duracao : musicas) {
            // Atualizar dp de trás para frente para evitar reutilização de músicas
            for (int j = D; j >= duracao; j--) {
                dp[j] = Math.max(dp[j], dp[j - duracao] + duracao);
            }
        }

        // O melhor resultado será o maior valor em dp[D]
        return dp[D];
    }
}
