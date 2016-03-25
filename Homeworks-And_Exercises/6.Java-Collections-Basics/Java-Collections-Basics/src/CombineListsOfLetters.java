import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CombineListsOfLetters {

	public static void main(String[] args) {
		Scanner inputLetters = new Scanner(System.in);
		
		String firstLineInput = inputLetters.nextLine();
		String firstSequenceOfLetters = extractLetters(firstLineInput);
		ArrayList<Character> l1 = createListOfLetters(firstSequenceOfLetters);
		
		String secondLineInput = inputLetters.nextLine();
		String secondSequenceOfLetters = extractLetters(secondLineInput);
		ArrayList<Character> l2 = createListOfLetters(secondSequenceOfLetters);
		
		ArrayList<Character> combinedSequenceOfLetters = (ArrayList<Character>) l1.clone();
		for (Character character : l2) {
			if (!l1.contains(character)) {
				combinedSequenceOfLetters.add(character);
			}
		}
		
		combinedSequenceOfLetters.forEach(l -> System.out.print(l + " "));
		
	}

	private static ArrayList<Character> createListOfLetters(String sequenceOfLetters) {
		ArrayList<Character> lettersCollection = new ArrayList<Character>();
		for (Character character : sequenceOfLetters.toCharArray()) {
			lettersCollection.add(character);
		}
		
		return lettersCollection;
	}

	private static String extractLetters(String text) {
		Pattern lettersPattern = Pattern.compile("\\S+");
		Matcher lettersMatcher = lettersPattern.matcher(text);
		
		StringBuilder sb = new StringBuilder();
		while (lettersMatcher.find()) {
			sb.append(lettersMatcher.group(0));
			
		}
		
		String sequenceOfLetters = sb.toString();
		return sequenceOfLetters;
	}

}
