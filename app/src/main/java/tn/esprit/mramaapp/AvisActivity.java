package tn.esprit.mramaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mramaapp.LoginvActivity;
import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.daos.AvisDAO;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Avis;

public class AvisActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button addAvis;
    myDatabase mydatabase;
    AvisDAO avisdao;
    List<String> items;
    String itemSelected;
    EditText description;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acessDatabase();

        items=new ArrayList<>();
        items.add("Ouvriers");
        items.add("Outils");
        items.add("Application");
        setContentView(R.layout.activity_avis);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,items));
        spinner.setOnItemSelectedListener(this);
       addAvis=findViewById(R.id.addavis);
       addAvis.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Avis a=new Avis();
           description=findViewById(R.id.descavis1);
           a.setCategorieAvis(itemSelected);
           a.setDescription(description.getText().toString());
           avisdao.insertAvis(a);
           Intent intent = new Intent(AvisActivity.this, AvisListActivity.class);
           startActivity(intent);
           }
       });
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
        mydatabase= myDatabase.getDatabase(AvisActivity.this);
        avisdao=mydatabase.AvisDAO();
    }
}