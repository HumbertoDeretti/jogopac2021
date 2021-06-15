package br.edu.catolicasc.jogo.modelo;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.EventQueue;
import javax.swing.ImageIcon;
import br.edu.catolicasc.services.MysqlUtil;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Font;


public class TelaRankingAluno extends JFrame{

	
	private static MysqlUtil banco;
	private static final long serialVersionUID = 7304639996686864599L;
	@SuppressWarnings("unused")
	private JPanel contentPane;
	private JTable table_2;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaRankingAluno frame = new TelaRankingAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public TelaRankingAluno() {
		banco = new MysqlUtil();
		
		banco.SelectRankingAluno();
			
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
		
		getContentPane().setLayout(null);
		MysqlUtil ppontos = new MysqlUtil();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		getContentPane().add(scrollPane);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		
		DefaultTableModel model = new DefaultTableModel();
		  model.addColumn("Nome");
		    model.addColumn("Pontuação");
		table_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_2.setBounds(214, 67, 682, 302);
		getContentPane().add(table_2);
		table_2.setModel(model);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(TelaRankingAluno.class.getResource("/resources/RankingAluno.jpg")));
		lblNewLabel.setSize(1024, 615);
		getContentPane().add(lblNewLabel);
	
		model.addRow(new Object[]{"Nome","Pontuação"});
		for(Pontuacao p: ppontos.SelectRankingAluno()) {
			
			System.out.println(p.getNome());
			System.out.println(p.getValor());
			
			model.addRow(new Object[]{p.getNome(),p.getValor()});
			
		}
	  
		
		
		
		
		setVisible(true);
		
		
	}
}




