package br.edu.catolicasc.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.edu.catolicasc.parametros.UsuarioAtivo;

public class Cadastros {
	private static String sql;
	
	private static String error;
	
	
	public static void novoAluno(int idPessoa,int idTurma, Connection conn) {
		sql = " insert into ALUNOS (ID_PESSOA,ID_TURMA,ID_PROFESSOR) values (?,?,?)";
		try {
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
			 preparedStmt.setInt (1, idPessoa);
			 preparedStmt.setInt (2, idTurma);
			 preparedStmt.setInt (3, UsuarioAtivo.getIdPessoa());
		     //preparedStmt.setString (2, "Rubble");
		     //preparedStmt.setDate   (3, startDate);
		     //preparedStmt.setBoolean(4, false);
		     //preparedStmt.setInt    (5, 5000);			 
			 preparedStmt.execute();
			 JOptionPane.showMessageDialog(null, "Cadastrado Aluno!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			error = ex.getMessage();
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, error,"Erro",JOptionPane.ERROR_MESSAGE);
		}finally {
			
		}		
	}
	
	
	public static void novoProfessor(int idPessoa,int idTurma, Connection conn) {
		sql = " insert into PROFESSORES (ID_PESSOA,ID_TURMA) values (?,?)";
		try {
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
			 preparedStmt.setInt (1, idPessoa);
			 preparedStmt.setInt (2, idTurma);
		     //preparedStmt.setString (2, "Rubble");
		     //preparedStmt.setDate   (3, startDate);
		     //preparedStmt.setBoolean(4, false);
		     //preparedStmt.setInt    (5, 5000);			 
			 preparedStmt.execute();
			 JOptionPane.showMessageDialog(null, "Professor registrado!","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			error = ex.getMessage();
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, error,"Erro",JOptionPane.ERROR_MESSAGE);
		}finally {
			
		}		
	}
	
	public static void novaTurma(String nome,int idSerie, Connection conn) {
		sql = " insert into TURMA (NOME,ID_SERIE) values (?,?)";
		try {
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
			 preparedStmt.setString (1, nome);
			 preparedStmt.setInt    (2, idSerie);
		     //preparedStmt.setString (2, "Rubble");
		     //preparedStmt.setDate   (3, startDate);
		     //preparedStmt.setBoolean(4, false);
		     			 
			 preparedStmt.execute();
			 JOptionPane.showMessageDialog(null, "Cadastrado Turma: "+nome+ "\nOK","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			error = ex.getMessage();
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, error,"Erro",JOptionPane.ERROR_MESSAGE);
		}finally {
			
		}		
	}
	public static void novaSerie(String nome, Connection conn) {
		sql = " insert into SERIE (NOME) values (?)";
		try {
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
			 preparedStmt.setString (1, nome);
		     //preparedStmt.setString (2, "Rubble");
		     //preparedStmt.setDate   (3, startDate);
		     //preparedStmt.setBoolean(4, false);
		     //preparedStmt.setInt    (5, 5000);			 
			 preparedStmt.execute();
			 JOptionPane.showMessageDialog(null, "Cadastrado Série: "+nome+ "\nOK","Sucesso",JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException ex) {
			error = ex.getMessage();
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, error,"Erro",JOptionPane.ERROR_MESSAGE);
		}finally {
			
		}		
	}
	
	
}
