package tn.esprit.mramaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import tn.esprit.mramaapp.clientActivities.HomecActivity;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Utilisateur;
import tn.esprit.mramaapp.entities.datas;
import tn.esprit.mramaapp.ouvrierActivities.HomeoActivity;

public class LoginvActivity extends AppCompatActivity {

    Button login;
    EditText email, password;
    Button btnLogin;
    // DBHelper DB;
    SharedPreferences preference;
    SharedPreferences.Editor editor;
    datas d = new datas();
    myDatabase mydatabase;
    UtilisateurDAO utilisateurdao;
    /* List<Utilisateur> os=d.getOuvriers();
        List<Utilisateur> cs=d.getClients(); */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preference = getSharedPreferences("MyPreference", MODE_PRIVATE);
        editor = preference.edit();

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        btnLogin = findViewById(R.id.loginbtn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String my_email = email.getText().toString();
                String my_password = password.getText().toString();
                if (my_email.isEmpty() || my_password.isEmpty()) {
                    Toast.makeText(LoginvActivity.this, "Vérifiez vos informations!",
                            Toast.LENGTH_LONG).show();
                } else {
                    //checking login :
                   // new Thread(()->{
                        acessDatabase();
                       Utilisateur u = utilisateurdao.getUtilisateurByMail(my_email);
                       if(u.getPwd().equals(my_password)){
                           String role=u.getRole().toString();
                           editor.putString("saved_email", my_email);
                           editor.putString("saved_password", my_password);
                           editor.putString("saved_role", role);
                           editor.commit();

                           if(role.equals("ouvrier")){
                               Intent intent = new Intent(LoginvActivity.this, HomeoActivity.class);
                               startActivity(intent);
                           }
                           else if(role.equals("client")){
                               Intent intent = new Intent(LoginvActivity.this, HomecActivity.class);
                               startActivity(intent);
                           }

                       }
                       else{
                           Toast.makeText(LoginvActivity.this, "Vérifiez vos informations!",
                                   Toast.LENGTH_LONG).show();
                       }
                    //});
                }
            }

        });
    }
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(LoginvActivity.this);
        utilisateurdao=mydatabase.utilisateurDAO();
    }
}

// code kdim :

//checking pwd
                        /*
                        if(d.loginPwd(role,my_email,my_password)){
                            if(role.equals("ouvrier") || role.equals("client")){
                                editor.putString("saved_email", my_email);
                                editor.putString("saved_password", my_password);
                                editor.putString("saved_role", role);
                                editor.commit();
                                if(role.equals("ouvrier")){
                                    Intent intent = new Intent(LoginvActivity.this, HomeoActivity.class);
                                    startActivity(intent);
                                }
                                else if(role.equals("client")){
                                    Intent intent = new Intent(LoginvActivity.this, HomecActivity.class);
                                    startActivity(intent);
                                }
                            }
                            else {
                                Toast.makeText(LoginvActivity.this, "Vérifiez vos informations!",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                        else{
                            Toast.makeText(LoginvActivity.this, "Vérifiez vos informations!",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });*/