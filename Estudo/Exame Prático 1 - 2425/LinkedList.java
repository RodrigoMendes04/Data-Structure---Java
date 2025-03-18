// public void insert(T v, int pos)
//inserir um nó com valor v na posicao pos

public class LinkedList<T> {
    private class Node {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head; // Cabeça da lista

    public LinkedList() {
        this.head = null; // Inicialmente a lista está vazia
    }

    // Método para inserir na posição especificada
    public void insert(T v, int pos) {
        Node newNode = new Node(v);

        // Caso especial: inserção na cabeça da lista
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Percorrer até a posição anterior à inserção
        Node current = head;
        int index = 0;

        while (current != null && index < pos - 1) {
            current = current.next;
            index++;
        }

        // Se a posição for inválida (fora do tamanho atual da lista)
        if (current == null) {
            throw new IndexOutOfBoundsException("Posição inválida para inserção.");
        }

        // Inserir o novo nó na posição especificada
        newNode.next = current.next;
        current.next = newNode;
    }

    // Método para exibir os elementos da lista
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Testando a inserção
        list.insert(10, 0); // Inserir na cabeça
        list.insert(20, 1); // Inserir no final
        list.insert(15, 1); // Inserir no meio
        list.insert(5, 0);  // Inserir novamente na cabeça

        // Exibindo a lista
        list.printList();
    }
}
