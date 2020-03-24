package it.polito.tdp.spellchecker;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class FXMLController {
	Dictionary d;
	int i = 0;

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
    	txtTesto.clear();
    	txtWrong.clear();
    	txtWW.setText("");
    	txtCompleted.setText("");

    }

    @FXML
    void doSpellCheck(ActionEvent event) throws IOException {
    	List<String> temp = new ArrayList<String>();
    	List<RichWord> rw = new ArrayList<RichWord>();
    	double start = System.nanoTime();  //per studiare performance
    	d.loadDictionary(comboBox.getValue());
    	temp = d.StringToList(txtTesto.getText());
    	rw = d.spellCheckText(temp);
    	
    	//cerco se ci sono parole sbagliate
    	for (RichWord r : rw) {
    		if (r.getIsCorretta()==false) {
    			txtWrong.appendText(r.getWord()+"\n");
    			i++;
    		}
    	}
    	double stop = System.nanoTime();
    	txtWW.setText("The text contains "+i+" errors");
    	txtCompleted.setText("Spell check completed in "+(stop-start)+" milliseconds");
    	
    	

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
        d = new Dictionary();
    }
}
