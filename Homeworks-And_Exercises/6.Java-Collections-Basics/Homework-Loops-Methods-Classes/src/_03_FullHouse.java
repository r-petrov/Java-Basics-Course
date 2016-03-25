public class _03_FullHouse {
    public static void main(String[] args) {
        String[] suits = {"\u2660", "\u2665", "\u2666", "\u2663"};
        String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        int countOfSuits = suits.length;
        int countOfFullHouses = 0;
        for (int suit = 0; suit < countOfSuits; suit++) {
            for (int suitTwo = suit+1; suitTwo < countOfSuits; suitTwo++) {
                for (int suitThree = suitTwo+1; suitThree < countOfSuits; suitThree++) {
                    for (int secondSuit = 0; secondSuit < countOfSuits; secondSuit++) {
                        for (int secondSuitOne = secondSuit+1; secondSuitOne < countOfSuits; secondSuitOne++) {
                            for (int faceOne = 0; faceOne < faces.length; faceOne++) {
                                for (int faceTwo = 0; faceTwo < faces.length; faceTwo++) {
                                    if (faceOne!=faceTwo){
                                        String result = faces[faceOne] + suits[suit]+" " +
                                                faces[faceOne] +suits[suitTwo]+ " " +
                                                faces[faceOne] + suits[suitThree] + " " +
                                                faces[faceTwo] + suits[secondSuit] + " " +
                                                faces[faceTwo] +suits[secondSuitOne];
                                        System.out.println(result);
                                        countOfFullHouses++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(countOfFullHouses);
    }
}
