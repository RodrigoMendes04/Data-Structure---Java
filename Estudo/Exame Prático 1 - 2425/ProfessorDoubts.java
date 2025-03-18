import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Student {
    String name;
    int time;
    int day;

    public Student(String name, int time, int day) {
        this.name = name;
        this.time = time;
        this.day = day;
    }
}

public class ProfessorDoubts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler o máximo de minutos que o professor pode gastar por dia
        int M = scanner.nextInt();

        // Ler o número de alunos na fila
        int N = scanner.nextInt();

        // Fila de alunos com dúvidas
        Queue<Student> queue = new LinkedList<>();

        // Ler os alunos e suas dúvidas
        for (int i = 0; i < N; i++) {
            String name = scanner.next();
            int time = scanner.nextInt();
            queue.add(new Student(name, time, -1)); // Inicialmente, o dia é -1
        }

        int day = 1; // Dia atual
        int R = M;   // Tempo restante no dia

        // Processar a fila
        while (!queue.isEmpty()) {
            Student student = queue.poll();

            if (student.time <= R) {
                // O professor consegue responder à dúvida
                R -= student.time;
                System.out.println(student.name + " " + day + " " + R);
            } else if (student.time <= M) {
                // Dúvida adiada para o próximo dia
                if (student.day == day) {
                    // Se já foi tentado no mesmo dia, o professor para
                    day++;
                    R = M; // Reinicia o tempo disponível
                }
                student.day = day; // Atualiza o último dia em que foi tentado
                queue.add(student); // Adiciona ao final da fila
            }
            // Se a dúvida for maior que M, ela é ignorada e não volta para a fila
        }
    }
}
