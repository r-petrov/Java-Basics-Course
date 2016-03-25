import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class SumNumbersFromATextFile {

	public static void main(String[] args) {
		int currentNumber = 0;
		int sumOfNumbers = 0;
		
		try (BufferedReader fileReader = new BufferedReader(
				new FileReader("\\..\\..\\input.txt"));
				) {
			while (true) {
				String line = fileReader.readLine();
				if (line == null) {
					break;
				}
				
				currentNumber = Integer.parseInt(line);
				sumOfNumbers += currentNumber;
			}
			System.out.println(sumOfNumbers);
		} catch (IOException ioex) {
			System.err.println("Error");
		} 
	}

}
