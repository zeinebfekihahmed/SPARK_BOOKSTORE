/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Livre;
import Connection.ConnectionLivre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableList;
import javafx.collections.ObservableList;

/**
 *
 * @author House
 */
public class LivreCRUD {

    static Connection cnx;

    public LivreCRUD() {
        cnx = ConnectionLivre.getInstance().getCnx();
    }

    public void ajouterLivre() {
        try {
            String requete = "INSERT INTO livre(nom_livre,nom_auteur,date_edition,prix_livre) VALUES"
                    + " ('tafkir al ijebi','50')";
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Livre ajouté au panier!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void ajouterLivre(Livre l) {
        try {
//            String requete = "INSERT INTO personne(nom,prenom) "
//                    + "VALUES ('"+p.getNom()+"','"+p.getPrenom()+"')";

            String requete = "INSERT INTO livre(nom_livre,nom_auteur,date_edition,prix_livre,description,catégorie,image)"
                    + "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, l.getNom());
            pst.setString(2, l.getNom_auteur());
            pst.setString(3, l.getDate());
            pst.setDouble(4, l.getPrix());
            pst.setString(5, l.getDescription());
            pst.setString(6, l.getCatégorie());
             pst.setString(7, l.getImage());

            pst.executeUpdate();
            System.out.println("Livre ajouté!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
    public void readBooks(ObservableList<Livre> bookList) {
        try {
            String req = "select * from livre";
            PreparedStatement st = cnx.prepareStatement(req);
            ResultSet res = st.executeQuery();
            Livre b;
            while (res.next()) {
                b = new Livre();
                b.setNom(res.getString("nom_livre"));
                b.setPrix(res.getDouble("prix_livre"));
                b.setDescription(res.getString("description"));
                b.setImage(res.getString("image"));
               
                int bookId = res.getInt("id_livre");
    
                
                b.setId(bookId);
                bookList.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean supprimerLivre(int p) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM livre WHERE id_livre=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p);
            pst.executeUpdate();
            System.out.println("Livre supprimé");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;
    }

    public void modifierLivre(Livre l, int id) {
        try {
            String requete = "UPDATE livre set nom_livre=?,nom_auteur=?,date_edition=?,prix_livre=?,description=?,catégorie=?" + "WHERE id_livre=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, l.getNom());
            pst.setString(2, l.getNom_auteur());
            pst.setString(3, l.getDate());
            pst.setDouble(4, l.getPrix());
            pst.setString(5, l.getDescription());
            pst.setString(6, l.getCatégorie());
            pst.setInt(7, id);
            pst.executeUpdate();
            System.out.println("livre modifié");
        } catch (SQLException ex) {

            System.out.println("livre non  modifié");

        }

    }
}
