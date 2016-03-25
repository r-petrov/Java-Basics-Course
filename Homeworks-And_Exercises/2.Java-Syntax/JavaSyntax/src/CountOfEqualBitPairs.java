import java.util.Scanner;


public class CountOfEqualBitPairs {

	public static void main(String[] args) {
		Scanner inputNumber = new Scanner(System.in);
		
		int number = inputNumber.nextInt();
		char[] binaryNumberString = Integer.toBinaryString(number).toCharArray();
		
		int countOfEqualBitPairs = 0;
		for (int i = 0; i < binaryNumberString.length - 1; i++) {
			if (binaryNumberString[i] == binaryNumberString[i + 1]) {
				countOfEqualBitPairs++;
			}
		}
		
		System.out.println(countOfEqualBitPairs);
	}

}
