
import java.util.ArrayList;

public class Hand {
    enum State {
    ACTIVE, STOOD, BUSTED, DOUBLED, BLACKJACK;
    }

    private final ArrayList<Card> hand;
    private int handValue;
    private int countFullAces;
    private State state;

    public Hand() {
        hand = new ArrayList<>();
        countFullAces = 0;
        this.state = State.ACTIVE;
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
        for (Card card : hand) {
            if (card.getRank() == Rank.ACE) this.countFullAces++;
            this.handValue += card.getValue();
        }
        handleAceValue();
    }

    public int getHandValue() {return this.handValue;}

/*
    store the number of aces using .calculateHandValue()
    if handValue goes over 21 and has at least 1 ace then -10 value and -1 ace count
    TODO decide in the event of a split if the ace count should reset
    TODO or just delete the hand from the player and create 2 new hands
*/
    public void handleAceValue() {
        while (this.handValue > 21 && this.countFullAces > 0) {
            this.countFullAces--;
            this.handValue -= 10;
        }
    }

    public boolean isActive() {return this.state == State.ACTIVE;}
    public boolean isBusted() {return this.state == State.BUSTED;}
    public boolean isBlackjack() {return this.state == State.BLACKJACK;}

    public void updateState() {
        if (this.handValue > 21) this.state = State.BUSTED;
        if (this.handValue == 21 && this.hand.size() == 2) this.state = State.BLACKJACK;
    }
}
