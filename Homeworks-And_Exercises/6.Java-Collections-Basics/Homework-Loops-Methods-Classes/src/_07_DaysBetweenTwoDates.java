import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class _07_DaysBetweenTwoDates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please, enter the starting date:");
        String startDate = input.nextLine();
        if (startDate.length() == 9) {
            startDate = "0" + startDate;
        }

        System.out.print("Please, enter the end date:");
        String endDateAsString = input.nextLine();
        if (endDateAsString.length() == 9) {
            endDateAsString = "0" + endDateAsString;
        }

        DateTimeFormatter formatOfDate = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate startingDate = LocalDate.parse(startDate, formatOfDate);
        LocalDate endDate = LocalDate.parse(endDateAsString, formatOfDate);

        long daysBetweenTwoDates = ChronoUnit.DAYS.between(startingDate, endDate);

        System.out.println(daysBetweenTwoDates);
    }
}
