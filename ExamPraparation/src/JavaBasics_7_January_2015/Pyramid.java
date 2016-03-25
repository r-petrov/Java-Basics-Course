package JavaBasics_7_January_2015;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pyramid {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int numberOfPyramidRows = Integer.parseInt(input.nextLine());
		int currentBiggerNumber = Integer.parseInt(input.nextLine().trim());
		List<Integer> biggerNumbers = new ArrayList<Integer>();
		biggerNumbers.add(currentBiggerNumber);
		
		for (int i = 1; i < numberOfPyramidRows; i++) {
			String[] numbersStrings = input.nextLine().trim().split("\\s+");
			List<Integer> currentBiggerNumbers = new ArrayList<Integer>();
			for (int j = 0; j < numbersStrings.length; j++) {
				int currentNumber = Integer.parseInt(numbersStrings[j]);
				if (currentNumber > currentBiggerNumber) {
					currentBiggerNumbers.add(currentNumber);
				} 
			}

			if (currentBiggerNumbers.size() > 0) {
				currentBiggerNumber = getMinimumNumberFromCollection(currentBiggerNumbers);
				biggerNumbers.add(currentBiggerNumber);
			} else {
				currentBiggerNumber++;
			}
		}
		
		System.out.println(biggerNumbers.toString().substring(1, biggerNumbers.toString().length() - 1));
	}

	private static int getMinimumNumberFromCollection(List<Integer> numbers) {
		int minimumValue = Integer.MAX_VALUE;
		for (Integer number : numbers) {
			if (number < minimumValue) {
				minimumValue = number;
			}
		}
		
		return minimumValue;
	}
}
