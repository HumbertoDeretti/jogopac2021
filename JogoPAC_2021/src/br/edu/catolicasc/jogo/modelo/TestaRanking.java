package br.edu.catolicasc.jogo.modelo;

import br.edu.catolicasc.services.MysqlUtil;


public class TestaRanking {
	
	private static MysqlUtil banco;
		


public static void main (String args[]){

	banco = new MysqlUtil();
	banco.SelectRanking();
}

}

