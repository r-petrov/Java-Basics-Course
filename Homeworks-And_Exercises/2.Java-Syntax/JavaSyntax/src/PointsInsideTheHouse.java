import java.util.Locale;
import java.util.Scanner;


public class PointsInsideTheHouse {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		final double aX = 12.5;
		final double aY = 8.5;
		final double bX = 17.5;
		final double bY = 3.5;
		final double cX = 22.5;
		final double cY = 8.5;
		
		Scanner inputCoordinates = new Scanner(System.in);
		
		double xCoordinate = inputCoordinates.nextDouble();
		double yCoordinate = inputCoordinates.nextDouble();
		
		boolean isInsideTriangle = false;
		boolean isInsideRectangle1 = false;
		boolean isInsideRectangle2 = false;
		
		// position = sign( (Bx-Ax)*(Y-Ay) - (By-Ay)*(X-Ax) );   value = (x1 - x0)(y2 - y0) - (y1 - y0)(x2 - x0)
		double leftPosition = (bX - aX) * (yCoordinate - aY) - (bY - aY) * (xCoordinate - aX);
		double rightPosition = (cX - bX) * (yCoordinate - bY) - (cY - bY) * (xCoordinate - bX);
		double verticalPosition = (22.5 - 8.5) * (yCoordinate - 8.5) - (8.5 - 8.5) * (xCoordinate - 12.5);
		
		if(leftPosition >= 0 && rightPosition >= 0 && verticalPosition <= 0) {
			isInsideTriangle = true;
		}
		
		if((xCoordinate >= 12.5 && xCoordinate <= 17.5) && (yCoordinate >= 8.5 && yCoordinate <= 13.5)) {
			isInsideRectangle1 = true;
		}
		
		if((xCoordinate >= 20 && xCoordinate <= 22.5) && (yCoordinate >= 8.5 && yCoordinate <= 13.5)) {
			isInsideRectangle2 = true;
		}
		
		boolean isInsideTheHouse = false;
		if (isInsideTriangle || isInsideRectangle1 || isInsideRectangle2) {
			isInsideTheHouse = true;
		}
		
		if(isInsideTheHouse) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}
	}
	
}
