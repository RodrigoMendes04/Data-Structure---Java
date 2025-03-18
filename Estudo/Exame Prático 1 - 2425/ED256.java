import java.util.LinkedList;
import java.util.Queue;

public class ED256 {
    public static void processQueue(Queue<Integer> doubts, int M) {
        int day = 1; // Contador de dias

        while (!doubts.isEmpty()) {
            System.out.println("Dia " + day + ":");
            int R = M; // Tempo restante no dia
            Queue<Integer> tempQueue = new LinkedList<>(); // Para dúvidas adiadas

            while (!doubts.isEmpty() && R > 0) {
                int current = doubts.poll();

                if (current <= R) {
                    // Responde à dúvida
                    System.out.println("  Respondeu à dúvida de " + current + " minutos.");
                    R -= current;
                } else if (current <= M) {
                    // Adia para outro dia
                    System.out.println("  Adiou a dúvida de " + current + " minutos para outro dia.");
                    tempQueue.add(current);
                } else {
                    // Ignora definitivamente
                    System.out.println("  Ignorou a dúvida de " + current + " minutos.");
                }
            }

            // Verifica se há dúvidas adiadas para adicionar no final da fila
            doubts.addAll(tempQueue);

            day++; // Passa para o próximo dia
        }

        System.out.println("Todas as dúvidas foram processadas.");
    }

    public static void main(String[] args) {
        // Fila inicial de dúvidas
        Queue<Integer> doubts = new LinkedList<>();
        doubts.add(20);
        doubts.add(30);
        doubts.add(70);
        doubts.add(10);
        doubts.add(60);
        doubts.add(90);

        int M = 60; // Tempo máximo por dia

        processQueue(doubts, M);
    }
}
