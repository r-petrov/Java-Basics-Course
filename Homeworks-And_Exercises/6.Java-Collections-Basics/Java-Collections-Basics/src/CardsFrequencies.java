import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class CardsFrequencies {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		Scanner inputCards = new Scanner(System.in);
		String[] cardsStrings = inputCards.nextLine().split(" ");
		
		Map<String, Integer> cards = createCardsCounts(cardsStrings);
		
		cards.entrySet().forEach(c -> System.out.printf("%s -> %.2f%%\n", c.getKey(), (c.getValue() * 100.0) / cardsStrings.length));
		
//		for (Map.Entry<Character, Integer> card : cards.entrySet()) {
//			System.out.printf("%c -> %.2f%", card.getKey(), (card.getValue() * 100) / cardsStrings.length);
//		}
	}

	private static Map<String, Integer> createCardsCounts(String[] cardsStrings) {
		Map<String, Integer> cards = new LinkedHashMap<String, Integer>();
		for (String card : cardsStrings) {
			String cardFace = null;
			if (card.length() == 2) {
				cardFace = "" + card.charAt(0);
			} else if (card.length() > 2) {
				cardFace = "" + card.charAt(0) + card.charAt(1);
			}
			
			Integer count = cards.get(cardFace);
			if (count == null) {
				count = 0;
			}
			cards.put(cardFace, count + 1);
		}
		return cards;
	}

}
