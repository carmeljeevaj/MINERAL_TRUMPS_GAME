package Cards;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */

public class TrumpCard extends Card {
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
    public boolean CompareValue(PlayCard card, String category) {
        return true;
    }
}
