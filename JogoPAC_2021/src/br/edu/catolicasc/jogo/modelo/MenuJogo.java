package br.edu.catolicasc.jogo.modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.text.Normalizer.Form;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Color;

public class MenuJogo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuJogo frame = new MenuJogo();
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
	public MenuJogo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 728);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Jogar");
		lblNewJgoodiesLabel.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 33));
		lblNewJgoodiesLabel.setBounds(230, 195, 85, 60);
		contentPane.add(lblNewJgoodiesLabel);
		
		JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Ranking da Turma");
		lblNewJgoodiesLabel_1.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_1.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewJgoodiesLabel_1.setBounds(198, 275, 150, 60);
		contentPane.add(lblNewJgoodiesLabel_1);
		
		JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Ranking do Aluno");
		lblNewJgoodiesLabel_2.setForeground(new Color(255, 255, 255));
		lblNewJgoodiesLabel_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		lblNewJgoodiesLabel_2.setBounds(205, 345, 150, 60);
		contentPane.add(lblNewJgoodiesLabel_2);
		
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
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Cerebelo Brain");
		lblNewJgoodiesTitle.setForeground(new Color(0, 191, 255));
		lblNewJgoodiesTitle.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewJgoodiesTitle.setBounds(135, 60, 300, 100);
		contentPane.add(lblNewJgoodiesTitle);
		
		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Game");
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
