package bookstore.Testing;


import bookstore.Entities.Facture;
import bookstore.Entities.Panier_utilisateur;
import bookstore.Services.PanierService;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

//public class GererPanierController extends BaseController  {

//    public GererPanierController(ViewFactory vf, String fxmlName) {
//        super(vf, fxmlName);
//    }
//    

public class GererPanierController implements Initializable {
    
    @FXML
    private TableView<Panier_utilisateur> table_panier;
    
    @FXML
    private Button passerC_btn_id;

    @FXML
    private TableColumn<Panier_utilisateur, Integer> nomlivre_id;

    @FXML
    private TableColumn<Panier_utilisateur, Float> prix;

    @FXML
    private TableColumn<Panier_utilisateur, Integer> Quantite;

//    private TableColumn<Panier_utilisateur, Button> supprimer;
//    @FXML
    private Button idsupprimer;
    
  
    
 
    public void initialize(URL url, ResourceBundle rb) {

        PanierService ps = new PanierService();

        List<Panier_utilisateur> myList = ps.afficher();
        System.out.println(myList);

        nomlivre_id.setCellValueFactory(new PropertyValueFactory<>("id_livre"));   
    prix.setCellValueFactory(new PropertyValueFactory<>("prix_livre"));  
    Quantite.setCellValueFactory(new PropertyValueFactory<>("quantité_livre"));  
//    supprimer.setCellValueFactory(new PropertyValueFactory<>("supprimer"));  

        table_panier.getItems().setAll(myList);
        
    }
    

    @FXML
    private void onCliqPasserCommande(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PasserCommande.fxml"));
        
        Parent root =fxmlLoader.load();
        
         PasserCommandeController rv=fxmlLoader.getController();
          
         Stage stage=new Stage();
         stage.setScene(new Scene(root));
         stage.show();

    }

    @FXML
    private void supprimer(ActionEvent event) {
        Panier_utilisateur p = table_panier.getSelectionModel().getSelectedItem();
        PanierService ps = new PanierService();
        ps.supprimer(p.getId_livre());
         table_panier.getItems().setAll(ps.afficher());
         
    }
}
    
    
    


