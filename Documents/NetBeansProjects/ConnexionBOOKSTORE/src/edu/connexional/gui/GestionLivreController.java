/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexional.gui;

import edu.connexionalt.entities.Livre;
import edu.connexionalt.services.LivreCRUD;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class GestionLivreController implements Initializable {

    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_list;
    @FXML
    private Button btn_supp;
    @FXML
    private Button btn_modifier;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AjoutLivre(ActionEvent event) {
        try {
            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("AjoutLivre.fxml"));
            Parent root3 = Loader.load();
            AjoutLivreController load = Loader.getController();
           btn_ajout.getScene().setRoot(root3);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void ListerLivre(ActionEvent event) {
        try {

            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("LiserLivre.fxml"));
            Parent root2 = Loader.load();
            LiserLivreController load = Loader.getController();
            btn_list.getScene().setRoot(root2);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    private void supprimerLivre(ActionEvent event) {
        try {
            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
            Parent root2 = Loader.load();
            FXMLController load = Loader.getController();
            btn_supp.getScene().setRoot(root2);
        } catch (IOException ex) {
            Logger.getLogger(GestionLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ModifierLivre(ActionEvent event) {
          try {
            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("ModifierLivre.fxml"));
            Parent root2 = Loader.load();
              ModifierLivreController load = Loader.getController();
            btn_modifier.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            Logger.getLogger(GestionLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
