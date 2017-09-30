package Cards;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */
public class PlayCard extends Card {
    public String chemistry;
    public String classification;
    public String crystalSystem;
    public String cleavage;
    public String crustal_Abundance;
    public String economic_Value;
    public String occurrence;
    public double low_hardness;
    public double high_hardness;
    public double low_Specific_Gravity;
    public double high_Specific_Gravity;


    public PlayCard(String fileName, String imageName, String title, String chemistry, String classification, String crystalSystem, String occurrence, double low_hardness, double high_hardness, double low_Specific_Gravity, double high_Specific_Gravity, String cleavage, String crustal_Abundance, String economic_Value) {
        super(fileName, imageName, title);
        this.chemistry = chemistry;
        this.classification = classification;
        this.crystalSystem = crystalSystem;
        this.occurrence = occurrence;
        this.low_hardness = low_hardness;
        this.high_hardness = high_hardness;
        this.low_Specific_Gravity = low_Specific_Gravity;
        this.high_Specific_Gravity = high_Specific_Gravity;
        this.cleavage = cleavage;
        this.crustal_Abundance = crustal_Abundance;
        this.economic_Value = economic_Value;


    }

    public String toString() {
        return ("\n <<<<<<< MINERAL CARD >>>>>> \n"+" --------Chemistry: " +chemistry + "\n--------Classification: " +classification + "\n--------Crystal System: "+ crystalSystem + "\n--------Occurrence: "+occurrence +"\n ================================" + "\n--------Hardness: " + high_hardness +"\n--------Specific Gravity: "+ high_Specific_Gravity +"\n--------Cleavage: "+cleavage+"\n--------Crustal Abundance: "+ crustal_Abundance +"\n--------Economic Value: "+ economic_Value +"\n <<<<<<< *********** >>>>>>>\n");
    }


    public int findingCleavage(){
        switch (cleavage){
            case "none":
                return 0;
            case "poor/none":
                return 1;
            case "1 poor":
                return 2;
            case "2 poor":
                return 3;
            case "1 good":
                return 4;
            case "1 good, 1 poor":
                return 5;
            case "2 good":
                return 6;
            case "3 good":
                return 7;
            case "1 perfect":
                return 8;
            case "1 perfect, 1 good":
                return 9;
            case "1 perfect, 2 good":
                return 10;
            case "2 perfect, 1 good":
                return 11;
            case "3 perfect":
                return 12;
            case "4 perfect":
                return 13;
            case "6 perfect":
                return 14;
            default:
                throw new NullPointerException("Cleavage Value is not found");

        }

    }

    public boolean CompareValue(PlayCard card, String category){
        switch (category){
            case "Hardness":
                return this.high_hardness > card.high_hardness;
            case "Specific gravity":
                return  this.high_Specific_Gravity > card.high_Specific_Gravity;
            case "Cleavage":
                return this.findingCleavage() > card.findingCleavage();
            case "Crustal abundance":
                return this.findingCrustalAbundance() > card.findingCrustalAbundance();
            case "Economic value":
                return  this.findingEconomicValue() > card.findingEconomicValue();
            default:
                throw new  NullPointerException("The category:  " + category+" doesn't exist!!!");
        }
    }
    public int findingCrustalAbundance(){
        switch (crustal_Abundance){
            case "ultratrace":
                return 0;
            case "trace":
                return 1;
            case "low":
                return 2;
            case "moderate":
                return 3;
            case "high":
                return 4;
            case "very high":
                return 5;
            default:
                throw new NullPointerException("CrustalAbundance getValue is not found");
        }
    }
    public int findingEconomicValue(){
        switch (economic_Value){
            case "trivial":
                return 0;
            case "low":
                return 1;
            case "moderate":
                return 2;
            case "high":
                return 3;
            case "very high":
                return 4;
            case "I'm rich!":
                return 5;
            default:
                throw new NullPointerException("EconomicValue getValue is not found");
        }
    }
}



