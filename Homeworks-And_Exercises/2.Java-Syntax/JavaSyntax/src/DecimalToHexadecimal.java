import java.util.Scanner;


public class DecimalToHexadecimal {

	public static void main(String[] args) {
		Scanner inputNumber = new Scanner(System.in);
		
		int num = inputNumber.nextInt();
		String hexademicalNumString = Integer.toHexString(num).toUpperCase();
		
		System.out.println(hexademicalNumString);
	}

}
