package game;

import java.util.ArrayList;
import model.*;
/*
    Gameflow:
        Game loop:
            Start
            number of decks -> generate deck, shuffle
            number of players
            starting money

            Round loop
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
    Deck deck;
    ArrayList<Player> players;
    Dealer dealer;
    boolean isContinue = true;


    public Game(Deck deck, ArrayList<Player> players, Dealer dealer) {
        this.deck = deck;
        this.players = players;
        this.dealer = dealer;
    }

    public void start() {
        while (isContinue) {
            Round round = new Round(deck, players, dealer);
            round.start();
            isContinue = false; //TODO delete
        }
    }
}

