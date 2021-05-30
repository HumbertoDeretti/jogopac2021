package br.edu.catolicasc.jogo.modelo;

public class Serie {
	private int idSerie;
	private String nome;
	
	public Serie() {
		
	}
	public Serie(int idSerie,String nome) {
		this.idSerie = idSerie;
		this.nome = nome;
	}
	public int getIdSerie() {
		return idSerie;
	}
	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}
	@Override
	public String toString() {
		return nome;
	}
}
