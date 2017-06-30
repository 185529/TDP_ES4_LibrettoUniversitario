/**
 * Sample Skeleton for 'LibrettoUniversitario.fxml' Controller Class
 */

package it.polito.tdp.librettouniversitario;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.librettouniversitario.model.Esame;
import it.polito.tdp.librettouniversitario.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LibrettoUniversitarioController {
	
	Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void handleCerca(ActionEvent event) {
    	
// parsing dati
    	
    	String codice = txtCodice.getText();
    	
    	// verifica integrità dati
    	
    	if(codice.length()<5){
    		txtMessage.appendText("Codice non valido.\n");
    		return;
    	}
    	
    	// call al Model per operazioni
    	
    	Esame esame = model.trovaEsame(codice);
    	
    	// aggiorna View con risultati
    	
    	if(esame==null){
    		txtMessage.appendText("Esame non trovato.\n");
    	}else{
    		txtMessage.appendText("Esame trovato.\n");
    		
    		txtCodice.setText(esame.getCodice());
    		txtTitolo.setText(esame.getTitolo());
    		txtDocente.setText(esame.getDocente());
    	}

    }

    @FXML
    void handleInserisci(ActionEvent event) {
    	    	
    	// parsing dati
    	
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtDocente.getText();
    	
    	// verifica integrità dati
    	
    	if(codice.length()<5 || titolo.length()==0 || docente.length()==0){
    		txtMessage.appendText("Dati esame insufficienti.\n");
    		return;
    	}
    	
    	// call al Model per operazioni
    	
    	Esame esame = new Esame(codice, titolo, docente);
    	boolean result = model.addEsame(esame);
    	
    	// aggiorna View con risultati
    	
    	if(result){
    		txtMessage.appendText("Esame aggiunto correttamente.\n");
    	}else{
    		txtMessage.appendText("Esame non aggiunto.\n");
    	}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'LibrettoUniversitario.fxml'.";

    }

	/**
	 * @param model the model to set
	 */
	public void setModel(Model model) {
		this.model = model;
	}
}
