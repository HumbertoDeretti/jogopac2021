/**
 * 
 */
package br.edu.catolicasc.jogo.modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

/**
 * @author Grupo PAC 3
 *
 */
public class Menu extends JFrame implements ActionListener {

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
		add(compo.button("LOGAR", "bt_logon", 5, 90,245, 30, true, true,this));
		add(compo.button("DESCONECTAR", "bt_logoff", 5, 125,245, 30, true, true,this));
		
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
	@Override
	public void actionPerformed(ActionEvent e) {
		String origem =  e.getSource().toString().replace('[',',').replace(']',' ');
		String[] obj = origem.split(",");
		//obj[1]  Contém nome do componente setado pelo setName()
		if(obj[1].equals("bt_logon")) {
			System.out.println("Botao Logon Clicado");
			
		}
		else if(obj[1].equals("bt_logoff")) {
			System.out.println("Botao Logoff Clicado");
		}
		
	}
}
