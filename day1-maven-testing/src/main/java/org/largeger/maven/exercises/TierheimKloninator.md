# 🧠 Aufgabe: "Der Tierheim-Kloninator"

Ein nahegelegenes Tierheim nutzt veraltete Software zur Verwaltung seiner Tiere. Deine Aufgabe ist es, ein modernes System zu entwickeln – mit einer Besonderheit:
Jedes Tier, das besonders beliebt ist (z.B. 🐶 Bello oder 🐱 Miezi), wird aus Spaß automatisch geklont – aber nur virtuell!

## Anforderungen:
1. Verwalte Tiere als Objekte mit folgenden Eigenschaften:
- Name (String)
- Tierart (Enum: DOG, CAT, RABBIT, etc.)
- Beliebtheit (int, 0–100)
2. Erstelle eine Liste mit zufällig generierten Tieren (mindestens 20 Stück).
3. Klone alle Tiere, deren Beliebtheit über 80 liegt. Verwende dafür `ImmutableList` und `Lists.transform` aus Guava, sodass du die originale Liste nicht veränderst.
4. Sortiere alle Tiere nach Tierart, dann absteigend nach Beliebtheit – mit Guava's Ordering.
3. Erstelle ein `Multimap<Tierart, Tier>`, die alle Tiere je nach Tierart gruppiert – mithilfe von Multimap aus Guava.
4. Gib das Ergebnis hübsch formatiert aus – z.B.:
```
🐱 CAT
- Miezi (Beliebtheit: 97)
- Mauzi (Beliebtheit: 84)

🐶 DOG
- Bello (Beliebtheit: 95)
- Rex (Beliebtheit: 68)
```

## Bonus 🤓
Verwende `Optional<T>` aus Guava, um ein zufällig gesuchtes Tier zu finden (z.B. "Gibt es einen Hund namens Bello?").

## 🧰 Hinweise zur Guava-Nutzung
* `Lists.transform` zum Erzeugen der Klone ohne die Originaldaten zu verändern.
* `Ordering` zum eleganten Sortieren.
* `Multimaps.index` oder `ArrayListMultimap.create()` zum Gruppieren.
* `Optional.fromNullable(...)` zur sicheren Suche.
