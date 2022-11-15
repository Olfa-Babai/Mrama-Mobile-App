package tn.esprit.mramaapp.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import tn.esprit.mramaapp.entities.Materiel;

@Dao
public interface MaterielDAO {
    @Insert
    public void insertMateriel(Materiel bp);
    @Update
    public void updateMateriel(Materiel bp);
    @Delete
    public void deleteMateriel(Materiel bp);
    @Query("SELECT * FROM materiel")
    public List<Materiel> findMateriels();

    // recherche
    @Query("SELECT * FROM materiel where nom=:search")
    public List<Materiel> searchMateriel(String search);

}
