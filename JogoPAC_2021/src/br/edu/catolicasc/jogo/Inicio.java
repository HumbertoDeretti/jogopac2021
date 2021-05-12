package br.edu.catolicasc.jogo;

import br.edu.catolicasc.jogo.modelo.Menu;
import br.edu.catolicasc.services.MysqlUtil;


public class Inicio {

	public static void main(String[] args) {
		MysqlUtil bd = new MysqlUtil();
		Menu menu = new Menu();
		
		menu.isVisivle(true);
		try {
			if(!bd.ValidaUser("master", "master",bd.getInstance().getConnection())) {
				System.out.println("Usuario ou senha inválido.");
			}else {
				System.out.println("Conectado");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
