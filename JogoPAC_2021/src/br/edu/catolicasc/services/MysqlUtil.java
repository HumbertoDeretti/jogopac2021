/**
 * 
 */
package br.edu.catolicasc.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.LinkedList;


/**
 * @author Projeto PACS
 *
 */
/*
*Server: 189.2.117.178
*Server2: 186.235.59.27
*Name: game
*User name: master
*Password: master
*Port number: 6603
 */
public class MysqlUtil {
	private Encrypt encrypt;
	private Connection conn = null;
	private Statement statement = null;
	@SuppressWarnings("unused")
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
	
	public LinkedList<Hashtable<String,String>> UserDados(String usuario,Connection conn) {
		resultSet = null;
		LinkedList<Hashtable<String,String>> list = new LinkedList<>();
		sql = "select * from DADOS_GERAIS where UPPER(LOGIN)=\'"+usuario.toUpperCase()+"\'";
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
			        currentRowMap .put(key, value);
			
			    }
				list.add(currentRowMap);
			}
		} catch (Exception e) {
			return null;
		}
		
		return list;
		
		
	}
	
	public void Close() {
		try {
			conn.close();
		} catch (Exception e) {
			
		}
	}
	
	
}
