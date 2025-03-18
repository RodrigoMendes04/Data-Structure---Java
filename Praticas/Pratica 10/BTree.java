// -----------------------------------------------------------
// Estruturas de Dados 2024/2025 (CC1007) - DCC/FCUP
// https://www.dcc.fc.up.pt/~fds/aulas/EDados/2425/
// -----------------------------------------------------------
// Arvore binaria "normal"
// (Pedro Ribeiro @ DCC-FCUP)
// -----------------------------------------------------------

public class BTree<T> {
    private BTNode<T> root; // raiz da arvore

    // Construtor
    BTree() {
        root = null;
    }

    // Getter e Setter para a raiz
    public BTNode<T> getRoot() {return root;}
    public void setRoot(BTNode<T> r) {root = r;}

    // Verificar se arvore esta vazia
    public boolean isEmpty() {
        return root == null;
    }

    // --------------------------------------------------------

    // Numero de nos da arvore
    public int numberNodes() {
        return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n) {
        if (n == null) return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    // --------------------------------------------------------

    // Altura da arvore
    public int depth() {
        return depth(root);
    }

    private int depth(BTNode<T> n) {
        if (n == null) return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    // --------------------------------------------------------

    // O elemento value esta contido na arvore?
    public boolean contains(T value) {
        return contains(root, value);
    }

    private boolean contains(BTNode<T> n, T value) {
        if (n==null) return false;
        if (n.getValue().equals(value)) return true;
        return contains(n.getLeft(), value) || contains(n.getRight(), value);
    }

    // --------------------------------------------------------

    // Imprimir arvore em PreOrder
    public void printPreOrder() {
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> n) {
        if (n==null) return;
        System.out.print(" " + n.getValue() );
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em InOrder
    public void printInOrder() {
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BTNode<T> n) {
        if (n==null) return;
        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }

    // --------------------------------------------------------

    // Imprimir arvore em PostOrder
    public void printPostOrder() {
        System.out.print("PostOrder:");
        printPostOrder(root);
        System.out.println();
    }

    private void printPostOrder(BTNode<T> n) {
        if (n==null) return;
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em largura (usando TAD Fila)
    public void printBFS() {
        System.out.print("BFS:");

        MyQueue<BTNode<T>> q = new LinkedListQueue<BTNode<T>>();
        q.enqueue(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.dequeue();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.enqueue(cur.getLeft());
                q.enqueue(cur.getRight());
            }
        }
        System.out.println();
    }

    // --------------------------------------------------------

    // Imprimir arvore numa visita em profundidade (usando TAD Pilha)
    public void printDFS() {
        System.out.print("DFS:");

        MyStack<BTNode<T>> q = new LinkedListStack<BTNode<T>>();
        q.push(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.pop();
            if (cur != null) {
                System.out.print(" " + cur.getValue());
                q.push(cur.getLeft());
                q.push(cur.getRight());
            }
        }
        System.out.println();
    }

    // --------------------------------------------------------

    // devolve o número de folhas da árvore
    public int numberLeafs() {
        return numberLeafs(root);
    }

    private int numberLeafs(BTNode<T> n) {
        if (n == null) return 0;
        if (n.getLeft() == null && n.getRight() == null) return 1;
        return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
    }

    // --------------------------------------------------------

    // devolve true se a árvore for estritamente binária ou false caso contrário
    public boolean strict() {
        return strict(root);
    }

    private boolean strict(BTNode<T> n) {
        if (n == null) return true;
        if ((n.getLeft() == null && n.getRight() != null) || (n.getLeft() != null && n.getRight() == null)) return false;
        return strict(n.getLeft()) && strict(n.getRight());
    }

    // --------------------------------------------------------

    // devolve o valor guardado no caminho indicado pela string s
    public T path(String s) {
        BTNode<T> current = root;
        for (char c : s.toCharArray()) {
            if (c == 'E') {
                current = current.getLeft();
            } else if (c == 'D') {
                current = current.getRight();
            }
        }
        return current.getValue();
    }

    // --------------------------------------------------------

    // devolve o número de nós num dado nível de profundidade
    public int nodesLevel(int k) {
        return nodesLevel(root, k);
    }

    private int nodesLevel(BTNode<T> n, int k) {
        if (n == null) return 0;
        if (k == 0) return 1;
        return nodesLevel(n.getLeft(), k - 1) + nodesLevel(n.getRight(), k - 1);
    }
}