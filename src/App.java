

public class App {
    public static void main(String[] args) throws Exception {
        Card newCard = new Card(Rank.QUEEN, Suit.HEARTS);
        // System.out.println(newCard);
        // System.out.println(newCard.getValue());
        // System.out.println(newCard.getisAce());
        Deck deck = new Deck();
        deck.generate(2);
        System.out.println(deck.getDeck());
        System.out.println(deck.getTopCard());
        deck.addToTop(newCard);
        System.out.println(deck.getTopCard());
    }
}
