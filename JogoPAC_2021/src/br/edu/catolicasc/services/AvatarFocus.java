package br.edu.catolicasc.services;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JRadioButton;

public class AvatarFocus extends FocusAdapter {
	private JRadioButton item;
	public AvatarFocus(JRadioButton item) {
		this.item = item;
	}
	
	public void focusGained(FocusEvent e) {
		item.setBorderPainted(true);
		item.setBackground(Color.blue);
	}

	public void focusLost(FocusEvent e) {
		item.setBorderPainted(false);
		item.setBackground(null);
	}
	
}
