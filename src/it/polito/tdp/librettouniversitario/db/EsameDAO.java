package it.polito.tdp.librettouniversitario.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.librettouniversitario.model.Esame;

public class EsameDAO {
	
	/**
	 * 
	 * @param codice
	 * @return
	 */
	public Esame find(String codice){
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		Esame ex;
		
		try {
			
			Connection connection = DriverManager.getConnection(jdbcURL);
			
			String sql = "SELECT codice, titolo, docente, superato, voto, data_superamento FROM esame WHERE codice=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, codice);
			
			ResultSet result = statement.executeQuery();
			
			if(result.next()){
				
				ex = new Esame(result.getString("codice"), result.getString("titolo"), result.getString("docente"));
				
				// TODO - estrarre voto e data superamento
				
			}else{
				
				ex = null;
				
			}
			
			connection.close();
			return ex;
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	/**
	 * 
	 * @param ex
	 * @return
	 */
	public boolean create(Esame ex){
		
		String jdbcURL = "jdbc:mysql://localhost/libretto?user=root";
		
		try {
			
			Connection connection = DriverManager.getConnection(jdbcURL);
			
			String sql = "INSERT INTO `libretto`.`esame` (`codice`, `titolo`, `docente`) VALUES (?, ?, ?);";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, ex.getCodice());
			statement.setString(2, ex.getTitolo());
			statement.setString(3, ex.getDocente());
			
			int result = statement.executeUpdate();
			
			connection.close();
			
			if(result == 1){
				
				return true;
				
			}else{
				
				return false;
				
			}
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
			
		}
		
	}

}
