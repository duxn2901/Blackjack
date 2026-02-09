
import java.util.ArrayDeque;

/*
    Deck : Deque Stack
        generate()
            nested loop for each enums Rank, Suit
        printDeck()
        shuffle()
        addToTop(Card)
            deque.push()
        dealCard(Hand)
            deque.pop()
        getTopCard()
            deque.peek()
            
*/

public class Deck {
    ArrayDeque<Card> deck;

    public Deck() {
        deck = new ArrayDeque<>();
    }

    public void printDeck() {
        for (Card card : deck) System.out.print(card + "\t");
    }

    public void generate(int numberOfDecks) {
        for (int i = 0; i < numberOfDecks; i++) {
            for (Rank rank : Rank.values()) {
                for (Suit suit : Suit.values()) {
                    deck.push(new Card(rank, suit));
                }
            }
        }
    }
}
