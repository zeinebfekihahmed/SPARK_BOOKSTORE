package Controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import model.Book;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;
    @FXML
    private Button Favoris;
    @FXML
    private Button Description;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(book);
    }

    private Book book;
    private MyListener myListener;

    public void setData(Book book, MyListener myListener) {
        this.book = book;
        this.myListener = myListener;
        nameLabel.setText(book.getNom());
        priceLable.setText(Main.CURRENCY + book.getPrix());
        Image image = new Image(getClass().getResourceAsStream(book.getImgSrc()));
        img.setImage(image);
    }

    @FXML
    private void Favoris_btn(ActionEvent event) throws IOException {
        System.out.println("-----reirection-----");
            FXMLLoader Loader = new FXMLLoader(getClass().getResource("/views/Home.fxml"));
            Parent root2=Loader.load();
            HomeController pc2=Loader.getController();
           
            Favoris.getScene().setRoot(root2);
        
    }

    @FXML
    private void Description_btn(ActionEvent event) {
    }
}
