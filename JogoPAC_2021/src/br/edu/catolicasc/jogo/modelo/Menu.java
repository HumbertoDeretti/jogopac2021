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
	private Componentes compo;

	public Menu() {
		compo = new Componentes();
		
		setTitle("The Loggic Game");
		setSize(1024, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setLayout(null);
		add(compo.label("Login:", "lb_login", 5, 10, 40, 30));
		add(compo.textBox("", "txtLogin", 50, 10, 200, 30));
		add(compo.label("Senha:", "lb_senha", 5, 50, 40, 30));
		add(compo.textBox("", "txtSenha", 50, 50, 200, 30));
		add(compo.button("LOGAR", "bt_logon", 5, 90,245, 30, true, true));
		add(compo.button("DESCONECTAR", "bt_logoff", 5, 125,245, 30, true, true));
		
	}
	
	public void isVisivle(boolean var) {
		setVisible(var);
	}
	public void refresh() {
		this.repaint();
		/*
		 * this.invalidate();
			this.validate();
			this.repaint();
		 * 
		 */
	}
}
