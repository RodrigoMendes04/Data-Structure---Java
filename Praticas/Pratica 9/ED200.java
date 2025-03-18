import java.util.Scanner;

public class ED200 {
    static int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler o número de casos
        int N = scanner.nextInt();

        for (int t = 0; t < N; t++) {
            // Ler dimensões da matriz
            int L = scanner.nextInt();
            int C = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            // Ler a matriz da caixa de Petri
            char[][] petri = new char[L][C];
            for (int i = 0; i < L; i++) {
                petri[i] = scanner.nextLine().toCharArray();
            }

            // Descobrir o tamanho do maior micróbio
            boolean[][] visited = new boolean[L][C];
            int maxMicrobeSize = 0;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < C; j++) {
                    if (petri[i][j] == '#' && !visited[i][j]) {
                        int size = exploreMicrobe(petri, visited, i, j, L, C);
                        maxMicrobeSize = Math.max(maxMicrobeSize, size);
                    }
                }
            }

            // Imprimir o tamanho do maior micróbio para este caso
            System.out.println(maxMicrobeSize);
        }

        scanner.close();
    }

    // Método para explorar um micróbio usando busca em profundidade (DFS)
    private static int exploreMicrobe(char[][] petri, boolean[][] visited, int row, int col, int L, int C) {
        int size = 1;
        visited[row][col] = true;

        for (int d = 0; d < 8; d++) { // Explorar todas as 8 direções
            int newRow = row + dRow[d];
            int newCol = col + dCol[d];

            if (isValid(newRow, newCol, L, C) && petri[newRow][newCol] == '#' && !visited[newRow][newCol]) {
                size += exploreMicrobe(petri, visited, newRow, newCol, L, C);
            }
        }

        return size;
    }

    // Método para verificar se uma posição é válida na matriz
    private static boolean isValid(int row, int col, int L, int C) {
        return row >= 0 && row < L && col >= 0 && col < C;
    }
}
