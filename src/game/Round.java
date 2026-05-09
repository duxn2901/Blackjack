package game;

import java.util.ArrayList;
import model.*;

public class Round {
    Deck deck;
    ArrayList<Player> players;
    Dealer dealer;

    public Round(Deck deck, ArrayList<Player> players, Dealer dealer) {
        this.deck = deck;
        this.players = players;
        this.dealer = dealer;
    }

    public void start() {
        dealInitial();  //deal 2 at the start of round to each hand for each player including dealer
        // handlePlayerTurn(); //handle turn logic for each player
        // handleDealerTurn(); //handle turn logic of dealer
        // checkResults(); //checking result after dealer turn
        System.out.println("Dealer's hand:"); //TODO delete
        System.out.println(dealer.hand.showHand());
        System.out.println();
        for (Player p : players) {
            for (Hand h : p.hands) {
                System.out.println(p + " " + h);
                System.out.println(h.showHand());
            }
        }
    }

    public void dealInitial() {
        for (Player p : players) {
            for (Hand h : p.hands) {
                System.out.println("Dealing cards to " +h);
                h.addCardToHand(deck.dealCard());
                h.addCardToHand(deck.dealCard());
            }
        }
        System.out.println("Dealing cards to dealer");
        dealer.hand.addCardToHand(deck.dealCard());
        dealer.hand.addCardToHand(deck.dealCard());
    }


}
