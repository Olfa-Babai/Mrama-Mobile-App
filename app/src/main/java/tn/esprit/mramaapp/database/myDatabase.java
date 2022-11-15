package tn.esprit.mramaapp.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

//import androidx.room.;

import kotlin.jvm.Synchronized;
import tn.esprit.mramaapp.daos.AvisDAO;
import tn.esprit.mramaapp.daos.BonplanDAO;
import tn.esprit.mramaapp.daos.MaterielDAO;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.entities.Avis;
import tn.esprit.mramaapp.entities.Bonplan;
import tn.esprit.mramaapp.entities.Materiel;
import tn.esprit.mramaapp.entities.Utilisateur;


@Database(entities = {Utilisateur.class, Avis.class ,Materiel.class, Bonplan.class}, version = 3,exportSchema = false)
public abstract class myDatabase extends RoomDatabase {

    private static myDatabase instance;
    public abstract UtilisateurDAO utilisateurDAO();
    public abstract AvisDAO AvisDAO();
    public abstract MaterielDAO materielDAO();
    public abstract BonplanDAO bonplanDAO();
    public static myDatabase getDatabase(Context ctx){
       //
        if(instance==null){
            synchronized(myDatabase.class){
                if(instance==null){
            instance= Room.databaseBuilder(ctx.getApplicationContext(),myDatabase.class,"mramadb")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }}}
        return instance;
    }
}
