package tn.esprit.mramaapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "materiel")
public class Materiel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "disponibilite")
    private String disponibilite;
    @ColumnInfo(name = "prix")
    private int prix;
    @ColumnInfo(name = "categoriesm")
    private String categoriesm;

    public Materiel(int id, String nom, String disponibilite, int prix, String categoriesm) {
        this.id = id;
        this.nom = nom;
        this.disponibilite = disponibilite;
        this.prix = prix;
        this.categoriesm = categoriesm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getCategoriesm() {
        return categoriesm;
    }

    public void setCategoriesm(String categoriesm) {
        this.categoriesm = categoriesm;
    }
    public Materiel(){

    }
}
