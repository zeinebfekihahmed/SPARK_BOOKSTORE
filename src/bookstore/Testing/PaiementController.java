/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Testing;

import bookstore.Entities.Facture;
import bookstore.Services.FactureService;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PaiementController implements Initializable {

    @FXML
    private TextField tel_id;
    @FXML
    private TextField prenom_id;
    @FXML
    private TextField adresse_id;
    @FXML
    private TextField code_id;
    @FXML
    private TextField num_compte_id;
    @FXML
    private Button payer_btn_id;
    @FXML
    private Button annuler_btn_id;
    @FXML
    private TextField nom_id;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onCliqPayer(ActionEvent event) throws IOException{
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("commandeFaite.fxml"));
        
        Parent root =fxmlLoader.load();
        
         CommandeFaiteController rv=fxmlLoader.getController();
          
         Stage stage=new Stage();
         stage.setScene(new Scene(root));
         stage.show();
           
           
    }

    @FXML
    private void onCliqAnnuler(ActionEvent event) {
    }
    
}
