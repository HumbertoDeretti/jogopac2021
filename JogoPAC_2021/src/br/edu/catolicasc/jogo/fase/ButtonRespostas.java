package br.edu.catolicasc.jogo.fase;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import br.edu.catolicasc.parametros.Globais;

public class ButtonRespostas extends JButton implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8698217818012188809L;
	private String nome;
	private String commandValue;
	private String resposta;
	private Fase fase;

	protected int id = 0;

	public ButtonRespostas(String nome, String commandValue, String resposta, Fase fase) {
		this.id++;
		this.nome = nome;
		this.commandValue = commandValue;
		this.resposta = resposta;
		this.fase = fase;

		setText(this.nome);
		setActionCommand(this.commandValue);
		setBackground(Color.decode("#AFD3DB"));
	
		// setOpaque(false);//BOTAO SEM FUNDO
		// setContentAreaFilled(false);//BOTAO SEM FUNDO
		// setBorderPainted(false);//BOTAO SEM FUNDO

		setFont(new Font(Globais.FONT_NAME_RESPOSTA, Font.BOLD, Globais.FONT_SIZE_RESPOSTA));
		setSize(200, 50);

		addActionListener(this);
		addMouseListener(this);

		setVisible(true);

	}

	public String getNome() {
		return nome;
	}

	public String getCommandValue() {
		return commandValue;
	}

	public void actionPerformed(ActionEvent e) {
		if (commandValue.equals(resposta)) {
			fase.validar(0);

		} else {
			fase.validar(1);
		}
	}

	public void mouseEntered(java.awt.event.MouseEvent evt) {
		
		//setBorder(BorderFactory.createBevelBorder(1, Color.CYAN, Color.MAGENTA));
		setBackground(Color.decode("#B35D93"));
	}

	public void mouseExited(java.awt.event.MouseEvent evt) {
		//setOpaque(false);
		setBackground(Color.decode("#AFD3DB"));
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}
}
