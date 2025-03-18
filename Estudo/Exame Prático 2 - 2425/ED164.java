import java.util.Scanner;

public class ED164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        BSTree<String> tree = new BSTree<>();

        for (int i = 0; i < N; i++) {
            String word = scanner.nextLine();
            tree.insert(word);
        }

        System.out.println(tree.numberNodes());
    }
}