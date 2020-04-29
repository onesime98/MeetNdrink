package fr.point.meetndrink;

public class Reservation2 {
    private String nombar;
    private String heure;
    private String date;

    public Reservation2 (){
        //empty constructor needed
    }


    public Reservation2 (String nombar, String heure, String date){
        this.nombar = nombar;
        this.heure = heure;
        this.date = date;

    }

    public String getNombar() {
        return nombar;
    }

    public String getHeure() {
        return heure;
    }

    public String getDate() {
        return date;
    }
}
