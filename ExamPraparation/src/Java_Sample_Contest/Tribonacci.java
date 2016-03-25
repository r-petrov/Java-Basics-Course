package Java_Sample_Contest;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Tribonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		BigInteger firstNumber = new BigInteger(input.nextLine());
		BigInteger secondNumber = new BigInteger(input.nextLine());
		BigInteger thirdNumber = new BigInteger(input.nextLine());
		int nThNumber = Integer.parseInt(input.nextLine());
		
		List<BigInteger> tribonachiNumbers = new ArrayList<BigInteger>(Arrays.asList(firstNumber, secondNumber, thirdNumber));
		for (int i = 3; i < nThNumber; i++) {
			BigInteger currentNumber = 
					tribonachiNumbers.get(i - 3)
					.add(tribonachiNumbers.get(i - 2)
							.add(tribonachiNumbers.get(i - 1)));
			tribonachiNumbers.add(currentNumber);
		}
		
		System.out.println(tribonachiNumbers.get(nThNumber - 1));
	}

}
