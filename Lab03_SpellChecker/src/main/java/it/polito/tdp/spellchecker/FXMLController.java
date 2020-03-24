package it.polito.tdp.spellchecker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> comboBox;
    
    @FXML
    private TextArea txtTesto;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea txtWrong;

    @FXML
    private Text txtWW;

    @FXML
    private Button btnClear;

    @FXML
    private Text txtCompleted;

    @FXML
    void doClearText(ActionEvent event) {

    }

    @FXML
    void doSpellCheck(ActionEvent event) {

    }

    /**
     * Mi permette di scegliere la lingua da utilizzare.
     */
    void insertLanguage() {
    	comboBox.getItems().add("English");
     	comboBox.getItems().add("Italian");
     	comboBox.setValue("English");
    }
    
    @FXML
    void initialize() {
        assert comboBox != null : "fx:id=\"comboBox\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTesto != null : "fx:id=\"txtTesto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWrong != null : "fx:id=\"txtWrong\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtWW != null : "fx:id=\"txtWW\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCompleted != null : "fx:id=\"txtCompleted\" was not injected: check your FXML file 'Scene.fxml'.";
        insertLanguage();
    }
}
