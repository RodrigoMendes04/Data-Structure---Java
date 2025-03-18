import java.util.Scanner;

public class ED202 {
    private static int N;
    private static double[][] dist;
    private static double[][] dp;
    private static final double INF = Double.MAX_VALUE / 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of locations
        N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Read the names of the locations
        String[] locations = new String[N];
        for (int i = 0; i < N; i++) {
            locations[i] = scanner.next();
        }

        // Read the distance matrix
        dist = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dist[i][j] = scanner.nextDouble();
            }
        }

        // Initialize the dp array
        dp = new double[N][1 << N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < (1 << N); j++) {
                dp[i][j] = INF;
            }
        }

        // Start the TSP from the first location
        double result = tsp(0, 1);
        System.out.printf("%.2f\n", result);

        scanner.close();
    }

    private static double tsp(int pos, int mask) {
        if (mask == (1 << N) - 1) {
            return dist[pos][0];
        }

        if (dp[pos][mask] != INF) {
            return dp[pos][mask];
        }

        for (int next = 0; next < N; next++) {
            if ((mask & (1 << next)) == 0) {
                double newDist = dist[pos][next] + tsp(next, mask | (1 << next));
                dp[pos][mask] = Math.min(dp[pos][mask], newDist);
            }
        }

        return dp[pos][mask];
    }
}