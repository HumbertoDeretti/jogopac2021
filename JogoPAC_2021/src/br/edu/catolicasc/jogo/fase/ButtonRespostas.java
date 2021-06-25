package br.edu.catolicasc.jogo.fase;

import javax.swing.JButton;

public class ButtonRespostas extends JButton{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8698217818012188809L;
	private String nome;
	private String commandValue;
	protected int id=0;
	
	public ButtonRespostas(String nome, String commandValue) {
		this.id++;
		this.nome = nome;
		this.commandValue = commandValue;
		setText(this.nome);
		setActionCommand(this.commandValue);
	
	
		setSize(200, 30);
		setVisible(true);
	}
	
	
	
	public String getNome() {
		return nome;
	}

	public String getCommandValue() {
		return commandValue;
	}
	
	
}
