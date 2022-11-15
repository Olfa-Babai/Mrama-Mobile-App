package tn.esprit.mramaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;

public class ItemActivity extends AppCompatActivity {
    myDatabase mydatabase;
    UtilisateurDAO utilisateurdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
    }
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(ItemActivity.this);
        utilisateurdao=mydatabase.utilisateurDAO();
    }
}

