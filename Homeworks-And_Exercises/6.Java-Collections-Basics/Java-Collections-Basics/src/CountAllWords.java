import java.util.Scanner;


public class CountAllWords {

	public static void main(String[] args) {
		Scanner inputWords = new Scanner(System.in);
		String[] words = inputWords.nextLine().split("\\W+");
		
		System.out.println(words.length);
	}

}
