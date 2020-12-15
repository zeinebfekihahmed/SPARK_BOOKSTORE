/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.connexional.gui;

import edu.connexionalt.entities.Livre;
import edu.connexionalt.services.LivreCRUD;
import edu.connexionalt.test.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Helmi
 */
public class LiserLivreController implements Initializable {

    @FXML
    private TableView<Livre> ListeLivre;
    @FXML
    private TableColumn<Livre, Integer> col_id;
    @FXML
    private TableColumn<Livre, String> col_nom;
    @FXML
    private TableColumn<Livre, String> col_auteur;
    @FXML
    private TableColumn<Livre, Integer> col_prix;
    @FXML
    private TableColumn<Livre, String> col_date;
    @FXML
    private TableColumn<Livre, String> col_cat;
    @FXML
    private TableColumn<Livre, String> col_des;

    ObservableList<Livre> oblist= FXCollections.observableArrayList();
    int index=-1;
    @FXML
    private Button btn_back;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        LivreCRUD lc=new LivreCRUD();
          for(Livre p1 : lc.listerLivre()){
            oblist.add(new Livre(p1.getId(), p1.getNom(), p1.getPrix(), p1.getNom_auteur(), p1.getDate(),p1.getDescription(),p1.getCatégorie()));
        }
      col_id.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("id"));
         col_nom.setCellValueFactory(new PropertyValueFactory<Livre,String>("nom"));
             col_auteur.setCellValueFactory(new PropertyValueFactory<Livre,String>("nom_auteur"));
         col_prix.setCellValueFactory(new PropertyValueFactory<Livre,Integer>("prix"));
         col_date.setCellValueFactory(new PropertyValueFactory<Livre,String>("date"));
         col_cat.setCellValueFactory(new PropertyValueFactory<Livre,String>("catégorie"));
         col_des.setCellValueFactory(new PropertyValueFactory<Livre,String>("description"));
        ListeLivre.setItems(oblist);

}

    @FXML
    private void goback(ActionEvent event) {
        try {
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("GestionLivre.fxml"));
            Parent root2=Loader.load();
            GestionLivreController pc2=Loader.getController();
           
            btn_back.getScene().setRoot(root2);
        } catch (IOException ex) {
            Logger.getLogger(LiserLivreController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
