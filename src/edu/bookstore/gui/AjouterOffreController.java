/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bookstore.gui;

import edu.bookstore.entites.Offre;
import edu.bookstore.services.OffreCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.sql.Connection;
import java.sql.Date;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dridi
 */
public class AjouterOffreController implements Initializable {

    Connection cnx;
    @FXML
    private Button btnajou;
    @FXML
    private TextField nomOffre;
    @FXML
    private DatePicker dated;
    @FXML
    private DatePicker datef;
    @FXML
    private TextField tfr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void OnAdd(ActionEvent event) {
        try {
            //        try {
            java.util.Date dated = Date.from(this.dated.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date date_debut = new java.sql.Date(dated.getTime());

            java.util.Date datef = Date.from(this.datef.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date date_fin = new java.sql.Date(datef.getTime());

            System.out.println("=================Sauvegarde dans la base==================");
            String nomO = nomOffre.getText();
            try {
                Integer re = Integer.parseInt(tfr.getText());

                Offre f = new Offre(5, nomO, date_debut, date_fin, re);
                OffreCRUD pc = new OffreCRUD();
                pc.ajouterOffre(f);
                JOptionPane.showMessageDialog(null, "Ajouter");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "vueiller verfirier le taux de remise");
            }

            FXMLLoader loader = new FXMLLoader(getClass().getResource("OffreDetail.fxml"));
            Parent root = loader.load();
            OffreDetailController pc2 = loader.getController();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void setNomOffre(TextField nomOffre) {
        this.nomOffre = nomOffre;
    }

    public void setDated(DatePicker dated) {
        this.dated = dated;
    }

    public void setDatef(DatePicker datef) {
        this.datef = datef;
    }

}
