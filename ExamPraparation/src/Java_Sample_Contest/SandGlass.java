package Java_Sample_Contest;

import java.util.Scanner;

public class SandGlass {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int sandClockHeight = Integer.parseInt(input.nextLine());
		
		printLinesBeforeMiddle(sandClockHeight);
		
		printLinesAfterMiddle(sandClockHeight);
	}

	private static void printLinesAfterMiddle(int sandClockHeight) {
		final String DOT = ".";
		final String ASTERISK = "*";
		
		int linesAfterMiddle = (sandClockHeight - 1) / 2;
		for (int i = 1; i <= linesAfterMiddle; i++) {
			int dotsNumber = linesAfterMiddle - i;
			int asteriskNumber = 1 + (2 * i);
			System.out.println(String.format("%s%s%s", 
					repeatString(dotsNumber, DOT),
					repeatString(asteriskNumber, ASTERISK),
					repeatString(dotsNumber, DOT)));
		}
	}

	private static void printLinesBeforeMiddle(int sandClockHeight) {
		final String DOT = ".";
		final String ASTERISK = "*";
		
		System.out.println(String.format("%s", repeatString(sandClockHeight, "*")));
		int linesBeforeTheMiddle = (sandClockHeight - 1) / 2;
		for (int i = 1; i <= linesBeforeTheMiddle; i++) {
			int dotsNumber = i;
			int asteriskNumber = sandClockHeight - (i * 2);
			System.out.println(String.format("%s%s%s", 
					repeatString(dotsNumber, DOT), 
					repeatString(asteriskNumber, ASTERISK), 
					repeatString(dotsNumber, DOT)));
		}
	}

	private static String repeatString(int numberOfRepeats, String stringToPrint) {
		String outputString = new String(new char[numberOfRepeats]).replace("\0", stringToPrint);
		return outputString;
	}

}
