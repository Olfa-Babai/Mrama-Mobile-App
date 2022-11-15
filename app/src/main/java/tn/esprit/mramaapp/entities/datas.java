package tn.esprit.mramaapp.entities;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import tn.esprit.mramaapp.LoginvActivity;

public class datas {

    private  static List<Utilisateur> ouvriers ;
    private  static List<Utilisateur> clients ;
    private List<Avis> avis ;


    public datas() {
        ouvriers= new ArrayList<>();
         clients= new ArrayList<>();
         avis= new ArrayList<>();
     }

    public List<Utilisateur> getOuvriers() {
        ouvriers.add(new Utilisateur(2, "olfa babai", 50288699, "olfa.babai@gmail.com", "olfa123", "disponible 7j/7", Role.ouvrier.name(), CategoriesU.Chauffeur.name()));
        ouvriers.add(new Utilisateur(3, "sirine hjaij", 54243838, "sirine.hjaij@gmail.com", "monte les murs", "sirine123", Role.ouvrier.name(), CategoriesU.Chauffeur.name()));
        return ouvriers;
    }

    public List<Utilisateur> getClients(){
        clients.add(new Utilisateur(1,"eya ouellani",54243838,"eya.ouellani@gmail.com","eya123","",Role.client.name(), null));
        clients.add(new Utilisateur(4,"maryem slaimi",54243838,"maryem.slaimi@gmail.com","maryem123","",Role.client.name(), null));
        return clients;
    }

    public List<Utilisateur> addOuvrier(Utilisateur u){
        ouvriers.add(u);
        return ouvriers;
    }

    public List<Utilisateur> addClient(Utilisateur u){
        clients.add(u);
        return clients;
    }
    public List<Avis> getAvis(){
        avis.add(new Avis(1,"eya ouellani","eya.ouellani@gmail.com"));
        avis.add(new Avis(4,"maryem slaimi","maryem.slaimi@gmail.com"));
        return avis;
    }

    public List<Avis> addAvis(Avis u){
        avis.add(u);
        return avis;
    }

    public boolean loginPwd(String role,String email,String pwd){
        Utilisateur u=getUser(role, email);
        return pwd.equals(u.getPwd());
    }

    public String loginOrientation(String email){
        String role="";
        ouvriers=getOuvriers();
        clients=getClients();
        for(Utilisateur u : ouvriers){
            if(u.getMail().equals(email)){
                System.out.println(u.getNom());
               role="ouvrier";
            }
        }
        for(Utilisateur u : clients){
            if(u.getMail().equals(email)){
                System.out.println(u.getNom());
                role="client";
            }
        }
        return role;
    }

    public Utilisateur getUser(String role,String email){
       Utilisateur ut=new Utilisateur();
            for(Utilisateur u : getOuvriers()){
                if(u.getMail().equals(email)){
                    ut=u;
                }
            }
        return ut;
    }

    public void UpdateOuvrier(Utilisateur ov)
    {
        Utilisateur u=getUser(ov.getRole(),ov.getMail());
        System.out.println(ouvriers.indexOf(u));
       ouvriers.set(ouvriers.indexOf(u),ov);
       System.out.println(ouvriers.get(2));

        }
    }



