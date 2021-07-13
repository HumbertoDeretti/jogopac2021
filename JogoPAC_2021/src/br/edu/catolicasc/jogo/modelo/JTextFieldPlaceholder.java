package br.edu.catolicasc.jogo.modelo;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class JTextFieldPlaceholder extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTextFieldPlaceholder(String texto) {
		setText(texto);
		addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(texto)) {
					setText("");
					setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (getText().isEmpty()) {
					setForeground(Color.GRAY);
					setText(texto);
				}
			}

			
		});
	}

}
