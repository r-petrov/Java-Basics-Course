import java.util.Scanner;


public class TriangleArea {

	public static void main(String[] args) {
		Scanner inputPointCoordinates = new Scanner(System.in);
		
		int aX = inputPointCoordinates.nextInt();
		int aY = inputPointCoordinates.nextInt();
		int bX = inputPointCoordinates.nextInt();
		int bY = inputPointCoordinates.nextInt();
		int cX = inputPointCoordinates.nextInt();
		int cY = inputPointCoordinates.nextInt();
		
		int triangleArea = Math.abs((aX * (bY - cY) + bX * (cY - aY) + cX * (aY - bY)) / 2);
		
		System.out.println(triangleArea);
	}

}