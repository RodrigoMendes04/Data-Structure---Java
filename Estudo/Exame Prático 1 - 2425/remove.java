// public SinglyLinkedList<T> remove(int[] pos)
//
//se list {2,4,6,8,10} e list.remove([0,1,3])
//devolve nova lista com conteudo {6,10}
public SinglyLinkedList<T> remove(int[] pos) {
    // Ordenar o array de posições para facilitar a remoção
    Arrays.sort(pos);
    int currentIndex = 0;
    int posIndex = 0;

    Node current = head;
    SinglyLinkedList<T> newList = new SinglyLinkedList<>();

    while (current != null) {
        // Verificar se a posição atual deve ser ignorada
        if (posIndex < pos.length && currentIndex == pos[posIndex]) {
            posIndex++;
        } else {
            // Adicionar o valor à nova lista
            newList.add(current.value);
        }
        current = current.next;
        currentIndex++;
    }

    return newList;
}