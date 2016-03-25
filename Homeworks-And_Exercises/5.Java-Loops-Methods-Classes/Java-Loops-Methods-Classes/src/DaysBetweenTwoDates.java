import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class DaysBetweenTwoDates {

	public static void main(String[] args) {
		Scanner inputDate = new Scanner(System.in);
		
		String[] firstDateStrings = inputDate.nextLine().split("-");
		checkDateInput(inputDate, firstDateStrings);
		int firstDateDay = Integer.parseInt(firstDateStrings[0]);
		int firstDateMonth = Integer.parseInt(firstDateStrings[1]);
		int firstDateYear = Integer.parseInt(firstDateStrings[2]);
		Calendar firstDate = GregorianCalendar.getInstance();
		firstDate.set(firstDateYear, firstDateMonth - 1, firstDateDay);
		
		String[] secondDateStrings = inputDate.nextLine().split("-");
		checkDateInput(inputDate, secondDateStrings);
		int secondDateDay = Integer.parseInt(secondDateStrings[0]);
		int secondDateMonth = Integer.parseInt(secondDateStrings[1]);
		int secondDateYear = Integer.parseInt(secondDateStrings[2]);
		Calendar secondDate = GregorianCalendar.getInstance();
		secondDate.set(secondDateYear, secondDateMonth - 1, secondDateDay);
		
		long daysBetweenTwoDates = calculateDaysBetweenTwoDates(firstDate, secondDate);
		System.out.println(daysBetweenTwoDates);
	}
	
	public static long calculateDaysBetweenTwoDates(Calendar startDate, Calendar endDate) {
	    long end = endDate.getTimeInMillis();
	    long start = startDate.getTimeInMillis();
	    long difference = TimeUnit.MILLISECONDS.toDays(end - start);
//	    return TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
	    if(difference < 0) {
	    	difference--;
	    }
	    return difference;
	}

	private static void checkDateInput(Scanner inputDate,
			String[] dateStrings) {
		int day = Integer.parseInt(dateStrings[0]);
		int month = Integer.parseInt(dateStrings[1]);
		int year = Integer.parseInt(dateStrings[2]);
		while (day < 1 || day > 31
				|| month < 1 || month > 12
				|| year < 1900 || year > 2100) {
			dateStrings = inputDate.nextLine().split("-");
			day = Integer.parseInt(dateStrings[0]);
			month = Integer.parseInt(dateStrings[1]);
			year = Integer.parseInt(dateStrings[2]);
		}
	}

}
