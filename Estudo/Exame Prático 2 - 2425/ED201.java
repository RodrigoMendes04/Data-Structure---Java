import java.util.Scanner;

public class ED201 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the duration of the trip and the number of songs
        int D = scanner.nextInt();
        int N = scanner.nextInt();
        int[] durations = new int[N];

        // Read the durations of the songs
        for (int i = 0; i < N; i++) {
            durations[i] = scanner.nextInt();
        }

        // Dynamic programming array to keep track of possible sums
        boolean[] dp = new boolean[D + 1];
        dp[0] = true;

        // Process each song duration
        for (int i = 0; i < N; i++) {
            for (int j = D; j >= durations[i]; j--) {
                if (dp[j - durations[i]]) {
                    dp[j] = true;
                }
            }
        }

        // Find the maximum possible sum that is less than or equal to D
        for (int i = D; i >= 0; i--) {
            if (dp[i]) {
                System.out.println(i);
                break;
            }
        }

        scanner.close();
    }
}