package br.edu.catolicasc.jogo.modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.catolicasc.services.ComponentesUtils;
import br.edu.catolicasc.services.MysqlUtil;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;

public class CadastroPessoas extends JFrame {

	private JTextField txtNomePessoa;
	private JTextField txtDataNascimento;
	private MysqlUtil bd = MysqlUtil.getInstance();
	private ComponentesUtils cUtils = new ComponentesUtils();
	/**
	 * Launch the application.
	 */
	/*
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
	*/
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
		NomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NomePessoa.setBounds(-1, 167, 113, 13);
		getContentPane().add(NomePessoa);
		
		txtNomePessoa = new JTextField();
		txtNomePessoa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NomePessoa.setLabelFor(txtNomePessoa);
		txtNomePessoa.setBounds(113, 159, 243, 30);
		getContentPane().add(txtNomePessoa);
		txtNomePessoa.setColumns(20);
		
		JLabel DataNascimento = new JLabel("Data de Nasc.: ");
		DataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		DataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DataNascimento.setBounds(-2, 163, 113, 100);
		getContentPane().add(DataNascimento);
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		NomePessoa.setLabelFor(txtDataNascimento);
		txtDataNascimento.setBounds(113, 200, 243, 30);
		getContentPane().add(txtDataNascimento);
		txtDataNascimento.setColumns(20);
		
		// Fotos Avatares
		ButtonGroup groupAvatar = new ButtonGroup();
		
		JRadioButton Avatar1 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar1.setSelected(true);
		Avatar1.setBounds(87, 25, 55, 55);
		getContentPane().add(Avatar1);
		
		JRadioButton Avatar2 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar2.setBounds(147, 25, 55, 55);
		getContentPane().add(Avatar2);
		
		JRadioButton Avatar3 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar3.setBounds(207, 25, 55, 55);
		getContentPane().add(Avatar3);
		
		JRadioButton Avatar4 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar4.setBounds(267, 25, 55, 55);
		getContentPane().add(Avatar4);
		
		JRadioButton Avatar5 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar5.setBounds(327, 25, 55, 55);
		getContentPane().add(Avatar5);
		
		JRadioButton Avatar6 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar6.setBounds(87, 85, 55, 55);
		getContentPane().add(Avatar6);
		
		JRadioButton Avatar7 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar7.setBounds(147, 85, 55, 55);
		getContentPane().add(Avatar7);
		
		JRadioButton Avatar8 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar8.setBounds(207, 85, 55, 55);
		getContentPane().add(Avatar8);
		
		JRadioButton Avatar9 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar9.setBounds(267, 85, 55, 55);
		getContentPane().add(Avatar9);
		
		JRadioButton Avatar10 = new JRadioButton(cUtils.imageResource("menu.png",55,55));
		Avatar10.setBounds(327, 85, 55, 55);
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
				/*bd.newSerie(txtNomePessoa.getText(),bd.getConnection());
				if(Avatar1.isSelected()) {
					System.out.println("Avatar 1");
				}else if(Avatar2.isSelected()) {
					System.out.println("Avatar 2");
				}else if(Avatar3.isSelected()) {
					System.out.println("Avatar 3");
				}else if(Avatar4.isSelected()) {
					System.out.println("Avatar 4");
				}else if(Avatar5.isSelected()) {
					System.out.println("Avatar 5");
				}else if(Avatar6.isSelected()) {
					System.out.println("Avatar 6");
				}else if(Avatar7.isSelected()) {
					System.out.println("Avatar 7");
				}else if(Avatar8.isSelected()) {
					System.out.println("Avatar 8");
				}else if(Avatar9.isSelected()) {
					System.out.println("Avatar 9");
				}else if(Avatar10.isSelected()) {
					System.out.println("Avatar 10");
				}else {
					System.out.println("Nenhum selecionado!!");
				}*/
			}
		});
		btCadastrar.setForeground(new Color(255, 255, 255));
		btCadastrar.setBackground(new Color(154, 205, 50));
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCadastrar.setBounds(111, 245, 243, 35);
		getContentPane().add(btCadastrar);
	}
}
