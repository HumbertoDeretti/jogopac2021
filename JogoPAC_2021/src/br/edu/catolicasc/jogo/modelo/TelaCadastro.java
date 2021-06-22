package br.edu.catolicasc.jogo.modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import java.awt.Font;

public class TelaCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtLogin;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		getContentPane().setLayout(null);
		
		JLabel imgBackground = new JLabel("New label");
		imgBackground.setIcon(new ImageIcon(TelaCadastro.class.getResource("/resources/menu.png")));
		imgBackground.setBounds(0, 0, 1024, 615);
		getContentPane().add(imgBackground);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Harrington", Font.PLAIN, 36));
		txtLogin.setToolTipText("");
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setDropMode(DropMode.INSERT);
		txtLogin.setBackground(Color.WHITE);
		txtLogin.setForeground(Color.BLACK);
		txtLogin.setBounds(114, 233, 191, 32);
		getContentPane().add(txtLogin);
	
		txtPassword = new JPasswordField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setBounds(114, 315, 191, 32);
		getContentPane().add(txtPassword);
		
		
		
	}
}
