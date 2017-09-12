package Cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*

Mineral SuperTrumps Card Game by 13422239 (CARMELJEEVA JOHNJEYASEELAN);

 */

public class CardDeck {
    private ArrayList<Card> cards;

    public CardDeck() {
        cards = new ArrayList<>();
        // Mineral Cards Initialization
        cards.add(new Cards.PlayCard("Slide01.jpg", "Slide01", "Quartz", "SiO_2", "tectosilicate", "hexagonal", "igneous, metamorphic, sedimentary", 7.00, 7.00, 2.65, 2.65, "poor/none", "high", "moderate"));
        cards.add(new Cards.PlayCard("Slide02.jpg", "Slide02", "Plagioclase", "Na Al Si_3 O_8 - Ca Al_2 Si_2 O_8", "tectosilicate", "triclinic", "igneous, metamorphic, sedimentary", 6, 6.5, 2.6, 2.8, "1 perfect, 1 good", "very high", "moderate"));
        cards.add(new Cards.PlayCard("Slide03.jpg", "Slide03", "Orthoclase", "K Al Si_3 O_3", "tectosilicate", "monoclinic", "igneous, metamorphic, sedimentary", 6, 6.5, 2.5, 2.6, "1 perfect, 1 good", "high", "moderate"));
        cards.add(new Cards.PlayCard("Slide04.jpg", "Slide04", "Biotite", "K(Fe, Mg)_3 Al Si_3 O_10 (OH)_2 ", "phyllosilicate", "monoclinic", "igneous,metamorphic", 2.5, 3, 2.7, 3.3, "1 perfect", "moderate", "low"));
        cards.add(new Cards.PlayCard("Slide05.jpg", "Slide05", "Muscovite", "K Al_3 Si_3 O_10 (O H)_2", "phyllosilicate", "monoclinic", "igneous,metamorphic", 2.5, 3, 2.8, 2.9, "1 perfect", "moderate", "moderate"));
        cards.add(new Cards.PlayCard("Slide06.jpg", "Slide06", "Hornblende", "Ca_2 (Mg, Fe)_4 Al_2 Si_7 O_22 (OH)_2", "inosilicate", "monoclinic", "igneous, metamorphic", 5, 6, 3.0, 3.5, "2 good", "moderate", "trivial"));
        cards.add(new Cards.PlayCard("Slide07.jpg", "Slide07", "Actinolite", "Ca_2 (Mg, Fe)_5 Si_8 O_22 (OH)_2", "inosilicate", "monoclinic", "metamorphic", 5, 6, 3.0, 3.5, "2 good", "low", "low"));
        cards.add(new Cards.PlayCard("Slide08.jpg", "Slide08", "Glaucophane", "Na_2 (Mg, Fe)_3 Al_2 Si_8 O_22 (OH)_2 ", "inosilicate", "monoclinic", "metamorphic", 6, 6, 3.0, 3.2, "2 good", "low", "trivial"));
        cards.add(new Cards.PlayCard("Slide09.jpg", "Slide09", "Olivine", "(Mg, Fe)_2 Si O_4", "nesosilicate", "orthorhombic", "igneous, metamorphic, mantle", 6.5, 7, 3.2, 4.4, "2 poor", "high", "low"));
        cards.add(new Cards.PlayCard("Slide10.jpg", "Slide10", "Garnet", "(Fe, Mg, Ca, Mn)_3 (Al, Fe)_2 Si_3 O_12", "nesosilicate", "isometric", "igneous, metamorphic, mantle", 6, 7.5, 3.5, 4.3, "none", "moderate", "moderate"));
        cards.add(new Cards.PlayCard("Slide11.jpg", "Slide11", "Titanite", "Ca Ti Si O_5", "nesosilicate", "monoclinic", "igneous,metamorphic", 5, 5.5, 3.4, 3.6, "3 good", "low", "low"));
        cards.add(new Cards.PlayCard("Slide12.jpg", "Slide12", "Zircon", "Zr Si O_4", "nesosilicate", "tetragonal", "igneous,metamorphic,sedimentary", 7.5, 7.5, 4.6, 4.7, "2 poor", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide13.jpg", "Slide13", "Augite", "Ca (Mg, Fe) Si_2 O_6 ", "inosilicate", "monoclinic", "igneous,metamorphic", 5.5, 6.5, 3.2, 3.6, "2 good", "high", "trivial"));
        cards.add(new Cards.PlayCard("Slide14.jpg", "Slide14", "Orthopyroxene", "(Mg, Fe)_2 Si_2 O_6 ", "inosilicate", "orthorhombic", "igneous,metamorphic, mantle", 5, 6, 3.2, 3.9, "2 good", "high", "trivial"));
        cards.add(new Cards.PlayCard("Slide15.jpg", "Slide15", "Chlorite", "(Mg, Fe)_5 Al_2 Si_3 O_10 (OH)_8", "phyllosilicate", "monoclinic", "metamorphic", 2, 3, 2.6, 3.3, "1 perfect", "moderate", "low"));
        cards.add(new Cards.PlayCard("Slide16.jpg", "Slide16", "Antigorite", "(Mg, Fe)_3 Si_2 O_5 (OH)_4", "phyllosilicate", "monoclinic", "metamorphic, mantle", 3.5, 4, 2.6, 2.6, "1 perfect", "low", "low"));
        cards.add(new Cards.PlayCard("Slide17.jpg", "Slide17", "Talc", "Mg_3 Si_4 O_10 (OH)_2", "phyllosilicate", "monoclinic", "metamorphic", 1, 1, 2.6, 2.8, "1 perfect", "low", "moderate"));
        cards.add(new Cards.PlayCard("Slide18.jpg", "Slide18", "Kaolinite", "Al_2 Si_2 O_5 (OH)_4", "phyllosilicate", "triclinic", "sedimentary", 1.5, 2.5, 2.6, 2.7, "1 perfect", "moderate", "high"));
        cards.add(new Cards.PlayCard("Slide19.jpg", "Slide19", "Andalusite", "Al_2 Si O_5", "nesosilicate", "orthorhombic", "metamorphic", 6.5, 7, 3.15, 3.15, "2 good", "low", "moderate"));
        cards.add(new Cards.PlayCard("Slide20.jpg", "Slide20", "Kyanite", "Al_2 Si O_5", "nesosilicate", "triclinic", "metamorphic", 5.5, 7, 3.5, 3.7, "1 perfect, 1 good", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide21.jpg", "Slide21", "Sillimanite", "Al_2 Si O_5", "nesosilicate", "orthorhombic", "igneous, metamorphic", 6.5, 7.5, 3.25, 3.25, "1 perfect, 1 good", "low", "low"));
        cards.add(new Cards.PlayCard("Slide22.jpg", "Slide22", "Staurolite", "(Fe, Mg)_2 Al_9 Si_4 O_22 (OH)_2", "nesosilicate", "monoclinic", "metamorphic", 7, 7, 3.7, 3.8, "1 good", "trace", "low"));
        cards.add(new Cards.PlayCard("Slide23.jpg", "Slide23", "Epidote", "Ca_2 (Al, Fe)_3 Si_3 O_12 (OH)", "sorosilicate", "monoclinic", "igneous,metamorphic", 6, 6.5, 3.2, 3.5, "1 perfect", "moderate", "trivial"));
        cards.add(new Cards.PlayCard("Slide24.jpg", "Slide24", "Tourmaline", "Na (Mg, Fe)_3 Al_6 B_3 Si_6 O_27 (OH)_4", "cyclosilicate", "hexagonal", "metamorphic", 7, 7.5, 3.0, 3.2, "2 poor", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide25.jpg", "Slide25", "Topaz", "Al_2 Si O_4 (F, OH)_2", "nesosilicate", "orthorhombic", "metamorphic, sedimentary", 8, 8, 3.5, 3.6, "1 perfect", "ultratrace", "low"));
        cards.add(new Cards.PlayCard("Slide26.jpg", "Slide26", "Beryl", "Be_3 Al_2 Si_6 O_18", "cyclosilicate", "hexagonal", "igneous,metamorphic", 7.5, 8, 2.6, 2.9, "1 poor", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide27.jpg", "Slide27", "Pyrite", "Fe S_2", "sulfide", "isometric", "igneous,metamorphic", 6, 6.5, 5, 5, "2 poor", "low", "moderate"));
        cards.add(new Cards.PlayCard("Slide28.jpg", "Slide28", "Pyrrhotite", "Fe_{1-x} S", "sulfide", "monoclinic", "igneous, metamorphic", 3.5, 4.5, 4.6, 4.6, "none", "low", "moderate"));
        cards.add(new Cards.PlayCard("Slide29.jpg", "Slide29", "Chalcopyrite", "Cu Fe S_2", "sulfide", "tetragonal", "igneous,metamorphic", 3.5, 4, 4.1, 4.3, "2 poor", "low", "very high"));
        cards.add(new Cards.PlayCard("Slide30.jpg", "Slide30", "Galena", "Pb S", "sulfide", "isometric", "metamorphic", 2.5, 2.5, 7.5, 7.6, "3 perfect", "trace", "high"));
        cards.add(new Cards.PlayCard("Slide31.jpg", "Slide31", "Sphalerite", "(Zn, Fe) S", "sulfide", "isometric", "metamorphic", 3.5, 4, 3.9, 4.1, "6 perfect", "trace", "high"));
        cards.add(new Cards.PlayCard("Slide32.jpg", "Slide32", "Molybdenite", "Mo S_2", "sulfide", "hexagonal", "igneous,metamorphic", 1, 1.5, 4.7, 4.7, "1 perfect", "trace", "high"));
        cards.add(new Cards.PlayCard("Slide33.jpg", "Slide33", "Gold", "Au", "native element", "isometric", "metamorphic, sedimentary", 2.5, 3, 19.3, 19.3, "none", "ultratrace", "I'm rich!"));
        cards.add(new Cards.PlayCard("Slide34.jpg", "Slide34", "Diamond", "C", "native element", "isometric", "igneous,metamorphic,sedimentary", 10, 10, 3.5, 3.5, "4 perfect", "ultratrace", "I'm rich!"));
        cards.add(new Cards.PlayCard("Slide35.jpg", "Slide35", "Graphite", "C", "native element", "hexagonal", "metamorphic,sedimentary", 1, 2, 2.2, 2.2, "1 perfect", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide36.jpg", "Slide36", "Halite", "Na Cl", "halide", "isometric", "sedimentary", 2.5, 2.5, 2.2, 2.2, "3 perfect", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide37.jpg", "Slide37", "Fluorite", "Ca F_2", "halide", "isometric", "metamorphic", 4, 4, 3.2, 3.2, "4 perfect", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide38.jpg", "Slide38", "Gypsum", "Ca S O_4 (H_2 O)_2", "sulfate", "monoclinic", "metamorphic,sedimentary", 2, 2, 2.3, 2.3, "1 perfect, 2 good", "trace", "high"));
        cards.add(new Cards.PlayCard("Slide39.jpg", "Slide39", "Barite", "Ba S O_4", "sulfate", "orthorhombic", "metamorphic,sedimentary", 3, 3.5, 4.5, 4.5, "2 perfect, 1 good", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide40.jpg", "Slide40", "Apatite", "Ca_5 (P O_4)_3 (OH, F, Cl)", "phosphate", "hexagonal", "igneous,metamorphic,sedimentary", 5, 5, 3.1, 3.2, "2 poor", "low", "high"));
        cards.add(new Cards.PlayCard("Slide41.jpg", "Slide41", "Monazite", "(La, Ce, Nd) P O_4 ", "phosphate", "monoclinic", "igneous,metamorphic,sedimentary", 5, 5, 5.0, 5.3, "1 good, 1 poor", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide42.jpg", "Slide42", "Calcite", "Ca C O_3", "carbonate", "hexagonal", "igneous,metamorphic,sedimentary", 3, 3, 2.7, 2.7, "3 perfect", "moderate", "high"));
        cards.add(new Cards.PlayCard("Slide43.jpg", "Slide43", "Dolomite", "Ca Mg (C O_3)_2", "carbonate", "hexagonal", "metamorphic,sedimentary", 3.5, 4, 2.9, 2.9, "3 perfect", "low", "low"));
        cards.add(new Cards.PlayCard("Slide44.jpg", "Slide44", "Magnesite", "Mg C O_3", "carbonate", "hexagonal", "metamorphic,sedimentary", 4, 4, 3, 3.0, "3 perfect", "low", "moderate"));
        cards.add(new Cards.PlayCard("Slide45.jpg", "Slide45", "Siderite", "Fe C O_3", "carbonate", "hexagonal", "metamorphic,sedimentary", 4, 4.5, 4, 4, "3 perfect", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide46.jpg", "Slide46", "Magnetite", "Fe_3 O_4", "oxide (spinel)", "isometric", "igneous,metamorphic,sedimentary", 5.5, 6, 5.2, 5.2, "none", "moderate", "very high"));
        cards.add(new Cards.PlayCard("Slide47.jpg", "Slide47", "Hematite", "Fe_2 O_3", "oxide", "hexagonal", "metamorphic,sedimentary", 5, 6, 5.3, 5.3, "none", "trace", "high"));
        cards.add(new Cards.PlayCard("Slide48.jpg", "Slide48", "Chromite", "(Fe, Mg) Cr_2 O_4", "oxide (spinel)", "isometric", "igneous,sedimentary", 5.5, 5.5, 4.5, 5.1, "none", "low", "high"));
        cards.add(new Cards.PlayCard("Slide49.jpg", "Slide49", "Ilmenite", "Ti Fe O_3", "oxide", "hexagonal", "igneous,metamorphic,sedimentary", 5, 6, 4.7, 4.8, "none", "low", "moderate"));
        cards.add(new Cards.PlayCard("Slide50.jpg", "Slide50", "Rutile", "Ti O_2", "oxide", "tetragonal", "metamorphic,sedimentary", 6, 6.5, 4.3, 4.3, "2 good", "low", "high"));
        cards.add(new Cards.PlayCard("Slide51.jpg", "Slide51", "Corundum", "Al_2 O_3", "oxide", "hexagonal", "metamorphic,sedimentary", 9, 9, 4, 4, "none", "trace", "moderate"));
        cards.add(new Cards.PlayCard("Slide52.jpg", "Slide52", "Cassiterite", "Sn O_2", "oxide", "tetragonal", "igneous,metamorphic,sedimentary", 6, 7, 6.9, 7.1, "1 good, 1 poor", "trace", "high"));
        cards.add(new Cards.PlayCard("Slide53.jpg", "Slide53", "Gibbsite", "Al (O H)_3", "hydroxide", "monoclinic", "metamorphic,sedimentary", 2.5, 3.5, 2.4, 2.4, "1 perfect", "low", "high"));
        cards.add(new Cards.PlayCard("Slide54.jpg", "Slide54", "Goethite", "Fe O (OH)", "hydroxide", "orthorhombic", "sedimentary", 5, 5.5, 4.3, 4.3, "1 perfect, 1 good", "moderate", "moderate"));
        //Trump Cards Initialisation
        cards.add(new Cards.TrumpCard("Slide55.jpg", "Slide55", "The Miner", "Economic value", "Economic value"));
        cards.add(new Cards.TrumpCard("Slide56.jpg", "Slide56", "The Petrologist", "Crustal abundance", "Crustal abundance"));
        cards.add(new Cards.TrumpCard("Slide57.jpg", "Slide57", "The Gemmologist", "Hardness", "Hardness"));
        cards.add(new Cards.TrumpCard("Slide58.jpg", "Slide58", "The Mineralogist", "Cleavage", "Cleavage"));
        cards.add(new Cards.TrumpCard("Slide59.jpg", "Slide59", "The Geophysicist", "Specific gravity", "Specific gravity"));
        cards.add(new Cards.TrumpCard("Slide60.jpg", "Slide60", "The Geologist", "Change to trumps category of your choice", "Cleavage, Crustal abundance, Economic value, Hardness, Specific gravity"));

        Collections.shuffle(cards);
    }

    public ArrayList<Cards.Card> dealCards(int NotDealtCards) {
        ArrayList<Cards.Card> ret = new ArrayList<Cards.Card>();
        for (int i = 0; i < NotDealtCards; i++) {
            int handover = new Random().nextInt(cards.size());
            Cards.Card card = cards.remove(handover);
            ret.add(card);
        }
        return ret;
    }

    public Cards.Card takeCard() {
        return cards.remove(0);
    }

    public int count() {
        return cards.size();

    }
}