/**
 * 
 */
package br.edu.catolicasc.jogo.modelo;

import javax.swing.JFrame;

/**
 * @author Grupo PAC 3
 *
 */
public class Menu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu() {
		setTitle("The Protagonista Game");
		setSize(1024, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);
		
	}
}
