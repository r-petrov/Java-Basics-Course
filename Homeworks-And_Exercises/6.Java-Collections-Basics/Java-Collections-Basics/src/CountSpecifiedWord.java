import java.util.Scanner;


public class CountSpecifiedWord {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] textWords = input.nextLine().split("[^A-z]+");
		String wordPattern = input.next().toLowerCase();
		int numberOfMatches = 0;
		
		for (String word : textWords) {
			if (wordPattern.equals(word.toLowerCase())) {
				numberOfMatches++;
			}
		}
		
		System.out.println(numberOfMatches);
	}

}
