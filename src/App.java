/*
    Gameflow:
        Start
        number of decks -> generate deck, shuffle
        number of players
        starting money

        Game loop
            bet amount
            deal cards to players and dealer
            calc hand value
            check for blackjacks -> return wins
            for each player
                while hand active
                    ask choice
                    proceed with choice
                        if hit -> deal 1 card
                        if stand -> update state = STOOD
                        if hand length == 2
                            allow double
                                deal 1 card, handle bet amount 1 more time, update state = DOUBLED 
                        if hand length == 2 and card 0 == card 1
                            allow split
                                init new hand, pop 1 card out for the new hand
                                deal new cards to 2 hands
                                continue

                    calc hand value
                    decide hand state
                        if bust
                            update state to BUSTED

            dealer flips, calc hand value, draws until at least 17 
                if bust -> return wins to all STOOD, DOUBLED hands
                else -> compare scores with all STOOD, DOUBLED hands -> return win/lost
            reset all players' hands
            reset dealer's hand
            return balance
*/

public class App {
    public static void main(String[] args) throws Exception {
        // Card newCard = new Card(Rank.QUEEN, Suit.HEARTS);
        // System.out.println(newCard);
        // System.out.println(newCard.getValue());
        // System.out.println(newCard.getisAce());
        Deck deck = new Deck();
        deck.generate(1);
        System.out.println(deck);
        // System.out.println(deck.getTopCard());
        // deck.addToTop(newCard);
        // System.out.println(deck.getTopCard());
        Hand hand = new Hand();
        hand.addCardToHand(deck.dealTopCard());
        hand.addCardToHand(deck.dealTopCard());
        System.out.println(hand);
        hand.updateHandValue(hand.calculateHandValue());
        System.out.println(hand.getHandValue());
    }
}
