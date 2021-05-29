package br.edu.catolicasc.jogo.modelo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class PrintUsuarioAtivo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 418606821364068978L;
	
	
	
	public PrintUsuarioAtivo(String usuario) {
		
		
		setBackground(SystemColor.menu);
		
		getContentPane().setLayout(null);
		setTitle("The Loggic Game");
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		JLabel lbNome = new JLabel("Nome");
		lbNome.setBounds(10, 11, 46, 14);
		getContentPane().add(lbNome);
		
		JLabel lbNomeInfo = new JLabel("carregando...");
		lbNomeInfo.setBounds(66, 11, 125, 14);
		getContentPane().add(lbNomeInfo);
	
		lbNomeInfo.setText(UsuarioAtivo.getNome());//EXEMPLO DE COMO CHAMAR UM DADO DO USUARIO ATIVO
		
		setVisible(true);
		printDados();
	}
	
	public void printDados() {
		System.out.println(UsuarioAtivo.getNome());
	}
}
