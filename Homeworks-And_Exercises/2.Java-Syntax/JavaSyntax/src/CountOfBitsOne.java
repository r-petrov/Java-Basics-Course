import java.util.Scanner;


public class CountOfBitsOne {

	public static void main(String[] args) {
		Scanner inputNumber = new Scanner(System.in);
		
		int number = inputNumber.nextInt();
		char[] binaryNumberString = Integer.toBinaryString(number).toCharArray();
		
		int countOfOnes = 0;
		for (int i = 0; i < binaryNumberString.length; i++) {
			if (binaryNumberString[i] == '1') {
				countOfOnes++;
			}
		}
		
		System.out.println(countOfOnes);
	}

}
