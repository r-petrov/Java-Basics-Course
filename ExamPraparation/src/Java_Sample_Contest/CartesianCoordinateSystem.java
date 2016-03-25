package Java_Sample_Contest;

import java.util.Scanner;

public class CartesianCoordinateSystem {

	public static void main(String[] args) {
		final int ZERO_POINT = 0;
		final int FIRST_QUADRANT = 1;
		final int SECOND_QUADRANT = 2;
		final int THIRD_QUADRANT = 3;
		final int FOURTH_QUADRANT = 4;
		final int ORDINATE = 5;
		final int ABSCISSA = 6;
		
		Scanner input = new Scanner(System.in);
		long xCoordinate = input.nextLong();
		long yCoordinate = input.nextLong();
		
		if (xCoordinate == 0 && yCoordinate == 0) {
			System.out.println(ZERO_POINT);
		} else if (xCoordinate == 0) {
			System.out.println(ORDINATE);
		} else if (yCoordinate == 0) {
			System.out.println(ABSCISSA);
		} else if (xCoordinate > 0 && yCoordinate > 0) {
			System.out.println(FIRST_QUADRANT);
		} else if (xCoordinate < 0 && yCoordinate > 0) {
			System.out.println(SECOND_QUADRANT);
		} else if (xCoordinate < 0 && yCoordinate < 0) {
			System.out.println(THIRD_QUADRANT);
		} else {
			System.out.println(FOURTH_QUADRANT);
		}
	}

}
