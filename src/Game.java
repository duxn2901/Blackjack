
import java.util.ArrayList;

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

public class Game {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        System.out.println(game.deck);
        game.deal2CardsEach();
        
    }


    //attributes
    Deck deck;
    int numberOfDecks;

    Dealer dealer;

    ArrayList<Player> players;
    int numberOfPlayers;

    int handsPerPlayer;

    Game() {
        deck = new Deck();
        numberOfDecks = 1;  //customizeable
        deck.generate(numberOfDecks);
        deck.shuffle();

        players = new ArrayList<>();
        numberOfPlayers = 2; //customizeable
        for (int i = 0; i < numberOfPlayers; i++) players.add(new Player());    // create x players

        handsPerPlayer = 2; //customizeable
        //create x hands for each player
        for (Player player : players) {
            for (int i = 0; i < handsPerPlayer; i++) {
                player.hands.add(new Hand());
            }
        }
    }

    void dealCard(Hand hand) {
        hand.addCardToHand(deck.dealTopCard());
    }

    //deal 2 cards to each existing hand
    void deal2CardsEach() {
        for (Player p : this.players) {
            for (Hand h : p.hands) {
                this.dealCard(h);
                this.dealCard(h);
                h.calculateHandValue();
                System.out.println(h); //TODO remove
                System.out.println(h.getHandValue()); //TODO remove
            }
        }
    }
}
