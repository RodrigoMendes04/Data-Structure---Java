import java.util.Scanner;
import java.util.Arrays;

public class MediaAmplitude {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] valores = new int[n];
        for (int i = 0; i < n; i++) {
            valores[i] = scanner.nextInt();
        }

        double media = calcularMedia(valores);
        int amplitude = calcularAmplitude(valores);

        System.out.printf("%.2f\n", media);
        System.out.println(amplitude);
    }

    public static double calcularMedia(int[] valores) {
        int soma = 0;
        for (int valor : valores) {
            soma += valor;
        }
        return (double) soma / valores.length;
    }

    public static int calcularAmplitude(int[] valores) {
        Arrays.sort(valores);
        int min = valores[0];
        int max = valores[valores.length - 1];
        return max - min;
    }
}