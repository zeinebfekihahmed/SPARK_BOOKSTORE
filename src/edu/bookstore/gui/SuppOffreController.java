/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bookstore.gui;

import com.mysql.jdbc.MySQLConnection;
import edu.bookstore.entites.Offre;
import edu.bookstore.services.OffreCRUD;
import edu.bookstore.test.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dridi
 */
public class SuppOffreController implements Initializable {

    Connection cnx;
    @FXML
    private TableView<Offre> table;
    private TableColumn<Offre, Integer> col_id;
    @FXML
    private TableColumn<Offre, String> col_nom;
    @FXML
    private TableColumn<Offre, Date> col_dd;
    @FXML
    private TableColumn<Offre, Date> col_df;
    @FXML
    private Button btns;

     ObservableList<Offre> data = FXCollections.observableArrayList();
    @FXML
    private TableColumn<Offre, Integer> col_re;

    

  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cnx = MyConnection.getInstance().getCnx();
            String requete = "SELECT * FROM offre ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new Offre(rs.getInt("id"), rs.getString("nomOffre"), 
                        rs.getDate("date_debut"), rs.getDate("date_fin"),rs.getInt("remise")));

            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_dd.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        col_df.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        col_re.setCellValueFactory(new PropertyValueFactory<>("remise"));
        table.setItems(data);
    }

    @FXML
    private void OnDelete(ActionEvent event) {
       
        
        try {
            
            Offre off = table.getSelectionModel().getSelectedItem();
             
            String requete = "delete from offre where id =? ";
            PreparedStatement pst = cnx.prepareStatement(requete);
          
            pst.setInt(1,off.getId());

             pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Delete");
           // UpdateTable();
            table.getItems().removeAll(table.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Table est vide");
        }

       
    }

    private void UpdateTable() {
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_dd.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        col_df.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        col_re.setCellValueFactory(new PropertyValueFactory<>("remise"));
        
       //data = MyConnection.getData();
        table.setItems(data);
    }

}