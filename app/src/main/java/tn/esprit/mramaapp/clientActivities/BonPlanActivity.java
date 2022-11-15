package tn.esprit.mramaapp.clientActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.daos.BonplanDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Bonplan;

public class BonPlanActivity extends AppCompatActivity {

    myDatabase mydatabase;
    BonplanDAO bonplandao;
    RecyclerView bprecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bon_plan);
        acessDatabase();

        bprecycle=findViewById(R.id.bonplanrecycle);
        bprecycle.setLayoutManager(new LinearLayoutManager(this));
        bprecycle.setHasFixedSize(true);
        BonPlanAdapter adapter=new BonPlanAdapter();
        bprecycle.setAdapter(adapter);
        adapter.setBonplans(bonplandao.findBonplans());
       // System.out.println(bonplandao.findBonplans());
        //insert
       /* Bonplan bp=new Bonplan(1,"-50%","Bricorama","Remise sur tous les articles.");
        Bonplan bp1=new Bonplan(2,"-30%","Carrefour","Remise sur tous les articles.");
        Bonplan bp2=new Bonplan(3,"-70%","Geant","Remise sur tous les articles.");
        Bonplan bp3=new Bonplan(4,"-40%","Quincaillerie Tunis","Remise sur tous les articles.");
        Bonplan bp4=new Bonplan(5,"-20%","Quincaillerie Sidi Bou Said","Remise sur tous les articles.");
        bonplandao.insertBonplan(bp);
        bonplandao.insertBonplan(bp1);
        bonplandao.insertBonplan(bp2);
        bonplandao.insertBonplan(bp3);
        bonplandao.insertBonplan(bp4); */
        //end insert
    }
    public void acessDatabase()
    {
        mydatabase= myDatabase.getDatabase(BonPlanActivity.this);
        bonplandao=mydatabase.bonplanDAO();
    }}