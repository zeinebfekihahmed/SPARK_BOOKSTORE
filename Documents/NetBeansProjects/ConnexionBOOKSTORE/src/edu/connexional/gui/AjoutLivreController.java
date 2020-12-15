/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexional.gui;

import edu.connexionalt.entities.Livre;
import edu.connexionalt.services.LivreCRUD;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Helmi
 */
public class AjoutLivreController implements Initializable {

    @FXML
    private Button btn_ajout;
    @FXML
    private TextField nom;
    @FXML
    private TextField auteur;
    @FXML
    private TextField date;
    @FXML
    private TextField prix;
    @FXML
    private TextArea desc;
    @FXML
    private TextField cat;
    @FXML
    private Button btn_image;
    @FXML
    private TextField singleFileLab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SaveLivre(ActionEvent event) {
         try {
            String tNom=nom.getText();
            String tauteur=auteur.getText();
            String tdate=date.getText();
            String tdescription=desc.getText();
            String tcat=cat.getText();
            double tprix = parseInt(prix.getText());
            String timage=singleFileLab.getText();
            Livre l= new Livre(tNom,tprix,tauteur,tdate,tdescription,tcat,timage);
            LivreCRUD livre=new LivreCRUD();
            livre.ajouterLivre(l);
              showSuccessAlert("Done!!", "Livre a été ajouté avec succès");
            System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("GestionLivre.fxml"));
            Parent root2=Loader.load();
            GestionLivreController pc2=Loader.getController();
           
            btn_ajout.getScene().setRoot(root2);
           
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

    @FXML
    private void Saveimage(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg"));
        File f = fc.showOpenDialog(null);
        if (f != null) {
            singleFileLab.setText(f.getPath());
        }
    }
    
}
