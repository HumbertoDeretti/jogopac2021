package br.edu.catolicasc.jogo.modelo;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.EventQueue;
import br.edu.catolicasc.services.ComponentesUtils;
import br.edu.catolicasc.services.MysqlUtil;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.Dimension;

public class TelaRankingAluno extends JFrame {

	private static final long serialVersionUID = 7304639996686864599L;
	private static MysqlUtil banco = MysqlUtil.getInstance();
	private Connection conn = banco.getConnection();
	private ComponentesUtils cUtils = new ComponentesUtils();

	@SuppressWarnings("unused")
	private JPanel contentPane;
	private JTable table_2;

	

	public TelaRankingAluno(MenuJogoAluno menu) {

		banco.SelectRanking(conn); 

		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);

		getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(new Dimension(671, 288));
		scrollPane.setPreferredSize(new Dimension(600, 200));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(213, 66, 671, 288);
		getContentPane().add(scrollPane);
		
		JLabel lbBackground = new JLabel(cUtils.imageResource("RankingAluno.jpg", 0, 0));
		lbBackground.setSize(1024, 615);
		getContentPane().add(lbBackground);
		
		
		table_2 = new JTable();
		table_2.setFont(new Font("Malgun Gothic", Font.PLAIN, 25));
		table_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		table_2.setBounds(214, 67, 682, 302);
		table_2.setRowHeight(40);
		//table_2.setShowHorizontalLines(false);
		table_2.setShowVerticalLines(false);
		table_2.setGridColor(Color.MAGENTA);
		table_2.setFillsViewportHeight(true);
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Nome");
		model.addColumn("Pontuação");
		model.addColumn("Fase");
		//model.addRow(new Object[] { "Nome", "Pontuação","Fase" });
		for (Pontuacao p : banco.SelectRankingAluno(banco.getConnection())) {

			model.addRow(new Object[] { p.getNome(), p.getValor(),p.getIdFase() });

		}
		
		table_2.setModel(model);
		scrollPane.setViewportView(table_2);
		
		addWindowListener(new WindowAdapter() {
			   public void windowClosing(WindowEvent evt) {
				     menu.setVisivel();
				     dispose();
				   }
				  });
		
		setVisible(true);
		
	}
}
