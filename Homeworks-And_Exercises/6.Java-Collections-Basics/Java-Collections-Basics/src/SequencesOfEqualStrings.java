import java.util.Scanner;


public class SequencesOfEqualStrings {

	public static void main(String[] args) {
		System.out.println("Please enter a sequence of strings separated by spaces:");
		
		Scanner inputStringScanner = new Scanner(System.in);
		
		String[] strings = inputStringScanner.nextLine().split(" ");
		
		System.out.printf("%s ", strings[0]);
		for (int i = 1; i < strings.length; i++) {
			if(strings[i].equals(strings[i - 1])) {
				System.out.printf("%s ", strings[i]);
			} else {
				System.out.printf("\n%s ", strings[i]);
			}
		}
	}

}
