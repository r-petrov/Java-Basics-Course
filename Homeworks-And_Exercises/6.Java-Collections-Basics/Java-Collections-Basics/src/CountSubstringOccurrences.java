import java.util.Scanner;


public class CountSubstringOccurrences {

	public static void main(String[] args) {
		Scanner inputScanner = new Scanner(System.in);
		String text = inputScanner.nextLine();
		String substringPattern = inputScanner.next().toLowerCase();
		int numberOfMatches = 0;
		
		int index = text.toLowerCase().indexOf(substringPattern);
		while (index != -1) {
			numberOfMatches++;
			index = text.toLowerCase().indexOf(substringPattern, index + 1);
		}
		
		System.out.println(numberOfMatches);
	}

}
