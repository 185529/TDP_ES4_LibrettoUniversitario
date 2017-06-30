package it.polito.tdp.librettouniversitario.model;

import it.polito.tdp.librettouniversitario.db.EsameDAO;

public class Model {
	
	/**
	 * Aggiunge un nuovo esame all'elenco
	 * verificando che non sia già presente
	 * @param e
	 * @return true -> success / false -> failure
	 */
	public boolean addEsame(Esame e){
		
		EsameDAO dao = new EsameDAO();
		
		return dao.create(e);
		
	}
	
	/**
	 * Ricerca un esame tramite il codice specificato
	 * @param codice
	 * @return Esame se esiste, null se non esiste
	 */
	public Esame trovaEsame(String codice){
		
		EsameDAO dao = new EsameDAO();
		
		Esame result = dao.find(codice);
		
		return result;
		
	}

}
