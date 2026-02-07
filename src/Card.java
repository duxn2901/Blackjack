/* 
    attributes
        String rank
        Suit suit
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
    private String rankA;
    private Suit suit;
    private int value;
    private boolean isAce = false;
    private boolean isOpen = true;

    public Card(String rankA, Suit suit) {
        this.rankA = rankA;
        this.suit = suit;
        this.value = this.calculateValue();
        if (this.rankA.equals("A")) this.isAce = true;
    }
        
    @Override
    public String toString() {
        if (isOpen) return rankA + " " + suit.getSymbol();
        else return "??";
    }

    public final int calculateValue() {
        if (
            rankA.equals("K") ||
            rankA.equals("Q") ||
            rankA.equals("J")
        ) return 10;

        if (rankA.equals("A")) return 11;
        return Integer.parseInt(rankA);
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
