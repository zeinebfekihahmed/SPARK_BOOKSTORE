/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.inter;

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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UtilisateurDetailsController implements Initializable {

    @FXML
    private TextField tfname;
    @FXML
    private TextField tfuserName;
    @FXML
    private TextArea tfaddress;
    @FXML
    private PasswordField tfmdp;
    @FXML
    private TextField tflogin;
    @FXML
    private Label invalidName;
    @FXML
    private Label invalidEmail;
    @FXML
    private Label invalidAddress;
    @FXML
    private Label invalidPassword;
    @FXML
    private Label invalidMatch;
    @FXML
    private TextField tfemail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setdtnom(String message) {
        this.tfname.setText(message);
    }

    public void setdtprenom(String message) {
        this.tfuserName.setText(message);
    }

    public void setdtadresse(String message) {
        this.tfaddress.setText(message);
    }

    public void setdtemail(String message) {
        this.tfemail.setText(message);}
            

    public void setdtlogin(String message) {
        this.tflogin.setText(message);
    }

    public void setdtmotdepasse(String message) {
        this.tfmdp.setText(message);
    }

}

