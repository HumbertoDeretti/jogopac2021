package br.edu.catolicasc.jogo.modelo;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2438794617558804165L;
	private JTextField txtLogin;
	private JTextField txtSenha;

	
	public Login() {
		
		
		setBackground(SystemColor.menu);
		getContentPane().setLayout(null);
		setTitle("The Loggic Game");
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		JButton btLogin = new JButton("Entrar");
		btLogin.setForeground(SystemColor.controlLtHighlight);
		btLogin.setBackground(SystemColor.textHighlight);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(txtLogin.getText());
				System.out.println(txtSenha.getText());
			}
		});
		
		btLogin.setBounds(10, 168, 360, 40);
		getContentPane().add(btLogin);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(10, 32, 360, 40);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtSenha = new JTextField();
		txtSenha.setBounds(10, 106, 360, 40);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 374, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 83, 374, 20);
		getContentPane().add(lblNewLabel_1);
		
		
		setVisible(true);
		

	}
}
