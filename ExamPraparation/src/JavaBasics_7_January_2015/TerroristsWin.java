package JavaBasics_7_January_2015;

import java.util.Scanner;

public class TerroristsWin {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		StringBuilder string = new StringBuilder(input.nextLine());
		
		int currentIndex = 0;
		int bombStartIndex = 0;
		int bombEndIndex = 0;
		
		while ((bombStartIndex = string.indexOf("|", currentIndex)) != -1) {
			bombEndIndex = string.indexOf("|", bombStartIndex + 1);
			String bombContent = string.substring(bombStartIndex + 1, bombEndIndex);
			
			setOffBomb(string, bombStartIndex, bombEndIndex, bombContent);
			
			currentIndex = bombEndIndex + 1;
		}
		
		System.out.println(string);
	}

	private static void setOffBomb(StringBuilder string, int bombStartIndex,
			int bombEndIndex, String bombContent) {
		int bombPower = calculateBombPower(bombContent);
		int startIndex = Math.max(0, bombStartIndex - bombPower);
		int endIndex = Math.max(0, bombEndIndex + bombPower);
		
		while (startIndex <= endIndex) {
			string.setCharAt(startIndex, '.');
			startIndex++;
		}
	}

//	private static void setOffBomb(StringBuilder inputString, String bomb) {
//		int bombPower = calculateBombPower(bomb);
//		int currentBombStartIndex = inputString.indexOf(bomb);
//		int currentBombEndIndex = inputString.indexOf(bomb) + bomb.length() - 1;
//		
//		int startIndex = Math.max(0, currentBombStartIndex - bombPower);
//		int endIndex = Math.min(inputString.length() - 1, currentBombEndIndex + bombPower);
//		
//		while (startIndex <= endIndex) {
//			inputString.setCharAt(startIndex, '.');
//			startIndex++;
//		}
//		
//	}

	private static int calculateBombPower(String bombContent) {
		int bombPower = 0;
		for (char character : bombContent.toCharArray()) {
			bombPower += character;
		}
		
//		for (int i = 1; i < bombContent.length() - 1; i++) {
//			bombPower += (int) bombContent.charAt(i);
//		}
		
		return bombPower % 10;
	}

}
