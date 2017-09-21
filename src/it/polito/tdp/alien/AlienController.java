package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary dictionary = new AlienDictionary();
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	
    	txtResult.clear();
    	
    	String riga = txtWord.getText().toLowerCase();
    	
    	// controllo input
    	
    	if(riga==null || riga.length()==0){
    		txtResult.setText("Inserire una o due parole.\n");
    		return;
    	}
    	
    	// separo le stringhe con un tokenizer
    	
    	StringTokenizer st = new StringTokenizer(riga, " ");
    	
    	// estraggo prima parola
    	
    	String alienWord = st.nextToken();
    	
    	// controllo validità stringhe
    	
    	if (!alienWord.matches("[a-zA-Z]*")){
			txtResult.setText("Inserire solo caratteri alfabetici.");
			return;
    	}
    	
    	// controllo se la riga ha una o due parole
    	
    	if(st.hasMoreTokens()){
    		
    		// inserimento nel dizionario
    		
    		String translation = st.nextToken();
    		
    		if (!translation.matches("[a-zA-Z]*")){
    			txtResult.setText("Inserire solo caratteri alfabetici.");
    			return;
        	}
    		
    		dictionary.addWord(alienWord, translation);
    		
			txtResult.appendText("Corrispondenza correttamente inserita nel dizionario.\n");
    		
    	}else{
    		
    		// ricerca della traduzione
    		
    		String translation = dictionary.translateWord(alienWord);
    		
    		if(translation==null){
    			txtResult.appendText("La parola cercata non è presente nel dizionario.\n");
    		}
    		else{
    			txtResult.appendText(alienWord+": "+translation+"\n");
    		}
    	}
    	    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtWord.clear();
    	txtResult.clear();

    }
    
}
