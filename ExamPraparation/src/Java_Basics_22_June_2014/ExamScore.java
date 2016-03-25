package Java_Basics_22_June_2014;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class ExamScore {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		input.nextLine();
		input.nextLine();
		String headerOrFooter = input.nextLine();
		
		Map<Integer, Map<String, Double>> examScores = new TreeMap<Integer, Map<String,Double>>();
		
		String examInformation = input.nextLine();
		while (!examInformation.equals(headerOrFooter)) {
			String[] currentStudentData = examInformation.split("\\s*\\|\\s*");
			
			String studentFullName = currentStudentData[1];
			int examScore = Integer.parseInt(currentStudentData[2]);
			double examGrade = Double.parseDouble(currentStudentData[3]);
			
			if (!examScores.containsKey(examScore)) {
				examScores.put(examScore, new TreeMap<String, Double>());
			}
			
			examScores.get(examScore).put(studentFullName, examGrade);
			
			examInformation = input.nextLine();
		}
		
		for (Integer score : examScores.keySet()) {
			System.out.print(score + " -> ");
			System.out.print(examScores.get(score).keySet());
			
			Map<String, Double> currentScore =  examScores.get(score);
			double averageGrade = calculateAverageGrade(currentScore);
			System.out.printf("; avg=%.2f\n", averageGrade);
		}
	}


	private static double calculateAverageGrade(Map<String, Double> currentScore) {
		double averageGrade = 0;
		for (Entry<String, Double> entry : currentScore.entrySet()) {
			averageGrade += currentScore.get(entry.getKey());
		}
		
		return averageGrade / (double) currentScore.size();
	}

}
