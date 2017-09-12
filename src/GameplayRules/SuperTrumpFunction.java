


package GameplayRules;

import Cards.Card;
import Cards.CardDeck;
import Players.Computer;
import Players.Human;
import Players.Player;

import java.util.ArrayList;
import java.util.Random;


/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */

public class SuperTrumpFunction {
    private static final int CARDS_TO_DEAL = 8 ; //Number of cards to be dealt for each player.
    private int number_of_players;
    private Player[] players;
    private CardDeck deck;
    private int yourPlayerId;
    private int randomDealer;  // random dealer is notified to deal.
    private int startingPlay;

    public SuperTrumpFunction(int number_of_players) {
        deck = new CardDeck();
        this.number_of_players = number_of_players;
        System.out.println("Starting new game with " + number_of_players +" players.\n");
        selectDealer();
        new CardDeck();
        dealRandomCards();


        selecting_Player();
        Player human_player_one = getHumanPlayer();
        showPlayer(human_player_one);

        //Handles Round Winners and Overall Game winners
        Player startingPlayer = players[new Random().nextInt(players.length)];
        ArrayList<Player> playersNotYetWon = arrayToList(players);
        ArrayList<Player> playersWon = new ArrayList<>();
        GameRound.RoundFinished roundFin = new GameRound.RoundFinished(GameRound.findCategory(startingPlayer, "Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity"), startingPlayer, GameRound.RoundFinishedType.STANDARD);
        while(playersNotYetWon.size() > 1){
            roundFin =  new GameRound(arrayToList(playersNotYetWon.toArray(new Player[playersNotYetWon.size()])) , deck, playersNotYetWon, playersWon,roundFin).beginRound();
        }
        for(Player player: playersWon){
            System.out.println((playersWon.indexOf(player) +1) + "Place : Player " + player.position);
        }

    }


    private void showPlayer(Player humanplayerl) {
        System.out.println("You are Player "+ humanplayerl +"\n");
    }

    private Player getHumanPlayer() {
        return players[yourPlayerId];
    }

    private void selecting_Player() {
        yourPlayerId = 0;
    }

    public void selectDealer() {
        Random random = new Random();
        randomDealer = random.nextInt(number_of_players)+1;
        startingPlay = randomDealer+1;
        System.out.println("Player: " + randomDealer + " is the dealer"+ "\n");

    }
    // Method to deal random cards
    public void dealRandomCards() {
        players = new Player[number_of_players];

        for (int i = 0; i < number_of_players; i++){
            players[i] = new Computer(i);

        }
        players[0] = new Human(0);

        for (Player player: players) {
            ArrayList<Card> cards = deck.dealCards(CARDS_TO_DEAL);
            player.setCard(cards);
        }
    }
    // Converts to List to be handled by the GameRound Class
    public ArrayList<Player> arrayToList(Player[] players){
        ArrayList<Player> newArrayList = new ArrayList<Player>();
        for (Player superTrumpsBasePlayer:players){
            newArrayList.add(superTrumpsBasePlayer);
        }
        return newArrayList;
    }
}
