package br.edu.catolicasc.jogo.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

public class Turma {
	
	private int idTurma;
	private String nome;
	
	public Turma() {
		
	}
	public Turma(int idTurma,String nome) {
		this.idTurma = idTurma;
		this.nome = nome;
	}
	public int getId() {
		return idTurma;
	}
	public void setIdTurma(int idTurma) {
		this.idTurma = idTurma;
	}
	@Override
	public String toString() {
		return nome;
	}

	public void show(JComboBox <Turma> comboProduct,Connection conn){
	    ResultSet res = null;
	    try {
	        
	        String query = "SELECT A.ID_TURMA,A.NOME FROM TURMA A INNER JOIN PROFESSORES P ON A.ID_TURMA = P.ID_TURMA WHERE P.ID_PESSOA = " + Integer.toString(UsuarioAtivo.getIdPessoa());
	        PreparedStatement ps = conn.prepareStatement(query);
	        res = ps.executeQuery();
	        while (res.next()) {
	            comboProduct.addItem(new Turma(res.getInt("ID_TURMA"), res.getString("NOME")));
	        }
	        res.close();
	    } catch (SQLException e) {
	        System.err.println("Error showing the products " + e.getMessage());
	    }

	}
}
