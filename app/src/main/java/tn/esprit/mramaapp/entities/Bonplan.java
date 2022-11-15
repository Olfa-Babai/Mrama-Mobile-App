package tn.esprit.mramaapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bonplan")
public class Bonplan {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "solde")
    private String solde;
    @ColumnInfo(name = "lieu")
    private String lieu;
    @ColumnInfo(name = "description")
    private String description;

    public Bonplan(int id, String solde, String lieu, String description) {
        this.id = id;
        this.solde = solde;
        this.lieu = lieu;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSolde() {
        return solde;
    }

    public void setSolde(String solde) {
        this.solde = solde;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
