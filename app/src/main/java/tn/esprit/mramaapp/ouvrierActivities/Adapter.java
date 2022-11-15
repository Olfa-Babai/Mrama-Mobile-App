package tn.esprit.mramaapp.ouvrierActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.clientActivities.OutillageActivity;
import tn.esprit.mramaapp.daos.MaterielDAO;
import tn.esprit.mramaapp.daos.UtilisateurDAO;
import tn.esprit.mramaapp.database.myDatabase;
import tn.esprit.mramaapp.entities.Utilisateur;
import tn.esprit.mramaapp.entities.datas;


public class Adapter extends RecyclerView.Adapter<ItemViewHolder> {

    List<Utilisateur> ouvList;
    myDatabase mydatabase;
    MaterielDAO materieldao;
    UtilisateurDAO utilisateurDAO;


    Adapter(Context context) {
        acessDatabase(context);
        ouvList =utilisateurDAO.getAllUtilisateurs();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new ItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Utilisateur a = ouvList.get(position);

        holder.nom.setText(a.getNom());
        holder.tel.setText(String.valueOf(a.getService()));
        holder.mail.setText(String.valueOf(a.getMail()));
        holder.img.setImageResource(R.drawable.rajelmodified);
                //ImageView img= (ImageView) findViewById(R.id.image);
        //img.setImageResource(R.drawable.my_image);

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), a.getNom() + " Clicked", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return ouvList.size();
    }


      public void setOuvriers(List<Utilisateur> u){
        this.ouvList=u;
        notifyDataSetChanged();
    }


    public void acessDatabase(Context context)
    {
        mydatabase= myDatabase.getDatabase(context);
        materieldao=mydatabase.materielDAO();
        utilisateurDAO=mydatabase.utilisateurDAO();
    }

}

/*
public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private ArrayList<ouv> dataList;

    public Adapter(ArrayList<ouv> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.activity_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtNama.setText(dataList.get(position).getNama());
        holder.txtNpm.setText(dataList.get(position).getNpm());
        holder.txtNoHp.setText(dataList.get(position).getNohp());
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNpm, txtNoHp;

        public ViewHolder(View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txt_nama_mahasiswa);
            txtNpm = itemView.findViewById(R.id.txt_npm_mahasiswa);
            txtNoHp = itemView.findViewById(R.id.txt_nohp_mahasiswa);
        }
    }*/
