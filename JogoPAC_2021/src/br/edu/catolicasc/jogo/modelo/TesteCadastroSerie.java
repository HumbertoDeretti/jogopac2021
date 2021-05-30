package br.edu.catolicasc.jogo.modelo;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import br.edu.catolicasc.services.MysqlUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TesteCadastroSerie extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3349417742695400872L;
	private JTextField txtSerieName;
    private MysqlUtil bd;
    
	public TesteCadastroSerie() {
		bd = new MysqlUtil();

		setSize(new Dimension(438, 152));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cadastro de S\u00E9ries");
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome da S\u00E9rie:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 17, 113, 13);
		getContentPane().add(lblNewLabel);
		
		txtSerieName = new JTextField();
		txtSerieName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setLabelFor(txtSerieName);
		txtSerieName.setBounds(143, 9, 243, 30);
		getContentPane().add(txtSerieName);
		txtSerieName.setColumns(20);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.newSerie(txtSerieName.getText(),bd.getInstance().getConnection());
			}
		});
		btCadastrar.setForeground(new Color(255, 255, 255));
		btCadastrar.setBackground(new Color(154, 205, 50));
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCadastrar.setBounds(143, 49, 243, 35);
		getContentPane().add(btCadastrar);
		setVisible(true);
	}
}
