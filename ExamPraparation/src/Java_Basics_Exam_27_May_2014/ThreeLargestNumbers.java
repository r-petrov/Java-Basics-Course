package Java_Basics_Exam_27_May_2014;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ThreeLargestNumbers {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		final int NUMBER_OF_LARGEST_NUMBERS = 3;
		
		Scanner input = new Scanner(System.in);
		int numberOfLines = Integer.parseInt(input.nextLine());
		
		List<String> numbers = new ArrayList<String>();
		for (int i = 0; i < numberOfLines; i++) {
			String currentNumber = input.nextLine();
			numbers.add(currentNumber);
		}
		
		printThreeLargestNumbers(NUMBER_OF_LARGEST_NUMBERS, numbers);
		
	}

	private static void printThreeLargestNumbers(
			final int NUMBER_OF_LARGEST_NUMBERS, List<String> numbers) {
		for (int i = 0; i < NUMBER_OF_LARGEST_NUMBERS; i++) {
			if (i == numbers.size()) {
				break;
			}
			
			int maxNumberIndex = getLargestNumberIndex(numbers);
			BigDecimal maxNumber = new BigDecimal(numbers.get(maxNumberIndex));
			String maxNumberString = maxNumber.toPlainString();
			System.out.println(maxNumberString);
			numbers.set(maxNumberIndex, Double.toString(-Double.MAX_VALUE));
		}
	}

	private static int getLargestNumberIndex(List<String> numbers) {
		BigDecimal maxNumber = BigDecimal.valueOf(-Double.MAX_VALUE);
		int maxNumberIndex = -1;
		for (int i = 0; i < numbers.size(); i++) {
			BigDecimal currentNumber = BigDecimal.valueOf(Double.parseDouble(numbers.get(i)));
			if (currentNumber.compareTo(maxNumber) > 0) {
				maxNumber = currentNumber;
				maxNumberIndex = i;
			}
		}
		
		return maxNumberIndex;
	}

}
