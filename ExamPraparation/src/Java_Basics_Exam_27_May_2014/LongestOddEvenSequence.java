package Java_Basics_Exam_27_May_2014;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LongestOddEvenSequence {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String inputNumbers = input.nextLine().trim();

		List<Integer> numbers = new ArrayList<Integer>();
		Pattern numbersPattern = Pattern.compile("-?\\d+");
		Matcher numbersMatcher = numbersPattern.matcher(inputNumbers);
		while (numbersMatcher.find()) {
			numbers.add(Integer.parseInt(numbersMatcher.group()));
		}

		// System.out.println(numbers);
		int maxOddEvenSequence = Integer.MIN_VALUE;
		int oddEvenSequenceCounter = 1;
		for (int i = 0; i < numbers.size() - 1; i++) {
			if (numbers.get(i) == 0) {
				oddEvenSequenceCounter++;
			} else {
				if (numbers.get(i) % 2 != 0) {
					if (numbers.get(i + 1) % 2 == 0 || numbers.get(i + 1) == 0) {
						oddEvenSequenceCounter++;
					} else {
						oddEvenSequenceCounter = 1;
					}
				}
				if (numbers.get(i) % 2 == 0) {
					if (numbers.get(i + 1) % 2 != 0 || numbers.get(i + 1) == 0) {
						oddEvenSequenceCounter++;
					} else {
						oddEvenSequenceCounter = 1;
					}
				}
				if (i + 1 == numbers.size()) {
					if (numbers.get(i + 1) == 0) {
						oddEvenSequenceCounter++;
					} else {
						if ((numbers.get(i) % 2 == 0 && numbers.get(i + 1) % 2 != 0)
								|| (numbers.get(i) % 2 != 0 && numbers.get(i + 1) % 2 != 0)) {
							oddEvenSequenceCounter++;
						}
					}
				}
			}

			if (oddEvenSequenceCounter > maxOddEvenSequence) {
				maxOddEvenSequence = oddEvenSequenceCounter;
			}
		}

		System.out.println(maxOddEvenSequence);

	}

}
