package Cards;

public class TrumpCard extends Cards.Card {
    public String subtitle;
    public String categories;

    public TrumpCard(String fileName, String imageName, String title, String subtitle, String categories) {
        super(fileName, imageName, title);
        this.subtitle = subtitle;
        this.categories = categories;
    }
    public String toString() {

        return ("\n $$$$$$$$$$* TRUMP CARD *$$$$$$$$$$$ \n" +"--------Title: "+ title +"\n\n--------Ability to Change category to: " + categories+"\n\n<<<<<<< **************** >>>>>>>\n");
    }

    @Override
    public boolean CompareValue(Cards.PlayCard card, String category) {
        return true;
    }
}
