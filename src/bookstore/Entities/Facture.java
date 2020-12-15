package bookstore.Entities;

import java.sql.Date;
import java.util.ArrayList;

public class Facture {

private int id_facture ;
private int id_commande ;
private int id_utilisateur ;
private String date_facture ;
private float prix_total; 


public Facture() {
     
    }
    public Facture(int id_Facture, int id_utilisateur,String date_facture, float prix_total) {
        this.id_facture = id_facture;
        
        this.id_utilisateur = id_utilisateur;
        this.date_facture = date_facture;
        this.prix_total = prix_total;
    }


    public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }


//    public Facture(String date_fact) {
//////        Client c = null;
//        Livre l = null;
//        Commande cc = null;
//        this.idCommande = cc.getId_commande();
////        this.id_client = c.getId_user();
//        this.date_fact = date_fact;
//    }
//    @Override
//    public int hashCode() {
//        int hash = 3;
//        hash = 17 * hash + Float.floatToIntBits(this.idFacture);
//        return hash;
//    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Facture other = (Facture) obj;
//        if ((this.idFacture != other.idFacture) && (this.idCommande != other.idCommande) &&(this.id_client != other.id_client)) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        return "Facture{" + "id_facture=" + id_facture + ", id_utilisateur=" + id_utilisateur + ", date_facture=" + date_facture + ", prix_Total=" + prix_total+ '}';
    }

    public int getId_facture() {
        return id_facture;
    }

    public void setId_facture(int id_facture) {
        this.id_facture = id_facture;
    }

   
   

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

   
    public String getDate_facture() {
        return date_facture;
    }

    public void setDate_facture(String date_facture) {
        this.date_facture = date_facture;
    }


//    public void imprimer()
//    {}
    public void telecharger()
    {}
    public void envoyer()
    {}

    
}
