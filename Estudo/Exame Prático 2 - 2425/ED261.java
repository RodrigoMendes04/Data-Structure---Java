import java.util.ArrayList;
import java.util.List;

public class ED261 {
    public static int[] prune(BTree<Integer> t) {
        List<Integer> leafValues = new ArrayList<>();
        t.setRoot(prune(t.getRoot(), leafValues));
        decrementValues(t.getRoot());
        return leafValues.stream().mapToInt(i -> i).toArray();
    }

    private static BTNode<Integer> prune(BTNode<Integer> node, List<Integer> leafValues) {
        if (node == null) return null;
        if (node.getLeft() == null && node.getRight() == null) {
            leafValues.add(node.getValue());
            return null;
        }
        node.setLeft(prune(node.getLeft(), leafValues));
        node.setRight(prune(node.getRight(), leafValues));
        return node;
    }

    private static void decrementValues(BTNode<Integer> node) {
        if (node == null) return;
        node.setValue(node.getValue() - 1);
        decrementValues(node.getLeft());
        decrementValues(node.getRight());
    }
}