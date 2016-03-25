package JavaBasicsExam_1st_June_2014;

import java.util.Scanner;

public class StuckNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int count = Integer.parseInt(input.nextLine());
		String[] numbers = input.nextLine().split(" ");
		
		boolean hasStuckNumbers = false;
		for (String number1 : numbers) {
			for (String number2 : numbers) {
				for (String number3 : numbers) {
					for (String number4 : numbers) {
						if (number1 != number2 && 
								number1 != number3 && 
								number1 != number4 && 
								number2 != number3 &&
								number2 != number4 &&
								number3 != number4) {
							if ((number1 + number2).equals(number3 + number4)) {
								System.out.printf("%s|%s==%s|%s\n", number1, number2, number3, number4);
								hasStuckNumbers = true;
							}
						}
					}
				}
			}
		}
		
		
		if (!hasStuckNumbers) {
			System.out.println("No");
		}
	}

}
