
import java.util.ArrayDeque;
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
    private final ArrayDeque<Card> deck;

    public Deck() {
        deck = new ArrayDeque<>();
    }

    public String getDeck() {
        String deckString = "";
        for (Card card : deck) deckString += (card + "\t");
        return deckString;
    }

    public void generate(int numberOfDecks) {
        ArrayList<Card> tempDeck = new ArrayList<>();
        for (int i = 0; i < numberOfDecks; i++) {
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    tempDeck.add(new Card(rank, suit));
                }
            }
        }
        Collections.shuffle(tempDeck);
        for (Card card : tempDeck) deck.push(card);
    }

    public void addToTop(Card card) {deck.push(card);}

    public Card getTopCard() {return deck.peek();}
}
