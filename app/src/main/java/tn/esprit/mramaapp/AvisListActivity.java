package tn.esprit.mramaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import tn.esprit.mramaapp.daos.AvisDAO;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.ouvrierActivities.HomeoActivity;

public class AvisListActivity extends AppCompatActivity {

    Button addAvis;
    myDatabase mydatabase;
    AvisDAO avisdao;
    ListView ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avis_list);

        acessDatabase();
        ls=findViewById(R.id.lst);
        addAvis=findViewById(R.id.addavisbtn);
        Cursor c=avisdao.findAllAvis();
        System.out.println();
        System.out.println("size of avis : "+c.getColumnName(0).length());
        SimpleCursorAdapter adapter=new SimpleCursorAdapter(AvisListActivity.this,R.layout.item,c,
                new String[]{c.getColumnName(0),c.getColumnName(1),c.getColumnName(2)},
                new int[]{R.id.aid,R.id.davis, R.id.cat},1);
        ls.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        addAvis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvisListActivity.this, AvisActivity.class);
                startActivity(intent);
            }
        });
    }
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(AvisListActivity.this);
        avisdao=mydatabase.AvisDAO();
    }
}