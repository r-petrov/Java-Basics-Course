import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class _06_RandomHandsOfFiveCards {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
        String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        System.out.print("Please, enter the number of hands:");
        int numberOfHands = Integer.parseInt(input.nextLine());

        for (int i = 0; i < numberOfHands; i++) {
            List<String> hand = new ArrayList<>();

            while (hand.size() < 5) {
                String face = faces[random.nextInt(13)];
                String suit = suits[random.nextInt(4)];

                hand.add(face + suit);
            }

            for (String card : hand) {
                System.out.print(card + " ");
            }
            System.out.println();
        }
    }
}
