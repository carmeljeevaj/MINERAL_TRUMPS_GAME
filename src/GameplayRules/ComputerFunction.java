package GameplayRules;

import Cards.Card;
import Cards.PlayCard;
import Cards.TrumpCard;

import java.util.Random;

public class ComputerFunction {
    public Card chooseCard(Card currentCard, String currentCat, Players.Player currentPlayer) {
        if (currentCard == null){
            for (Card card : currentPlayer.hand){
                if (card instanceof PlayCard){
                    return card;
                }
            }
        }
        for (Card card : currentPlayer.hand) {
            if (card instanceof PlayCard && currentCard instanceof PlayCard){
                if(card.CompareValue((PlayCard) currentCard, currentCat)){
                    return card;
                }

            }
            else
            if (currentCard instanceof TrumpCard && card instanceof PlayCard){
                return card;
            }

        }
        for (Card card : currentPlayer.hand){
            if (card instanceof TrumpCard){
                return card;
            }
        }
        if(currentCard == null){
            System.out.println(currentPlayer.hand.size());
            throw new NullPointerException("Current card is null :(");
        }
        return currentCard;
    }

    public String choose_Category(String categories){
        String[] select_Categories =  categories.split(", ");
        return select_Categories[new Random().nextInt(select_Categories.length)];
    }

}
