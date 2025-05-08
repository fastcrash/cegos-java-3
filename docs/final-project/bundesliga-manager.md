# 🏆 Spring Boot Projektaufgabe: Bundesligamanager

**Ziel:** Entwicklung einer Webapplikation zur Verwaltung einer Fußballliga mit Spielersimulation, Kartensystem und Rangliste.

---

## 📦 Stufe 1 – Grundstruktur & Datenmodell (ca. 2–3 Stunden)

### Anforderungen:

#### 🔁 Controller
- `@RestController` für JSON-Endpunkte (z.B. Spieler hinzufügen, Clubdaten abrufen)
- `@Controller` mit Thymeleaf-Templates für HTML-Ansichten (z.B. Spielerliste, Clubübersicht)

#### 🧱 Domänenmodell
- **Entitäten**:
    - `Club` (Name, Punkte, Tore, etc.)
    - `Player` (Name, Position, Club, Anzahl Karten)
- Beziehung: Ein Club hat mehrere Spieler

#### 🧠 Services
- Trennung der Geschäftslogik über Service-Klassen (z.B. Spielerlogik, Punktezählung)

#### 💾 Datenbank
- Nutzung von Spring Data JPA mit einer H2-In-Memory-Datenbank zur Speicherung der Daten
- Aufbau der entsprechenden `@Entity`-Klassen und Repository-Schnittstellen
- Sinnvolle Validierung der Daten (ggf. mit Spring Validation
- optional: Erstellung eines "Testdatensatzes" für die Datenbank, der bei jedem Start der App geladen wird

### Ziel:
> Clubs und Spieler können erstellt, verwaltet und über HTML-View oder JSON angezeigt werden.

---

## 🐳 Stufe 2 – Dockerisierung & CI/CD (ca. 1–2 Stunden)

### Anforderungen:

#### 🐳 Docker
- `Dockerfile` zur Containisierung der Spring Boot App
- Optional: `docker-compose.yml` mit externer Datenbank (PostgreSQL)

#### ⚙️ GitHub Actions
- CI/CD Pipeline für:
    - Build
    - Test
    - Docker-Image-Erstellung
    - Deployment in Github Container Registry

---

## 🎮 Stufe 3 – Spielsimulation & Ranking (ca. 2–3 Stunden)

#### 🔀 Spielsimulation
- Endpunkt zur Simulation einer Begegnung zweier Clubs
- Zufällige Torschützen, Ergebnisse und Kartenverteilung

#### 🟥🟨 Kartensystem
- Spieler erhalten zufällig Gelbe oder Rote Karten
- Kartenanzeige je Spieler

#### 📊 Rangliste
- Rangtabelle der Clubs:
    - Punkte
    - Tore
    - Torverhältnis

#### 🧪 Unit Tests
- Services werden mit JUnit 5 getestet
- Mocks für abhängige Services (z.B. mit Mockito)

---

## ✅ Optional: Erweiterungen

- Docker Compose mit persistenter DB
- Spielersperren bei Kartensumme
- REST-Dokumentation (Swagger/OpenAPI)

---

## 📝 Mögliche Skizze der Projektstruktur

```
                                        +-------------------------+
                                        |  BundesligamanagerApp   |
                                        |   (SpringBootApp.java)  |
                                        +------------+------------+
                                                     |
                          +--------------------------+--------------------------+
                          |                                                     |
             +------------v------------+                          +-------------v-------------+
             |     ClubController      |                          |     PlayerController      |
             | @RestController + HTML  |                          | @RestController + HTML    |
             +------------+------------+                          +-------------+-------------+
                          |                                                     |
                +---------v--------+                                  +---------v---------+
                |   ClubService    |                                  |   PlayerService    |
                +---------+--------+                                  +---------+----------+
                          |                                                     |
            +-------------v-------------+                        +---------------v---------------+
            |     ClubRepository        |                        |     PlayerRepository          |
            |     extends JpaRepository |                        |     extends JpaRepository     |
            +-------------+-------------+                        +---------------+---------------+
                          |                                                     |
                    +-----v------+                                      +--------v--------+
                    |   Club     |                                      |     Player      |
                    +------------+                                      +-----------------+

                          +---------------------------------------------------+
                          |                                                   |
                +---------v---------+                              +----------v----------+
                |  MatchController  |                              |   MatchService       |
                | (Simulate Match)  |                              | (simulateGames, etc) |
                +---------+---------+                              +----------+-----------+
                          |                                                   |
                  +-------v-------+                                   +-------v----------------+
                  | MatchSimUtil  |                                   | (uses ClubService +     |
                  | (Random logic)|                                   | PlayerService to update)|
                  +---------------+                                   +-------------------------+

                                    +----------------------+
                                    |       H2 DB          |
                                    | (in-memory database) |
                                    +----------+-----------+
                                               |
             +---------------------------------+----------------------------------+
             |                                                                    |
+---------v----------+                                             +-----------v-----------+
|   ClubRepository   |                                             |   PlayerRepository    |
+--------------------+                                             +-----------------------+

```
