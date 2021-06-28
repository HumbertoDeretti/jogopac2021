package br.edu.catolicasc.jogo.modelo;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class JButtonJogo extends JButton implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3064976821766400819L;
	
	public JButtonJogo(String name) {
		setText(name);
		setOpaque(false);//BOTAO SEM FUNDO
		setContentAreaFilled(false);//BOTAO SEM FUNDO
		setBorderPainted(false);//BOTAO SEM FUNDO
		addMouseListener(this);
	}
	public JButtonJogo(Icon icon) {
		setIcon(icon);
		setOpaque(false);//BOTAO SEM FUNDO
		setContentAreaFilled(false);//BOTAO SEM FUNDO
		setBorderPainted(false);//BOTAO SEM FUNDO
		addMouseListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		setForeground(Color.MAGENTA);
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		setForeground(Color.BLACK);
		
	}
	
}
