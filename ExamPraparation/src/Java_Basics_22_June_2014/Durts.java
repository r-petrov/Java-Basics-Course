package Java_Basics_22_June_2014;

import java.util.Scanner;

public class Durts {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int centerX = input.nextInt();
		int centerY = input.nextInt();
		int radius = input.nextInt();
		
//		double horizontalUpperLeftX = centerX - radius;
//		double horizontalUpperLeftY = centerY + (radius / 2.0);
//		Rectangle2D horizontelRectangle = new Rectangle2D.Double(
//				horizontalUpperLeftX, horizontalUpperLeftY, radius * 2, radius);
//		
//		double verticalUpperLeftX = centerX - (radius / 2.0);
//		double verticalUpperLeftY = centerY + radius;
//		Rectangle2D verticalRectangle = new Rectangle2D.Double(
//				verticalUpperLeftX, verticalUpperLeftY, radius, radius * 2);
		
		int numberOfDarts = input.nextInt();
		for (int i = 0; i < numberOfDarts; i++) {
			int currentDartX = input.nextInt();
			int currentDartY = input.nextInt();
			
			boolean isInsideHorizontalRectangle = false;
			boolean isInsideVerticalRectangle = false;
			
			if (((centerX - radius <= currentDartX) && (currentDartX <= centerX + radius)) && 
					(centerY - (radius / 2) <= currentDartY) && currentDartY <= centerY + (radius / 2)) {
				isInsideHorizontalRectangle = true;
			}
			
			if ((centerX - (radius / 2) <= currentDartX && currentDartX <= centerX + (radius / 2) &&
					centerY - radius <= currentDartY && currentDartY <= centerY + radius)) {
				isInsideVerticalRectangle = true;
			}
			
			if (isInsideHorizontalRectangle || isInsideVerticalRectangle) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
//			if (horizontelRectangle.contains(currentDartX, currentDartY) || 
//					verticalRectangle.contains(currentDartX, currentDartY)) {
//				System.out.println("yes");
//				
//			} else {
//				System.out.println("no");
//			}
		}
	}

}
