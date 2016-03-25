package Java_Basics_22_June_2014;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CognateWords {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String[] words = input.nextLine().trim().split("[^A-z]+");
		
		Set<String> cognateWords =new HashSet<String>();
		for (String a : words) {
			for (String b : words) {
				for (String c : words) {
					if (!a.equals(c) && !b.equals(c)) {
						if ((a + b).equals(c)) {
							String equality = a + "|" + b + "=" + c;
							cognateWords.add(equality);
						}
					}
				}
			}
		}
		
		if (cognateWords.size() > 0) {
			cognateWords.forEach(w -> System.out.println(w));
		} else {
			System.out.println("No");
		}
	}

}
