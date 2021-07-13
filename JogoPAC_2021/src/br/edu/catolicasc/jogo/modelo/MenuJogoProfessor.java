package br.edu.catolicasc.jogo.modelo;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;

public class MenuJogoProfessor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6020196052955276117L;
	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public MenuJogoProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 728);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		
		JButton btCadastroTurma =  new JButtonJogo("Cadastro de Turma");
		btCadastroTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TesteCadastroSerie();
				
			}
		});
		btCadastroTurma.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		btCadastroTurma.setBounds(655, 230, 250, 65);
		contentPane.add(btCadastroTurma);
		
		
		JButton btCadastroAluno =  new JButtonJogo("Cadastro de Aluno");
		btCadastroAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new CadastroPessoas();
				
			}
		});
		btCadastroAluno.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		btCadastroAluno.setBounds(520, 315, 250, 65);
		contentPane.add(btCadastroAluno);

		JLabel lblNewJgoodiesTitle = new JLabel("Menu do");
		lblNewJgoodiesTitle.setForeground(new Color(244, 164, 96));
		lblNewJgoodiesTitle.setFont(new Font("Wide Latin", Font.PLAIN, 36));
		lblNewJgoodiesTitle.setBounds(540, 110, 340, 65);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = new JLabel("Professor");
		lblNewJgoodiesTitle_1.setForeground(new Color(173, 255, 47));
		lblNewJgoodiesTitle_1.setFont(new Font("Wide Latin", Font.PLAIN, 36));
		lblNewJgoodiesTitle_1.setBounds(580, 140, 340, 65);
		contentPane.add(lblNewJgoodiesTitle_1);
		
		
		JLabel lblNewLabel_6 = new JLabel(imageResource("Botao1.png", 200, 75));
		lblNewLabel_6.setBounds(675, 230, 200, 75);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewJgoodiesLabel_2 = new JLabel("Cadastro de Aluno");
		lblNewJgoodiesLabel_2.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewJgoodiesLabel_2.setBounds(575, 315, 160, 65);
		contentPane.add(lblNewJgoodiesLabel_2);
		JLabel lblNewLabel_5 = new JLabel(imageResource("Botao.png", 200, 75));
		lblNewLabel_5.setBounds(555, 310, 200, 75);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewJgoodiesLabel_3 =  new JLabel("Ranking da Turma");
		lblNewJgoodiesLabel_3.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_3.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewJgoodiesLabel_3.setBounds(700, 390, 160, 65);
		contentPane.add(lblNewJgoodiesLabel_3);
		JLabel lblNewLabel_4 = new JLabel(imageResource("Botao2.png", 200, 75));
		lblNewLabel_4.setBounds(675, 390, 200, 75);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewJgoodiesLabel_4 =  new JLabel("Ranking de Alunos");
		lblNewJgoodiesLabel_4.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_4.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewJgoodiesLabel_4.setBounds(575, 475, 160, 65);
		contentPane.add(lblNewJgoodiesLabel_4);
		JLabel lblNewLabel_7 = new JLabel(imageResource("Botao3.png", 200, 75));
		lblNewLabel_7.setBounds(555, 470, 200, 75);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel(imageResource("Professora.png", 500, 600));
		lblNewLabel_3.setBounds(-75, 155, 500, 600);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel(imageResource("Professor.png", 500, 600));
		lblNewLabel_2.setBounds(200, 155, 500, 600);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel(imageResource("QuadroBranco.png", 700, 800));
		lblNewLabel.setBounds(470, -80, 700, 800);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(imageResource("SalaDeAula_1.jpg", 1024, 728));
		lblNewLabel_1.setBounds(0,0,1024,728);
		contentPane.add(lblNewLabel_1);
		
		setVisible(true);
	}
	
	private ImageIcon imageResource(String path,int w,int h) {
		
		ImageIcon img;
		if(w==0) {
			img = new ImageIcon(getClass().getResource("/resources/"+path));
		}else {
			img = new ImageIcon(new ImageIcon(getClass().getResource("/resources/"+path)).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
		}
		
		return img;
		
	}
}
