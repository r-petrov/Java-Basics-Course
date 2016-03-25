package Java_Basics_Exam_3_September_2014;

import java.util.Scanner;

public class AddingAngles {

	public static void main(String[] args) {
		final int FULL_CIRCLE_DEGREES = 360;

		Scanner input = new Scanner(System.in);
		int countOfAngles = Integer.parseInt(input.nextLine());
		int[] angles = new int[countOfAngles];
		for (int i = 0; i < angles.length; i++) {
			angles[i] = input.nextInt();
		}

		int counterOfSetsOfAngles = 0;
		for (int i = 0; i < angles.length - 2; i++) {
			for (int j = i + 1; j < angles.length - 1; j++) {
				for (int j2 = j + 1; j2 < angles.length; j2++) {
					int sumOfAngles = angles[i] + angles[j] + angles[j2];
					if (sumOfAngles % 360 == 0) {
						System.out.printf("%d + %d + %d = %d degrees%n",
								angles[i], angles[j], angles[j2], sumOfAngles);
						counterOfSetsOfAngles++;
					}
				}
			}
		}
		
		if (counterOfSetsOfAngles == 0) {
			System.out.println("No");
		}
	}

}
