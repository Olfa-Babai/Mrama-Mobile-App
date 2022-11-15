package tn.esprit.mramaapp.ouvrierActivities;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import tn.esprit.mramaapp.R;

public class ItemViewHolder extends RecyclerView.ViewHolder {


    TextView nom;
    TextView mail;
    TextView service;
    TextView role;
    TextView categoriesu;
    TextView tel;
    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        nom = itemView.findViewById(R.id.nom);
        mail = itemView.findViewById(R.id.prix);
      //  service = itemView.findViewById(R.id.service);
       // role = itemView.findViewById(R.id.role);
        //categoriesu = itemView.findViewById(R.id.categoriesu);
        tel = itemView.findViewById(R.id.dispo);



    }
}
