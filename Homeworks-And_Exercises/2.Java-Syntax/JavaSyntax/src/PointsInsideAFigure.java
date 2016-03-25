import java.util.Locale;
import java.util.Scanner;


public class PointsInsideAFigure {

	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		Scanner inputCoordinates = new Scanner(System.in);
		
		double xCoordinate = inputCoordinates.nextDouble();
		double yCoordinate = inputCoordinates.nextDouble();
		
		boolean isInsideFigure1 = false;
		boolean isInsideFigure2 = false;
		boolean isInsideFigure3 = false;
		
		if((xCoordinate >= 12.5 && xCoordinate <= 22.5) && (yCoordinate >= 6 && yCoordinate <= 8.5)) {
			isInsideFigure1 = true;
		}
		
		if((xCoordinate >= 12.5 && xCoordinate <= 17.5) && (yCoordinate >= 8.5 && yCoordinate <= 13.5)) {
			isInsideFigure2 = true;
		}
		
		if((xCoordinate >= 20 && xCoordinate <= 22.5) && (yCoordinate >= 8.5 && yCoordinate <= 13.5)) {
			isInsideFigure3 = true;
		}
		
		boolean isInsideTheFigure = false;
		if (isInsideFigure1 || isInsideFigure2 || isInsideFigure3) {
			isInsideTheFigure = true;
		}
		
		if(isInsideTheFigure) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}
	}

}
