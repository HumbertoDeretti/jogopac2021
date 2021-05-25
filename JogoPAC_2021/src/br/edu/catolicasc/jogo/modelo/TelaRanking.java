package br.edu.catolicasc.jogo.modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.DropMode;

public class TelaRanking extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRanking frame = new TelaRanking();
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
	public TelaRanking() {
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		getContentPane().setLayout(null);
		
		JTextPane aluno1 = new JTextPane();
		aluno1.setEditable(false);
		aluno1.setBounds(211, 152, 274, 31);
		getContentPane().add(aluno1);
		aluno1.setText( "Aluno 1" );  
		
		JTextPane aluno2 = new JTextPane();
		aluno2.setText("Aluno 2");
		aluno2.setEditable(false);
		aluno2.setBounds(211, 200, 274, 31);
		getContentPane().add(aluno2);
		
		JTextPane aluno3 = new JTextPane();
		aluno3.setText("Aluno 3");
		aluno3.setEditable(false);
		aluno3.setBounds(211, 249, 274, 31);
		getContentPane().add(aluno3);
		
		JTextPane aluno4 = new JTextPane();
		aluno4.setText("Aluno 4");
		aluno4.setEditable(false);
		aluno4.setBounds(211, 301, 274, 31);
		getContentPane().add(aluno4);
		
		JTextPane aluno5 = new JTextPane();
		aluno5.setText("Aluno 5");
		aluno5.setEditable(false);
		aluno5.setBounds(211, 350, 274, 31);
		getContentPane().add(aluno5);
		
		JTextPane pontuacao1 = new JTextPane();
		pontuacao1.setText("Pontuacao 1");
		pontuacao1.setEditable(false);
		pontuacao1.setBounds(520, 152, 274, 31);
		getContentPane().add(pontuacao1);
		
		JTextPane pontuacao2 = new JTextPane();
		pontuacao2.setText("Pontuacao 2");
		pontuacao2.setEditable(false);
		pontuacao2.setBounds(520, 200, 274, 31);
		getContentPane().add(pontuacao2);
		
		JTextPane pontuacao3 = new JTextPane();
		pontuacao3.setText("Pontuacao 3");
		pontuacao3.setEditable(false);
		pontuacao3.setBounds(520, 249, 274, 31);
		getContentPane().add(pontuacao3);
		
		JTextPane pontuacao4 = new JTextPane();
		pontuacao4.setText("Pontuacao 4");
		pontuacao4.setEditable(false);
		pontuacao4.setBounds(520, 301, 274, 31);
		getContentPane().add(pontuacao4);
		
		JTextPane pontuacao5 = new JTextPane();
		pontuacao5.setText("Pontuacao 5");
		pontuacao5.setEditable(false);
		pontuacao5.setBounds(520, 350, 274, 31);
		getContentPane().add(pontuacao5);
		
		//a
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaRanking.class.getResource("/resources/fundoranking2.jpg")));
		lblNewLabel.setBounds(0, 0, 1024, 615);
		getContentPane().add(lblNewLabel);
		setTitle("Ranking da Turma");
	  
		
		
		
		
	}
}
