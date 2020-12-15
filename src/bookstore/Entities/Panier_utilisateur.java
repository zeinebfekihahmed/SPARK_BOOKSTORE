package bookstore.Entities;

import bookstore.Services.PanierService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;

public class Panier_utilisateur extends Panier {

    private int id_panier;
    private int id_utilisateur;
     private int id_livre;
      private float prix_livre;
    private float prix_total;
    private int quantité_livre;
    private Button supprimer;

    public Panier_utilisateur() {
    }

    public Panier_utilisateur(int id_panier, int id_utilisateur,int id_livre, float prix_livre, int quantité_livre, Button supprimer) {
        this.id_panier = id_panier;
        this.id_utilisateur = id_utilisateur;
        this.id_livre = id_livre;
        this.prix_livre = prix_livre;
        this.quantité_livre = quantité_livre;
        this.supprimer = supprimer;
    }

    public Panier_utilisateur(int id_panier, int id_utilisateur,int id_livre, float prix_livre, int quantité_livre) {
        this.id_panier = id_panier;
        this.id_utilisateur = id_utilisateur;
        this.id_livre=id_livre;
        this.prix_livre = prix_livre;
        this.quantité_livre = quantité_livre;

    } public float getPrix_total() {
        return prix_total;
    }

    public void setPrix_total(float prix_total) {
        this.prix_total = prix_total;
    }

    public int getId_panier() {
        return id_panier;
    }

    public void setId_panier(int id_panier) {
        this.id_panier = id_panier;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }
 public int getId_livre() {
        return id_livre;
    }

    public void setId_livre(int id_livre) {
        this.id_utilisateur = id_livre;
    }
    
    
   

    public float getPrix_livre() {
        return prix_livre;
    }

    public void setPrix_livre(float prix_livre) {
        this.prix_livre = prix_livre;
    }

    public int getQuantité_livre() {
        return quantité_livre;
    }

    public void setQuantité_livre(int quantité_livre) {
        this.quantité_livre = quantité_livre;
    }

    public Button getSupprimer() {
        return supprimer;
    }

    public void setSupprimer(Button supprimer) {
        this.supprimer = supprimer;
    }

    @Override
    public void retirerLivre(Livre b) {
        PanierService ps = new PanierService();
        ps.supprimer(this.id_panier);
    }

    @Override
    public int modifierQuantité(ArrayList<Livre> list) {

        PanierService ps = new PanierService();
        try {
            ps.modifier(this.quantité_livre, this.id_panier);
        } catch (SQLException ex) {
            Logger.getLogger(Panier_utilisateur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps.afficherQ();

    }

    @Override
    public String toString() {
        return "Panier{" + "id_panier=" + id_panier + ", id_utilisateur=" + id_utilisateur  + ", prix=" + prix_livre + ", prix_total=" + prix_total+", quantité_livre" + quantité_livre + '}';
    }

}
