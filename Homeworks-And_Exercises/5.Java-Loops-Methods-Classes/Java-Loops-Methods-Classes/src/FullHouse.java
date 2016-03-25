
public class FullHouse {

	public static void main(String[] args) {
		
		String[] face = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        char[] suit = {'\u2660', '\u2665', '\u2666', '\u2663'};
        int count = 0;

        for (int i = 0; i < face.length; i++) {
            for (int j = 0; j < face.length; j++) {
                for (int l1 = 0; l1 < suit.length; l1++) {
                    for (int l2 = l1 + 1; l2 < suit.length; l2++) {
                        for (int l3 = l2 + 1; l3 < suit.length; l3++) {
                            for (int r1 = 0; r1 < suit.length; r1++) {
                                for (int r2 = r1 + 1; r2 < suit.length; r2++) {
                                    if (i != j) {
                                        System.out.printf("(%s%c%s%c%s%c%s%c%s%c) ", face[i], suit[l1],
                                                face[i], suit[l2], face[i], suit[l3],
                                                face[j], suit[r1], face[j], suit[r2]);
                                        count++;
                                        System.out.println();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        System.out.println(count + " full houses");
	}

}
