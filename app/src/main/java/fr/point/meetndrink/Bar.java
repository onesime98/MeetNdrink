package fr.point.meetndrink;

public class Bar {
    private String name;
    private String description;
    private String adresse;
    private String numtel;
    private String horaire;
    private String classification;

    //constructeur
    public Bar(){
        //empty constructor need
    }

    public Bar(String name, String description, String adresse, String numtel, String horaire, String classification){
        this.name = name;
        this.description = description;
        this.adresse = adresse;
        this.numtel = numtel;
        this.horaire = horaire;
        this.classification = classification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}

