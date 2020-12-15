/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bookstore.services;

import edu.bookstore.entites.Offre;
import edu.bookstore.test.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Dridi
 */
public class OffreCRUD {

    Connection cnx;

    public OffreCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }

    public void afficherOffre(Offre f) {

//        try {
//            String requete = "SELECT * FROM offre ";
//            PreparedStatement pst = cnx.prepareStatement(requete);
//            ResultSet rs = pst.executeQuery();
//            while (rs.next()) {
//       
//                System.out.println(rs.getInt("id"));
//                System.out.println(rs.getString("nomOffre"));
//                System.out.println(rs.getDate("date_debut"));
//                System.out.println(rs.getDate("date_fin"));
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    public void ajouterOffre(Offre f) {
        try {
//            String requete = "INSERT INTO personne(nom,prenom) "
//                    + "VALUES ('"+p.getNom()+"','"+p.getPrenom()+"')";

            String requete = "INSERT INTO offre(nomOffre,date_debut,date_fin,remise) "
                    + "VALUES (?,?,?,?)";

            PreparedStatement pst = cnx.prepareStatement(requete);

            pst.setString(1, f.getNom());
            pst.setDate(2, f.getDateDebut());
            pst.setDate(3, f.getDateFin());
            pst.setInt(4, f.getRemise());

            pst.executeUpdate();
            System.out.println("Offre ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public boolean supprimerOffre(Offre f) {
        boolean etat = false;
        try {
            String requete = "DELETE FROM offre WHERE id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, f.getId());
            pst.executeUpdate();
            System.out.println("Offre supprimée");
            etat = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            etat = false;
        }
        return etat;
    }

    public void modiferOffre(Offre f, int id) {
        try {
            String requete = "UPDATE offre set nomOffre=? where id=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, f.getNom());
            pst.setInt(2, id);
            pst.executeUpdate();
            System.out.println("offre modifié");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
