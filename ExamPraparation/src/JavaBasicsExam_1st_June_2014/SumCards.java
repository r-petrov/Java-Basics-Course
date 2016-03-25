package JavaBasicsExam_1st_June_2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumCards {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] handOfCards = input.nextLine().split(" ");
		
		List<Integer> sequentialValues = new ArrayList<Integer>();
		//sequentialValues.add(getCardValue(handOfCards[0]));
		
		int cardValuesSum = 0;
		for (int i = 1; i < handOfCards.length; i++) {
			int currentCardValue = getCardValue(handOfCards[i]);
			int previousCardValue = getCardValue(handOfCards[i - 1]);
			
			if (currentCardValue == previousCardValue) {
				if (sequentialValues.size() == 0) {
					sequentialValues.addAll(Arrays.asList(currentCardValue, previousCardValue));
				} else {
					sequentialValues.add(currentCardValue);
				}
			} else {
				if (sequentialValues.size() == 0) {
					cardValuesSum += previousCardValue;
				} else {
					cardValuesSum += duplicateCardValues(sequentialValues);
					sequentialValues.clear();
				}
			}
			
			if (i == handOfCards.length - 1) {
				if (sequentialValues.size() == 0) {
					cardValuesSum += currentCardValue;
				} else {
					cardValuesSum += duplicateCardValues(sequentialValues);
				}
			}
		}
		
		System.out.println(cardValuesSum);
	}
	
	static int duplicateCardValues(List<Integer> cardValues) {
		int sum = 0;
		for (Integer value : cardValues) {
			sum += value;
		}
		
		return sum * 2;
	}
	
	static int getCardValue(String card) {
		int value = 0;
		char cardFace = card.charAt(0);
		if ('1' <= cardFace && cardFace <= '9') {
			value = Integer.parseInt(card.substring(0, card.length() - 1));
		} else if (cardFace == 'J') {
			value = 12;
		} else if (cardFace == 'Q') {
			value = 13;
		} else if (cardFace == 'K') {
			value = 14;
		} else if (cardFace == 'A') {
			value = 15;
		} else {
			throw new IllegalArgumentException("Invalid card " + card);
		}
		
		return value;
	}
}
