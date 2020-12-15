/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ghazi
 */
public class SampleController implements Initializable {

    @FXML
    private Button Login;
    @FXML
    private Button Register;
    @FXML
    private Button Rent;
    @FXML
    private Button More;
    @FXML
    private Button Join;
    @FXML
    private Button Reviews;
    @FXML
    private MenuItem en;
    @FXML
    private MenuItem fr;
    @FXML
    private MenuItem es;
    @FXML
    private Button help;
    @FXML
    private Label Week;
    @FXML
    private Label Month;
    @FXML
    private Label years;
    @FXML
    private Label label1;
    @FXML
    private Label label2;
    @FXML
    private Label label3;
    private Locale locale;
    private ResourceBundle bundle;
    @FXML
    private TextField book;
    @FXML
    private Label small;
    @FXML
    private Label price;
    @FXML
    private Label medium;
    @FXML
    private Label premium;
    private String lan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Login_btn(ActionEvent event) {
    }

    @FXML
    private void Register_btn(ActionEvent event) {
    }

    public String getLan() {
        return lan;
    }

    public void setLan(String lan) {
        this.lan = lan;
    }

    @FXML
    private void More_btn(ActionEvent event) {
    }

    @FXML
    private void Rent_btn(ActionEvent event) {
    }

    @FXML
    private void Join_btn(ActionEvent event) throws IOException {
        System.out.println("-----reirection-----");
        FXMLLoader Loader = new FXMLLoader(getClass().getResource("/views/market.fxml"));
        Parent root2 = Loader.load();
        MarketController pc2 = Loader.getController();

        Join.getScene().setRoot(root2);
    }

    @FXML
    private void Reviews_btn(ActionEvent event) {
    }

    @FXML
    private void en_btn(ActionEvent event) {
        loadLang("en");

    }

    @FXML
    private void fr_btn(ActionEvent event) {
        loadLang("fr");

    }

    @FXML
    private void es_btn(ActionEvent event) {
        loadLang("es");

    }

    private void loadLang(String lang) {
        locale = new Locale(lang);
        bundle = ResourceBundle.getBundle("Controller.lang", locale);
        Login.setText(bundle.getString("Login"));
        Register.setText(bundle.getString("Register"));
        help.setText(bundle.getString("help"));
        label1.setText(bundle.getString("label1"));
        label2.setText(bundle.getString("label2"));
        label3.setText(bundle.getString("label3"));
        Week.setText(bundle.getString("Week"));
        Month.setText(bundle.getString("Month"));
        years.setText(bundle.getString("years"));
        More.setText(bundle.getString("More"));
        Rent.setText(bundle.getString("Rent"));
        Join.setText(bundle.getString("Join"));
        Reviews.setText(bundle.getString("Reviews"));
        book.setText(bundle.getString("book"));
        small.setText(bundle.getString("small"));
        medium.setText(bundle.getString("medium"));
        premium.setText(bundle.getString("premium"));
        price.setText(bundle.getString("price"));
        setLan(lang);

    }

}
