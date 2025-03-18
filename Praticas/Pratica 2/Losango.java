import java.util.Scanner;

public class Losango {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int meio = n / 2; // Ponto central

        // Parte superior e linha central do losango
        for (int i = 0; i <= meio; i++) {
            //pontos à esquerda
            for (int j = 0; j < meio - i; j++) {
                System.out.print(".");
            }

            // Imprimir o padrão de '#'
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("#");
            }

            //pontos à direita
            for (int j = 0; j < meio - i; j++) {
                System.out.print(".");
            }

            System.out.println();
        }

        // Parte inferior do losango
        for (int i = meio - 1; i >= 0; i--) {
            //pontos à esquerda
            for (int j = 0; j < meio - i; j++) {
                System.out.print(".");
            }

            // Imprimir o padrão de '#'
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("#");
            }

            //pontos à direita
            for (int j = 0; j < meio - i; j++) {
                System.out.print(".");
            }

            System.out.println();
        }
        scanner.close();
    }
}
