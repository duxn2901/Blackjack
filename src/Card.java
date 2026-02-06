/* 
    attributes
        String rank
        String suit
        int value
        boolean isAce
        boolean isOpen

    toString()
    calculateValue()
    getValue()
    isAce()
    aceValue()**
    setisOpen()
*/

public class Card {
    private String rank;
    private String suit;
    private int value;
    private boolean isAce = false;
    private boolean isOpen = true;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.value = this.calculateValue();
        if (this.rank.equals("A")) this.isAce = true;
    }
        
    @Override
    public String toString() {
        if (isOpen) return rank + suit;
        else return "??";
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

    public void setIsOpen(boolean state) {
        this.isOpen = state;
    }
}
