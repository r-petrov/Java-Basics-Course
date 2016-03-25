import java.util.Random;
import java.util.Scanner;


public class RandomHandsOf5Cards {
	
	
	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		int numberOfHands = Integer.parseInt(inputScanner.nextLine());
		
		String[] deckOfCards = generateDeckOfCards();
		for (int i = 0; i < numberOfHands; i++) {
			generateRandomHands(deckOfCards);
			System.out.println();
		}
	}

	private static void generateRandomHands(String[] deckOfCardsString) {
		final int NUMBER_OF_CARDS = 5;
		Integer index = null;
		
		for (int i = 0; i < NUMBER_OF_CARDS; i++) {
			index = new Random().nextInt(deckOfCardsString.length);
			String randomCard = deckOfCardsString[index];
			
			System.out.print(randomCard + " ");
		}
	}

	private static String[] generateDeckOfCards() {
		String spade = "\u2660";
		String heart = "\u2665";
		String diamond = "\u2666"; 
		String club = "\u2663";
		
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] playngCards = new String[52];
		
		for (int i = 0; i < playngCards.length; i++) {
			if(i < ranks.length) {
				playngCards[i] = ranks[i % ranks.length] + club;
			} else if (i >= ranks.length && i < ranks.length * 2) {
				playngCards[i] = ranks[i % ranks.length] + diamond;
			} else if (i >= ranks.length * 2 && i < ranks.length * 3) {
				playngCards[i] = ranks[i % ranks.length] + heart;
			} else {
				playngCards[i] = ranks[i % ranks.length] + spade;
			}
		}
		
		return playngCards;
	}

}
