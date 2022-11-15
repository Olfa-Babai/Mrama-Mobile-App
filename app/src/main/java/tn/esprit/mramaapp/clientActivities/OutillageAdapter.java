package tn.esprit.mramaapp.clientActivities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.entities.Materiel;

public class OutillageAdapter extends RecyclerView.Adapter<OutillageAdapter.OutillageHolder> {

    List<Materiel> outils=new ArrayList<>();

    class OutillageHolder extends  RecyclerView.ViewHolder{

        private TextView nomOutil;
        private TextView dOutil;
        private TextView prixOutil;

        public OutillageHolder(@NonNull View itemView) {
            super(itemView);
            nomOutil=itemView.findViewById(R.id.nom);
            dOutil=itemView.findViewById(R.id.dispo);
            prixOutil=itemView.findViewById(R.id.prix);

        }
    }


    @NonNull
    @Override
    public OutillageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item,parent,false);
        return new OutillageHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull OutillageHolder holder, int position) {
        Materiel currentOutil=outils.get(position);
        holder.nomOutil.setText(currentOutil.getNom());
        holder.prixOutil.setText(String.valueOf(currentOutil.getPrix())+"dt");
        holder.dOutil.setText(currentOutil.getDisponibilite());
    }

    @Override
    public int getItemCount() {
        return outils.size();
    }

    public void setOutils(List<Materiel> o){
        this.outils=o;
        notifyDataSetChanged();
    }
}
