package br.edu.catolicasc.jogo.modelo;


import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import br.edu.catolicasc.services.MysqlUtil;

import java.awt.event.ActionListener;

import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2438794617558804165L;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JPasswordField passwordField;
    private MysqlUtil bd;
    private JTable table;
	
	public Login() {
		bd = new MysqlUtil();
		
		setBackground(SystemColor.menu);
		
		getContentPane().setLayout(null);
		setTitle("The Loggic Game");
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		
		JButton btLogin = new JButton("Entrar");
		btLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btLogin.setForeground(SystemColor.controlLtHighlight);
		btLogin.setBackground(SystemColor.textHighlight);
		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					if(!bd.ValidaUser(txtLogin.getText(), txtSenha.getText(),bd.getInstance().getConnection())) {
						System.out.println("Usuario ou senha inválido.");
						JOptionPane.showMessageDialog(null, "Digita certo que funciona...");
					}else {
						System.out.println("Conectado");
						JOptionPane.showMessageDialog(null, "Acessou com sucesso o jogo.");
					}
				} catch (Exception ex) {
					System.out.println(ex);
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Erro Desconhecido, verifique sua internet ou tente novamente mais tarde.");
				}
				
			}
		});
		
		btLogin.setBounds(374, 455, 294, 64);
		getContentPane().add(btLogin);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(374, 245, 294, 40);
		getContentPane().add(txtLogin);
		txtLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtLogin.setOpaque(false);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtSenha.setOpaque(false);
		
		txtSenha.setBounds(374, 330, 294, 40);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lbBackgroud = new JLabel(imageResource("wpBrain.png",0,0));
		lbBackgroud.setBounds(0, 0, 1024, 576);
		getContentPane().add(lbBackgroud);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"A", "New column", "New column"
			}
		));
		table.setBounds(188, 181, 1, 1);
		getContentPane().add(table);
		
		
		
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
