package Players;


public class Computer extends Players.Player {
    public PlayerType getPlayerType() {
        return PlayerType.COMPUTER;
    }

    public Computer(int position) {
        super(position);
    }
}
