
import java.util.ArrayList;

public class Hand {
    private final ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public String getHand() {
        String handString = "";
        for (Card card : hand) handString += card + "\t";
        return handString;
    }

}
