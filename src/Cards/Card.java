package Cards;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */

public abstract class Card {

    public String fileName;
    public String imageName;
    public String title;



    public Card(String fileName, String imageName, String title) {
        this.fileName = fileName;
        this.imageName = imageName;
        this.title = title;

    }

    public String toString() {
        return(fileName + " " + imageName + " " + title);
    }

    public abstract boolean CompareValue(PlayCard card, String category);
}
