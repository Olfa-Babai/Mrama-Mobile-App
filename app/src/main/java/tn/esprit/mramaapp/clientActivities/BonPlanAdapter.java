package tn.esprit.mramaapp.clientActivities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mramaapp.R;
import tn.esprit.mramaapp.entities.Bonplan;

public class BonPlanAdapter extends RecyclerView.Adapter<BonPlanAdapter.BonPlanHolder> {
    List<Bonplan> bonplans = new ArrayList<>();

    @NonNull
    @Override
    public BonPlanHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_item, parent, false);
        return new BonPlanAdapter.BonPlanHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BonPlanHolder holder, int position) {
        Bonplan currentBonPlan = bonplans.get(position);
        holder.description.setText(currentBonPlan.getDescription());
        holder.solde.setText(String.valueOf(currentBonPlan.getSolde()));
        holder.lieu.setText(currentBonPlan.getLieu());
        holder.img.setImageResource(R.drawable.plan);
    }

    @Override
    public int getItemCount() {
        return bonplans.size();
    }

    public class BonPlanHolder extends RecyclerView.ViewHolder {
        private TextView description;
        private TextView solde;
        private TextView lieu;
        private ImageView img;

        public BonPlanHolder(@NonNull View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.nom);
            lieu = itemView.findViewById(R.id.dispo);
            solde = itemView.findViewById(R.id.prix);
            img = itemView.findViewById(R.id.imgrecycle);
        }
    }

    public void setBonplans(List<Bonplan> b) {
        this.bonplans = b;
        notifyDataSetChanged();
    }

}
