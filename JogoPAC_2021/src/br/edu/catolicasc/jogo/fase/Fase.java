package br.edu.catolicasc.jogo.fase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;

import br.edu.catolicasc.jogo.modelo.MenuJogoAluno;
import br.edu.catolicasc.parametros.Globais;
import br.edu.catolicasc.parametros.UsuarioAtivo;
import br.edu.catolicasc.services.ComponentesUtils;
import br.edu.catolicasc.services.MysqlUtil;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Fase extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4084817774670326435L;
	// Objetos Externos
	private MysqlUtil bd = MysqlUtil.getInstance();
	private ComponentesUtils cUtils = new ComponentesUtils();
	// Declarações
	private JPanel painelRight;
	private JPanel panelTop;
	private JPanel panelBottom;
	private JPanel panelLeft;
	private JPanel panelMid;
	private JLabel lbPergunta;
	private JLabel lbPontuacao;
	private JLabel lbNomeUsuario;
	private JLabel lbFase;
	private JLabel lbImage;
	private JLabel lbImageAvatar;
	private JButton btSair;
	private static LinkedList<Hashtable<String, String>> listFases;
	private int idFasePlay;
	private MenuJogoAluno menu;

	private ArrayList<FasesList> fasesLista;
	// Construtor
	public Fase(int idFasePlay,MenuJogoAluno menu) {
		newStage(idFasePlay);
		this.menu = menu;
	}

	private void newStage(int idFasePlay) {
		Globais.PONTUACAO_INICIAL = 10;
		this.idFasePlay = idFasePlay;

		try {
			carregarDados();
			tela();
		} catch (Exception e) {
			System.out.println(e);
		}
		setVisible(true);

	}

	private void tela() {
		
		initComponentesTela();
		configComponentesTela();
		
		setTitle("Cerebelo - Jogo Lógico: Fase " + idFasePlay);
		setResizable(false);
		setSize(1024, 615);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(painelRight, BorderLayout.EAST);
		getContentPane().add(panelBottom, BorderLayout.SOUTH);
		getContentPane().add(panelTop, BorderLayout.NORTH);
		getContentPane().add(panelLeft, BorderLayout.WEST);
		getContentPane().add(panelMid, BorderLayout.CENTER);
		panelMid.add(lbImage);
		panelTop.add(lbPergunta);
			
		panelBottom.add(lbImageAvatar);
		panelBottom.add(lbNomeUsuario);
		panelBottom.add(lbFase);
		panelBottom.add(lbPontuacao);
		
		panelBottom.add(btSair);
 
		gerarRespostas();
		

	}
	private void configComponentesTela() {
		try {
			painelRight.setLayout(new GridLayout(10, 4, 5, 5));
			panelLeft.setLayout(new GridLayout(5, 1, 5, 5));
			panelBottom.setLayout(new GridLayout(1, 10, 5, 5));
			lbImage.setHorizontalAlignment(SwingConstants.CENTER);
			lbPergunta.setText(fasesLista.get(0).getiPergunta());
			lbFase.setFont(new Font(Globais.FONT_NAME, Font.PLAIN, Globais.FONT_SIZE));
			lbNomeUsuario.setFont(new Font(Globais.FONT_NAME, Font.PLAIN, Globais.FONT_SIZE));
			lbPontuacao.setFont(new Font(Globais.FONT_NAME, Font.PLAIN, Globais.FONT_SIZE));
			//lbPontuacao.setForeground(Color.CYAN);
		} catch (Exception e) {
			System.out.println("Erro na Configurações dos Componentes de Tela.");
			System.out.println(e);
		}
		
	}
	private void initComponentesTela() {
		try {
			btSair = new JButton("Desistir");
			btSair.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.out.println("Desistiu NOOB");
					dispose();
					menu.setVisivel();
				}
			});
			painelRight = new JPanel();
			panelTop = new JPanel();
			panelBottom = new JPanel();
			panelLeft = new JPanel();
			panelMid = new JPanel();
			lbPergunta = new JLabel("");
			lbFase = new JLabel("Fase "+ Integer.toString(idFasePlay));
			lbNomeUsuario = new JLabel("Jogador: " + UsuarioAtivo.getNome());
			lbPergunta.setFont(new Font(Globais.FONT_NAME, Font.PLAIN, Globais.FONT_SIZE_TITLE));
			lbImage = new JLabel(cUtils.fasesResource(fasesLista.get(0).getiImgPath(), 800, 450));
			lbImageAvatar = new JLabel(cUtils.imageResourceAvatar(UsuarioAtivo.getImgAvatar(), 80, 80));
			lbPontuacao = new JLabel("Pontuação: 10");
		} catch (Exception e) {
			System.out.println("Erro na Inicialização dos Componentes de Tela.");
			System.out.println(e);
		}
		
	}
	
	private void carregarDados() {
		UsuarioAtivo.Update();
		faseDados();
	}

	public void validar(int i) {
		
		if(Globais.getPONTUACAO_INICIAL().equals("0")) {
			menu.setVisivel();
			dispose();
		}else {
			if (i == 0) {
				bd.insertPontuacao(UsuarioAtivo.getIdPessoa(), idFasePlay, Globais.PONTUACAO_INICIAL, UsuarioAtivo.getNome());
				menu.setVisivel();
				dispose();
				
				
			} else {
				Globais.setPONTUACAO_INICIAL(1);
				lbPontuacao.setText("0"+Globais.getPONTUACAO_INICIAL());
			}
		}
		
	}

	@SuppressWarnings("static-access")
	private void gerarRespostas() {
		ArrayList<ButtonRespostas> JBList = new ArrayList<ButtonRespostas>();
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		int countBtn = 0;
		int dificuldade = fasesLista.get(0).getiDificuldade();
		int resposta = fasesLista.get(0).getiResposta();

		for (int i = 0; i < 300; i++) {
			int num = cUtils.getRandomNumber((resposta - 9), (resposta - 1));
			if (num >= 0) {
				numeros.add(num);
			}
			numeros.add(cUtils.getRandomNumber((resposta + 1), (resposta + 20)));
		} 
		numeros = cUtils.removeDuplicates(numeros);
		Collections.shuffle(numeros);

		// ADD RESPOSTA CORRETA
		JBList.add(new ButtonRespostas(Integer.toString(resposta), Integer.toString(resposta),
				Integer.toString(resposta), this));

		countBtn++;
		if (dificuldade == 1) {
			for (int i = 0; i < (dificuldade * 2); i++) {
				String num = Integer.toString(numeros.get(i));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
			}
		} else if (dificuldade == 2) {
			for (int i = 0; i < (dificuldade * 1.5); i++) {
				String num = Integer.toString(numeros.get(i));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
				countBtn++;
			}
			if (!(countBtn % 2 == 0)) {
				String num = Integer.toString(numeros.get(3));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
			}
		} else if (dificuldade == 3) {
			for (int i = 0; i < (dificuldade * 2.5); i++) {
				String num = Integer.toString(numeros.get(i));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
				countBtn++;
			}
			if (!(countBtn % 2 == 0)) {
				String num = Integer.toString(numeros.get(3));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
			}
		} else if (dificuldade == 4) {
			for (int i = 0; i < (dificuldade * 3.5); i++) {
				String num = Integer.toString(numeros.get(i));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
				countBtn++;
			}
			if (!(countBtn % 2 == 0)) {
				String num = Integer.toString(numeros.get(3));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
			}
		} else {
			for (int i = 0; i < (dificuldade * 5); i++) {
				String num = Integer.toString(numeros.get(i));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
				countBtn++;
			}
			if (!(countBtn % 9 == 0)) {
				String num = Integer.toString(numeros.get(3));
				JBList.add(new ButtonRespostas(num, num, Integer.toString(resposta), this));
			}
		}

		Collections.shuffle(JBList);
		Collections.shuffle(JBList);
		for (JLabel btn : JBList) {
			
			painelRight.add(btn);
			
		}

	}

	private void faseDados() {
		if (fasesLista == null) {
			fasesLista = new ArrayList<FasesList>();
		}
		listFases = bd.fasesJogo(bd.getConnection(), Integer.toString(idFasePlay));
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
