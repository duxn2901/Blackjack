/* 
    attributes
        String rank
        String suit
        int value
        boolean isAce

    toString()

*/

public class Card {
    private String rank;
    private String suit;
    private int value;
    private boolean isAce = false;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
