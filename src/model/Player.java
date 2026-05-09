package model;
import java.util.ArrayList;

public class Player {
    ArrayList<Hand> hands;
    String name;

    public Player(String name) {
        hands = new ArrayList<>();
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
