# 🌱 Projekt: Book Club API 

## Überblick
In dieser mehrstufigen Übungsaufgabe erstellst du eine REST-API für einen "Book Club", bei dem Bücher empfohlen, hinzugefügt, gespeichert und getestet werden. Die Aufgaben steigern sich im Schwierigkeitsgrad und helfen dir, wichtige Spring Boot-Konzepte zu erlernen und praktisch umzusetzen.

---
## Stufe 1: REST Controller – Bücher lesen und hinzufügen ⭐
**Ziel:** Implementiere einen REST-Controller, der es erlaubt, Bücher abzufragen und neue hinzuzufügen.

### Anforderungen:
* Erstelle eine `BookController`-Klasse mit folgenden Endpoints:
    * `GET /books`: Liefert eine Liste aller Bücher
    * `POST /books`: Fügt ein neues Buch hinzu (Titel, Autor)

### Hinweise:
* Nutze eine einfache Datenklasse `Book` mit `id`, `title` und `author`.
* Verwende eine statische Liste in der Controller-Klasse zur Speicherung.

---
## Stufe 2: Service-Schicht – Bücher verwalten ⭐⭐

**Ziel:** Refaktoriere die Controller-Logik in eine separate Service-Schicht.

### Anforderungen:

* Erstelle eine `BookService`-Klasse, die die Buchliste verwaltet.
* Verschiebe die Logik für `getAllBooks()` und `addBook()` vom Controller in den Service.
* Der Controller ruft nur noch Methoden aus dem Service auf.

### Bonus (optional):

* Füge einen `GET /books/{id}` Endpoint hinzu, der ein Buch nach ID liefert.

---

## Stufe 3: Persistenz mit H2-Datenbank ⭐⭐⭐

**Ziel:** Ersetze die lokale Liste durch eine persistente Speicherung mit einer H2-Datenbank.

### Anforderungen:

* Erstelle eine `Book`-Entity mit JPA-Annotationen.
* Verwende ein `BookRepository`, das von `JpaRepository` erbt.
* Der `BookService` nutzt nun das Repository zum Speichern und Abrufen.
* Konfiguriere `application.properties`, um H2 zu aktivieren und im Webbrowser nutzbar zu machen.

### Bonus:

* Stelle sicher, dass IDs automatisch generiert werden.
* Optional: Füge einen `DELETE /books/{id}` Endpoint hinzu.

---

## Stufe 4: Tests für Controller und Service ⭐⭐⭐

**Ziel:** Teste die Business-Logik und die REST-Schnittstellen.

### Anforderungen:

* Schreibe Unit-Tests für den `BookService` mit Mockito:

    * Buch hinzufügen
    * Buch finden
* Schreibe Integrationstests für den `BookController` mit `MockMvc`:

    * `GET /books` gibt die Liste zurück
    * `POST /books` fügt ein Buch hinzu

### Bonus:

* Füge negative Tests hinzu, z. B. für ungültige IDs.
* Verwende `@DataJpaTest`, um das Repository isoliert zu testen.

---

## Erweiterungsidee (nach allen Stufen):

Füge ein zweites Entity `Review` hinzu, um Buchbewertungen zu speichern. Diese könnten Kommentare und Sterne-Bewertungen enthalten. Damit können auch Konzepte wie `@ManyToOne`, DTOs und Validierung eingebaut werden.
