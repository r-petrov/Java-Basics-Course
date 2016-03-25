package Java_Basics_Exam_26_May_2014;

import java.util.Scanner;

public class PythagoreanNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfNumbers = Integer.parseInt(input.nextLine());
		
		int[] numbers = new int[numberOfNumbers];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextInt();
		}
		
		int pitagoreanEquationsCounter = 0;
		for (int number1 : numbers) {
			for (int number2 : numbers) {
				for (int number3 : numbers) {
					if (number1 <= number2) {
						if ((number1 * number1) + (number2 * number2) == number3 * number3) {
							System.out.println(String.format("%d*%d + %d*%d = %d*%d", 
									number1, number1, number2, number2, number3, number3));
							pitagoreanEquationsCounter++;
						}
					}
				}
			}
		}
		
		if (pitagoreanEquationsCounter == 0) {
			System.out.println("No");
		}
	}

}
