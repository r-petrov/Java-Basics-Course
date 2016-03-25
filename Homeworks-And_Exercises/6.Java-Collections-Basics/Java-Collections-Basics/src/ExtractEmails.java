import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ExtractEmails {

	public static void main(String[] args) {
		Scanner inputText = new Scanner(System.in);
		String text = inputText.nextLine();
		
		String emailPattern = "([A-z0-9])+([\\.\\-_])?([A-z0-9])+([\\.\\-_])?([A-z0-9])+@([A-z])+\\-?([A-z]+\\.)+([A-z])+";
		List<String> matchCollection = new ArrayList<String>();
		Matcher matchEmail = Pattern.compile(emailPattern).matcher(text);
		while (matchEmail.find()) {
			matchCollection.add(matchEmail.group());
		}
		
		for (String match : matchCollection) {
			System.out.println(match);
		}
	}

}
