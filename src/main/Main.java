package main;
//
import Connection.ConnectionLivre;
import Controller.Favoris;
import Controller.FavorisCrud;
//import Controller.Favoris;
//import Controller.FavorisCrud;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Book;
import Controller.MarketController;

public class Main extends Application {


    public static final String CURRENCY = "$";

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../views/GrandMenu.fxml"));
        primaryStage.setTitle("Book Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
    ConnectionLivre mc = ConnectionLivre.getInstance();
    MarketController livre = new MarketController();
            
        Favoris F = new Favoris();
        FavorisCrud favor=new FavorisCrud();
//        favor.ajouterLivre(F);
 
   
        launch(args);
        
    }
}
