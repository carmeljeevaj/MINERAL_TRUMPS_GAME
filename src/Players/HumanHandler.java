package Players;
import Cards.Card;
import Cards.PlayCard;
import Cards.TrumpCard;
import GUI.GameFunction;

import java.util.InputMismatchException;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */
public class HumanHandler {
    private boolean wasInputEntered = false;
    private String categoryWasSelected = "";
    private int cardWasSelected;
    public static HumanHandler humanHandler;

    public HumanHandler(){
        humanHandler = this;
    }

    public String getCategory(String categories) {
        //System.out.println("\n Choose a Category to play: \n");
        String[] tempCategorys = categories.split(", ");
        //handles if there is only 1 category passed in.
        if (tempCategorys.length == 1) {
            return tempCategorys[0];
        }
        for (int i = 0; i < tempCategorys.length; i++) {
            System.out.println(i + " : " + tempCategorys[i]);
        }
        //int userInput = -1;
        GameFunction.gameFunction.displayCatChoice();
        while (!wasInputEntered){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                }
            }
            wasInputEntered = false;
            GameFunction.gameFunction.hideCatChoice();
        return categoryWasSelected;
        //return localCats[userInput];
    }

    public Card getCard(Card currentCard, String currentCategory, Player currentPlayer) {
        GameFunction.gameFunction.handGUIGenerator(currentPlayer.hand);
        System.out.println("\nChoose A Card: \n");

        //handles if there is only 1 category passed in.
        for (int i = 0; i < currentPlayer.hand.size(); i++) {
            System.out.println(i + " : " + currentPlayer.hand.get(i).toString());
        }
        System.out.println(currentPlayer.hand.size() + " : Pass Turn");
        int userInput = -1;
        while (userInput < 0 || userInput > currentPlayer.hand.size()) {
            try {
                System.out.println("Enter Your choice: ");
                //userInput = new Scanner(System.in).nextInt();
                while (!wasInputEntered) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                    userInput = cardWasSelected;
                    wasInputEntered = false;

                    if (userInput == currentPlayer.hand.size()) {
                        return currentCard;
                    }


            }catch (InputMismatchException e) {
                System.out.println("Please Enter Valid Number Input");
            }
            if (userInput > 0 && userInput < currentPlayer.hand.size()) {
                if (currentCard instanceof PlayCard && !currentPlayer.hand.get(userInput).CompareValue((PlayCard) currentCard, currentCategory)) {
                    System.out.println(currentPlayer.hand.get(userInput).title + " is not higher than " + currentCard.title);
                    GameFunction.gameFunction.changeStatus("Card You Selected, Is not better than the current card.");
                    userInput = -1;
                } else if (currentCard instanceof TrumpCard) {
                    return currentPlayer.hand.get(userInput);
                }
            } else {
                System.out.println("Please choose a valid option"); // handler, if user inputs greater than List.
            }
        }

        return currentPlayer.hand.get(userInput);// returns the hand with userinput

}
    public void categoryNotifier(String category){
        categoryWasSelected = category;
        wasInputEntered = true;
    }
    public void cardNotifier(int selectedCard){
        cardWasSelected = selectedCard;
        wasInputEntered = true;
    }
}
