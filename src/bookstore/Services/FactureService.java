package bookstore.Services;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookstore.Testing.DBConnection;

import bookstore.Entities.Facture;


//import com.lowagie.text.DocumentException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactureService {
Connection cnx = DBConnection.getInstance().getCnx();

public void ajouter (Facture p) throws IOException, SQLException {
   

  String requete1 = "INSERT INTO facture (id_facture, id_utilisateur,date_facture,prix_Total) VALUES (?,?,?,?,?)";
        PreparedStatement pst = cnx.prepareStatement(requete1);

        pst.setInt(1, p.getId_facture());
        pst.setInt(2, p.getId_utilisateur());
        pst.setString(3, p.getDate_facture());
        pst.setFloat(4, p.getPrix_total() );
        pst.executeUpdate();
        System.out.println(" facture ajoutée");
        try {
            pst = cnx.prepareStatement(requete1);
        } catch (SQLException ex) {
            Logger.getLogger(PanierService.class.getName()).log(Level.SEVERE, null, ex);
        }
}

 
/*
public void supprimer (Facture p) {
	 String req ="DELETE From facture WHERE id_facture="+p.getIdFacture();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("F supprimée");
} catch (SQLException e) {
	e.printStackTrace();
}
}


public void modifier (Facture p) {
	 String req ="UPDATE facture SET date_facturation='"+p.getDate_fact();
try {
	
	Statement st = cnx.createStatement();
st.executeUpdate(req);
System.out.println("F modifiée");
} catch (SQLException e) {
	e.printStackTrace();
}
}
*/
public List<Facture> afficher() {
        List<Facture> list = new ArrayList<>();
        String req = "SELECT * from facture ";
        try {

            Statement st = cnx.createStatement();
            ResultSet res = st.executeQuery(req);
            while (res.next()) {
                list.add(new Facture(res.getInt("id_facture"),res.getInt("id_utilisateur"), res.getString("date_facture"), res.getFloat("prix_Total")));
            }
            System.out.println("voici la liste de votre facture");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public void affichage() {

            List<Facture> fact = this.afficher();
            for (Facture a : fact) {
                
                System.out.println(a.toString());
                
                
            }}

}

