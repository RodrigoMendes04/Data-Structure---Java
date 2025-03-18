import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class ED234 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int flag = scanner.nextInt();
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Map<String, Integer> countMap = new TreeMap<>();
        Map<String, Integer> sumMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String movie = scanner.next();
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            countMap.put(movie, countMap.getOrDefault(movie, 0) + 1);
            sumMap.put(movie, sumMap.getOrDefault(movie, 0) + rating);
        }

        if (flag == 1) {
            // Flag 1: Number of different movies with at least one rating
            System.out.println(countMap.size());
        } else if (flag == 2) {
            // Flag 2: Movie with the most ratings
            String mostRatedMovie = null;
            int maxRatings = 0;
            for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
                if (entry.getValue() > maxRatings) {
                    mostRatedMovie = entry.getKey();
                    maxRatings = entry.getValue();
                }
            }
            System.out.println(mostRatedMovie + " " + maxRatings);
        } else if (flag == 3) {
            // Flag 3: Movies with a positive average rating, in alphabetical order
            for (Map.Entry<String, Integer> entry : sumMap.entrySet()) {
                String movie = entry.getKey();
                int totalRating = entry.getValue();
                int numRatings = countMap.get(movie);
                double averageRating = (double) totalRating / numRatings;
                if (averageRating >= 5.0) {
                    System.out.println(movie);
                }
            }
        }

        scanner.close();
    }
}