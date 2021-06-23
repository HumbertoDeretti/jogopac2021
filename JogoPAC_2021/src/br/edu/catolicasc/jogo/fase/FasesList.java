package br.edu.catolicasc.jogo.fase;

public class FasesList {

	private int idFase;
	private int iDificuldade;
	private int iResposta;
	private String iPergunta;
	private String iImgPath;

	public FasesList(int idFase, int iDificuldade, int iResposta, String iPergunta, String iImgPath) {
		this.idFase = idFase;
		this.iDificuldade = iDificuldade;
		this.iResposta = iResposta;
		this.iPergunta = iPergunta;
		this.iImgPath = iImgPath;
	}

	public int getIdFase() {
		return idFase;
	}

	public int getiDificuldade() {
		return iDificuldade;
	}

	public int getiResposta() {
		return iResposta;
	}

	public String getiPergunta() {
		return iPergunta;
	}

	public String getiImgPath() {
		return iImgPath;
	}
	
	
	
	
}
