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
    //ED204
    // Método para contar o número de folhas
    public int numberLeafs() {
        return numberLeafs(root);
    }

    private int numberLeafs(BTNode<T> n) {
        if (n == null) return 0;
        if (n.getLeft() == null && n.getRight() == null) return 1;
        return numberLeafs(n.getLeft()) + numberLeafs(n.getRight());
    }

    // --------------------------------------------------------
    //ED205
    // Método para verificar se a árvore é estritamente binária
    public boolean strict() {
        return strict(root);
    }

    private boolean strict(BTNode<T> n) {
        if (n == null) return true;
        if ((n.getLeft() == null && n.getRight() != null) || (n.getLeft() != null && n.getRight() == null)) {
            return false;
        }
        return strict(n.getLeft()) && strict(n.getRight());
    }

    // --------------------------------------------------------
    //ED206
    // Método para devolver o valor guardado no caminho indicado pela string s
    public T path(String s) {
        BTNode<T> current = root;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                current = root;
            } else if (c == 'E') {
                current = current.getLeft();
            } else if (c == 'D') {
                current = current.getRight();
            }
        }
        return current.getValue();
    }

    // --------------------------------------------------------
    //ED207
    // Método para contar o número de nós num dado nível de profundidade
    public int nodesLevel(int k) {
        return nodesLevel(root, k, 0);
    }

    private int nodesLevel(BTNode<T> n, int k, int currentLevel) {
        if (n == null) return 0;
        if (currentLevel == k) return 1;
        return nodesLevel(n.getLeft(), k, currentLevel + 1) + nodesLevel(n.getRight(), k, currentLevel + 1);
    }

    // --------------------------------------------------------
    //ED233
    // Método para contar o número de nós internos
    public int internal() {
        return internal(root);
    }

    private int internal(BTNode<T> n) {
        if (n == null || (n.getLeft() == null && n.getRight() == null)) return 0;
        return 1 + internal(n.getLeft()) + internal(n.getRight());
    }

    // Método para remover nós com profundidade >= d
    public void cut(int d) {
        if (d <= 0) {
            root = null;
        } else {
            root = cut(root, d, 0);
        }
    }

    private BTNode<T> cut(BTNode<T> n, int d, int currentDepth) {
        if (n == null) return null;
        if (currentDepth >= d) return null;
        n.setLeft(cut(n.getLeft(), d, currentDepth + 1));
        n.setRight(cut(n.getRight(), d, currentDepth + 1));
        return n;
    }

    // Método para encontrar o nível com o máximo número de nós e quantos níveis têm esse máximo
    public int[] maxLevel() {
        int[] levelCount = new int[depth(root) + 1];
        maxLevel(root, 0, levelCount);
        int maxNodes = 0;
        int maxLevels = 0;
        for (int count : levelCount) {
            if (count > maxNodes) {
                maxNodes = count;
                maxLevels = 1;
            } else if (count == maxNodes) {
                maxLevels++;
            }
        }
        return new int[]{maxNodes, maxLevels};
    }

    private void maxLevel(BTNode<T> n, int level, int[] levelCount) {
        if (n == null) return;
        levelCount[level]++;
        maxLevel(n.getLeft(), level + 1, levelCount);
        maxLevel(n.getRight(), level + 1, levelCount);
    }

    // --------------------------------------------------------
    //ED239
    // Método para contar o número de nós que são filhos únicos
    public int count() {
        return count(root);
    }

    private int count(BTNode<T> n) {
        if (n == null) return 0;
        int count = 0;
        if ((n.getLeft() == null && n.getRight() != null) || (n.getLeft() != null && n.getRight() == null)) {
            count = 1;
        }
        return count + count(n.getLeft()) + count(n.getRight());
    }

    // Método para devolver o nível mais baixo onde é possível encontrar um nó com valor v
    public int level(T v) {
        return level(root, v, 0);
    }

    private int level(BTNode<T> n, T v, int currentLevel) {
        if (n == null) return -1;
        if (n.getValue().equals(v)) return currentLevel;
        int leftLevel = level(n.getLeft(), v, currentLevel + 1);
        int rightLevel = level(n.getRight(), v, currentLevel + 1);
        if (leftLevel == -1) return rightLevel;
        if (rightLevel == -1) return leftLevel;
        return Math.min(leftLevel, rightLevel);
    }
}