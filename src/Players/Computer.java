package Players;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */
public class Computer extends Players.Player {
    public PlayerType getPlayerType() {
        return PlayerType.COMPUTER;
    }

    public Computer(int position) {
        super(position);
    }
}
