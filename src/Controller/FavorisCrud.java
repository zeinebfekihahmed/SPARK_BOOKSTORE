/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.Favoris;
import Connection.ConnectionLivre;
import static Controller.LivreCRUD.cnx;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

/**
 *
 * @author Ghazi
 */
public class FavorisCrud {

    Connection cnx;

    public FavorisCrud() {
        cnx = ConnectionLivre.instance.getCnx();
    }

    int current_user_id;

    public int  getidLiv(String nom) {
        int idliv=0;
        try {
            
            String req1 = "SELECT * FROM livre";
            Statement s = cnx.createStatement();

            ResultSet res = s.executeQuery(req1);
            while (res.next()) {
                if(res.getString("nom_livre").equals(nom)) {
                    idliv = res.getInt("id_livre");
            }
     
            }
        } catch (SQLException ex) {
            System.err.println("erreur " + ex);
        }
        return idliv;
    }

    public void ajouterLivre(Favoris f,String s) {
        int idL=0;
        idL=getidLiv(s);
        System.out.println("id liv test : "+idL);
        try {

            String requete = "insert into Favoris VALUES (?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, f.getId());
            pst.setInt(2, idL);
            pst.setInt(3, 1);
            pst.executeUpdate();
            System.out.println("Livre ajouté!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void readBooks(ObservableList<Favoris> favorsList) {

        try {
            String req = "select * from Favoris, livre  where idUser=1 and Favoris.id_livre= livre.id_livre";
            PreparedStatement st = cnx.prepareStatement(req);
            ResultSet res = st.executeQuery();
            Favoris fav;
            while (res.next()) {
                fav = new Favoris();
                fav.setIdLivre(res.getInt("id_livre"));
                fav.setId_user(res.getInt("idUser"));
                fav.setImage(res.getString("image"));
                fav.setPrix(res.getDouble("prix_livre"));
                fav.setNomLivre(res.getString("nom_livre"));
                int favorId = res.getInt("id");

                fav.setId(favorId);
                favorsList.add(fav);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public boolean supprimerLivre(Favoris p) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM Favoris WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, p.getId());
            pst.executeUpdate();
            System.out.println("Livre supprimé");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;
    }

    public void modifierLivre(Favoris l, int id) {
        try {
            String requete = "UPDATE Favoris set idLivre=?" + "WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, l.getIdLivre());
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("livre modifié");
        } catch (SQLException ex) {

            System.out.println("livre non  modifié");

        }

    }
}
