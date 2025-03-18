public class ED196 {
    public static void process(MyQueue<String> q, MyQueue<String> a, MyQueue<String> b) {
        String conteudo[] = new String[2];
        
        // Loop enquanto a fila q não estiver vazia
        while (q.size() != 0) {
            int i = 1;
            
            // Desenfileira dois elementos da fila q e armazena no array conteudo[]
            conteudo[i - 1] = q.dequeue();
            conteudo[i] = q.dequeue();
            
            // Verifica o valor do segundo elemento (conteudo[1])
            if (conteudo[1].equals("A"))
                a.enqueue(conteudo[0]); // Enfileira o primeiro elemento em a
            else if (conteudo[1].equals("B"))
                b.enqueue(conteudo[0]); // Enfileira o primeiro elemento em b
            else if (conteudo[1].equals("X")) {
                // Compara o tamanho de a e b e enfileira o primeiro elemento na fila com menor tamanho
                if (a.size() < b.size())
                    a.enqueue(conteudo[0]);
                else if (b.size() < a.size())
                    b.enqueue(conteudo[0]);
            } else {
                continue; // Ignora outros valores de conteudo[1]
            }
        }
    }
}
