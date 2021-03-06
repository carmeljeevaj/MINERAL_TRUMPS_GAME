package Players;

import Cards.Card;

import java.util.ArrayList;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */
public abstract class Player {
    public int position;
    public ArrayList<Card> hand;
    public abstract PlayerType getPlayerType();


    public Player(int position){
        this.position = position;
    }
    public String toString() {
        return String.valueOf((position));
    }

    public void setCard(ArrayList<Card> cards) {
        hand = cards;
    }

    public enum PlayerType{
        COMPUTER,
        HUMAN,
    }
}
