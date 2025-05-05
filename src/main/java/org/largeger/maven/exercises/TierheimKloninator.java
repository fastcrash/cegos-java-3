package org.largeger.maven.exercises;

import com.google.common.base.Optional;
import com.google.common.collect.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TierheimKloninator {

    enum Tierart {
        DOG, CAT, RABBIT, HAMSTER, PARROT
    }

    static class Tier {
        final String name;
        final Tierart art;
        final int beliebtheit;

        Tier(String name, Tierart art, int beliebtheit) {
            this.name = name;
            this.art = art;
            this.beliebtheit = beliebtheit;
        }

        @Override
        public String toString() {
            return name + " (Beliebtheit: " + beliebtheit + ")";
        }
    }

    public static void main(String[] args) {
        List<Tier> tiere = generiereZufallsTiere(20);

        // TODO: Klone beliebte Tiere (>80) mithilfe von Guava Lists.transform oder Streams
        // TODO: Sortiere Tiere nach Tierart, dann nach Beliebtheit (absteigend)
        // TODO: Erstelle eine Multimap<Tierart, Tier> mit Guava
        // TODO: Gib die Multimap schön formatiert aus
        // TODO (Bonus): Suche optional nach einem Hund namens "Bello" mit Guava Optional
    }

    private static List<Tier> generiereZufallsTiere(int anzahl) {
        String[] namen = {"Bello", "Miezi", "Rex", "Hoppel", "Kiki", "Mauzi", "Wuschel", "Spike", "Nemo", "Flauschi"};
        List<Tier> liste = new ArrayList<>();
        for (int i = 0; i < anzahl; i++) {
            String name = namen[ThreadLocalRandom.current().nextInt(namen.length)] + i;
            Tierart art = Tierart.values()[ThreadLocalRandom.current().nextInt(Tierart.values().length)];
            int beliebtheit = ThreadLocalRandom.current().nextInt(101);
            liste.add(new Tier(name, art, beliebtheit));
        }
        return liste;
    }
}
