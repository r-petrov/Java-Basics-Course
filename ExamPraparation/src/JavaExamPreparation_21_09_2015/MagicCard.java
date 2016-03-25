package JavaExamPreparation_21_09_2015;

import java.util.HashMap;
import java.util.Scanner;

public class MagicCard {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] cards = scan.nextLine().split("\\s+");
		String oddOrEven = scan.nextLine();
		String magicCard = scan.nextLine();
		
		String magicCardValue = magicCard.replaceAll("[SHDC]", "");
		char magicCardSuit = magicCard.replaceAll("[0-9JQKA]+", "").charAt(0);
		
		HashMap<Character, Integer> specialValues =  new HashMap<Character, Integer>();
		specialValues.put('J', 120);
		specialValues.put('Q', 130);
		specialValues.put('K', 140);
		specialValues.put('A', 150);
		
		int magicSum = 0;
		int i;
		
		if (oddOrEven.equals("odd")) {
			i = 1;
		} else {
			i = 0;
		}
		
		for (; i < cards.length; i += 2) {
			
			String card = cards[i];
			int cardValue;
			
			if (isSpecial(card)) {
				cardValue = specialValues.get(card.charAt(0));
			} else {
				cardValue = Integer.parseInt(card.replaceAll("[SHDC]", "")) * 10;
			}
			
			if (card.contains(magicCardValue)) {
				cardValue *= 3;
			} else if (card.indexOf(magicCardSuit) >= 0) {
				cardValue *= 2;
			}
			
			magicSum += cardValue;
		}
		
		System.out.println(magicSum);
	}
	private static boolean isSpecial(String s) {
		if (s.charAt(0) == 'J' || s.charAt(0) == 'Q' || s.charAt(0) == 'K' || s.charAt(0) == 'A') {
			return true;
		}
		return false;
	}

}
