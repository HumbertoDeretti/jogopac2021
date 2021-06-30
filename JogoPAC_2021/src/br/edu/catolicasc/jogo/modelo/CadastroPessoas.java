package br.edu.catolicasc.jogo.modelo;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import br.edu.catolicasc.parametros.Globais;
import br.edu.catolicasc.services.AvatarFocus;
import br.edu.catolicasc.services.ComponentesUtils;
import br.edu.catolicasc.services.MysqlUtil;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class CadastroPessoas extends JFrame {

	
	private static final long serialVersionUID = 983030616361762662L;
	private JTextField txtNomePessoa;
	private JTextField txtDataNascimento;
	@SuppressWarnings("unused")
	private MysqlUtil bd = MysqlUtil.getInstance();
	private static String sql;
	private static String error;
	private ComponentesUtils cUtils = new ComponentesUtils();
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPessoas frame = new CadastroPessoas();
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
	public CadastroPessoas() {
		setSize(new Dimension(490, 340));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Cadastrar Pessoa");
		getContentPane().setLayout(null);
		setResizable(false);
		
		JLabel NomePessoa = new JLabel("Nome: ");
		NomePessoa.setHorizontalAlignment(SwingConstants.RIGHT);
		NomePessoa.setFont(new Font(Globais.FONT_NAME, Font.PLAIN, Globais.FONT_SIZE));
		NomePessoa.setBounds(-1, 167, 113, 13);
		getContentPane().add(NomePessoa);
		
		txtNomePessoa = new JTextField();
		txtNomePessoa.setFont(new Font(Globais.FONT_NAME, Font.PLAIN, Globais.FONT_SIZE));
		NomePessoa.setLabelFor(txtNomePessoa);
		txtNomePessoa.setBounds(113, 159, 243, 30);
		getContentPane().add(txtNomePessoa);
		txtNomePessoa.setColumns(20);
		
		JLabel DataNascimento = new JLabel("Data de Nasc.: ");
		DataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		DataNascimento.setFont(new Font(Globais.FONT_NAME, Font.PLAIN, Globais.FONT_SIZE));
		DataNascimento.setBounds(-2, 163, 113, 100);
		getContentPane().add(DataNascimento);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setFont(new Font(Globais.FONT_NAME, Font.PLAIN,  Globais.FONT_SIZE));
		NomePessoa.setLabelFor(txtDataNascimento);
		txtDataNascimento.setBounds(113, 200, 243, 30);
		getContentPane().add(txtDataNascimento);
		txtDataNascimento.setColumns(20);
		
		// Fotos Avatares
		ButtonGroup groupAvatar = new ButtonGroup();
		
		JRadioButton Avatar1 = new JRadioButton(cUtils.imageResource("Avatar_10.jpg",55,55));
		Avatar1.addFocusListener(new AvatarFocus(Avatar1));
		Avatar1.setSelected(true);
		Avatar1.setActionCommand("Avatar_10");
		Avatar1.setBounds(87, 25, 55, 55);
		getContentPane().add(Avatar1);
		
		JRadioButton Avatar2 = new JRadioButton(cUtils.imageResource("Avatar_01.jpg",55,55));
		Avatar2.addFocusListener(new AvatarFocus(Avatar2));
		Avatar2.setActionCommand("Avatar_01");
		Avatar2.setBounds(147, 25, 55, 55);
		getContentPane().add(Avatar2);
		
		JRadioButton Avatar3 = new JRadioButton(cUtils.imageResource("Avatar_02.jpg",55,55));
		Avatar3.addFocusListener(new AvatarFocus(Avatar3));
		Avatar3.setActionCommand("Avatar_02");
		Avatar3.setBounds(207, 25, 55, 55);
		getContentPane().add(Avatar3);
		
		JRadioButton Avatar4 = new JRadioButton(cUtils.imageResource("Avatar_03.jpg",55,55));
		Avatar4.addFocusListener(new AvatarFocus(Avatar4));
		Avatar4.setActionCommand("Avatar_03");
		Avatar4.setBounds(267, 25, 55, 55);
		getContentPane().add(Avatar4);
		
		JRadioButton Avatar5 = new JRadioButton(cUtils.imageResource("Avatar_04.jpg",55,55));
		Avatar5.addFocusListener(new AvatarFocus(Avatar5));
		Avatar5.setActionCommand("Avatar_04");
		Avatar5.setBounds(327, 25, 55, 55);
		getContentPane().add(Avatar5);
		
		JRadioButton Avatar6 = new JRadioButton(cUtils.imageResource("Avatar_05.jpg",55,55));
		Avatar6.addFocusListener(new AvatarFocus(Avatar6));
		Avatar6.setActionCommand("Avatar_05");
		Avatar6.setBounds(87, 85, 55, 55);
		getContentPane().add(Avatar6);
		
		JRadioButton Avatar7 = new JRadioButton(cUtils.imageResource("Avatar_06.jpg",55,55));
		Avatar7.addFocusListener(new AvatarFocus(Avatar7));
		Avatar7.setActionCommand("Avatar_06");
		Avatar7.setBounds(147, 85, 55, 55);
		getContentPane().add(Avatar7);
		
		JRadioButton Avatar8 = new JRadioButton(cUtils.imageResource("Avatar_07.jpg",55,55));
		Avatar8.addFocusListener(new AvatarFocus(Avatar8));
		Avatar8.setActionCommand("Avatar_07");
		Avatar8.setBounds(207, 85, 55, 55);
		getContentPane().add(Avatar8);
		
		JRadioButton Avatar9 = new JRadioButton(cUtils.imageResource("Avatar_08.jpg",55,55));
		Avatar9.addFocusListener(new AvatarFocus(Avatar9));
		Avatar9.setBounds(267, 85, 55, 55);
		Avatar9.setActionCommand("Avatar_08");
		getContentPane().add(Avatar9);
		
		JRadioButton Avatar10 = new JRadioButton(cUtils.imageResource("Avatar_09.jpg",55,55));
		Avatar10.addFocusListener(new AvatarFocus(Avatar10));
		Avatar10.setBounds(327, 85, 55, 55);
		Avatar10.setActionCommand("Avatar_09");
		getContentPane().add(Avatar10);
		
		groupAvatar.add(Avatar1);
		groupAvatar.add(Avatar2);
		groupAvatar.add(Avatar3);
		groupAvatar.add(Avatar4);
		groupAvatar.add(Avatar5);
		groupAvatar.add(Avatar6);
		groupAvatar.add(Avatar7);
		groupAvatar.add(Avatar8);
		groupAvatar.add(Avatar9);
		groupAvatar.add(Avatar10);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				System.out.println("Select: " + groupAvatar.getSelection().getActionCommand());
			
			}
		});
		btCadastrar.setForeground(new Color(255, 255, 255));
		btCadastrar.setBackground(new Color(154, 205, 50));
		btCadastrar.setFont(new Font(Globais.FONT_NAME, Font.PLAIN, Globais.FONT_SIZE_TITLE));
		btCadastrar.setBounds(111, 245, 243, 35); 
		getContentPane().add(btCadastrar);
	}
}
