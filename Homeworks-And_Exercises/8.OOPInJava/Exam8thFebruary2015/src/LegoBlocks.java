import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class LegoBlocks {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfRows = Integer.parseInt(input.nextLine());

		ArrayList<ArrayList<String>> firstJaggedArray = fillJaggedArray(numberOfRows, input);
		ArrayList<ArrayList<String>> secondJaggedArray = fillJaggedArray(numberOfRows, input);
		ArrayList<ArrayList<String>> reversedSecondJaggedArray = new ArrayList<ArrayList<String>>(numberOfRows);
		
		for (ArrayList<String> numbersCollection : secondJaggedArray) {
			ArrayList<String> reversedNumbersCollection = reverseCollection(numbersCollection);
			reversedSecondJaggedArray.add(reversedNumbersCollection);
		}
		//System.out.println(Arrays.deepToString(reversedSecondJaggedArray.toArray()));
		
		for (int i = 0; i < numberOfRows; i++) {
			firstJaggedArray.get(i).addAll(reversedSecondJaggedArray.get(i));
		}
		
		boolean hasEqualRows = false;
		int firstRowLength = firstJaggedArray.get(0).size();
		for (int i = 1; i < firstJaggedArray.size(); i++) {
			if (firstJaggedArray.get(i).size() == firstRowLength) {
				hasEqualRows = true;
			} else {
				hasEqualRows = false;
				break;
			}
		}
		
		if (hasEqualRows) {
			firstJaggedArray.forEach(arr -> System.out.println(Arrays.deepToString(arr.toArray())));
		} else {
			int totalNumberOfCells = 0;
			for (ArrayList<String> numbersCollection : firstJaggedArray) {
				totalNumberOfCells += numbersCollection.size();
			}
			System.out.printf("The total number of cells is: %d", totalNumberOfCells);
		}
	}

	private static ArrayList<String> reverseCollection(
			ArrayList<String> numbersCollection) {
		ArrayList<String> reversedNumbersCollection = new ArrayList<String>(numbersCollection.size());
		for (int i = numbersCollection.size() - 1; i >= 0; i--) {
			reversedNumbersCollection.add(numbersCollection.get(i));
		}
		return reversedNumbersCollection;
	}

	private static ArrayList<ArrayList<String>> fillJaggedArray(int numberOfRows, Scanner input) {
		ArrayList<ArrayList<String>> jaggedArray = new ArrayList<ArrayList<String>>(numberOfRows);
		for (int i = 0; i < numberOfRows; i++) {
			String[] numbers = input.nextLine().trim().split("\\s+");
			ArrayList<String> numbersList = new ArrayList<String>(Arrays.asList(numbers));
			jaggedArray.add(numbersList);
		}
		return jaggedArray;
	}
}
