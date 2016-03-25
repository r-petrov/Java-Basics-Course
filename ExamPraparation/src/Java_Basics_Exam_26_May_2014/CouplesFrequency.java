package Java_Basics_Exam_26_May_2014;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CouplesFrequency {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] numbers = input.nextLine().split(" ");
		
		Map<String, Integer> couples = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < numbers.length - 1; i++) {
			String currentCouple = numbers[i] + " " + numbers[i + 1];
			if (!couples.containsKey(currentCouple)) {
				couples.put(currentCouple, 1);
			} else {
				int currentFrequency = couples.get(currentCouple);
				couples.put(currentCouple, currentFrequency + 1);
			}
		}
		
		printCouplesFrequency(couples);
	}

	private static void printCouplesFrequency(Map<String, Integer> couples) {
		int totalFrequncies = getTotalFrequencies(couples);
		for (String couple : couples.keySet()) {
			int currentFrequency = couples.get(couple);
			double currentFrequencyPercentage = (currentFrequency * 100.00) / totalFrequncies;
			System.out.printf("%s -> %.2f%%%n", couple, currentFrequencyPercentage);
		}
	}

	private static int  getTotalFrequencies(Map<String, Integer> couples) {
		int totalFrequncies = 0;
		for (String couple : couples.keySet()) {
			totalFrequncies += couples.get(couple);
		}
		
		return totalFrequncies;
	}

}
