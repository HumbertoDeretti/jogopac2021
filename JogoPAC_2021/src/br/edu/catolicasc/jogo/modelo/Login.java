	package br.edu.catolicasc.jogo.modelo;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import br.edu.catolicasc.parametros.UsuarioAtivo;
import br.edu.catolicasc.services.ComponentesUtils;
import br.edu.catolicasc.services.MysqlUtil;

import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2438794617558804165L;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private MysqlUtil bd = MysqlUtil.getInstance();
    private JTable table;
    private ComponentesUtils cUtils = new ComponentesUtils();
	@SuppressWarnings("unused")
	private UsuarioAtivo userAtivo;
	
    private boolean FAST_LOGIN = true;
    private boolean FAST_LOGIN_PROF = false;
    
	public Login() {
		
		setBackground(SystemColor.menu);
		
		getContentPane().setLayout(null);
		setTitle("The Loggic Game");
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		JButton btLogin = new JButton("");
		
		btLogin.setOpaque(false);//BOTAO SEM FUNDO
		btLogin.setContentAreaFilled(false);//BOTAO SEM FUNDO
		btLogin.setBorderPainted(false);//BOTAO SEM FUNDO
		
		btLogin.setIcon(cUtils.imageResource("lgBrain.png",0,0));
		btLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtLogin.getText();
				btLogin.setEnabled(false);
				try {
					if(!bd.validaUser(usuario, txtSenha.getText(),bd.getConnection())) {
						System.out.println("Usuario ou senha inv?lido.");
						JOptionPane.showMessageDialog(null, "Digita certo que funciona...");
						userAtivo = null;
						btLogin.setEnabled(true);
					}else {
						System.out.println("Conectado");
						userAtivo = new UsuarioAtivo(usuario);
						setVisible(false);
						
						if(!(UsuarioAtivo.getAdmPerm() == "null")) {
							System.out.println("ADMIN");
							new MenuJogoAdmin();
						}
						else if(!(UsuarioAtivo.getProfPerm()=="null")) {
							System.out.println("PROF");
							new MenuJogoProfessor();
						}
						else if(!(UsuarioAtivo.getAluPerm()=="null")) {
						
							try {
								new MenuJogoAluno();
							} catch (Exception e2) {
								System.out.println("Erro Invoke class MenuJogoAluno");
							}
							
						}else {
							
						}
						
					}
				} catch (Exception ex) {
					System.out.println(ex);
					System.out.println(ex);
					JOptionPane.showMessageDialog(null, "Erro Desconhecido, verifique sua internet ou tente novamente mais tarde.");
				}
				
			}
		});
		
		btLogin.setBounds(144, 373, 111, 77);
		getContentPane().add(btLogin);
		
		txtLogin = new JTextFieldPlaceholder("Login");
		
		if(FAST_LOGIN) {
			if(FAST_LOGIN_PROF) {
				txtLogin.setText("humberto");
			}else {
				txtLogin.setText("jonatha");
			}
		}
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBounds(111, 211, 191, 32);
		getContentPane().add(txtLogin);
		txtLogin.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtLogin.setOpaque(false);
		txtLogin.setColumns(10);
		
		txtSenha = new JPasswordFieldPlaceholder("Senha");
		if(FAST_LOGIN) {
			txtSenha.setText("master");
		}
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtSenha.setOpaque(false);
		
		txtSenha.setBounds(111, 295, 196, 32);
		getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lbBackgroud = new JLabel(cUtils.imageResource("menu.png",0,0));
		
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
	
	
}
