package Java_Basics_Exam_27_May_2014;

import java.util.Scanner;

public class CountBeers {

	public static void main(String[] args) {
		final int BEERS_PER_STACK = 20;
		
		Scanner input = new Scanner(System.in);
		String inputLine = input.nextLine();
		
		int totalBeers = 0;
		int totalStacks = 0;
		while (!inputLine.equals("End")) {
			String[] beersLine = inputLine.split(" ");
			int beersCount = Integer.parseInt(beersLine[0]);
			String measure = beersLine[1];
			
			switch (measure) {
			case "stacks":
				totalStacks += beersCount;
				break;
			case "beers":
				totalBeers += beersCount;
				break;

			default:
				throw new IllegalArgumentException("Illegal measure.");
			}
			
			inputLine = input.nextLine();
		}
		
		totalStacks += (totalBeers / BEERS_PER_STACK);
		totalBeers = totalBeers % BEERS_PER_STACK;
		
		System.out.println(String.format("%d stacks + %d beers", totalStacks, totalBeers));
	}

}
