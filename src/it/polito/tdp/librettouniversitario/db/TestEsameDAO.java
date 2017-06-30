package it.polito.tdp.librettouniversitario.db;

import it.polito.tdp.librettouniversitario.model.Esame;

public class TestEsameDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EsameDAO dao = new EsameDAO();
		
		Esame e1 = dao.find("03FYZ");
		Esame e2 = dao.find("99QQQ");
		
		System.out.println(e1);
		System.out.println(e2);

	}

}
