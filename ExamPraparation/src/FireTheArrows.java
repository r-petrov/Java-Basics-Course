import java.util.Scanner;


public class FireTheArrows {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfRows = Integer.parseInt(input.nextLine());
		
		//final char blankSpace = 'o';
		
		char[][] matrix = new char[numberOfRows][];
		fillMatrix(input, matrix);
		
		boolean hasMoved = true;
		while (hasMoved) {
			hasMoved = false;
			for (int row = 0; row < matrix.length; row++) {
				for (int col = 0; col < matrix[row].length; col++) {
					char currentSymbol = matrix[row][col];
					final char blankSpace = 'o';
					switch (currentSymbol) {
					case '<':
						if (col > 0 && matrix[row][col - 1] == blankSpace) {
							matrix[row][col - 1] = currentSymbol;
							matrix[row][col] = blankSpace;
							hasMoved = true;
						}
						break;
					case '>':
						if (col < (matrix[row].length - 1)
								&& matrix[row][col + 1] == blankSpace) {
							matrix[row][col + 1] = currentSymbol;
							matrix[row][col] = blankSpace;
							hasMoved = true;
						}
						break;
					case '^':
						if (row > 0 && matrix[row - 1][col] == blankSpace) {
							matrix[row - 1][col] = currentSymbol;
							matrix[row][col] = blankSpace;
							hasMoved = true;
						}
						break;
					case 'v':
						if (row < (matrix.length - 1)
								&& matrix[row + 1][col] == blankSpace) {
							matrix[row + 1][col] = currentSymbol;
							matrix[row][col] = blankSpace;
							hasMoved = true;
						}
						break;

					default:
						break;
					}
				}
			}
		}
		
		printMatrix(matrix);
	}

	private static void fillMatrix(Scanner input, char[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			char[] currentRowChars = input.nextLine().toCharArray();
			matrix[i] = currentRowChars;
		}
	}

	private static void printMatrix(char[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[row].length; col++) {
				System.out.print(matrix[row][col]);
			}
			System.out.println();
		}
	}

}
