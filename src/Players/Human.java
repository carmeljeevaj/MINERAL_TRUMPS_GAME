package Players;
/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */

public class Human extends Player {

    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }

    public Human(int position) {
        super(position);
    }
}

