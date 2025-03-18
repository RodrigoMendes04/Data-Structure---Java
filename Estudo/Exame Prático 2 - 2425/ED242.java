import java.util.*;

public class ED242 {
    private static int L, C, K;
    private static char[][] map;
    private static boolean[][] visited;
    private static List<Integer> lakeSizes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        K = scanner.nextInt();
        L = scanner.nextInt();
        C = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        map = new char[L][C];
        visited = new boolean[L][C];

        for (int i = 0; i < L; i++) {
            map[i] = scanner.nextLine().toCharArray();
        }

        // Identify and count lakes
        for (int i = 1; i < L - 1; i++) {
            for (int j = 1; j < C - 1; j++) {
                if (map[i][j] == '.' && !visited[i][j]) {
                    int size = dfs(i, j);
                    if (size > 0) {
                        lakeSizes.add(size);
                    }
                }
            }
        }

        // Sort lake sizes in ascending order
        Collections.sort(lakeSizes);

        // Calculate the minimum number of cells to fill
        int lakesToRemove = lakeSizes.size() - K;
        int cellsToFill = 0;
        for (int i = 0; i < lakesToRemove; i++) {
            cellsToFill += lakeSizes.get(i);
        }

        System.out.println(cellsToFill);
        scanner.close();
    }

    private static int dfs(int x, int y) {
        if (x <= 0 || x >= L - 1 || y <= 0 || y >= C - 1) {
            return -1; // Connected to the ocean
        }
        if (map[x][y] == '#' || visited[x][y]) {
            return 0;
        }

        visited[x][y] = true;
        int size = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int result = dfs(nx, ny);
            if (result == -1) {
                size = -1; // This lake is connected to the ocean
            } else if (size != -1) {
                size += result;
            }
        }

        return size;
    }
}