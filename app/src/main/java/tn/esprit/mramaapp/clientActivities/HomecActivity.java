package tn.esprit.mramaapp.clientActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tn.esprit.mramaapp.AvisActivity;
import tn.esprit.mramaapp.AvisListActivity;
import tn.esprit.mramaapp.MainActivity;
import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.ouvrierActivities.OuvriersActivity;

public class HomecActivity extends AppCompatActivity {
Button avis;
Button ouvriers;
Button BP;
Button outil;
Button logout;
RecyclerView list;
SharedPreferences preferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homec);
        outil = findViewById(R.id.outilbtn);
        preferences = getSharedPreferences("MyPreference", Context.MODE_PRIVATE);
        editor = preferences.edit();

        outil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(view.getContext(),"test",Toast.LENGTH_SHORT);
                Intent i = new Intent(HomecActivity.this, OutillageActivity.class);
                startActivity(i);
            }
        });
        avis = findViewById(R.id.avis);
        avis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(view.getContext(),"test",Toast.LENGTH_SHORT);
                Intent i = new Intent(HomecActivity.this, AvisListActivity.class);
                startActivity(i);
            }
        });
        ouvriers = findViewById(R.id.ouvrierbtn);
        ouvriers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(view.getContext(),"test",Toast.LENGTH_SHORT);
                Intent i = new Intent(HomecActivity.this, OuvriersActivity.class);
                startActivity(i);
            }
        });
        BP = findViewById(R.id.BPbtn);
        BP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toast.makeText(view.getContext(),"test",Toast.LENGTH_SHORT);
                Intent i = new Intent(HomecActivity.this, BonPlanActivity.class);
                startActivity(i);
            }
        });

        logout=findViewById(R.id.logoutclient);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                Intent intent = new Intent(HomecActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


}