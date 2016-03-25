import java.util.Scanner;

public class RectangleArea {
	public static void main(String[] args) {
		Scanner inputSides = new Scanner(System.in);
		
		int sideA = inputSides.nextInt();
		int sideB = inputSides.nextInt();
		
		int rectangleArea = sideA * sideB;
		
		System.out.println(rectangleArea);
	}
}
