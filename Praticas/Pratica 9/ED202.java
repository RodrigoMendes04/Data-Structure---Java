import java.util.Scanner;

public class ED202 {
    static int N;
    static double[][] dist;
    static boolean[] visited;
    static double minPath;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler o número de locais
        N = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        // Ler os nomes dos locais (ignorar para este problema)
        String[] locais = scanner.nextLine().split("\\s+");

        // Ler a matriz de distâncias
        dist = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = scanner.nextDouble();
            }
        }

        // Inicializar variáveis para a busca do menor caminho
        visited = new boolean[N];
        minPath = Double.MAX_VALUE;

        // Começar a busca a partir do local inicial (índice 0)
        visited[0] = true;
        findShortestPath(0, 0, 0, 1);

        // Imprimir o menor caminho encontrado, arredondado a duas casas decimais
        System.out.printf("%.2f%n", minPath);

        scanner.close();
    }
    
    private static void findShortestPath(int current, double cost, int start, int count) {
        if (count == N) {
            // Fechar o ciclo voltando ao local inicial
            minPath = Math.min(minPath, cost + dist[current][start]);
            return;
        }

        for (int next = 0; next < N; next++) {
            if (!visited[next]) {
                visited[next] = true;
                findShortestPath(next, cost + dist[current][next], start, count + 1);
                visited[next] = false; // Backtrack
            }
        }
    }
}
