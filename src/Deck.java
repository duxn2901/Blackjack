
import java.util.ArrayList;
import java.util.Collections;

/*
    Deck : Deque Stack
        generate()
            nested loop for each enums Rank, Suit
        printDeck()
        addToTop(Card)
            deque.push()
        dealCard(Hand)
            deque.pop()
        getTopCard()
            deque.peek()
            
*/

public class Deck {
    private final ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<>();
    }

    @Override
    public String toString() {
        String deckString = "";
        for (Card card : deck) deckString += (card + "\t");
        return deckString;
    }

    public void generate(int numberOfDecks) {
        for (int i = 0; i < numberOfDecks; i++) {
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    this.deck.add(new Card(rank, suit));
                }
            }
        }
    }

    public void shuffle() {Collections.shuffle(this.deck);}

    public void addToTop(Card card) {deck.add(card);}

    public Card getTopCard() {return deck.get(deck.size()-1);}

    public Card dealTopCard() {
        Card card = getTopCard();
        this.deck.remove(deck.size()-1);
        return card;
    }
}
