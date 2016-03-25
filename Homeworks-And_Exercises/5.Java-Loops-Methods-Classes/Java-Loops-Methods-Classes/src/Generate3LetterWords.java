import java.util.Scanner;


public class Generate3LetterWords {

	public static void main(String[] args) {
		System.out.println("Please, enter maximum three characters without whitespaces in between:");
		
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine().trim().toLowerCase();
		char[] characters = inputString.toCharArray();
		
		boolean hasEqualCharacters = checkArrayForEqualCharacters(characters);
		while (hasEqualCharacters) {
			System.out.println("Input characters should be unique.");
			inputString = input.nextLine().trim().toLowerCase();
			characters = inputString.toCharArray();
			hasEqualCharacters = checkArrayForEqualCharacters(characters);
		}
		
		for (int ch1 = 0; ch1 < characters.length; ch1++) {
			for (int ch2 = 0; ch2 < characters.length; ch2++) {
				for (int ch3 = 0; ch3 < characters.length; ch3++) {
					System.out.print("" + characters[ch1] + characters[ch2] + characters[ch3] + " ");
				}
			}
		}
	}

	private static boolean checkArrayForEqualCharacters(char[] characters) {
		boolean hasEqualCharacters = false;
		for (int i = 0; i < characters.length - 1; i++) {
			for (int j = i + 1; j < characters.length; j++) {
				if(characters[i] == characters[j]) {
					hasEqualCharacters = true;
				}
			}
		}
		return hasEqualCharacters;
	}

}
