package org.largeger.day4springthymeleaf.model;

public class Person {
    private Long id;
    private String vorname;
    private String nachname;

    // Konstruktoren, Getter, Setter
    public Person() {}

    public Person(Long id, String vorname, String nachname) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getVorname() { return vorname; }
    public void setVorname(String vorname) { this.vorname = vorname; }
    public String getNachname() { return nachname; }
    public void setNachname(String nachname) { this.nachname = nachname; }
}
