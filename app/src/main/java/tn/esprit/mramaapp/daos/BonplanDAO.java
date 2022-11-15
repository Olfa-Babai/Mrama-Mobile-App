package tn.esprit.mramaapp.daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import tn.esprit.mramaapp.entities.Bonplan;

@Dao
public interface BonplanDAO {
    @Insert
    public void insertBonplan(Bonplan bp);
    @Update
    public void updateBonplan(Bonplan bp);
    @Delete
    public void deleteBonplan(Bonplan bp);
    @Query("SELECT * FROM bonplan")
    public List<Bonplan> findBonplans();
}
