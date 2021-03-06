/**
 * 
 */
package br.edu.catolicasc.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import br.edu.catolicasc.jogo.modelo.Pontuacao;
import br.edu.catolicasc.parametros.UsuarioAtivo;

/**
 * @author Projeto PACS
 *
 */
/*
 * Server: 189.2.117.178 Server2: 186.235.59.27 Name: game User name: master
 * Password: master Port number: 6603
 */
public class MysqlUtil {
	private static Encrypt encrypt;
	private Connection conn = null;
	private Statement statement = null;
	@SuppressWarnings("unused")
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private static MysqlUtil mysqlUtil;
	private boolean isValid;
	private String sql;

	private static String serverMysql = "189.2.117.178";// REMOTO
	private static String portMysql = "6603";// REMOTO
	private static String dbaseMysql = "game";

	private MysqlUtil() {

	}

	public static MysqlUtil getInstance() {
		if (mysqlUtil == null) {
			mysqlUtil = new MysqlUtil();
			encrypt = new Encrypt();
		}
		return mysqlUtil;
	}

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://" + serverMysql + ":" + portMysql + "/" + dbaseMysql,
					"master", "master");
		} catch (Exception e) {

		}
		return conn;
	}

	public boolean validaUser(String usuario, String senha, Connection conn) {
		String pwd = encrypt.gerarMD5(senha);
		isValid = false;
		sql = "select senha from LOGIN where LOGIN=\'" + usuario + "\' and SENHA=\'" + pwd + "\'";
		System.out.println("AQUI 75");
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String pwdHash = resultSet.getString("senha");

				if (encrypt.validMD5(senha, pwdHash)) {
					isValid = encrypt.validMD5(senha, pwdHash);
				} else {
					isValid = false;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return isValid;
	}

	public LinkedList<Hashtable<String, String>> listarDados(String table) {
		resultSet = null;
		LinkedList<Hashtable<String, String>> list = new LinkedList<>();
		sql = "select * from " + table.toUpperCase();
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Hashtable<String, String> currentRowMap = new Hashtable<>();
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					String value = resultSet.getString(rsmd.getColumnName(i));
					if (value == null) {
						value = "null";
					}
					currentRowMap.put(key, value);

				}
				list.add(currentRowMap);
			}
		} catch (Exception e) {
			return null;
		}

		return list;
	}

	public LinkedList<Hashtable<String, String>> userDados(String usuario, Connection conn) {
		resultSet = null;
		LinkedList<Hashtable<String, String>> list = new LinkedList<>();
		sql = "select * from DADOS_GERAIS where UPPER(LOGIN)=\'" + usuario.toUpperCase() + "\'";
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Hashtable<String, String> currentRowMap = new Hashtable<>();
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					// retrieves column name and value.
					String key = rsmd.getColumnLabel(i);
					String value = resultSet.getString(rsmd.getColumnName(i));
					if (value == null) {
						value = "null";
					}
					currentRowMap.put(key, value);

				}
				list.add(currentRowMap);
			}
		} catch (Exception e) {
			return null;
		}

		return list;

	}

	public LinkedList<Hashtable<String, String>> fasesJogo(Connection conn, String idFasePlay) {

		if (idFasePlay.equals(null)) {
			sql = "select * from FASE";
		} else {
			sql = "select * from FASE where ID_FASE = " + idFasePlay;
		}

		resultSet = null;
		LinkedList<Hashtable<String, String>> list = new LinkedList<>();

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Hashtable<String, String> currentRowMap = new Hashtable<>();
				ResultSetMetaData rsmd = resultSet.getMetaData();
				int columnCount = rsmd.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					// retrieves column name and value.
					String key = rsmd.getColumnLabel(i);
					String value = resultSet.getString(rsmd.getColumnName(i));
					if (value == null) {
						value = "null";
					}
					currentRowMap.put(key, value);

				}
				list.add(currentRowMap);
			}
		} catch (Exception e) {
			return null;
		}

		return list;

	}

	public void newSerie(String nome, Connection conn) {
		System.out.println(conn);
		Cadastros.novaSerie(nome, conn);
	}

	public void newPessoa(String nome, String data, String avatar, Connection conn) {
		System.out.println(conn);
		Cadastros.novaPessoa(nome, data, avatar, conn);

	}

	public void newTurma(String nome, int idSerie, Connection conn) {
		System.out.println(conn);
		Cadastros.novaTurma(nome, idSerie, conn);
	}

	public void close() {
		try {
			conn.close();
		} catch (Exception e) {

		}
	}

	public void insertPontuacao(int idPessoa, int idFase, int pontos,String nome) {
		if (pontos > 100) {
			pontos = -200;
		} else if (pontos > 10) {
			pontos = 0;
		}
		int newPontos = pontos;
		sql = " insert into PONTUACAO (ID_ALUNO,PONTOS,ID_FASE) values (?,?,?)";
		try {
			 PreparedStatement preparedStmt = conn.prepareStatement(sql);
			 preparedStmt.setInt (1, idPessoa);
			 preparedStmt.setInt (2, newPontos);
			 preparedStmt.setInt (3, idFase);		 
			 preparedStmt.execute();
			 JOptionPane.showMessageDialog(null, "Parab?ns "+nome,"Sucesso",JOptionPane.PLAIN_MESSAGE);
		} catch (SQLException ex) {
			String error = ex.getMessage();
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, error,"Erro",JOptionPane.ERROR_MESSAGE);
		}finally {
			
		}	
		

	}

	public List<Pontuacao> SelectRanking(Connection conn) {
		int idPessoa = UsuarioAtivo.getIdPessoa();
		sql = "select r.NOME,r.PONTUACAO AS PONTOS from RANKING r where r.ID_TURMA = (select ID_TURMA from ALUNOS where ID_PESSOA = "
				+ idPessoa + " ) order by r.PONTUACAO desc LIMIT 10";

		List<Pontuacao> pontos = new ArrayList<>();

		try {

			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Pontuacao ranking = new Pontuacao();

				ranking.setNome(resultSet.getString("NOME"));
				ranking.setValor(resultSet.getInt("PONTOS"));

				pontos.add(ranking);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return pontos;
	}

	public List<Pontuacao> SelectRankingAluno(Connection conn) {
		int idPessoa = UsuarioAtivo.getIdPessoa();
		sql = "select a.NOME, p.PONTOS,p.ID_FASE from PESSOA a, ALUNOS a2, PONTUACAO p where a.ID_PESSOA =" + idPessoa
				+ " AND a2.ID_PESSOA = a.ID_PESSOA AND p.ID_ALUNO =" + idPessoa + " order by p.ID_FASE ASC";

		List<Pontuacao> pontos = new ArrayList<>();

		try {

			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				Pontuacao ranking = new Pontuacao();

				ranking.setNome(resultSet.getString("NOME"));
				ranking.setValor(resultSet.getInt("PONTOS"));
				ranking.setIdFase(resultSet.getInt("ID_FASE"));

				pontos.add(ranking);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return pontos;
	}

}
