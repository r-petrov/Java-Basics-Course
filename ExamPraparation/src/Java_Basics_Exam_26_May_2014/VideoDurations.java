package Java_Basics_Exam_26_May_2014;

import java.util.Scanner;

public class VideoDurations {

	public static void main(String[] args) {
		final int MINUTES_PER_HOUR = 60;
		
		Scanner input = new Scanner(System.in);
		String duration = input.nextLine();
		
		int totalHours = 0;
		int totalMinutes = 0;
		while (!duration.equals("End")) {
			String[] durationMeasures = duration.split(":");
			int hours = Integer.parseInt(durationMeasures[0]);
			int minutes = Integer.parseInt(durationMeasures[1]);
			
			totalHours += hours;
			totalMinutes += minutes;
			
			duration = input.nextLine();
		}
		
		totalHours += (totalMinutes / MINUTES_PER_HOUR);
		totalMinutes = (totalMinutes % MINUTES_PER_HOUR);
		
		System.out.println(String.format("%d:%02d", totalHours, totalMinutes));
	}

}
