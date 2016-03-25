package Java_Sample_Contest;

import java.math.BigInteger;
import java.util.Scanner;

public class BitFlipper {

	public static void main(String[] args) {
		final int SEQUENCE_OF_EQUAL_BITS = 3;
		
		Scanner input = new Scanner(System.in);
		BigInteger number = new BigInteger(input.next());
		
		String binaryNumber = number.toString(2);
		StringBuffer binaryNumberBuffer = new StringBuffer(binaryNumber);
		while (binaryNumberBuffer.length() < 64) {
			binaryNumberBuffer.insert(0, "0");
		}
		
		char[] binaryNumberBits = binaryNumberBuffer.toString().toCharArray();
		for (int i = 0; i <= binaryNumberBits.length - SEQUENCE_OF_EQUAL_BITS; i++) {
			if (binaryNumberBits[i] == binaryNumberBits[i + 1] 
					&& binaryNumberBits[i + 1] == binaryNumberBits[i + 2]) {
				char currentBit = binaryNumberBits[i];
				switch (currentBit) {
				case '0':
					binaryNumberBits[i] = '1';
					binaryNumberBits[i + 1] = '1';
					binaryNumberBits[i + 2] = '1';
					break;
				case '1':
					binaryNumberBits[i] = '0';
					binaryNumberBits[i + 1] = '0';
					binaryNumberBits[i + 2] = '0';
					break;

				default:
					break;
				}
				
				i += SEQUENCE_OF_EQUAL_BITS - 1;
			}
		}
		
		String resultBinaryNumber = String.valueOf(binaryNumberBits);
		BigInteger resultNumber = new BigInteger(resultBinaryNumber, 2);
		
		System.out.println(resultNumber);
	}

}
