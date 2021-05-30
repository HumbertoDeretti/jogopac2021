package br.edu.catolicasc.jogo.modelo;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;

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
		
		JButton btnNewButton = new JButton("Cadastrar S\u00E9rie");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TesteCadastroSerie();
			}
		});
		btnNewButton.setBounds(331, 72, 190, 41);
		getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(215, 261, 206, 21);
		getContentPane().add(comboBox);
		
		setVisible(true);
		printDados();
	}
	
	public void printDados() {
		System.out.println(UsuarioAtivo.getNome());
	}
}
