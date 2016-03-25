import java.util.Scanner;


public class _05_AngleUnitConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String degrees = "";
        String m = "";

        for (int i = 0; i <= n; i++) {
            degrees = input.nextLine();
            degrees = degrees.replaceAll("\\s+", "");
            m = degrees.replaceAll("\\d+", "");
            m = m.replace(".", "");
            degrees = degrees.replaceAll("[^0-9.,]+", "");

            if (m.equals("deg")) {
                System.out.format("%.6f rad%n",Double.parseDouble(degrees));
            } else if (m.equals("rad")) {
                System.out.format("%.6f deg%n", Double.parseDouble(degrees));
            }
        }
    }
}
