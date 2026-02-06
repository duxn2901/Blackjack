/* 
    attributes
        String rank
        String suit
        int value
        boolean isAce

    toString()
    calculateValue()
    getValue()
    isAce()
    aceValue()
*/

public class Card {
    private String rank;
    private String suit;
    private int value;
    private boolean isAce = false;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.value = this.calculateValue();
        if (this.rank.equals("A")) this.isAce = true;
    }
        
    @Override
    public String toString() {
        return rank + " " + suit;
    }

    public final int calculateValue() {
        if (
            rank.equals("K") ||
            rank.equals("Q") ||
            rank.equals("J")
        ) return 10;

        if (rank.equals("A")) return 11;
        return Integer.parseInt(rank);
    }

    public int getValue() {
        return this.value;
    }

    public boolean isAce() {
        return this.isAce;
    }
}
