/**
 * 
 */
package br.edu.catolicasc.jogo.modelo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
		setTitle("The Loggic Game");
		setSize(1024, 728);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		setLayout(null);
		
		add(jLabel("Login:",5,10));
		add(textBox("","txtLogin",60,10));
		add(jLabel("Senha:",5,45));
		add(textBox("","txtSenha",60,45));
		
		
	}
	private JTextField textBox(String texto,String name,int x,int y) {
		JTextField textField = new JTextField();
		textField.setBounds(x, y, 200, 30);
		textField.setText(texto);
		textField.setName(name);
		return textField;
	}
	public JLabel jLabel (String texto,int x,int y) {
		JLabel jLabel = new JLabel(texto);
		jLabel.setBounds(x, y, 50, 30);
		return jLabel;
	}
	public void isVisivle(boolean var) {
		setVisible(var);
	}
	public void refresh() {
		this.repaint();
	}
}
