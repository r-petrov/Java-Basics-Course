import java.util.Locale;
import java.util.Scanner;


public class FormattingNumbers {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		Scanner inputNumber = new Scanner(System.in);
		
		int a = inputNumber.nextInt();
		double b = inputNumber.nextDouble();
		double c = inputNumber.nextDouble();
		
		String hexademicalA = Integer.toHexString(a).toUpperCase();
		String binaryA = String.format("%10s", Integer.toBinaryString(a)).replace(" ", "0");
		
		System.out.printf("|%-10s|%s|%10.2f|%-10.3f|", hexademicalA, binaryA, b, c);
	}

}
