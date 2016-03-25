package Java_Basics_Exam_3_September_2014;

import java.util.Scanner;

public class DozensOfEggs {

	public static void main(String[] args) {
		final int DAYS_IN_WEEK = 7;
		final int EGGS_PER_DOZEN = 12;
		
		Scanner input = new Scanner(System.in);
		
		int totalDozens = 0;
		int totalEggs = 0;
		for (int i = 0; i < DAYS_IN_WEEK; i++) {
			String[] eggsPerDay = input.nextLine().split("\\s+");
			int eggsCount = Integer.parseInt(eggsPerDay[0]);
			String measure = eggsPerDay[1];
			switch (measure) {
			case "dozens":
				totalDozens += eggsCount;
				break;
			case "eggs":
				totalEggs += eggsCount;
				break;

			default:
				throw new IllegalArgumentException("Illegal measure.");
			}
		}
		
		totalDozens += (totalEggs / EGGS_PER_DOZEN);
		int eggsLeft = totalEggs % EGGS_PER_DOZEN;
		
		System.out.printf("%d dozens + %d eggs", totalDozens, eggsLeft);
	}

}
