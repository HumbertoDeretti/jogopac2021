package br.edu.catolicasc.jogo.modelo;

import javax.swing.JFrame;
import javax.swing.JLabel;

import br.edu.catolicasc.parametros.UsuarioAtivo;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class PrintUsuarioAtivo extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 418606821364068978L;
	
	
	
	public PrintUsuarioAtivo(String usuario,Connection conn) {
		
		
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
		
		JComboBox<Serie> cbSerie = new JComboBox<Serie>();
		cbSerie.setBounds(10, 261, 221, 21);
		Serie cbSerieModel = new Serie();
		cbSerieModel.show(cbSerie, conn);
		getContentPane().add(cbSerie);
		
		JComboBox<Turma> cbTurma = new JComboBox<Turma>();
		cbTurma.setBounds(300, 261, 221, 21);
		Turma cbTurmaModel = new Turma();
		cbTurmaModel.show(cbTurma, conn);
		getContentPane().add(cbTurma);
		
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(cbSerie.getItemAt(cbSerie.getSelectedIndex()).getId());
				System.out.println(cbTurma.getItemAt(cbTurma.getSelectedIndex()).getId());
			}
		});
		btnNewButton_1.setBounds(576, 261, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		setVisible(true);
		
	}
	
	
	
	
}
