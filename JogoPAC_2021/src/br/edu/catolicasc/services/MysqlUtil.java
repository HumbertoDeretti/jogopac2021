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
*Server: sql10.freemysqlhosting.net
*Name: sql10411872
*Username: sql10411872
*Password: 7dEvbLFuCI
*Port number: 3306
 */
public class MysqlUtil {
	
	private Connection conn = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private static MysqlUtil mysqlUtil;
	private boolean isValid;
	private String sql;
	
	public MysqlUtil getInstance() {
		if(mysqlUtil == null) {
			mysqlUtil = new MysqlUtil();
		}
		return mysqlUtil;
	}
	public Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://sql10.freemysqlhosting.net/sql10411872","sql10411872","7dEvbLFuCI");
		} catch (Exception e) {
			
		}
		return conn;
	}
	
	public boolean ValidaUser(String usuario, String senha,Connection conn)  {
		isValid = false;
		sql = "select login from TESTE where LOGIN=\'"+usuario+"\' and SENHA=\'"+senha+"\'";
		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String user_temp = resultSet.getString("login");
				if(user_temp.equals(usuario)) {
					isValid=true;
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
