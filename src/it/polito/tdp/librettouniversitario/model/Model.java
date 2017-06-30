package it.polito.tdp.librettouniversitario.model;

import java.util.HashSet;
import java.util.Iterator;

public class Model {
	
	// molto meglio HashMap non solo per aggiunta ma anche per ricerca
	private HashSet<Esame> esami;
	
	public Model(){
		this.esami = new HashSet<Esame>();
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
		
		if(esami.contains(new Esame(codice, null, null))){
			
			Iterator<Esame> it = esami.iterator();
			
			while(it.hasNext()){
				
				Esame e = it.next();
				
				if(e.equals(new Esame(codice, null, null))){
					return e;
				}
		
			}
			
			return null;
			
		}else return null;
		
	}

}
