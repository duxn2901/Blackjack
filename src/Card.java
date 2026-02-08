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
    private final Rank rank;
    private final Suit suit;
    private int value;
    private boolean isAce = false;
    private boolean isOpen = true;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.value = this.calculateValue();
        if (this.rank == Rank.ACE) this.isAce = true;
    }
        
    @Override
    public String toString() {
        if (isOpen) return rank.getAnnotation() + " " + suit.getSymbol();
        else return "??";
    }

    public final int calculateValue() {
        if (
            rank == Rank.KING ||
            rank == Rank.QUEEN ||
            rank == Rank.JACK
        ) return 10;

        if (isAce) return 1;
        
        return Integer.parseInt(rank.getAnnotation());
    }

    public int getValue() {
        return this.value;
    }

    public boolean getisAce() {
        return this.isAce;
    }

    public void setIsOpen(boolean state) {
        this.isOpen = state;
    }
}
