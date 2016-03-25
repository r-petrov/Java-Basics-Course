package Java_Basics_Exam_26_May_2014;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LargestThreeRectangles {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String rectanglesInput = input.nextLine();
		
		List<Integer> rectanglesSides = new LinkedList<Integer>();
		Pattern rectanglesPattern = Pattern.compile("\\d+");
		Matcher rectanglesMatcher = rectanglesPattern.matcher(rectanglesInput);
		while (rectanglesMatcher.find()) {
			rectanglesSides.add(Integer.parseInt(rectanglesMatcher.group()));
		}
		
		List<Integer> rectanglesAreas = getRectanglesAreas(rectanglesSides);
		
		System.out.println(rectanglesAreas);
		
		int maxTotalRectanglesArea = getMaxTotalRectanglesArea(rectanglesAreas);
		
		System.out.println(maxTotalRectanglesArea);
	}

	private static List<Integer> getRectanglesAreas(
			List<Integer> rectanglesSides) {
		List<Integer> rectanglesAreas = new LinkedList<Integer>();
		for (int i = 0; i < rectanglesSides.size(); i += 2) {
			int rectangleArea = rectanglesSides.get(i) * rectanglesSides.get(i + 1);
			rectanglesAreas.add(rectangleArea);
		}
		return rectanglesAreas;
	}

	private static int getMaxTotalRectanglesArea(List<Integer> rectanglesAreas) {
		int maxTotalRectanglesArea = Integer.MIN_VALUE;
		for (int i = 0; i < rectanglesAreas.size() - 2; i++) {
			int totalRectanglesArea = 
					rectanglesAreas.get(i) + rectanglesAreas.get(i + 1) + rectanglesAreas.get(i + 2);
			if (totalRectanglesArea > maxTotalRectanglesArea) {
				maxTotalRectanglesArea = totalRectanglesArea;
			}
		}
		return maxTotalRectanglesArea;
	}

}
