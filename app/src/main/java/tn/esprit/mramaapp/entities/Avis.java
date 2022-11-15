package tn.esprit.mramaapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "avis")
public class Avis {
    @PrimaryKey(autoGenerate = true)
    private int _id;
    private String description;
    private String categorieAvis;

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategorieAvis() {
        return categorieAvis;
    }

    public void setCategorieAvis(String categorieAvis) {
        this.categorieAvis = categorieAvis;
    }

    public Avis(int id, String description, String categorieAvis) {
        this._id = id;
        this.description = description;
        this.categorieAvis = categorieAvis;
    }
    public Avis() {

    }
}
