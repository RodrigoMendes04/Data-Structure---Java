import java.util.Scanner;

public class ED200 {
    private static int L, C;
    private static char[][] grid;
    private static boolean[][] visited;
    private static int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for (int i = 0; i < N; i++) {
            L = scanner.nextInt();
            C = scanner.nextInt();
            grid = new char[L][C];
            visited = new boolean[L][C];

            for (int j = 0; j < L; j++) {
                grid[j] = scanner.next().toCharArray();
            }

            int maxMicrobeSize = 0;
            for (int row = 0; row < L; row++) {
                for (int col = 0; col < C; col++) {
                    if (grid[row][col] == '#' && !visited[row][col]) {
                        int size = dfs(row, col);
                        maxMicrobeSize = Math.max(maxMicrobeSize, size);
                    }
                }
            }

            System.out.println(maxMicrobeSize);
        }

        scanner.close();
    }

    private static int dfs(int row, int col) {
        visited[row][col] = true;
        int size = 1;

        for (int i = 0; i < 8; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (isValid(newRow, newCol) && grid[newRow][newCol] == '#' && !visited[newRow][newCol]) {
                size += dfs(newRow, newCol);
            }
        }

        return size;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < L && col >= 0 && col < C;
    }
}