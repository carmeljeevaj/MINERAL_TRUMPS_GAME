package GameplayRules;

import Cards.Card;
import Cards.CardDeck;
import Cards.TrumpCard;
import Players.HumanHandler;
import Players.Player;

import java.util.ArrayList;
import java.util.Collections;

public class GameRound {

    private final ArrayList<Player> players;
    private final ArrayList<Player> playersWhoWon;
    private Player currentPlayer;
    private final ArrayList<Player> playersNotYetWon;
    private final CardDeck deck;
    private final String currentCategory;
    private final RoundFinishedType roundFinishedType;

    public GameRound(ArrayList<Player> players, CardDeck deck, ArrayList<Player> playersNotYetWon, ArrayList<Player> playersWhoWon, RoundFinished roundFinished) {
        this.playersNotYetWon = playersNotYetWon;
        this.playersWhoWon = playersWhoWon;
        this.players = players;
        this.currentPlayer = roundFinished.getPlayer();
        this.currentCategory = roundFinished.getCategory();
        this.roundFinishedType = roundFinished.getRoundFinishType();
        this.deck = deck;
    }

    public RoundFinished beginRound() {
        System.out.println("**************************************************");
        System.out.println("<<<<<<<<<<<<<< NEW ROUND COMMENCING >>>>>>>>>>>>>>");
        System.out.println("**************************************************");
        sleep();
        Card currentCard = null;
        if(roundFinishedType.equals(RoundFinishedType.STANDARD)){
            currentCard = findPickCard(currentPlayer, currentCategory, currentCard);
            System.out.println("Player No :"+currentPlayer.position + " played the card: " + currentCard.toString());
            sleep();
            currentPlayer.hand.remove(currentCard);
            PlayerWinCheck(currentPlayer);
        }
        //Handles current player cycle
        Collections.rotate(players, players.indexOf(currentPlayer) * -1);
        Collections.rotate(players, - 1);

        // Round Handler
        while (players.size() > 1){
            currentPlayer = players.get(0);
            Card oldCard = currentCard;
            currentCard = findPickCard(currentPlayer, currentCategory, currentCard);
            if(oldCard == null && currentCard == null || oldCard!= null && currentCard.equals(oldCard)){
                System.out.println("Player No: "+currentPlayer.position + " passed his turn and is removed from the round");
                sleep();
                players.remove(currentPlayer);
                //Checks if the deck is empty upon drawing.

                if(deck.count() > 0)
                    currentPlayer.hand.add(deck.takeCard());
                else
                    System.out.println("Deck is empty!");

            } else if(currentCard instanceof TrumpCard){
                System.out.println("Player: " + currentPlayer.position + " played the trump card: " + currentCard.toString());
                sleep();
                currentPlayer.hand.remove(currentCard);
                PlayerWinCheck(currentPlayer);
                Collections.rotate(players, -1);
                return new RoundFinished(findCategory(currentPlayer, ((TrumpCard) currentCard).categories), currentPlayer, RoundFinishedType.TRUMPCARD);
            } else {
                System.out.println("Player: " + currentPlayer.position + " played the card: " + currentCard.toString());
                sleep();
                currentPlayer.hand.remove(currentCard);
                PlayerWinCheck(currentPlayer);
                Collections.rotate(players, -1);
            }
        }
        return new RoundFinished(findCategory(players.get(0), "Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity"), players.get(0), RoundFinishedType.STANDARD);
    }

    public static class RoundFinished {
        private final String category;
        private final Player player;
        private final RoundFinishedType roundFinishType;

        public RoundFinished(String category, Player player, RoundFinishedType roundFinishType) {
            this.category = category;
            this.player = player;
            this.roundFinishType = roundFinishType;
        }

        public String getCategory() {
            return category;
        }

        public Player getPlayer() {
            return player;
        }

        public RoundFinishedType getRoundFinishType() {
            return roundFinishType;
        }
    }

    public enum RoundFinishedType {
        STANDARD,
        TRUMPCARD
    }

    private void PlayerWinCheck(Player currentPlayer) {
        if(currentPlayer.hand.size() == 0){
            System.out.println("Player: " + currentPlayer.position + " WON!");
            playersNotYetWon.remove(currentPlayer);
            playersWhoWon.add(currentPlayer);
            players.remove(currentPlayer);
        }
    }

    public Card findPickCard(Player currentPlayer, String currentCat, Card currentCard){
        if (currentPlayer.getPlayerType() == Player.PlayerType.HUMAN){
            currentCard = new HumanHandler().getCard(currentCard,currentCat,currentPlayer);
        }
        else
        if (currentPlayer.getPlayerType() == Player.PlayerType.COMPUTER){
            currentCard = new ComputerFunction().chooseCard(currentCard, currentCat,currentPlayer);
        }
        return currentCard;
    }
    public static String findCategory(Player currentPlayer, String categories){
        String currentCategory = null;
        if (currentPlayer.getPlayerType() == Player.PlayerType.HUMAN){
            currentCategory = new HumanHandler().getCategory(categories);
            System.out.println("You have chosen: "+ currentCategory + " as Current Category.");

        }
        else
        if (currentPlayer.getPlayerType() == Player.PlayerType.COMPUTER) {
            currentCategory = new ComputerFunction().choose_Category(categories);
            System.out.println("\nPlayer: " + currentPlayer + " Has Chosen the Category:  " + currentCategory);
        }
        return currentCategory;

    }
    public void sleep(){
        try {
            Thread.sleep(550);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
