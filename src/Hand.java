
import java.util.ArrayList;

enum State {
    ACTIVE, STOOD, BUSTED, DOUBLED, BLACKJACK;
}

public class Hand {
    private final ArrayList<Card> hand;
    private int handValue;

    public Hand() {
        hand = new ArrayList<>();
    }

    @Override
    public String toString() {
        String handString = "";
        for (Card card : hand) handString += card + "\t";
        return handString;
    }

    public void resetHand() {hand.clear();}

    public void addCardToHand(Card card) {hand.add(card);}

    public int calculateHandValue() {
        int value = 0;
        for (Card card : hand) value += card.getValue();
        return value;
    }

    public void updateHandValue(int value) {this.handValue = value;}

    public int getHandValue() {return this.handValue;}
}
