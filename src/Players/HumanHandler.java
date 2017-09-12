package Players;
import Cards.Card;
import Cards.PlayCard;
import Cards.TrumpCard;
import java.util.InputMismatchException;
import java.util.Scanner;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */
public class HumanHandler {

    public String getCategory(String categories) {
        System.out.println("\n Choose a Category to play: \n");
        String[] tempCategorys = categories.split(", ");
        //handles if there is only 1 category passed in.
        if (tempCategorys.length == 1) {
            return tempCategorys[0];
        }
        for (int i = 0; i < tempCategorys.length; i++) {
            System.out.println(i + " : " + tempCategorys[i]);
        }
        int userInput = -1;
        while (userInput < 0 || userInput > tempCategorys.length - 1) {
            try {
                System.out.println("\nEnter Your choice: ");
                userInput = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please Enter Valid Number Input");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("There is no Category at: " + userInput);
            }
        }
        return tempCategorys[userInput];
    }

    public Card getCard(Card currentCard, String currentCategory, Players.Player currentPlayer) {
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
                userInput = new Scanner(System.in).nextInt();

                if (userInput == currentPlayer.hand.size()) {
                    return currentCard;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please Enter Valid Number Input");
            }
            if (userInput > 0 && userInput < currentPlayer.hand.size()) {
                if (currentCard instanceof PlayCard && !currentPlayer.hand.get(userInput).CompareValue((PlayCard) currentCard, currentCategory)) {
                    System.out.println(currentPlayer.hand.get(userInput).title + " is not higher than " + currentCard.title);
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
}
