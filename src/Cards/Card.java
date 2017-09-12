package Cards;

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

    public abstract boolean CompareValue(Cards.PlayCard card, String category);
}
