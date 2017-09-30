package Application;
/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */
import GameplayRules.SuperTrumpFunction;


import java.util.*;

public class TrumpsGameInitialize {

    public static void main(String[] args) {
        display_Welcome_message();
        while (true) {
            displayMenu();
            int userMenuInput = getUserMenuInput();
            while (userMenuInput != 1 && userMenuInput != 2 && userMenuInput != 3) {
                System.out.println("Invalid Input");
                displayMenu();
                userMenuInput = getUserMenuInput();
            }
            switch (userMenuInput) {
                case 1:
                    startNewGame();
                    break;
                case 2:
                    displayGameDetails();
                    break;
                case 3:
                    System.out.println("Goodbye!!!");
                    System.exit(1); // Exit game
                    break;
            }
        }
    }

    private static void displayGameDetails() {
        System.out.println("\n************************************* ABOUT MINERAL SUPERTRUMP CARD GAME********************************************** ");
        System.out.println("This is a game designed by to help players learn about the properties\n" +
                "and uses of economically-significant and common rock-forming minerals.\n\n" +
                "The deck consists of 54 mineral cards and 6 'SUPERTRUMP' cards.\n\n" +
                "Each mineral card includes information about the mineral such as the generic chemical formula,\n" +
                "the classification, crystal system, the geological environment where the mineral is\n" +
                "commonly found or formed (igneous, metamorphic, sedimentary, or the mantle), as well as information in the\n" +
                "five playing categories (or trumps) of Hardness, Specific Gravity, Cleavage, Crustal Abundance, and Economic Value.\n" +
                "The first three trump categories relate to distinct physical properties of the mineral,\n" +
                "while last two categories rate the importance of the mineral in terms of abundance in the\n" +
                "Earths crust (continental and oceanic) and value to modern societies.\n" +
                "\n" +
                "Number of players: 3 to 5\n" +
                "\n\n" +
                "Objective: To be the first player to lose all of your cards");

        System.out.println("\n********************************************************************************************************************\n ");

    }



    private static void startNewGame() {
        int No_of_Players = getTotalPlayers();
        while (No_of_Players != 3 && No_of_Players != 4 && No_of_Players != 5) {
            System.out.println("The number of players must be valid.");
            No_of_Players = getTotalPlayers();
        }
       //    SuperTrumpFunction new_game = new SuperTrumpFunction(No_of_Players);

    }

    private static int getTotalPlayers() {
        System.out.println("Enter the number of players(3-5): ");
        int userInput = 0;
        try {
            userInput = getUserMenuInput();
        }
        catch (InputMismatchException e) {
            System.out.println("That is not a number.");
        }
        return userInput;
    }

    private static int getUserMenuInput() {
        Scanner reader = new Scanner(System.in);
        int userInput = 0;
        try {
            userInput = reader.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("That is not a number.");
        }
        return userInput;
    }

    private static void displayMenu() {
        System.out.println("Please select an option below: \n (1) - Play Game \n (2) - Information \n (3) - Run away from Game");
    }

    private static void display_Welcome_message() {
        System.out.println("***** Welcome to Mineral SuperTrumps Game *****\n");
    }
}
