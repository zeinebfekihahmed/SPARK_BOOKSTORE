/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.inter;

import entites.alt.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import services.alt.SendMailJava;
import services.alt.UtilisateurCRUD;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class InscriptionFXMLController implements Initializable {

    @FXML
    private TextField name;
    @FXML
    private TextField userName;
    @FXML
    private TextArea address;
    @FXML
    private TextField email;
    @FXML
    private TextField login;
    @FXML
    private PasswordField mdp;
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
    public void SavePerson(ActionEvent event){
        try{
        System.err.println("Sauvegarde dans la base");
        String tnom= name.getText();
        String tprenom= userName.getText();
        String tadresse= address.getText();
        String temail= email.getText();
        String tlogin= login.getText();
        String tmotdepasse= mdp.getText();
        Utilisateur u= new Utilisateur (tnom, tprenom, tadresse,temail, tlogin,tmotdepasse,"utilisateur");
        UtilisateurCRUD uc= new UtilisateurCRUD();
        uc.ajouterUtilisateur(u);
        SendMailJava.sendMail(temail,"WELCOME TO GRANDMA","Congratulations, you are registred");
        System.err.println("====REDIRECTION====");
          FXMLLoader loader = new FXMLLoader(getClass().getResource("UtilisateurDetails.fxml"));
        Parent root2 = loader.load();
        UtilisateurDetailsController uc1 = loader.getController();
        uc1.setdtnom(tnom);
        uc1.setdtprenom(tprenom);
        uc1.setdtadresse(tadresse);
        uc1.setdtemail(temail);
        uc1.setdtlogin(tlogin);
        uc1.setdtmotdepasse(tmotdepasse);
        name.getScene().setRoot(root2);}
     catch(IOException ex)
        {System.err.println(ex.getMessage());
        }

    
        
        
    
}}
