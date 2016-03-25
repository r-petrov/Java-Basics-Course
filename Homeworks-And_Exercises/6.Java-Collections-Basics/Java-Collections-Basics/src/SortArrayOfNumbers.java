import java.util.Arrays;
import java.util.Scanner;



public class SortArrayOfNumbers {

	public static void main(String[] args) {
		Scanner inputNumbers = new Scanner(System.in);
		int numberOfElements = Integer.parseInt(inputNumbers.nextLine());
		
		int[] numbers = new int[numberOfElements];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = inputNumbers.nextInt();
		}
		
		Arrays.sort(numbers);
		
		for (int i : numbers) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}

}
