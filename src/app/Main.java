package app;

import game.Game;
import java.util.ArrayList;
import model.*;

public class Main {
    public static void main(String args[]) {
        Deck deck = new Deck();
        deck.generate(1); //changeable
        deck.shuffle();

        Dealer dealer = new Dealer();

        ArrayList<Player> players = new ArrayList<>();
        for (int i = 1; i <= 3; i++) { //changeable
            players.add(new Player("Player "+i)); //changeable
        }

        for (Player p : players) {
            for (int i = 1; i <= 2; i++) {
                p.hands.add(new Hand(i));
            }
        }
        
        Game game = new Game(deck, players, dealer);
        game.start();
    }
}
