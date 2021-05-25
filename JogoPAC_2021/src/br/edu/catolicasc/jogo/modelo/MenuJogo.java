package br.edu.catolicasc.jogo.modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.Normalizer.Form;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

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
		
		//JLabel lblNewLabel_1 = new JLabel(imageResource("SalaDeAula.png",0,0));
		//lblNewLabel_1.setIcon(new ImageIcon(MenuJogo.class.getResource("/resources/QuadroBranco.png")));
		//lblNewLabel_1.setSize(434, 404);
		//contentPane.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setLocation(0, -14);
		lblNewLabel.setAlignmentY(0.0f);
		lblNewLabel.setIcon(new ImageIcon(MenuJogo.class.getResource("/resources/SalaDeAula.png")));
		lblNewLabel.setSize(1008, 718);
		contentPane.add(lblNewLabel);
		
		
	}
	
	public void imageResource(String path, int x, int y) {
		
	}
}
