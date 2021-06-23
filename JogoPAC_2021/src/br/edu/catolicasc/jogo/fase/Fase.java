package br.edu.catolicasc.jogo.fase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;

import br.edu.catolicasc.jogo.modelo.UsuarioAtivo;
import br.edu.catolicasc.parametros.Globais;
import br.edu.catolicasc.services.ComponentesUtils;
import br.edu.catolicasc.services.MysqlUtil;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class Fase extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4084817774670326435L;
	// Objetos Externos
	private MysqlUtil bd = MysqlUtil.getInstance();
	@SuppressWarnings("unused")
	private ComponentesUtils cUtils = new ComponentesUtils();
	// Declarações
	private JPanel painelRight;
	private JPanel panelTop;
	private JPanel panelBottom;
	private JPanel panelLeft;
	private JPanel panelMid;
	private JLabel lbPergunta;
	
	private static LinkedList<Hashtable<String, String>> listFases;
	private int idFasePlay;


	private ArrayList<FasesList> fasesLista;

	// Construtor
	public Fase(int idFasePlay) {
		
		this.idFasePlay = idFasePlay;
		carregarDados();
		tela();
		
		setVisible(true);
	}
	private void tela() {
		painelRight = new JPanel();
		panelTop = new JPanel();
		panelBottom = new JPanel();
		panelLeft = new JPanel();
		panelMid = new JPanel();
		lbPergunta = new JLabel("");
		lbPergunta.setFont(new Font(Globais.FONT_NAME,Font.PLAIN,Globais.FONT_SIZE_TITLE));
		setTitle("Cerebelo - Jogo Lógico: Fase "+idFasePlay);
		setResizable(false);
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(painelRight, BorderLayout.EAST);
		painelRight.setLayout(new GridLayout(10, 1, 0, 0));

		getContentPane().add(panelBottom, BorderLayout.SOUTH);
		getContentPane().add(panelTop, BorderLayout.NORTH);
		getContentPane().add(panelLeft, BorderLayout.WEST);
		getContentPane().add(panelMid, BorderLayout.CENTER);
		
		
		JButton btSair = new JButton("Sair");

		panelTop.add(lbPergunta);
		panelBottom.add(btSair);

		JLabel lbExemplo = new JLabel("New label");
		panelLeft.add(lbExemplo);

		gerarRespostas();
		lbPergunta.setText(fasesLista.get(0).getiPergunta());
		
				
		
	}
	private void carregarDados() {
		UsuarioAtivo.Update();
		faseDados();
	}
	
	private void gerarRespostas() {
		ArrayList<ButtonRespostas> JBList =  new ArrayList<ButtonRespostas>();
		JBList.add(new ButtonRespostas("Resposta é 1", "1"));
		JBList.add(new ButtonRespostas("Resposta é 2", "2"));
		JBList.add(new ButtonRespostas("Resposta é 3", "3"));
		JBList.add(new ButtonRespostas("Resposta é 4", "4"));
		JBList.add(new ButtonRespostas("Resposta é 5", "5"));
		JBList.add(new ButtonRespostas("Resposta é 6", "6"));
		JBList.add(new ButtonRespostas("Resposta é 7", "7"));
		JBList.add(new ButtonRespostas("Resposta é 8", "8"));
		JBList.add(new ButtonRespostas("Resposta é 9", "9"));


		Collections.shuffle(JBList);
		for(JButton btn: JBList) {
			painelRight.add(btn);
		}
			
		
		
		
	}

	private void faseDados() {
		if (fasesLista == null) {
			fasesLista = new ArrayList<FasesList>();
		}
		listFases = bd.fasesJogo(bd.getConnection(),Integer.toString(idFasePlay));
		int index = 0;
		while (index < listFases.size()) {
			fasesLista.add(new FasesList(Integer.parseInt(listFases.get(index).get("ID_FASE")),
					Integer.parseInt(listFases.get(index).get("DIFICULDADE")),
					Integer.parseInt(listFases.get(index).get("RESPOSTA")), listFases.get(index).get("PERGUNTA"),
					listFases.get(index).get("IMG_PATH")));

			print(index);
			index++;

		}

	}

	private void print(int index) {
		System.out.print(" ID Fase: " + fasesLista.get(index).getIdFase());
		System.out.print(" Dificuldade: " + fasesLista.get(index).getiDificuldade());
		System.out.print(" Pergunta: " + fasesLista.get(index).getiPergunta());
		System.out.print(" Resposta: " + fasesLista.get(index).getiResposta());
		System.out.print(" Imagem Path: " + fasesLista.get(index).getiImgPath());
		System.out.println(" ");
	}
}
