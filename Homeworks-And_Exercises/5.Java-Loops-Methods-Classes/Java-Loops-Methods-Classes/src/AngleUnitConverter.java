import java.util.Locale;
import java.util.Scanner;


public class AngleUnitConverter {
	static final double DEGREES_180 = 180;
	static final double PI = Math.PI;
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.ROOT);
		
		Scanner input = new Scanner(System.in);
		int numberOfConversions = Integer.parseInt(input.nextLine());
		String[] queriesStrings = null;
		
		for (int i = 0; i < numberOfConversions; i++) {
			queriesStrings = input.nextLine().split(" ");
			processQuery(queriesStrings);
			
		}
	}

	private static void processQuery(String[] queriesStrings) {
		double degreesToConvert = Double.parseDouble(queriesStrings[0]);
		String measure = queriesStrings[1];
		
		switch (measure) {
		case "deg":
			double radians = convertDegreesToRadians(degreesToConvert);
			System.out.printf("%.6f\n", radians);
			break;
		case "rad":
			double degrees = convertRadiansToDegrees(degreesToConvert);
			System.out.printf("%.6f\n", degrees);
			break;
			
		default:
			System.out.println("Invalid measure");
			break;
		}
	}

	private static double convertRadiansToDegrees(Double degreesToConvert) {
		double degrees = degreesToConvert * (DEGREES_180 / PI);
		return degrees;
	}

	private static double convertDegreesToRadians(Double degreesToConvert) {
		double radians = degreesToConvert * (PI / DEGREES_180);
		return radians;
	}

}
