/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.Testing;

import bookstore.Entities.Panier_utilisateur;
import bookstore.Services.PanierService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PasserCommandeController implements Initializable {

    @FXML
    private Button confirm_btn_id;
    @FXML
    private Button annuler_btn_id;
    
    @FXML
    private Text idTotal;
//    @FXML
//    private AnchorPane table_commande;
    
//    @FXML
//    private AnchorPane table_commande;
   @FXML
    private TableView<Panier_utilisateur> table_panier;
    
  

    @FXML
    private TableColumn<Panier_utilisateur, Integer> nomlivre_id;

    @FXML
    private TableColumn<Panier_utilisateur, Float> prix;

    @FXML
    private TableColumn<Panier_utilisateur, Integer> Quantite;
    @FXML
    private AnchorPane table_commande;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         PanierService ps = new PanierService();

        List<Panier_utilisateur> myList = ps.afficher();
        System.out.println(myList);

  nomlivre_id.setCellValueFactory(new PropertyValueFactory<>("id_livre"));   
    prix.setCellValueFactory(new PropertyValueFactory<>("prix_livre"));  
    Quantite.setCellValueFactory(new PropertyValueFactory<>("quantité_livre"));  
//    supprimer.setCellValueFactory(new PropertyValueFactory<>("supprimer"));  

        table_panier.getItems().setAll(myList);
        
        
        
//       PanierService ps = new PanierService();
//       System.out.println(ps.PrixLivres());
//       idTotal.setText(String.valueOf(ps.PrixLivres()+" dt "));
    }    

    @FXML
    private void onCliqConfirmer(ActionEvent event) throws IOException {
        
         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Paiement.fxml"));
        
        Parent root =fxmlLoader.load();
        
         PaiementController rv=fxmlLoader.getController();
          
         Stage stage=new Stage();
         stage.setScene(new Scene(root));
         stage.show();
    }

    @FXML
    private void onCliqAnnuler(ActionEvent event) {
    }
    
}
