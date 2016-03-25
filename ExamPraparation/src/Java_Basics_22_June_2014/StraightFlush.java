package Java_Basics_22_June_2014;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class StraightFlush {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String[] handOfCard = inputScanner.nextLine().split(", ");
		
		String[] cardFaces = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		Map<Character, Set<String>> cards = new TreeMap<Character, Set<String>>();
		for (int i = 0; i < cardFaces.length; i++) {
			for (String card : handOfCard) {
				char cardSuit = card.charAt(card.length() - 1);
				String cardFace = card.substring(0, card.length() - 1);

				if (!cards.containsKey(cardSuit)) {
					cards.put(cardSuit, new LinkedHashSet<String>());
				}
				
				if (cardFace.equals(cardFaces[i])) {
					cards.get(cardSuit).add(cardFace);
				}
			}
		}
		
		int counter = 0;
		for (Character cardSuit : cards.keySet()) {
			final int STRAIGHT_FLUSH_LENGTH = 5;
			
			if (cards.get(cardSuit).size() >= STRAIGHT_FLUSH_LENGTH) {
				final String CARD_VALUES = "2345678910JQKA";
				Set<String> cardValues = cards.get(cardSuit);
				for (String cardValue1 : cardValues) {
					for (String cardValue2 : cardValues) {
						for (String cardValue3 : cardValues) {
							for (String cardValue4 : cardValues) {
								for (String cardValue5 : cardValues) {
									String cardValuesSequence = cardValue1 + cardValue2 + cardValue3 + cardValue4 + cardValue5;
									if (CARD_VALUES.contains(cardValuesSequence)) {
										System.out.printf("[%s%c, %s%c, %s%c, %s%c, %s%c]%n", 
												cardValue1, cardSuit, 
												cardValue2, cardSuit, 
												cardValue3, cardSuit, 
												cardValue4, cardSuit, 
												cardValue5, cardSuit
												);
										counter++;
									}
								}
							}
						}
					}
				}
			}
		}
		
		if (counter == 0) {
			System.out.println("No Straight Flushes");
		}
	}
	
}
