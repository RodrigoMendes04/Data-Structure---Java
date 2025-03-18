// Cria um programa em java onde cria Y's, ou seja se o n = 5 cria
//#...#
//.#.#.
//..#..
//..#..
//..#..
//onde n é sempre impar
import java.util.Scanner;

public class YPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar o valor de n
        System.out.print("Digite um valor ímpar para n: ");
        int n = scanner.nextInt();

        // Verifica se o número é ímpar
        if (n % 2 == 0) {
            System.out.println("Por favor, insira um número ímpar.");
            return;
        }

        // Construir o padrão "Y"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Parte superior do "Y"
                if (i <= n / 2 && (j == i || j == n - i - 1)) {
                    System.out.print("#");
                }
                // Parte inferior do "Y"
                else if (i > n / 2 && j == n / 2) {
                    System.out.print("#");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
