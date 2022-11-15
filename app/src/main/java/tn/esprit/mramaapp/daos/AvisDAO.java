package tn.esprit.mramaapp.daos;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import tn.esprit.mramaapp.entities.Avis;

@Dao
public interface AvisDAO {
    @Insert
    public void insertAvis(Avis a);
    @Query("SELECT * FROM avis")
    public Cursor findAllAvis();
}
