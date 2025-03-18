import java.util.ArrayList;
import java.util.Scanner;

public class VerificaPalindromos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numLinhas = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> resultados = new ArrayList<>();

        for (int i = 0; i < numLinhas; i++) {
            String linha = scanner.nextLine();

            if (ehPalindromo(linha)) {
                resultados.add("sim");
            } else {
                resultados.add("nao");
            }
        }
        System.out.println(numLinhas);

        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    public static boolean ehPalindromo(String linha) {
        linha = linha.replaceAll("[^a-zA-Z]", "").toLowerCase();

        int inicio = 0;
        int fim = linha.length() - 1;

        while (inicio < fim) {
            if (linha.charAt(inicio) != linha.charAt(fim)) {
                return false;
            }
            inicio++;
            fim--;
        }

        return true;
    }
}