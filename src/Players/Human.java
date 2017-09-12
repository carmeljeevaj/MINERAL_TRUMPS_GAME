package Players;


public class Human extends Players.Player {

    public PlayerType getPlayerType() {
        return PlayerType.HUMAN;
    }

    public Human(int position) {
        super(position);
    }
}

