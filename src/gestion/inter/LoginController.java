/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.inter;

import entites.alt.Utilisateur;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import services.alt.AuthentificationCrud;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.alt.UtilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane ap;
    @FXML
    private ImageView loginIcon;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField pass;
    @FXML
    private Button bt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void handleLoginButton(ActionEvent event) {
       
        System.err.println("Authentification");
        String tname= userName.getText();
        String tmdp= pass.getText();
        AuthentificationCrud au= new AuthentificationCrud();
        if(au.Login(tname,tmdp)){
                       UserSession.getInstace(tname);
                         
            switch(au.getRole(tname)){
                case "admin" :
                     try {
               
            FXMLLoader loader=new FXMLLoader(getClass().getResource("AdminInterface.fxml"));

             Parent root3=(Parent) loader.load();
             AdminInterfaceController rc = loader.getController();
             Stage stage=new Stage();
             stage.setScene(new Scene(root3));
             stage.show();
             
        } catch (IOException ex) {
            System.err.println(ex);
        };break;
                case "utilisateur" :
                     try {
               
            FXMLLoader loader=new FXMLLoader(getClass().getResource("UtilisateurInter.fxml"));

             Parent root7=(Parent) loader.load();
             UtilisateurInterController rc = loader.getController();
             Stage stage=new Stage();
             stage.setScene(new Scene(root7));
             stage.show();
             
        } catch (IOException ex) {
            System.err.println(ex);
        };
                     System.out.println("");break;
                default:break ; 
                    
            }
            // by using our static class we'll save our user during our session 
            // System.out.println(  UserSession.getInstace(tname));
        }
         
     
           
            }
       
        


      
             
  
       
     



    @FXML
    private void SavePerson(ActionEvent event) {
        try {

            FXMLLoader loader=new FXMLLoader(getClass().getResource("InscriptionFXML.fxml"));

             Parent root4=(Parent) loader.load();
             InscriptionFXMLController rc = loader.getController();
             Stage stage=new Stage();
             stage.setScene(new Scene(root4));
             stage.show();
        } catch (IOException ex) {
            System.err.println(ex);
        }

     
    
    
}}
    

