import java.util.Scanner;

public class _02_GenerateThreeLetterWords {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        char[] letter = scan.next().toCharArray();

        for (int a = 0; a < letter.length; a++) {
            for (int b = 0; b < letter.length; b++) {
                for (int c = 0; c < letter.length; c++) {
                    System.out.printf("%c%c%c ", letter[a], letter[b], letter[c]);
                }
            }
        }
    }
}
