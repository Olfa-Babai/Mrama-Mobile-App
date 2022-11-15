package tn.esprit.mramaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tn.esprit.mramaapp.clientActivities.HomecActivity;
import tn.esprit.mramaapp.daos.MaterielDAO;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Materiel;
import tn.esprit.mramaapp.ouvrierActivities.HomeoActivity;

public class MainActivity extends AppCompatActivity {

    Button login;
    Button signin;
    Button apropos;
    SharedPreferences preference;
    SharedPreferences.Editor editor;
    String role;
    myDatabase mydatabase;
    UtilisateurDAO utilisateurdao;
    MaterielDAO materieldao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MediaPlayer mediaPlayer= MediaPlayer.create(this,R.raw.beep);
        acessDatabase();
        //remplissage base
       /* Materiel m=new Materiel();
        m.setNom("Clous");
        m.setPrix(20);
        m.setDisponibilite("Carrefour");
        //
        materieldao.insertMateriel(m);*/
        preference = getSharedPreferences("MyPreference", MODE_PRIVATE);
        editor = preference.edit();
        role=preference.getString("saved_role",null);
        //navigate to login activity

        if(preference.contains("saved_role")){
            if(role.equals("ouvrier")){
                Intent i = new Intent(MainActivity.this, HomeoActivity.class);
                startActivity(i);
            }
            else if(role.equals("client")){
                Intent i = new Intent(MainActivity.this, HomecActivity.class);
                startActivity(i);
            }
        }

        login = findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                    Intent i = new Intent(MainActivity.this, LoginvActivity.class);
                    startActivity(i);
            }
        });
        //navigate to signin activity
        signin = findViewById(R.id.btnsingin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Intent i = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(i);
            }
        });
        //navigate to apropos activity
        apropos = findViewById(R.id.btnapropos);
        apropos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();
                Intent i = new Intent(MainActivity.this, AproposActivity.class);
                startActivity(i);
            }
        });

    }


    public void acessDatabase()
    {
        mydatabase=myDatabase.getDatabase(MainActivity.this);
        utilisateurdao=mydatabase.utilisateurDAO();
        materieldao=mydatabase.materielDAO();
    }
}



