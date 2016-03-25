package Java_Fundamentals_4_October_2015;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DragonSharp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int numberOfLines = Integer.parseInt(input.nextLine());
		
		List<String> statements = new LinkedList<String>();
		for (int i = 1; i <= numberOfLines; i++) {
			String statement = input.nextLine().trim();
			
			statements.add(statement.toString());
		}
		
		for (int i = 0; i < statements.size(); i++) {
			String statementString =  statements.get(i);
			String[] statement = statementString.split(" ");
			
			String lastString = statement[statement.length - 1];
			if (!lastString.contains("\"") || !lastString.contains(";")) {
				System.out.println(String.format("Compile time error @ line %d", i));
				break;
			}
			
			if (i < statements.size() - 1) {
				if (statements.get(i + 1).contains("else")) {
					String[] nextStatement = statements.get(i + 1).split(" ");
					String nextLastString = nextStatement[nextStatement.length - 1];
					if (!nextLastString.contains("\"") || !nextLastString.contains(";")) {
						System.out.println(String.format("Compile time error @ line %d", i + 2));
						break;
					}
				}
			}
			
			Pattern outputStringPattern = Pattern.compile("\".+\"");
			Matcher outputStringMatcher = outputStringPattern.matcher(statementString);
			String outputString = null;
			while (outputStringMatcher.find()) {
				outputString = outputStringMatcher.group();
			}
			
			String statementType = statement[0];
			String statementCondition = statement[1];
			if (statementType.equals("if")) {
				LinkedList<Integer> numbersArguments = extractNumbers(statementCondition);
				if (statementCondition.contains("<")) {
					if (numbersArguments.get(0) < numbersArguments.get(1)) {
						printIfTrueCondition(statement, outputString);

						if (i < statements.size() - 1 && statements.get(i + 1).equals("else")) {
							i++;
						}
					}
				} else if (statementCondition.contains(">")) {
					if (numbersArguments.get(0) > numbersArguments.get(1)) {
						printIfTrueCondition(statement, outputString);

						if (i < statements.size() - 1 && statements.get(i + 1).equals("else")) {
							i++;
						}
					}
				} else if (statementCondition.contains("==")) {
					if (numbersArguments.get(0) == numbersArguments.get(1)) {
						printIfTrueCondition(statement, outputString);

						if (i < statements.size() - 1 && statements.get(i + 1).equals("else")) {
							i++;
						}
					}
				}
			}
			
			if (statementType.equals("else")) {
				printElseCondition(statement, outputString);
			}
		}
	}
	
	private static LinkedList<Integer> extractNumbers(String statement) {
		LinkedList<Integer> numbersArguments = new LinkedList<Integer>();
		Pattern numbersPattern = Pattern.compile("\\d+");
		Matcher numbersMatcher = numbersPattern.matcher(statement);
		while (numbersMatcher.find()) {
			numbersArguments.add(Integer.parseInt(numbersMatcher.group()));
		}
		
		return numbersArguments;
	}

	private static void printIfTrueCondition(String[] statement,
			String outputString) {
		if (statement[2].equals("loop")) {
			int loop = Integer.parseInt(statement[3]);
			for (int j = 0; j < loop; j++) {
				System.out.println(outputString.substring(1,
						outputString.length() - 1));
			}
		} else {
			System.out.println(outputString.substring(1,
					outputString.length() - 1));
		}
	}
	
	private static void printElseCondition(String[] statement,
			String outputString) {
		if (statement[1].equals("loop")) {
			int loop = Integer.parseInt(statement[2]);
			for (int j = 0; j < loop; j++) {
				System.out.println(outputString.substring(1,
						outputString.length() - 1));
			}
		} else {
			System.out.println(outputString.substring(1,
					outputString.length() - 1));
		}
	}

}

