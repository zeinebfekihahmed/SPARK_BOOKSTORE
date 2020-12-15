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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class UtilisateurInterController implements Initializable {

    @FXML
    private Label User;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          User.setText(UserSession.getInstance().toString());
        // TODO
    }    

    @FXML
    private void LogOut(ActionEvent event) {
         UserSession.CleanUser("");
        System.out.println(UserSession.getInstance());
        try {
               
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));

             Parent root6=(Parent) loader.load();
             LoginController rc = loader.getController();
             Stage stage=new Stage();
             stage.setScene(new Scene(root6));
             stage.show();
             
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    
}
