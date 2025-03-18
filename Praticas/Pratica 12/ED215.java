import java.util.PriorityQueue;
import java.util.Scanner;

public class ED215 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Priority queue to store offers, with the highest offer at the top
        PriorityQueue<Offer> offers = new PriorityQueue<>((o1, o2) -> o2.price - o1.price);

        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");

            if (parts[0].equals("OFERTA")) {
                String name = parts[1];
                int price = Integer.parseInt(parts[2]);
                offers.add(new Offer(name, price));
            } else if (parts[0].equals("VENDA")) {
                Offer bestOffer = offers.poll();
                System.out.println(bestOffer.price + " " + bestOffer.name);
            }
        }

        scanner.close();
    }

    // Inner class to represent an offer
    static class Offer {
        String name;
        int price;

        Offer(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}