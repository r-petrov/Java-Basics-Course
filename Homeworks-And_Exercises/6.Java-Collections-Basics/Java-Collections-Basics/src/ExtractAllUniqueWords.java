import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class ExtractAllUniqueWords {

	public static void main(String[] args) {
		Scanner inputText = new Scanner(System.in);
		String[] textWords = inputText.nextLine().split("\\W+");
		
		Set<String> words = new TreeSet<String>();
		for (String word : textWords) {
			words.add(word.toLowerCase());
		}
		
		words.forEach(w -> System.out.print(w + " "));
	}

}
