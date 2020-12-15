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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FXMLController implements Initializable {

    private TextField btn_nom;

    private Button btn_enregister;
    private TextField btn_auteur;
    private TextField btn_prix;
    private TextField btn_date;
    private TextField btn_catégorie;
    private TextField btn_description;
    private Button btn_ajout;
    @FXML
    private TextField id;
    @FXML
    private Button btn_delete;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void SaveLivre(ActionEvent event) {
   
        
    }

    @FXML
    private void DeleteLivre(ActionEvent event) {
         try {
           
            int tid = parseInt(id.getText());
            Livre l= new Livre();
            LivreCRUD livre=new LivreCRUD();
            livre.supprimerLivre(tid);
            showSuccessAlert("Done!!","Livre Supprimé");
            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("GestionLivre.fxml"));
            Parent root2=Loader.load();
            GestionLivreController pc2=Loader.getController();
           
            btn_delete.getScene().setRoot(root2);
           
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
 public void showSuccessAlert(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

  
    
}
