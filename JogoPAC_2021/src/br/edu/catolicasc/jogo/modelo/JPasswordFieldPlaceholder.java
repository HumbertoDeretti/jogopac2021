package br.edu.catolicasc.jogo.modelo;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPasswordField;

public class JPasswordFieldPlaceholder extends JPasswordField {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JPasswordFieldPlaceholder(String texto) {
		setText(texto);
		addFocusListener(new FocusListener() {
			@SuppressWarnings("deprecation")
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
