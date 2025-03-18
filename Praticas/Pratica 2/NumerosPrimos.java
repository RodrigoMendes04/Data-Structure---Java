import java.util.Scanner;

public class NumerosPrimos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        boolean[] isPrimo = crivoDeEratostenes(B);
        int count = contarPrimosNoIntervalo(A, B, isPrimo);
        System.out.println(count);
    }

    private static boolean[] crivoDeEratostenes(int limite) {
        boolean[] isPrimo = new boolean[limite + 1];
        for (int i = 2; i <= limite; i++) {
            isPrimo[i] = true;
        }

        for (int i = 2; i * i <= limite; i++) {
            if (isPrimo[i]) {
                for (int j = i * i; j <= limite; j += i) {
                    isPrimo[j] = false;
                }
            }
        }

        return isPrimo;
    }

    private static int contarPrimosNoIntervalo(int A, int B, boolean[] isPrimo) {
        int count = 0;
        for (int i = A; i <= B; i++) {
            if (isPrimo[i]) {
                count++;
            }
        }
        return count;
    }
}