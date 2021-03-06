import java.util.Locale;
import java.util.Scanner;


public class TheSmallestOf3Numbers {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		Scanner inputNumbers = new Scanner(System.in);
		
		double a = inputNumbers.nextDouble();
		double b = inputNumbers.nextDouble();
		double c = inputNumbers.nextDouble();
		Double minimalNumber = 0.0;
		
		if(a <= b) {
			minimalNumber = a;
		} else {
			minimalNumber = b;
		}
		
		if(c <= minimalNumber) {
			minimalNumber = c;
		}
		
		System.out.println(minimalNumber);
	}
}
