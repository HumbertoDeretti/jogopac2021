package br.edu.catolicasc.jogo.modelo;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import br.edu.catolicasc.services.MysqlUtil;

import java.awt.event.ActionListener;

import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2438794617558804165L;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JPasswordField passwordField;
    private MysqlUtil bd;
	
	public Login() {
		bd = new MysqlUtil();
		
		setBackground(SystemColor.menu);
		
		getContentPane().setLayout(null);
		setTitle("The Loggic Game");
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		JButton btLogin = new JButton("Entrar");
		btLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btLogin.setForeground(SystemColor.controlLtHighlight);
		btLogin.setBackground(SystemColor.textHighlight);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtLogin.getText());
				System.out.println(txtSenha.getText());
				try {
					if(!bd.ValidaUser("master", "master",bd.getInstance().getConnection())) {
						System.out.println("Usuario ou senha inválido.");
					}else {
						System.out.println("Conectado");
					}
				} catch (Exception ex) {
					System.out.println(ex);
					System.out.println("Errou baka");
				}
				
			}
		});
		
		btLogin.setBounds(374, 455, 294, 64);
		getContentPane().add(btLogin);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(374, 245, 294, 40);
		getContentPane().add(txtLogin);
		txtLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtLogin.setOpaque(false);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtSenha.setOpaque(false);
		
		txtSenha.setBounds(374, 330, 294, 40);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lbBackgroud = new JLabel(imageResource("a"));
		lbBackgroud.setBounds(0, 0, 1024, 576);
		getContentPane().add(lbBackgroud);
		
	
		
		setVisible(true);
		

	}
	private ImageIcon imageResource(String path) {
		ImageIcon img;
		img = new ImageIcon(getClass().getResource("/resources/wpBrain.png"));
		return img;
		
	}
}
