/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import Controller.FavorisCrud;
import Controller.Favoris;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Ghazi
 */
public class HomeController implements Initializable {

    @FXML
    private Label priceLable;
    @FXML
    private Label nameLabel;
    @FXML
    private Label description;
    @FXML
    private ImageView img;
    @FXML
    private Button read;
    @FXML
    private Button download;
    @FXML
    private Button addCart;
    @FXML
    private RadioButton favorsLivre;

    /**
     * Initializes the controller class.
     */
    Favoris F = new Favoris();
    FavorisCrud fa = new FavorisCrud();
    @FXML
    private ToggleGroup favorisation;
    @FXML
    private Button add1;

    public void setTexts(String s1, String s2, String s3, String s4) {
        InputStream stream = null;
        try {
            this.nameLabel.setText(s1);
            this.priceLable.setText(s2);
            this.description.setText(s3);
            //image
            stream = new FileInputStream(s4);
            Image image = new Image(stream);
            this.img.setImage(image);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stream.close();
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void read_btn(ActionEvent event) {
    }

    @FXML
    private void download_btn(ActionEvent event) {
    }

    @FXML
    private void addCart_btn(ActionEvent event) {
    }

    @FXML
    public void radioCheck(ActionEvent event) {
        if (favorsLivre.isSelected()) {
            Favoris fav = new Favoris();
            String s = this.nameLabel.getText();
            System.out.println("test s  "+s);
            fa.ajouterLivre(F,s);
            System.out.println("ajout");

        }else{
            fa.supprimerLivre(F);
        }
    }

    @FXML
    private void add_btn(ActionEvent event) {
                

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/FavorBook.fxml"));
            Pane root = loader.load();
            Scene scene = new Scene(root);
            FavorBookController h = loader.getController();
            // h.setTexts("titreee", "nameeeee", "20", "");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
 

            
            
    }

    public Label getPriceLable() {
        return priceLable;
    }

    public Label getNameLabel() {
        return nameLabel;
    }

    public ImageView getImg() {
        return img;
    }

    public void setPriceLable(Label priceLable) {
        this.priceLable = priceLable;
    }

    public void setNameLabel(Label nameLabel) {
        this.nameLabel = nameLabel;
    }

    public void setImg(ImageView img) {
        this.img = img;
    }


}
