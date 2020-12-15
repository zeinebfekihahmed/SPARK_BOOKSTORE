/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.bookstore.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.io.*;
import com.sun.speech.freetts.*;

/**
 * FXML Controller class
 *
 * @author Dridi
 */
public class TextToSpeechController implements Initializable {

    @FXML
    private TextArea textZone;
    @FXML
    private Button btnl;

    /*
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
private static final String VOICENAME = "kevin16";
    @FXML
    private void OnListen(ActionEvent event) {
        Voice voice;
         VoiceManager vm=VoiceManager.getInstance();
        voice=vm.getVoice(VOICENAME);
        voice.allocate(); 
        try {
            voice.speak(textZone.getText());
        } catch (Exception e) {
        }
    }

}
