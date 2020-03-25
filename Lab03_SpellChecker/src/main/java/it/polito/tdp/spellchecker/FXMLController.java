package it.polito.tdp.spellchecker;

import java.io.IOException;
import java.net.URL;
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
    	Dictionary d;
    	d = new Dictionary();
    	// carico dizionario corretto
    	d.loadDictionary(comboBox.getValue());

    	// faccio il controllo sul testo in input
    	
    	String input = txtTesto.getText().toLowerCase().replaceAll("[.,\\/#!?$%\\^&\\*;:{}=\\-_'()\\[\\]\"]","");
    	double start = System.nanoTime();  //per studiare performance
    	List<RichWord> rw = d.spellCheckText(input.split(" "));
    	double stop = System.nanoTime();
    	//inizializzazione errori
    	String wrong = "";
    	int i = 0;
    	
    	//cerco se ci sono parole sbagliate
    	for (RichWord r : rw) {
    		if (r.getIsCorretta()==false) {
    			wrong += r.getWord()+"\n";
    			i++;
    		}
    	}
    	txtWrong.setText(wrong);
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
        
    }
}
