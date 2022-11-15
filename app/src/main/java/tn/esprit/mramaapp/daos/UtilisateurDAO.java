package tn.esprit.mramaapp.daos;

import android.database.Cursor;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import tn.esprit.mramaapp.entities.Utilisateur;

@Dao
public interface UtilisateurDAO {
    @Insert
    public void insertUtilisateur(Utilisateur u);
    @Update
    public void updateUtilisateur(Utilisateur u);
    @Delete
    public void deleteUtilisateur(Utilisateur u);
    @Query("SELECT * FROM utilisateur")
    public Cursor findUtilisateurs();

    @Query("SELECT * FROM utilisateur")
    public List<Utilisateur> getAllUtilisateurs();

   // public List<Utilisateur> findUtilisateurs();
    @Query("SELECT * FROM utilisateur where id=:idu")
    public Utilisateur getUtilisateur(int idu);
    @Query("SELECT * FROM utilisateur where mail=:email")
    public Utilisateur getUtilisateurByMail(String email);

    //recherche
    @Query("SELECT * FROM utilisateur where nom=:search")
    public List<Utilisateur> searchUtilisateur(String search);

}
