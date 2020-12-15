/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bookstore.gui;

import edu.bookstore.entites.Offre;
import edu.bookstore.test.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Dridi
 */
public class ModifierOffreController implements Initializable {

    Connection cnx;

    @FXML
    private TableView<Offre> table;
    @FXML
    private TableColumn<Offre, Integer> cid;
    @FXML
    private TableColumn<Offre, String> col_nom;
    @FXML
    private TableColumn<Offre, Date> col_dd;
    @FXML
    private TableColumn<Offre, Date> col_df;
    @FXML
    private TextField tfn;
    @FXML
    private TextField tfdd;
    @FXML
    private TextField tfdf;
    ObservableList<Offre> data = FXCollections.observableArrayList();
    ObservableList<Offre> dataList = FXCollections.observableArrayList();
    int index = -1;

    @FXML
    private TextField id;
    @FXML
    private TextField search;
    @FXML
    private TableColumn<Offre, Integer> col_re;
    @FXML
    private TextField tfre;

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
        cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_dd.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        col_df.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        col_re.setCellValueFactory(new PropertyValueFactory<>("remise"));
        table.setItems(data);
        search_Livre();

    }

    @FXML
    private void onUpdate(ActionEvent event) {

        try {
            cnx = MyConnection.getInstance().getCnx();
            
            String value1 = id.getText();
            String value2 = tfn.getText();
            String value3 = tfdd.getText();
            String value4 = tfdf.getText();
            String value5=tfre.getText();

            String requete = "update offre set id= '" + value1 + "',nomOffre= '" + value2 + "',Date_debut= '"
                    + value3 + "',date_fin= '" + value4 +"',remise='"+value5+ "'where id='" + value1 + "'";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.execute();

            JOptionPane.showMessageDialog(null, "Update");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    @FXML
    private void getSelected(MouseEvent event) {
        index = table.getSelectionModel().getSelectedIndex();
        if (index <= -1) {
            return;
        }
        id.setText(cid.getCellData(index).toString());
        tfn.setText(col_nom.getCellData(index));
        tfdd.setText(col_dd.getCellData(index).toString());
        tfdf.setText(col_df.getCellData(index).toString());
        tfre.setText(col_re.getCellData(index).toString());
    }

 void search_Livre() { 
     
     cid.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_dd.setCellValueFactory(new PropertyValueFactory<>("dateDebut"));
        col_df.setCellValueFactory(new PropertyValueFactory<>("dateFin"));
        table.setItems(data);
             FilteredList<Offre> filteredData = new FilteredList<>(data, b -> true);
        search.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(f -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (f.getNom().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } 
                else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<Offre> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);    
    }

    @FXML
    private void searchMethode(MouseEvent event) {
    }

}
