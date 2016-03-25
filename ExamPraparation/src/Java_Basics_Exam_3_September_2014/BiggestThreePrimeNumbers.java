package Java_Basics_Exam_3_September_2014;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BiggestThreePrimeNumbers {

	public static void main(String[] args) {
		final int NUMBER_OF_BIGGEST_PRIMES = 3;
		Scanner input = new Scanner(System.in);
		String numbersString = input.nextLine().trim();
		
		Pattern numbersPattern = Pattern.compile("-?\\d+");
		Matcher numbersMatcher = numbersPattern.matcher(numbersString);
		
		List<Integer> numbers = new ArrayList<Integer>();
		while (numbersMatcher.find()) {
			String number = numbersMatcher.group();
			numbers.add(Integer.parseInt(number));
		}
		
		List<Integer> primeNumbers = new ArrayList<Integer>();
		for (int number : numbers) {
			boolean isPrimeNumber = checkIfNumberIsPrime(number);
			if (isPrimeNumber && !primeNumbers.contains(number)) {
				primeNumbers.add(number);
			}
		}
		
		printSumOfBiggestPrimes(NUMBER_OF_BIGGEST_PRIMES, primeNumbers);
		
	}

	private static void printSumOfBiggestPrimes(
			final int NUMBER_OF_BIGGEST_PRIMES, List<Integer> primeNumbers) {
		if (primeNumbers.size() < NUMBER_OF_BIGGEST_PRIMES) {
			System.out.println("No");
		} else {
			Collections.sort(primeNumbers, Collections.reverseOrder());
			
			int sumOfBiggestPrimes = 0;
			for (int i = 0; i < NUMBER_OF_BIGGEST_PRIMES; i++) {
				sumOfBiggestPrimes += primeNumbers.get(i);
			}
			
			System.out.println(sumOfBiggestPrimes);
		}
	}

	private static boolean checkIfNumberIsPrime(int number) {
		boolean isPrime = true;
		if (number < 2) {
			isPrime = false;
		} else if (number > 2) {
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
			
		return isPrime;
	}

}
