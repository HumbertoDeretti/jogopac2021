package br.edu.catolicasc.jogo;

import br.edu.catolicasc.jogo.modelo.Menu;
import br.edu.catolicasc.services.Mysql;


public class Inicio {

	public static void main(String[] args) {
		//new Menu();
		Mysql bd = new Mysql("sql10411872","7dEvbLFuCI","sql10.freemysqlhosting.net","3306","sql10411872");
		if(bd.Conectar()) {
			System.out.println("Conectou");
		}
		else {
			System.out.println("Deu Merda");
		}
	}

}
