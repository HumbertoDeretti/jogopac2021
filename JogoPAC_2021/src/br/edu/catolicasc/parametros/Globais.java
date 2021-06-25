package br.edu.catolicasc.parametros;

public abstract class Globais {
	
	//FASE
	public static int PONTUACAO_INICIAL = 10;

	//AVATARES
	
	public final static int LARGURA_AVATAR = 60;
	public final static int ALTURA_AVATAR = 60;
	
	//PADRÕES DE FONTS
	
	public final static int FONT_SIZE_TITLE = 20;
	public final static int FONT_SIZE = 14;

	public final static String FONT_NAME_TITLE = "Arial Black";
	public final static String FONT_NAME = "Arial";
	
	public final static String FONT_NAME_RESPOSTA = "Century Gothic";
	public final static int FONT_SIZE_RESPOSTA = 20;
	
	
	
	
	
	public static String getPONTUACAO_INICIAL() {
		return Integer.toString(PONTUACAO_INICIAL);
	}
	public static void setPONTUACAO_INICIAL(int i) {
		Globais.PONTUACAO_INICIAL -= i;
	}
}
