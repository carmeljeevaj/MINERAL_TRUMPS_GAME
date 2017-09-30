package Players;
import Cards.Card;
import Cards.PlayCard;
import Cards.TrumpCard;

import java.util.Random;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */
public class ComputerTr {
    // This is going to be basic bots, they just find what can be played, not much additional AI :P
    public Card chooseCard(Card currentCard, String currentCat, Player currentPlayer) {
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

    public String chooseCategory(String categories){
        String[] selectCat =  categories.split(", ");
        return selectCat[new Random().nextInt(selectCat.length)];
    }
}
