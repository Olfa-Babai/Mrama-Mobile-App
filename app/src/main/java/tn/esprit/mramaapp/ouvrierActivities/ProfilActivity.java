package tn.esprit.mramaapp.ouvrierActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tn.esprit.mramaapp.LoginvActivity;
import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Utilisateur;
import tn.esprit.mramaapp.entities.datas;

public class ProfilActivity extends AppCompatActivity {
    Button update ;
    SharedPreferences preference;
    SharedPreferences.Editor editor;
    TextView nomPrenom;
    TextView categorie;
    TextView services;
    TextView emailP;
    myDatabase mydatabase;
    UtilisateurDAO utilisateurdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        acessDatabase();
        preference = getSharedPreferences("MyPreference", MODE_PRIVATE);
        editor = preference.edit();
       String role=preference.getString("saved_role",null);
       String email =preference.getString("saved_email",null);
       System.out.println(utilisateurdao.findUtilisateurs());
       //get user
        Utilisateur u=utilisateurdao.getUtilisateurByMail(email);
        nomPrenom=(TextView)findViewById(R.id.nameprofile);
        categorie=(TextView)findViewById(R.id.categorieprofile);
        services=(TextView)findViewById(R.id.serviceprofile);
        emailP=(TextView)findViewById(R.id.emailprofile);
        nomPrenom.setText(u.getNom());
        categorie.setText(u.getCategoriesu().toString());
        services.setText(u.getService());
        emailP.setText(u.getMail());
        // navigate to update
        update=findViewById(R.id.buttonmodifier);
        update.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view) {
            Intent i = new Intent(ProfilActivity.this, UpdateActivity.class);
            startActivity(i);
        }
    });
}
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(ProfilActivity.this);
        utilisateurdao=mydatabase.utilisateurDAO();
    }
}