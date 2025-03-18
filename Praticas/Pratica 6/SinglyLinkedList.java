public class SinglyLinkedList<T> {
    private Node<T> first; // Primeiro no da lista
    private int size; // Tamanho da lista
    // Construtor (cria lista vazia)
    
    SinglyLinkedList() {
        first = null;
        size = 0;
    }
    // Retorna o tamanho da lista
    
    public int size() {
        return size;
    }
    // Devolve true se a lista estiver vazia ou falso caso contrario
    
    public boolean isEmpty() {
        return (size == 0);
    }
    // Adiciona v ao inicio da lista
    
    public void addFirst(T v) {
        Node<T> newNode = new Node<T>(v, first);
        first = newNode;
        size++;
    }
    // Adiciona v ao final da lista
    
    public void addLast(T v) {
        Node<T> newNode = new Node<T>(v, null);
        if (isEmpty()) {
            first = newNode;
        } else {
            Node<T> cur = first;
            while (cur.getNext() != null)
                cur = cur.getNext();
                cur.setNext(newNode);
        }
        size++;
    }
    // Retorna o primeiro valor da lista (ou null se a lista for vazia)
    
    public T getFirst() {
        if (isEmpty()) return null;
        return first.getValue();
    }
    // Retorna o ultimo valor da lista (ou null se a lista for vazia)
    
    public T getLast() {
        if (isEmpty()) return null;
        Node<T> cur = first;
        while (cur.getNext() != null)
            cur = cur.getNext();
            return cur.getValue();
    }
    // Remove o primeiro elemento da lista (se for vazia nao faz nada)
    
    public void removeFirst() {
        if (isEmpty()) return;
            first = first.getNext();
            size--;
    }
    // Remove o ultimo elemento da lista (se for vazia nao faz nada)
    
    public void removeLast() {
        if (isEmpty()) return;
            if (size == 1) {
                first = null;
            } else {
    // Ciclo com for e uso de de size para mostrar alternativa ao while
            Node<T> cur = first;
                for (int i=0; i<size-2; i++)
                    cur = cur.getNext();
                    cur.setNext(cur.getNext().getNext()); //ou cur.setNext(null)
            }
        size--;
    }
    
    public T get(int pos){
        if(pos<0 || pos>=size){
            return null;
        }
        Node <T> cur = first;
        for(int i=0;i<pos;i++){
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size)
            return null;
        else {
            Node<T> cur = first;
            if (pos == 0){
                T value = cur.getValue();
                removeFirst();
                return value;
            }
            for (int i = 0; i < pos -1 ; i++)// com ajuda de colegas
                cur = cur.getNext();
                T value = (cur.getNext().getValue());
                cur.setNext(cur.getNext().getNext());
                size --;
                return value;
        }
    }

    public SinglyLinkedList<T> copy(){
        Node<T> cur = first;
        SinglyLinkedList<T> copia = new SinglyLinkedList<>();
        while (cur !=null){
            copia.addLast(cur.getValue());
            cur = cur.getNext();
        }
        return copia;
    }

    public void duplicate(){
        Node<T> cur = first ;
        while(cur != null){
        Node<T> novo = new Node<> (cur.getValue(), cur.getNext());        
        size++;
        cur.setNext(novo);
        cur =( cur.getNext().getNext());
        }
    }    

    public int count(T value){
        Node<T> cur = first ;
        int contador=0;
        while(cur != null){
            if(cur.getValue().equals(value)){
            contador++;
            }
        cur = cur.getNext();
        }
        return contador;
    }

    public void removeAll(T value) {
        Node<T> cur = first;  // Inicializa um nó temporário cur e o define como o primeiro nó da lista.
        Node<T> prev = null;  // Inicializa um nó temporário prev como null. Será usado para rastrear o nó anterior.
    
        while (cur != null) {  // Inicia um loop enquanto ainda houver nós na lista.
            if (cur.getValue().equals(value)) {  // Verifica se o valor do nó atual é igual ao valor a ser removido.
                if (prev == null) {
                    // Caso especial: o valor a ser removido está no primeiro nó da lista.
                    // Atualiza first para o próximo nó.
                    first = cur.getNext();
                } else {
                    // Remove o nó atual ligando o nó anterior ao próximo nó.
                    prev.setNext(cur.getNext());
                }
                size--;  // Decrementa o tamanho da lista, pois um elemento foi removido.
            } else {
                // Atualiza o nó anterior para ser o nó atual.
                prev = cur;
            }
    
            // Move para o próximo nó na lista.
            cur = cur.getNext();
        }
    }
    
    

    // Converte a lista para uma String
    
    public String toString() {
        String str = "{";
        Node<T> cur = first;
        while (cur != null) {
            str += cur.getValue();
            cur = cur.getNext();
            if (cur != null) str += ",";
        }
        str += "}";
        return str;
    }
}