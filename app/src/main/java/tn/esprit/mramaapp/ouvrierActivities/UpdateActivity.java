package tn.esprit.mramaapp.ouvrierActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Utilisateur;
import tn.esprit.mramaapp.entities.datas;

public class UpdateActivity extends AppCompatActivity {
    SharedPreferences preference;
    SharedPreferences.Editor editor;
    EditText nomPrenom;
    EditText services;
    EditText emailP;
    EditText pwd;
    Button valider;
    myDatabase mydatabase;
    UtilisateurDAO utilisateurdao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        acessDatabase();
        preference = getSharedPreferences("MyPreference", MODE_PRIVATE);
        editor = preference.edit();
        String role=preference.getString("saved_role",null);
        String email =preference.getString("saved_email",null);
        //get user
        Utilisateur u=utilisateurdao.getUtilisateurByMail(email);

        nomPrenom=(EditText)findViewById(R.id.nomupdate);
       // categorie=(EditText)findViewById(R.id.categorieprofile);
        services=(EditText)findViewById(R.id.service);
        emailP=(EditText)findViewById(R.id.emailupdate);
        pwd=(EditText)findViewById(R.id.motdepasse);
        nomPrenom.setText(u.getNom());
        // categorie.setText(u.getCategoriesu().toString());
        services.setText(u.getService());
        emailP.setText(u.getMail());
        pwd.setText(u.getPwd());

        valider=findViewById(R.id.button);
        valider.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
               //updating
                u.setNom(nomPrenom.getText().toString());
                u.setMail(emailP.getText().toString());
                u.setPwd(pwd.getText().toString());
                u.setService(services.getText().toString());
                utilisateurdao.updateUtilisateur(u);
                //notif
                Toast.makeText(UpdateActivity.this, "modifaction effectuée!",
                        Toast.LENGTH_LONG).show();
                //navigate
                Intent i = new Intent(UpdateActivity.this, ProfilActivity.class);
                startActivity(i);
            }
        });
    }
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(UpdateActivity.this);
        utilisateurdao=mydatabase.utilisateurDAO();
    }
}