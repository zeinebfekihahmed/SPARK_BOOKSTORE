/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.inter;

import entites.alt.Utilisateur;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import test.alt.MyConnection;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class AdminInterfaceController implements Initializable {

    Connection cnx;

    @FXML
    private Label titre;
    @FXML
    private ImageView img1;
    @FXML
    private Tab CommandeTab;
    @FXML
    private TableView<?> purchaseTableView;
    @FXML
    private TableColumn<?, ?> purchaseIDCol;
    @FXML
    private TableColumn<?, ?> purchaseNameCol;
    @FXML
    private TableColumn<?, ?> purchaseDateCol;
    @FXML
    private TableColumn<?, ?> purchasePriceCol;
    @FXML
    private TextField customerID;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Tab offreTab;
    @FXML
    private TableView<?> customerTableView;
    @FXML
    private TableColumn<Utilisateur, Integer> Iduser;
    @FXML
    private TableColumn<Utilisateur, String> idName;
    @FXML
    private TableColumn<Utilisateur, String> idfirstname;
    @FXML
    private TableColumn<Utilisateur, String> Idadress;
    @FXML
    private TableColumn<Utilisateur, String> idEmail;
    @FXML
    private TableColumn<Utilisateur, String> idLogin;
    @FXML
    private TableColumn<Utilisateur, String> idPass;

    @FXML
    private TableColumn<?, ?> customerPassCol;
    @FXML
    private ImageView im2;
    @FXML
    private Tab utilisateurTab;
    @FXML
    private TableView<Utilisateur> staffTableView;
    @FXML
    private TextField addUserText;
    @FXML
    private TextField addPassText;
    @FXML
    private Tab productsTab;
    @FXML
    private TableView<?> productTableView;
    @FXML
    private TableColumn<?, ?> productIdCol;
    @FXML
    private TableColumn<?, ?> productCodeCol;
    @FXML
    private TableColumn<?, ?> productNameCol;
    @FXML
    private TableColumn<?, ?> productSizeCol;
    @FXML
    private TableColumn<?, ?> productPriceCol;
    @FXML
    private TextField productCode;
    @FXML
    private TextField productName;
    @FXML
    private TextField productSize;
    @FXML
    private TextField productPrice;
    @FXML
    private Label usernameLabel;
    @FXML
    private TableColumn<?, ?> offreIdCol;
    @FXML
    private TableColumn<?, ?> offreNameCol;
    @FXML
    private TableColumn<?, ?> offreAddCol;
    @FXML
    private TableColumn<?, ?> offreUserNameCol;

    ObservableList<Utilisateur> data = FXCollections.observableArrayList();
    private TableColumn<Utilisateur, String> role;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            usernameLabel.setText(UserSession.getInstance().toString());
            cnx = MyConnection.getInstance().getCnx();
            String requete = "SELECT * FROM utilisateur ";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                data.add(new Utilisateur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("adresse"),
                        rs.getString("email"), rs.getString("login"), rs.getString("motdepasse"), rs.getString("rolee")));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        Iduser.setCellValueFactory(new PropertyValueFactory<>("id"));
        idName.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idfirstname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Idadress.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        idLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        idPass.setCellValueFactory(new PropertyValueFactory<>("motdepasse"));
                    System.out.println(data);

        staffTableView.setItems(data);
        
        System.out.println(staffTableView.getItems().size());
        // TODO
    }

    @FXML
    private void handleDeleteButton(ActionEvent event) {
        try {

            Utilisateur u = staffTableView.getSelectionModel().getSelectedItem();

            String requete = "delete from offre where id =? ";
            PreparedStatement pst = cnx.prepareStatement(requete);

            pst.setInt(1, u.getid());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "Delete");

            staffTableView.getItems().removeAll(staffTableView.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Table est vide");
        }

    }

    private void UpdateTable() {
        Iduser.setCellValueFactory(new PropertyValueFactory<>("id"));
        idName.setCellValueFactory(new PropertyValueFactory<>("nom"));
        idfirstname.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        Idadress.setCellValueFactory(new PropertyValueFactory<>("adress"));
        idLogin.setCellValueFactory(new PropertyValueFactory<>("login"));
        idPass.setCellValueFactory(new PropertyValueFactory<>("motdepasse"));
        staffTableView.setItems(data);
    }


    @FXML
    private void handleViewTransactionButton(ActionEvent event) {
    }

    @FXML
    private void handleViewAllButton(ActionEvent event) {
    }

    @FXML
    private void handleDatePicker(ActionEvent event) {
        
    }

    @FXML
    private void handleValidateCmd(ActionEvent event) {
    }

    @FXML
    private void handleDeleteCmd(ActionEvent event) {
    }

    @FXML
    private void handleProductAddButton(ActionEvent event) {
    }

    @FXML
    private void handleProductDeleteButton(ActionEvent event) {
    }

    @FXML
    private void handleProductUpdateButton(ActionEvent event) {
    }

    @FXML
    private void handleProductDelButton(ActionEvent event) {
    }

    @FXML
    private void loginbt(MouseEvent event) {
        
    }

    @FXML
    private void Disconnect(ActionEvent event) {
         UserSession.CleanUser("");
        System.out.println(UserSession.getInstance());
        try {
               
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));

             Parent root5=(Parent) loader.load();
             LoginController rc = loader.getController();
             Stage stage=new Stage();
             stage.setScene(new Scene(root5));
             stage.show();
             
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
