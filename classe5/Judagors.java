package classe5;
import java.io.Serializable;

public class Judagors implements Serializable{
    private String nom;
    private int punts;

    public Judagors(String nom, int punts) {
        this.nom = nom;
        this.punts = punts;
    }

    public String getNom() {
        return nom;
    }

    public int getPunts() {
        return punts;
    }
}