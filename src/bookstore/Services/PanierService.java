package bookstore.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.Testing.DBConnection;
import bookstore.Entities.Panier_utilisateur;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanierService {

    Connection cnx = DBConnection.getInstance().getCnx();

    public void ajouter(Panier_utilisateur p) throws SQLException {

        String requete1 = "INSERT INTO panier_utilisateur (id_utilisateur, id_livre, prix,quantité) VALUES (?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requete1);

        pst.setInt(1, p.getId_utilisateur());
        pst.setInt(2, p.getId_livre());
        pst.setFloat(3, p.getPrix_livre());
        pst.setInt(4, p.getQuantité_livre());
        pst.executeUpdate();
        System.out.println("livre ajouté au panier");
        try {
            pst = cnx.prepareStatement(requete1);
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void supprimer(int i) {
        String req = "DELETE From panier_utilisateur WHERE panier_utilisateur.id_livre=?";
        try {
 PreparedStatement pst2 = cnx.prepareStatement(req);
            pst2.setInt(1, i);
            pst2.executeUpdate();
          
            System.out.println("livre supprimé du panier");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

      public void ViderPanier(){
        String req3 = "TRUNCATE TABLE panier_utilisateur";
        try {
 PreparedStatement pst3 = cnx.prepareStatement(req3);
        
            pst3.executeUpdate(req3);
          
            System.out.println("panier supprimé");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//  public void ValiderCommande() {
//
//            System.out.println("Commande validée");
//            //JOptionPane.showMessageDialog(null, "Commande validée");
//           NotificationAPI.notif("panier", "panier validé");
//    }

    
    
    
    public void modifier(int quantité_livre, int id_livre) throws SQLException {
        
        
        String requete5 = "UPDATE panier_utilisateur SET quantité = ?  WHERE id_livre = ?";

        try {

            PreparedStatement pst2 = cnx.prepareStatement(requete5);
            pst2.setInt(1, quantité_livre);
            pst2.setInt(2, id_livre); 
            pst2.executeUpdate();
            System.out.println("quantité modifiée");
            

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
 
      
      
    public List<Panier_utilisateur> afficher() {
        List<Panier_utilisateur> list = new ArrayList<>();
        String req = "SELECT * from panier_utilisateur ";
        try {

            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                list.add(new Panier_utilisateur(res.getInt("id_panier"), res.getInt("id_utilisateur"),res.getInt("id_livre"),  res.getFloat("prix"),res.getInt("quantité")));
            }
         
            
            System.out.println("voici la liste du panier");
            System.out.println(list);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
     
    public void affichage() {

            List<Panier_utilisateur> panier = this.afficher();
            for (Panier_utilisateur a : panier) {
                
                System.out.println(a.toString());
            
            }
    }
    

 
     
    public float PrixLivres() {
        float total=0;
        try {
            
            String req= "SELECT * FROM panier_utilisateur ";
           Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            
            while(res.next())
            {
                float tot = res.getFloat("prix");
                total= total+tot;
            }   
            
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }


public int afficherQ() {
        List<Panier_utilisateur> list = new ArrayList<>();
        String req = "SELECT quantite_ajouter from panier_utilisateur p join livre l on p.id_livre=l.id_livre";
        try {
            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                int i = res.getInt("quantité");
                return i;
            }
            System.out.println("voici la liste du panier");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }





   
}
