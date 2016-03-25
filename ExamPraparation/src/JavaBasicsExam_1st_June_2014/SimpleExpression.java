package JavaBasicsExam_1st_June_2014;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleExpression {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine().trim();
		String[] numbers = expression.split("[ \\+\\-]+");
		
		Pattern operatorsPattern = Pattern.compile("[\\-\\+]");
		Matcher operatorsMatcher = operatorsPattern.matcher(expression);
		List<String> operators = new ArrayList<String>();
		while (operatorsMatcher.find()) {
			operators.add(operatorsMatcher.group());
		}
		
		BigDecimal sum = new BigDecimal(numbers[0]);
		
		for (int i = 1; i < numbers.length; i++) {
			String currentOperatorString = operators.get(i - 1);
			BigDecimal currentNumber = new BigDecimal(numbers[i]);
			
			if (currentOperatorString.equals("+")) {
				sum = sum.add(currentNumber);
			} else {
				sum = sum.subtract(currentNumber);
			}
			
		}
		
		System.out.println(sum);
	}

}
