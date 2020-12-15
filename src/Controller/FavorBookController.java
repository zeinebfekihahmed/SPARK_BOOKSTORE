/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Controller.FavorisCrud;
import Controller.Favoris;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author Ghazi
 */
public class FavorBookController implements Initializable {

    @FXML
    private Button Search;
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label bookNameLable;
    @FXML
    private Label bookPriceLabel;
    @FXML
    private ImageView bookImg;
    @FXML
    private Button AddCart;
    @FXML
    private TilePane tilePane;
    private int nRows = 3;  //no of row for tile pane
    private int nCols = 3;
    int count = 0;
    File filesJpg[];
    ObservableList<Favoris> favorsList = FXCollections.observableArrayList();
    private static final double ELEMENT_SIZE = 150;
    private static final double GAP = ELEMENT_SIZE / 17;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tilePane.setPrefColumns(nCols);
        tilePane.setPrefRows(nRows);
        tilePane.setHgap(GAP);
        tilePane.setVgap(GAP);
        FavorisCrud fC = new FavorisCrud();
        fC.readBooks(favorsList);
        FavorisCrud nom;

        System.out.println(favorsList);
        nRows = favorsList.size() / 3;
        createElements(favorsList);
    }

    private void createElements(ObservableList<Favoris> favorsList) {
        tilePane.getChildren().clear();
        for (int j = 0; j < favorsList.size(); j++) {
            tilePane.getChildren().add(createPage(count, favorsList.get(j).getImage(), favorsList.get(j).getNomLivre(),favorsList.get(j).getId(), favorsList.size(), favorsList.get(j).getPrix(),favorsList.get(j).getId_user()));
            count++;
        }
    }

    public VBox createPage(int index, String imageUrl, String bookLabel, int bookId, int size, double price,int id_user) {
        ImageView imageView = new ImageView();
        try {
            InputStream stream = new FileInputStream(imageUrl);
            Image image = new Image(stream);
            imageView.setImage(image);
            imageView.setFitWidth(ELEMENT_SIZE);
            imageView.setFitHeight(ELEMENT_SIZE);
            imageView.setClip(null);
            imageView.setTranslateY(10);
            imageView.setEffect(new DropShadow(20, javafx.scene.paint.Color.BLACK));
            imageView.setSmooth(true);
            imageView.setCache(true);
        } catch (IOException ex) {
        }
        Label label = new Label();

        Label detailsLabel = new Label();
        label.setText(bookLabel);
//        label.setScaleX(2);
//        label.setScaleY(3);
//        label.setScaleZ(3);
        label.setAlignment(Pos.CENTER);
        //label.setMargin(label, new Insets(0, 0, 0, 50));

        //label.setSca
        detailsLabel.setText("Details");
        detailsLabel.getStyleClass().add("detailsLabel");
        label.getStyleClass().add("bookLabel");
        label.setStyle("-fx-alignment:center;");
        Label bookPrice = new Label();
        bookPrice.setText(price + " DT");
        bookPrice.setStyle("-fx-alignment:center;");
        ImageView addTocartBtn = new ImageView();
        ImageView bookDetailsBtn = new ImageView();
        ImageView ratingIcon = new ImageView();

        try {
//            Image addToCartBtn = new Image(new FileInputStream("C:\\Users\\Ghazi\\Documents\\NetBeansProjects\\menubook2\\src\\img\\addcart.png"));
//            addTocartBtn.setImage(addToCartBtn);
//            addTocartBtn.setFitWidth(30);
//            addTocartBtn.setFitHeight(30);
//            addTocartBtn.getStyleClass().add("add-to-cart");
            Glow glow = new Glow(0.5);
//            addTocartBtn.setEffect(glow);
            Image detailsBtn = new Image(new FileInputStream("C:\\Users\\Ghazi\\Documents\\NetBeansProjects\\menubook2\\src\\img\\details.png"));

            /*  addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
         System.out.println("Tile pressed ");
         event.consume();
     });*/
            bookDetailsBtn.setImage(detailsBtn);

            bookDetailsBtn.setFitWidth(30);
            bookDetailsBtn.setFitHeight(30);
//            bookDetailsBtn.getStyleClass().add("add-to-cart");
//            bookDetailsBtn.setEffect(glow);
//            Image ratingImage = new Image(new FileInputStream("C:\\Users\\Ghazi\\Documents\\NetBeansProjects\\menubook2\\src\\img\\star.png"));
//            ratingIcon.setImage(ratingImage);
//            ratingIcon.setFitWidth(20);
//            ratingIcon.setFitHeight(20);
//            ratingIcon.setEffect(glow);
        } catch (IOException ex) {
        }
        HBox buttonBox = new HBox();
        buttonBox.getChildren().add(bookDetailsBtn);
        buttonBox.getChildren().add(detailsLabel);
        buttonBox.getChildren().add(addTocartBtn);
        buttonBox.setAlignment(Pos.CENTER_LEFT);
        VBox pageBox = new VBox();
        pageBox.getChildren().add(imageView);
        pageBox.getChildren().add(label);
        pageBox.getChildren().add(buttonBox);
        pageBox.setMargin(label, new Insets(20, 0, 0, 50));
        buttonBox.setMargin(detailsLabel, new Insets(0, 0, 0, 0));

        HBox priceAndRating = new HBox();
        bookPrice.getStyleClass().add("priceLabel");
        priceAndRating.getChildren().add(bookPrice);
        Label ratingLabel = new Label();

//        ratingLabel.setText(descripion + "");
//        ratingLabel.getStyleClass().add("description");
        priceAndRating.getChildren().add(ratingLabel);
        priceAndRating.getChildren().add(ratingIcon);
        priceAndRating.setAlignment(Pos.CENTER_LEFT);
        ratingLabel.getStyleClass().add("price-rating-container");
        pageBox.getChildren().add(priceAndRating);
        priceAndRating.setMargin(bookPrice, new Insets(0, 40, 0, 0));

        pageBox.getStyleClass().add("card");
        if (bookLabel.equals("Harry Potter and the Goblet of Fire")) {
            pageBox.setStyle("-fx-effect: dropshadow(three-pass-box, green, 7, 0, 0, 0);-fx-background-radius:10;");
        }
        pageBox.setPrefWidth(ELEMENT_SIZE + 30);
        pageBox.getStyleClass().add("book-container");
        imageView = null;
        return pageBox;
    }

    @FXML
    private void Search_btn(ActionEvent event) {
    }

    @FXML
    private void AddCart_btn(ActionEvent event) {
    }

}
