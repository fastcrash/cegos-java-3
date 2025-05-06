package org.largeger.testing.mockito;

public class Shop {
    private Database database;
    public Shop(Database database) {
        this.database = database;
    }
    public boolean query(String query) {
        return database.isAvailable();
    }
    @Override
    public String toString() {
        return "Using article-database with id: " + String.valueOf(database.getUniqueId());
    }
}
