/**
 * 
 */
package br.edu.catolicasc.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Projeto PACS
 *
 */
/*
*Server: 189.2.117.178
*Name: game
*Username: master
*Password: master
*Port number: 6603
 */
public class MysqlUtil {
	private Encrypt encrypt;
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private static MysqlUtil mysqlUtil;
	private boolean isValid;
	private String sql;
	
	private static String serverMysql = "189.2.117.178";//REMOTO
	//private static String serverMysql = "192.168.23.113";//LOCAL
	private static String portMysql = "6603";//REMOTO
	//private static String portMysql = "3306";//LOCAL
	private static String dbaseMysql = "game";
	
	public MysqlUtil() {
		encrypt = new Encrypt();
	}
	
	public MysqlUtil getInstance() {
		if(mysqlUtil == null) {
			mysqlUtil = new MysqlUtil();			
		}
		return mysqlUtil;
	}
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+serverMysql+":"+portMysql+"/"+dbaseMysql,"master","master");
		} catch (Exception e) {
			
		}
		return conn;
	}
	
	public boolean ValidaUser(String usuario, String senha,Connection conn)  {
		String pwd = encrypt.gerarMD5(senha);
		isValid = false;
		sql = "select senha from LOGIN where LOGIN=\'"+usuario+"\' and SENHA=\'"+pwd+"\'";
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String pwdHash = resultSet.getString("senha");
				
				if(encrypt.validMD5(senha, pwdHash)) {
					isValid=encrypt.validMD5(senha, pwdHash);
				}
				else {
					isValid=false;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return isValid;
	}
	
	
	public void Close() {
		try {
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	
}
