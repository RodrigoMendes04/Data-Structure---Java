import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ED165 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of elements in the set
        int N = scanner.nextInt();
        int[] numbers = new int[N];
        Set<Integer> numberSet = new HashSet<>();

        // Read the elements of the set
        for (int i = 0; i < N; i++) {
            numbers[i] = scanner.nextInt();
            numberSet.add(numbers[i]);
        }

        // Read the number of queries
        int P = scanner.nextInt();
        int[] queries = new int[P];

        // Read the queries
        for (int i = 0; i < P; i++) {
            queries[i] = scanner.nextInt();
        }

        // Process each query
        for (int i = 0; i < P; i++) {
            int query = queries[i];
            boolean found = false;

            // Check if the query can be formed by the sum of two numbers in the set
            for (int num : numbers) {
                int complement = query - num;
                if (numberSet.contains(complement)) {
                    found = true;
                    break;
                }
            }

            // Print the result for the current query
            if (found) {
                System.out.println(query + ": sim");
            } else {
                System.out.println(query + ": nao");
            }
        }

        scanner.close();
    }
}