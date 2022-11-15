package tn.esprit.mramaapp;

import static android.text.TextUtils.isEmpty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.CategoriesU;
import tn.esprit.mramaapp.entities.Role;
import tn.esprit.mramaapp.entities.Utilisateur;

public class SigninActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    EditText username;
    EditText email;
    //String emailPattern = "[a-zA-Z0-9._-]\.+@[a-z]+\.+[a-z]+" ;
    EditText pwdsignin;
    EditText service;
    Button signin;
    myDatabase mydatabase;
    UtilisateurDAO utilisateurdao;
    String itemSelected;
    List<String> items;
    List<String> itemsC;
    String itemSelectedC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singin);
        username=findViewById(R.id.username);
        signin = findViewById(R.id.signinbtn);
        email=findViewById(R.id.emailsignin);
        pwdsignin=findViewById(R.id.pwdsignin);
        service=findViewById(R.id.Services);
        items=new ArrayList<>();
        itemsC=new ArrayList<>();
        itemsC.add("Carreleur");
        itemsC.add( "Couvreur");
        itemsC.add("Chauffeur");
        items.add("Ouvrier");
        items.add("Client");
        //spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinnerSI);
        spinner.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items));
        // Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        //spinner
        Spinner spinnerC = (Spinner) findViewById(R.id.spinnerCat);
        spinnerC.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,itemsC));
        // Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinnerC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemSelectedC=itemsC.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // CheckInfo();
                 //   new Thread(()->{
                        acessDatabase();
                        Utilisateur u=new Utilisateur();
                        u.setNom(username.getText().toString());
                        u.setService(service.getText().toString());
                        u.setMail(email.getText().toString());
                        u.setPwd(pwdsignin.getText().toString());
                        if(itemSelected.equals("Ouvrier")){
                            u.setRole(Role.ouvrier.name());
                        }
                        else{
                            u.setRole(Role.client.name());
                        }
                        //categorie
                        if(itemSelectedC.equals("Couvreur")){
                            u.setCategoriesu(CategoriesU.Couvreur.name());
                        }
                        else  if(itemSelectedC.equals("Carreleur")) {
                            u.setCategoriesu(CategoriesU.Carreleur.name());
                        }
                        else {
                            u.setCategoriesu(CategoriesU.Chauffeur.name());
                        }

                        System.out.println(u);
                        utilisateurdao.insertUtilisateur(u);
                        System.out.println(utilisateurdao.getUtilisateurByMail(u.getMail()));
                        Toast.makeText(SigninActivity.this, "Inscription effectuée!",
                                Toast.LENGTH_LONG).show();
                    //});
            }
        });

    }

    public void CheckInfo(){
        boolean isValid = true;
        //username
        if (username.getText().toString().isEmpty()) {
            username.setError("Vous devez mentionner votre nom!");
            isValid = false;
        }

        // email
        if (email.getText().toString().isEmpty()) {
            email.setError("Vous devez mentionner votre email!");
            isValid = false;

        }
        // mot de passe
        if (pwdsignin.getText().toString().isEmpty()) {
            pwdsignin.setError("Vous devez mentionner votre mot de passe!");
            isValid = false;
        } else {
            if (pwdsignin.getText().toString().length() < 4) {
                pwdsignin.setError("Votre mdp doit contenir au moins 4 caractères!");
                isValid = false;
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        itemSelected=items.get(i);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(SigninActivity.this);
        utilisateurdao=mydatabase.utilisateurDAO();
    }
}

/*
 Intent i = new Intent(SigninActivity.this, LoginvActivity.class);
 startActivity(i);
 */