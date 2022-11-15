package tn.esprit.mramaapp.ouvrierActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mramaapp.R;

public class OuvriersActivity extends AppCompatActivity {
   // private RecyclerView recyclerView;
   // private tn.esprit.mramaapp.ouvrierActivities.Adapter Adapter;
   // private ArrayList<ouv> ouvArrayList;
    RecyclerView list;
    Spinner spinner;
    List<String> items=new ArrayList<>();
    String itemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ouvriers);
        items.add("Filtrer par :");
        items.add("Carreleur");
        items.add("Couvreur");
        items.add("Chauffeur");

        spinner=findViewById(R.id.spinner3);
        spinner.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items));
        // Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemSelected=items.get(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        list=findViewById(R.id.Recycle);
       Adapter adapter = new Adapter(this);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

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
    }}
