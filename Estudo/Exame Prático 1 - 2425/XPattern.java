import java.util.Scanner;

public class XPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numX = scanner.nextInt();
        int[] sizes = new int[numX];

        for (int x = 0; x < numX; x++) {
            sizes[x] = scanner.nextInt();
        }

        for (int x = 0; x < numX; x++) {
            int n = sizes[x];

            if (n % 2 == 0) {
                continue;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == i || j == n - i - 1) {
                        System.out.print("#");
                    } else {
                        System.out.print(".");
                    }
                }
                System.out.println();
            }
        }
    }
}