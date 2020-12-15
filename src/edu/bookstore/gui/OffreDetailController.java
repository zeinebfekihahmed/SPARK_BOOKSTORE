/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bookstore.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Dridi
 */
public class OffreDetailController implements Initializable {

    @FXML
    private Button btna;
    @FXML
    private Button btns;
    @FXML
    private Button btnm;
    @FXML
    private Button btnc;
    @FXML
    private AnchorPane background;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void OnAjout(ActionEvent event) {
        try {
            Stage primaryStage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("AjouterOffre.fxml"));
            Scene scene = new Scene(root, 612,512);
            primaryStage.setTitle("Gestion des offres");
            String css =OffreWindow.class.getResource("FichierCss.css").toExternalForm();
            scene.getStylesheets().add(css);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    @FXML
    private void OnSupprime(ActionEvent event) {
        try {
            Stage primaryStage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("SuppOffre.fxml"));
            Scene scene = new Scene(root, 612,512);
            primaryStage.setTitle("Gestion des offres");
            String css =OffreWindow.class.getResource("FichierCss.css").toExternalForm();
            scene.getStylesheets().add(css);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void OnModifie(ActionEvent event) {
        try {
            Stage primaryStage=new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ModifierOffre.fxml"));
            Scene scene = new Scene(root, 612,512);
            primaryStage.setTitle("Gestion des offres");
            String css =OffreWindow.class.getResource("FichierCss.css").toExternalForm();
            scene.getStylesheets().add(css);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    private void OnClose(ActionEvent event) {
        Stage stage=(Stage) btnc.getScene().getWindow();
        stage.close();
    }
    
}
