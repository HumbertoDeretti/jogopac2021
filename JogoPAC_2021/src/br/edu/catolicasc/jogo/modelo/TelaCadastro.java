package br.edu.catolicasc.jogo.modelo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Point;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import java.awt.Font;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	public TelaCadastro() {
		
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastro.class.getResource("/resources/menu.png")));
		lblNewLabel.setBounds(0, 0, 1024, 615);
		getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Harrington", Font.PLAIN, 36));
		textField_1.setToolTipText("");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setDropMode(DropMode.INSERT);
		textField_1.setBackground(Color.WHITE);
		textField_1.setForeground(Color.BLACK);
		textField_1.setBounds(114, 233, 191, 32);
		getContentPane().add(textField_1);
	
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setBounds(114, 315, 191, 32);
		getContentPane().add(passwordField);
		
		
		
	}
}
