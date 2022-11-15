package tn.esprit.mramaapp.ouvrierActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import tn.esprit.mramaapp.AvisListActivity;
import tn.esprit.mramaapp.MainActivity;
import tn.esprit.mramaapp.R;

public class HomeoActivity extends AppCompatActivity {

    Button profil;
    Button avis;
    Button logout;
    Button btnLogout;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeo);
        // navigate to profile
        profil=findViewById(R.id.profilbtn);
        profil.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeoActivity.this, ProfilActivity.class);
                startActivity(i);
            }
        });
        // navigate to avis
        avis=findViewById(R.id.avisbtno);
        avis.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeoActivity.this, AvisListActivity.class);
                startActivity(i);
            }
        });
                preferences = getSharedPreferences("MyPreference", Context.MODE_PRIVATE);
                editor = preferences.edit();
                btnLogout = findViewById(R.id.logoubt);
                btnLogout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        editor.clear();
                        editor.commit();
                        Intent intent = new Intent(HomeoActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }



}