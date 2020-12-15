package Controller;

import java.io.File;
import java.io.FileOutputStream;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import main.Main;
import main.MyListener;
import model.Book;
import Controller.Livre;
import Controller.LivreCRUD;
import java.awt.Color;
import java.io.FileInputStream;
import javafx.scene.effect.DropShadow;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class MarketController implements Initializable {

    Connection cnx;
    String lan;

    private List<Book> books = new ArrayList<>();
    private List<Book> imed = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    @FXML
    private Button Search;
    @FXML
    private Button AddCart;
    @FXML
    private MenuItem English;
    @FXML
    private MenuItem français;
    @FXML
    private MenuItem espagnol;
    private ResourceBundle bundle;
    private Locale locale;
    @FXML
    private Label MyAccount;
    @FXML
    private Label Freedelivery;
    @FXML
    private Label over$20order;
    @FXML
    private TilePane tilePane;
    private int nRows = 3;  //no of row for tile pane
    private int nCols = 3;
    int count = 0;
    File filesJpg[];
    private static final double ELEMENT_SIZE = 150;
    private static final double GAP = ELEMENT_SIZE / 17;
    ObservableList<Livre> bookList = FXCollections.observableArrayList();
    @FXML
    private VBox chosenFruitCard;
    @FXML
    private Label bookNameLable;
    @FXML
    private Label bookPriceLabel;
    @FXML
    private ImageView bookImg;

    public void initialize(URL location, ResourceBundle resources) {
        tilePane.setPrefColumns(nCols);
        tilePane.setPrefRows(nRows);
        tilePane.setHgap(GAP);
        tilePane.setVgap(GAP);
        LivreCRUD bs = new LivreCRUD();
        bs.readBooks(bookList);
        System.out.println(bookList);
        nRows = bookList.size() / 3;
        createElements(bookList);

    }

    @FXML
    private void Search_btn(ActionEvent event) {
    }

    @FXML
    private void EN_btn(ActionEvent event) {
        loadLang("en");
    }

    @FXML
    private void FR_btn(ActionEvent event) {
        loadLang("fr");

    }

    @FXML
    private void ES_btn(ActionEvent event) {
        loadLang("es");

    }

    private void loadLang(String lang) {
        locale = new Locale(lang);
        bundle = ResourceBundle.getBundle("Controller.lang", locale);
        AddCart.setText(bundle.getString("ADDTOCART"));
        Search.setText(bundle.getString("Search"));
        MyAccount.setText(bundle.getString("MyAccount"));
        Freedelivery.setText(bundle.getString("Freedelivery"));

    }

    private void createElements(ObservableList<Livre> bookList) {
        tilePane.getChildren().clear();
        for (int j = 0; j < bookList.size(); j++) {
            tilePane.getChildren().add(createPage(count, bookList.get(j).getImage(), bookList.get(j).getNom(), bookList.get(j).getId(), bookList.size(), bookList.get(j).getPrix(), bookList.get(j).getDescription()));
            count++;
        }
    }

    public VBox createPage(int index, String imageUrl, String bookLabel, int bookId, int size, double price, String descripion) {
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
        label.setAlignment(Pos.CENTER_LEFT);
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
            bookDetailsBtn.setOnMouseClicked((MouseEvent event) -> {
                try {

                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/views/Home.fxml"));
                    Pane root = loader.load();
                    Scene scene = new Scene(root);
                    HomeController h = loader.getController();
                    System.out.println(bookLabel + String.valueOf(price) + descripion + imageUrl);
                    h.setTexts(bookLabel, String.valueOf(price), descripion, imageUrl);
                    // h.setTexts("titreee", "nameeeee", "20", "");
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }

            }
            );

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
        priceAndRating.setMargin(bookPrice, new Insets(0, 0, 0, 0));

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
    private void AddCart_btn(ActionEvent event) {
    }
}
