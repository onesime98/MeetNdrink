package fr.point.meetndrink;

public class Reservation {
    private String name;
    private String client;
    private String date;
    private String heure;
    private String nbpers;

    //constructeur
    public Reservation(){
        //empty constructor need
    }

    public Reservation(String name, String client, String date, String heure, String nbpers){
        this.name = name;
        this.client = client;
        this.date = date;
        this.heure = heure;
        this.nbpers = nbpers;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure= heure;
    }

    public String getNbpers() {
        return nbpers;
    }

    public void setNbpers(String nbpers) {
        this.nbpers = nbpers;
    }


}

