package Java_Sample_Contest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MagicCarNumbers {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int carNumberWeight = input.nextInt();
		
		Map<Character, Integer> carNumberLettersValues = new HashMap<Character, Integer>() {{
			put('A', 10);
			put('B', 20);
			put('C', 30);
			put('E', 50);
			put('H', 80);
			put('K', 110);
			put('M', 130);
			put('P', 160);
			put('T', 200);
			put('X', 240);
		}};
		int[] carNumberDigits = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		int carNumbersCounter = 0;
		int carNumberRemainingWeight = 
				carNumberWeight - (carNumberLettersValues.get('C') + carNumberLettersValues.get('A'));
		for (int digit1 : carNumberDigits) {
			for (int digit2 : carNumberDigits) {
				for (int digit3 : carNumberDigits) {
					for (int digit4 : carNumberDigits) {
						for (char letter1 : carNumberLettersValues.keySet()) {
							for (char letter2 : carNumberLettersValues.keySet()) {
								if ((digit1 == digit2 && digit2 == digit3 && digit3 == digit4) 
										|| digit1 != digit2 && digit2 == digit3 && digit3 == digit4 
										|| digit1 == digit2 && digit2 == digit3 && digit3 != digit4 
										|| digit1 == digit2 && digit2 != digit3 && digit3 == digit4 
										|| digit1 != digit2 && digit1 == digit3 && digit2 == digit4 
										|| digit1 != digit2 && digit2 == digit3 && digit1 == digit4) {
									if (digit1 + digit2	+ digit3 + digit4
											+ carNumberLettersValues.get(letter1) 
											+ carNumberLettersValues.get(letter2) 
											== carNumberRemainingWeight) {
										carNumbersCounter++;
									}
								}
							}
						}
					}
				}
				
			}
		}
		
		System.out.println(carNumbersCounter);
	}

}
