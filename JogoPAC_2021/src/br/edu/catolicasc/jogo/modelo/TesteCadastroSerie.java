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
import javax.swing.ImageIcon;

public class TesteCadastroSerie extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3349417742695400872L;
	private JTextField txtSerieName;
    private MysqlUtil bd = MysqlUtil.getInstance();
  
    
	public TesteCadastroSerie() {
		
		setSize(new Dimension(1024, 615));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cadastro de S\u00E9ries");
		setResizable(false);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Nome da S\u00E9rie:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(280, 257, 113, 13);
		getContentPane().add(lblNewLabel);
		
		txtSerieName = new JTextField();
		txtSerieName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setLabelFor(txtSerieName);
		txtSerieName.setBounds(400, 250, 243, 30);
		getContentPane().add(txtSerieName);
		txtSerieName.setColumns(20);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bd.newSerie(txtSerieName.getText(),bd.getConnection());
			}
		});
		btCadastrar.setForeground(new Color(255, 255, 255));
		btCadastrar.setBackground(new Color(154, 205, 50));
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCadastrar.setBounds(400, 300, 243, 35);
		getContentPane().add(btCadastrar);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(TesteCadastroSerie.class.getResource("/resources/SalaDeAula.png")));
		lblNewLabel_1.setSize(1024, 615);
		//lblNewLabel_1.setBounds(0, 0, 700, 233);
		getContentPane().add(lblNewLabel_1);
		setVisible(true);
		
		
	}
}
