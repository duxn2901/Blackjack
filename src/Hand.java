
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

    public void calculateHandValue() {
        this.handValue = 0;
        for (Card card : hand) this.handValue += card.getValue();
        handleAceValue();
    }

    public int getHandValue() {return this.handValue;}

/*
    if handValue over 21 then check for the first Ace with full 11 value, set it to 1
    recheck value, break loop if value now less than or equal to 21
    if no 11-value-aces found then break loop
*/
    //TODO rework logic
    public void handleAceValue() {
        while (this.handValue > 21) {
            boolean foundFullAce = false;
            for (Card card : hand) {
                foundFullAce = false;
                if (card.getValue() == 11) {
                    card.setAceValueToOne();
                    calculateHandValue();
                    foundFullAce = true;
                    break;
                }    
            }
            if (!foundFullAce) break;
        }
    }
}
