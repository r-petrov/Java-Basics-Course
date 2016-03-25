package JavaExamPreparation_21_09_2015;

import java.util.Scanner;

public class Enigma {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = Integer.parseInt(scan.nextLine());
		
		String[] lines = new String[n];
		
		for (int i = 0; i < lines.length; i++) {
			lines[i] = scan.nextLine();
		}
		
		int m;
		
		for (int i = 0; i < lines.length; i++) {
			m = lines[i]
					.replaceAll("[\\s\\d]+", "")
					.length() / 2;
			for (int j = 0; j < lines[i].length(); j++) {
				char currChar = lines[i].charAt(j);
				if ((currChar >= '0' && currChar <= '9') || currChar == ' ') {
					System.out.print(currChar);
					continue;
				}
				currChar = (char)(lines[i].charAt(j) + m);
				System.out.print(currChar);
			}
			System.out.println();
		}
	}

}
