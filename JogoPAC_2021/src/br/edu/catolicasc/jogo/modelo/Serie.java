package br.edu.catolicasc.jogo.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class Serie {
	private int idSerie;
	private String nome;
	
	public Serie() {
		
	}
	public Serie(int idSerie,String nome) {
		this.idSerie = idSerie;
		this.nome = nome;
	}
	public int getId() {
		return idSerie;
	}
	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}
	@Override
	public String toString() {
		return nome;
	}
	
	public void show(JComboBox <Serie> comboProduct,Connection conn){
	    ResultSet res = null;
	    try {
	        
	        String query = "select id_serie, nome from SERIE";
	        PreparedStatement ps = conn.prepareStatement(query);
	        res = ps.executeQuery();
	        while (res.next()) {
	            comboProduct.addItem(new Serie(res.getInt("ID_SERIE"), res.getString("NOME")));
	        }
	        res.close();
	    } catch (SQLException e) {
	        System.err.println("Error showing the products " + e.getMessage());
	    }

	}
	
}
