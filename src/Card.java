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
    private final int value;
    private final boolean isAce;
    private boolean isOpen = true;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
        this.isAce = this.rank == Rank.ACE;
        this.value = this.calculateCardValue();       
    }
        
    @Override
    public String toString() {
        if (isOpen) return rank.getAnnotation() + " " + suit.getSymbol();
        else return "??";
    }

    public final int calculateCardValue() {
        if (
            rank == Rank.KING ||
            rank == Rank.QUEEN ||
            rank == Rank.JACK
        ) return 10;

        if (isAce) return 11;
        
        return Integer.parseInt(rank.getAnnotation());
    }

    public int getValue() {
        return this.value;
    }

    public Rank getRank() {
        return this.rank;
    }

    public boolean getisAce() {
        return this.isAce;
    }

    public void setIsOpen(boolean state) {
        this.isOpen = state;
    }

}
