package tn.esprit.mramaapp.clientActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.daos.MaterielDAO;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Materiel;
import tn.esprit.mramaapp.ouvrierActivities.UpdateActivity;

public class OutillageActivity extends AppCompatActivity {

   // Offlinemapview offlineMapView;


    RecyclerView outils;
    myDatabase mydatabase;
    MaterielDAO materieldao;
    EditText search;
    Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outillage);
        acessDatabase();
     //  offlineMapView = findViewById(R.id.map);
       // offlineMapView.init(this, this);

        // insert outils :
        /*


        int lastid=materieldao.findMateriels().size();
        Materiel m=new Materiel(4,"Marteau","Geant",30,"Construction");
        Materiel m1=new Materiel(5,"Pince","Carrefour",10,"Construction");
        Materiel m2=new Materiel(6,"Cutter","Carrefour",50,"Construction");

        materieldao.insertMateriel(m);
        materieldao.insertMateriel(m1);
        materieldao.insertMateriel(m2); */

        outils=findViewById(R.id.recyle);
        outils.setLayoutManager(new LinearLayoutManager(this));
        outils.setHasFixedSize(true);
        OutillageAdapter oAdapter=new OutillageAdapter();
        outils.setAdapter(oAdapter);

        search=findViewById(R.id.searchoutil);
        searchButton=findViewById(R.id.btnsearchoutil);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        oAdapter.setOutils(materieldao.findMateriels());

    }
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(OutillageActivity.this);
        materieldao=mydatabase.materielDAO();
    }


}