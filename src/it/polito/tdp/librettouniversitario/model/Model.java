package it.polito.tdp.librettouniversitario.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private List<Esame> esami;
	
	public Model(){
		this.esami = new LinkedList<Esame>();
	}
	
	/**
	 * Aggiunge un nuovo esame all'elenco
	 * verificando che non sia già presente
	 * @param e
	 * @return true -> success / false -> failure
	 */
	public boolean addEsame(Esame e){
		
		if(!esami.contains(e)){
			esami.add(e);
			return true;
		}else{
			return false;
		}
		
	}
	
	/**
	 * Ricerca un esame tramite il codice specificato
	 * @param codice
	 * @return Esame se esiste, null se non esiste
	 */
	public Esame trovaEsame(String codice){
		
		int pos = this.esami.indexOf(new Esame(codice, null, null));
		
		if(pos==-1){
			return null;
		}else{
			return this.esami.get(pos);
		}
		
	}

}
