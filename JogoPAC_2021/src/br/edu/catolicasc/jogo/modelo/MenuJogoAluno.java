package br.edu.catolicasc.jogo.modelo;

import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

import br.edu.catolicasc.jogo.fase.Fase;
import br.edu.catolicasc.parametros.UsuarioAtivo;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuJogoAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7168976433054476308L;
	private JPanel contentPane;
	private boolean ativo = false;
	private boolean btJogarBOOL = true;
	private int idFase = 1;
	private JButton btJogar;
	private MenuJogoAluno menu;
	
	public MenuJogoAluno() {
		ativo = true;
		menu = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 728);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		try {
			idFase = Integer.parseInt(UsuarioAtivo.getLastStage())+1;
		} catch (Exception e) {
			idFase = 1;
		}
		
		
		
		btJogar =  new JButtonJogo("Jogar Fase "+ Integer.toString(idFase));
		if(idFase>10) {
			btJogar.setText("Em breve +");
			btJogar.setForeground(Color.RED);
			btJogar.setFont(new Font("Arial", Font.BOLD, 20));
			btJogarBOOL = false;
		}
		btJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btJogarBOOL) {
					new Fase(idFase,menu);
					setVisivel();
				}
				
			}
		});
		
		
		JButton btRankingTurma =  new JButtonJogo("Ranking da Turma");
		btRankingTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaRanking(menu);
				setVisivel();
			}
		});
		
		JButton btRankingAluno =  new JButtonJogo("Ranking Aluno");
		btRankingAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new TelaRankingAluno(menu);
				setVisivel();
			}
		});
		
		
		//btRankingTurma.setForeground(new Color(255, 255, 255));
		btRankingTurma.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		btRankingTurma.setBounds(198, 275, 150, 60);
		btRankingTurma.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btRankingTurma.setOpaque(false); 
		contentPane.add(btRankingTurma);
		
		//btRankingAluno.setForeground(new Color(255, 255, 255));
		btRankingAluno.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		btRankingAluno.setBounds(205, 345, 150, 60);
		btRankingAluno.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btRankingAluno.setOpaque(false);
		contentPane.add(btRankingAluno); 
		
		//btRankingAluno.setForeground(new Color(255, 255, 255));
		btJogar.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		btJogar.setBounds(200, 195, 150, 60);
		btJogar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		btJogar.setOpaque(false);
		contentPane.add(btJogar);
		
		JLabel lblNewLabel_2 = new JLabel(imageResource("Cerebro.png", 100, 75));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_2.setBounds(140, 125, 100, 75);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(imageResource("CerebroDoente.png", 175, 175));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_3.setBounds(480, 475, 175, 175);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(imageResource("CerebroExercicio.png", 225, 225));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_4.setBounds(745, 275, 225, 225);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(imageResource("CerebroMusculoso.png", 225, 175));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_5.setBounds(465, 120, 225, 225);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewJgoodiesTitle =  new JLabel("Cerebelo Brain");
		lblNewJgoodiesTitle.setForeground(new Color(0, 191, 255));
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewJgoodiesTitle.setBounds(135, 60, 300, 100);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 =  new JLabel("Game");
		lblNewJgoodiesTitle_1.setForeground(new Color(255, 165, 0));
		lblNewJgoodiesTitle_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewJgoodiesTitle_1.setBounds(287, 100, 114, 100);
		contentPane.add(lblNewJgoodiesTitle_1);
		lblNewJgoodiesTitle_1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		
		JLabel lblNewLabel_8 = new JLabel(imageResource("Botao1.png", 150, 60));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_8.setBounds(195, 200, 150, 60);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(imageResource("Botao.png", 150, 60));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_9.setBounds(195, 275, 150, 60);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_6 = new JLabel(imageResource("Botao2.png", 150, 60));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_6.setBounds(195, 350, 150, 60);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel(imageResource("QuadroBranco.png", 750, 600));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 41));
		lblNewLabel_1.setBounds(0, -50, 750, 600);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(imageResource("SalaDeAula.png", 1024, 728));
		lblNewLabel.setBounds(0,0,1024,728);
		contentPane.add(lblNewLabel);
		
		setVisible(true);
		
	}
	public void setVisivel() {
		if(ativo) {
			ativo = false;
		}else {
			ativo = true;
		}
		UsuarioAtivo.Update();
		idFase = Integer.parseInt(UsuarioAtivo.getLastStage())+1;
		if(idFase>10) {
			btJogar.setText("Em breve +");
			btJogar.setForeground(Color.RED);
			btJogar.setFont(new Font("Arial", Font.BOLD, 20));
			btJogarBOOL = false;
		}else {
			btJogar.setText("Jogar Fase "+ Integer.toString(idFase));
		}
		
		
		setVisible(ativo);
	}
	private ImageIcon imageResource(String path,int w,int h) {
		
		ImageIcon img;
		try {
			if(w==0) {
				img = new ImageIcon(getClass().getResource("/resources/"+path));
			}else {
				img = new ImageIcon(new ImageIcon(getClass().getResource("/resources/"+path)).getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH));
				
			}
			return img;
		} catch (Exception e) {
			System.out.println("ERRO ARQUIVO "+path);
			System.out.println(e);
			return null;
		}
		
		
		
		
		
	}
}