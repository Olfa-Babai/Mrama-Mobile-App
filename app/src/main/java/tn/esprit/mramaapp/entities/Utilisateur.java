package tn.esprit.mramaapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "utilisateur")
public class Utilisateur {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "tel")
    private int tel;
    @ColumnInfo(name = "mail")
    private String mail;
    @ColumnInfo(name = "pwd")
    private String pwd;
    @ColumnInfo(name = "service")
    private String service;
    @ColumnInfo(name = "role")
//    @Enumerated(EnumType.STRING)
    private String role;
    @ColumnInfo(name = "categoriesu")
    private String categoriesu;

    public Utilisateur(int id, String nom, int tel, String mail,String pwd, String service, String role, String categoriesu) {
        this.id = id;
        this.nom = nom;
        this.tel = tel;
        this.mail = mail;
        this.pwd = pwd;
        this.service = service;
        this.role = role;
        this.categoriesu = categoriesu;
    }

    public Utilisateur(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }
    public String getPwd() {
        return pwd;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCategoriesu() {
        return categoriesu;
    }

    public void setCategoriesu(String categoriesu) {
        this.categoriesu = categoriesu;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +

                ", tel=" + tel +
                ", mail='" + mail + '\'' +
                ", pwd='" + pwd + '\'' +
                ", service='" + service + '\'' +
                ", role=" + role +
                ", categoriesu=" + categoriesu +
                '}';
    }
}
