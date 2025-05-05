package org.largeger.maven.exercises;

import com.google.common.base.Optional;
import com.google.common.collect.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TierheimKloninatorLoesung {

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

        // Klone beliebte Tiere (>80), Original bleibt unverändert
        List<Tier> geklonteTiere = Lists.newArrayList(Iterables.concat(
                tiere,
                Lists.newArrayList(Iterables.filter(tiere, t -> t.beliebtheit > 80))
        ));



        // Sortiere nach Tierart, dann nach Beliebtheit (absteigend)
        Ordering<Tier> tierOrdering = Ordering.natural().onResultOf((Tier t) -> t.art.toString())
                .compound(Ordering.natural().reverse().onResultOf((Tier t) -> t.beliebtheit));

        List<Tier> sortiert = tierOrdering.sortedCopy(geklonteTiere);



        // Multimap<Tierart, Tier>
        Multimap<Tierart, Tier> tierMultimap = ArrayListMultimap.create();
        for (Tier tier : sortiert) {
            tierMultimap.put(tier.art, tier);
        }

        // Ausgabe
        for (Tierart art : Tierart.values()) {
            Collection<Tier> artTiere = tierMultimap.get(art);
            if (!artTiere.isEmpty()) {
                System.out.println(getIcon(art) + " " + art);
                for (Tier tier : artTiere) {
                    System.out.println("  - " + tier);
                }
                System.out.println();
            }
        }

        // Bonus: Suche Hund namens Bello
        Optional<Tier> gefunden = Optional.fromNullable(
                Iterables.find(tiere, t -> t.art == Tierart.DOG && t.name.contains("Bello"), null)
        );
        if (gefunden.isPresent()) {
            System.out.println("✅ Gefunden: " + gefunden.get());
        } else {
            System.out.println("❌ Kein Hund namens Bello gefunden.");
        }
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

    private static String getIcon(Tierart art) {
        return switch (art) {
            case DOG -> "🐶";
            case CAT -> "🐱";
            case RABBIT -> "🐰";
            case HAMSTER -> "🐹";
            case PARROT -> "🦜";
        };
    }
}
