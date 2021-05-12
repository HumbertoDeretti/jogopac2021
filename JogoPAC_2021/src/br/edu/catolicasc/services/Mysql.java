/**
 * 
 */
package br.edu.catolicasc.services;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Projeto PACS
 *
 */
/*
Server: sql10.freemysqlhosting.net
Name: sql10411872
Username: sql10411872
Password: 7dEvbLFuCI
Port number: 3306
 */
public class Mysql {
	private Connection conn = null;
	private String user;
	private String password;
	private String host;
	private String port;
	private String base;
	
	
	/**
	 * @param user - Usuário do Banco de Dados
	 * @param password - Senha do Banco de Dados
	 * @param host - IP ou Domínio do Banco de Dados
	 * @param port - Porta do Banco de Dados
	 * @param base - Nome da Banco de Dados
	 */
	public Mysql(String user,String password,String host,String port,String base) {
		this.user = user;
		this.password = password;
		this.host = host;
		this.port = port;
		this.base = base;
	}
	public boolean Conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+this.host+":"+this.port+"/"+this.base+"",this.user,this.password);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	public boolean Close() {
		try {
			conn.close();
			return true;			
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
}
