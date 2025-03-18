import java.util.*;

public class ED029 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCasos = Integer.parseInt(scanner.nextLine()); // Número de casos
        for (int caso = 0; caso < numCasos; caso++) {
            String[] la = scanner.nextLine().split(" ");
            int L = Integer.parseInt(la[0]); // Número de aviões a levantar
            int A = Integer.parseInt(la[1]); // Número de aviões a aterrar

            PriorityQueue<Aviao> filaLevantar = new PriorityQueue<>((a, b) -> Integer.compare(a.tempo, b.tempo));
            PriorityQueue<Aviao> filaAterrar = new PriorityQueue<>((a, b) -> Integer.compare(a.tempo, b.tempo));

            // Leitura dos aviões que querem levantar
            for (int i = 0; i < L; i++) {
                String[] info = scanner.nextLine().split(" ");
                filaLevantar.add(new Aviao(info[0], Integer.parseInt(info[1]), false));
            }

            // Leitura dos aviões que querem aterrar
            for (int i = 0; i < A; i++) {
                String[] info = scanner.nextLine().split(" ");
                filaAterrar.add(new Aviao(info[0], Integer.parseInt(info[1]), true));
            }

            List<String> resultadoLevantar = new ArrayList<>();
            List<String> resultadoAterrar = new ArrayList<>();

            int tempoAtual = 0;

            while (!filaLevantar.isEmpty() || !filaAterrar.isEmpty()) {
                Aviao proximo = null;

                // Escolher o próximo avião a usar a pista
                if (!filaAterrar.isEmpty() && (filaLevantar.isEmpty() || filaAterrar.peek().tempo <= tempoAtual)) {
                    proximo = filaAterrar.poll();
                } else if (!filaLevantar.isEmpty() && (filaAterrar.isEmpty() || filaLevantar.peek().tempo <= tempoAtual)) {
                    proximo = filaLevantar.poll();
                }

                if (proximo != null) {
                    int atraso = Math.max(0, tempoAtual - proximo.tempo);
                    tempoAtual++; // 1 minuto para usar a pista
                    if (proximo.querAterrar) {
                        resultadoAterrar.add(proximo.nome + " " + atraso);
                    } else {
                        resultadoLevantar.add(proximo.nome + " " + atraso);
                    }
                } else {
                    // Caso ninguém esteja disponível no tempoAtual, avançar no tempo
                    tempoAtual++;
                }
            }

            // Imprimir resultados do caso
            System.out.println(L + " " + A);
            for (String res : resultadoLevantar) {
                System.out.println(res);
            }
            for (String res : resultadoAterrar) {
                System.out.println(res);
            }
        }

        scanner.close();
    }

    // Classe Aviao para armazenar informações
    static class Aviao {
        String nome;
        int tempo;
        boolean querAterrar;

        public Aviao(String nome, int tempo, boolean querAterrar) {
            this.nome = nome;
            this.tempo = tempo;
            this.querAterrar = querAterrar;
        }
    }
}
