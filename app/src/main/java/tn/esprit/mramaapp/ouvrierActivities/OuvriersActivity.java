package tn.esprit.mramaapp.ouvrierActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mramaapp.LoginvActivity;
import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Utilisateur;

public class OuvriersActivity extends AppCompatActivity {
   // private RecyclerView recyclerView;
   // private tn.esprit.mramaapp.ouvrierActivities.Adapter Adapter;
   // private ArrayList<ouv> ouvArrayList;
    RecyclerView list;
    Spinner spinner;
    List<String> items=new ArrayList<>();
    String itemSelected;
    private myDatabase mydatabase;
    private UtilisateurDAO utilisateurdao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ouvriers);
        acessDatabase();
        items.add("Filtrer par :");
        items.add("Carreleur");
        items.add("Couvreur");
        items.add("Chauffeur");

        list=findViewById(R.id.Recycle);
        Adapter adapter = new Adapter(this);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));


        spinner=findViewById(R.id.spinner3);
        spinner.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items));
        // Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemSelected=items.get(i);
                List<Utilisateur> uts=new ArrayList<>();
                if(!(itemSelected.trim().equals("Filtrer par :"))){
               // uts=utilisateurdao.getUtilisateurByCategorieU(itemSelected);
                    System.out.println(utilisateurdao.getAllUtilisateurs());
                for(Utilisateur u : utilisateurdao.getAllUtilisateurs()){
                    if(u.getCategoriesu().equals(itemSelected)){
                        uts.add(u);
                    }
                }
                    adapter.setOuvriers(uts);
                }
                else{
                    adapter.setOuvriers(utilisateurdao.getAllUtilisateurs());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button searchbtn= findViewById(R.id.searchobtn);

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText search=findViewById(R.id.searchouvrier);
                List<Utilisateur> us=new ArrayList<>();
                for(Utilisateur m : utilisateurdao.getAllUtilisateurs()){
                    if(m.getNom().contains(search.getText().toString())){
                        us.add(m);
                    }
                }
                adapter.setOuvriers(us);
            }
        });

      /*  addData();
        recyclerView = findViewById(R.id.Recycle);

        Adapter = new Adapter(ouvArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(OuvriersActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(Adapter);
    }

    ouvArrayList = new ArrayList<>();
        ouvArrayList.add(new ("Aham Siswana01", "121437809801", "09875812401"));
        ouvArrayList.add(new ouv("Aham Siswana02", "121437809802", "09875812402"));

    } */
    }
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(OuvriersActivity.this);
        utilisateurdao=mydatabase.utilisateurDAO();
    }
}
