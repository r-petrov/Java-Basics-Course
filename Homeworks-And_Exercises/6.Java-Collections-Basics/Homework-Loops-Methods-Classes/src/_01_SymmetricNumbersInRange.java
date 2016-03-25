import java.util.Scanner;

public class _01_SymmetricNumbersInRange {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str=input.nextLine();
        String[] arr=str.split(" ");
        int start = Integer.parseInt(arr[0]);
        int end = Integer.parseInt(arr[1]);
        for (int i = start; i <= end; i++) {
            if (i<10 && i==11) {
                System.out.printf("%d ", i);
            }
            else if ((i>11 &&i<100) && (i%10==i/100)) {
                System.out.print(i+"");
            }
            else if((i>=100) && (i%10==i/100)) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
