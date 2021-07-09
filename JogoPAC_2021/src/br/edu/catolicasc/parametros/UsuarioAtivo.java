package br.edu.catolicasc.parametros;

import java.util.Hashtable;
import java.util.LinkedList;

import br.edu.catolicasc.services.Encrypt;
import br.edu.catolicasc.services.MysqlUtil;

public class UsuarioAtivo {

	private static LinkedList<Hashtable<String, String>> list;

	private static Encrypt encrypt = new Encrypt();;
	private static MysqlUtil bd = MysqlUtil.getInstance();

	private static int idPessoa;
	
	private static String idade;
	private static String nome;
	private static String dtCriacao;
	private static String dtNascimento;
	private static String login;
	private static String senha;
	private static String admPerm;
	private static String profPerm;
	private static String aluPerm;
	private static String nomeProf;
	private static String nomeTurma;
	private static String lastStage;
	
	private static String usuario;

	public UsuarioAtivo(String usuario) {
		UsuarioAtivo.usuario = usuario;
		gerarDados(usuario);

	}
	
	public static void Update() {
		gerarDados(UsuarioAtivo.usuario);
	}
	
	private static void gerarDados(String usuario) {
		int index = 0;
		list = bd.userDados(usuario, bd.getConnection());

		UsuarioAtivo.idPessoa = Integer.parseInt(list.get(index).get("ID_PESSOA"));
		UsuarioAtivo.idade = list.get(index).get("IDADE");
		UsuarioAtivo.nome = list.get(index).get("NOME");
		UsuarioAtivo.dtCriacao = list.get(index).get("DT_CRIACAO");
		UsuarioAtivo.dtNascimento = list.get(index).get("DATA_NASCIMENTO");
		UsuarioAtivo.login = list.get(index).get("LOGIN");
		UsuarioAtivo.senha = list.get(index).get("SENHA");
		UsuarioAtivo.admPerm = list.get(index).get("ADM_PERM");
		UsuarioAtivo.profPerm = list.get(index).get("PROF_PERM");
		UsuarioAtivo.aluPerm = list.get(index).get("ALU_PERM");
		UsuarioAtivo.nomeProf = list.get(index).get("NOME_PROFESSOR");
		UsuarioAtivo.nomeTurma = list.get(index).get("NOME_TURMA");
		UsuarioAtivo.lastStage =list.get(index).get("LAST_STAGE");
	}
	
	public static int getIdPessoa() {
		return idPessoa;
	}

	public static String getIdade() {
		return idade;
	}

	public static String getNome() {
		return nome;
	}

	public static String getDtCriacao() {
		return dtCriacao;
	}

	public static String getDtNascimento() {
		return dtNascimento;
	}

	public static String getLogin() {
		return login;
	}

	public static String getSenha() {
		return senha;
	}

	@SuppressWarnings("unused")
	private static void setSenha(String senha) {
		UsuarioAtivo.senha = encrypt.gerarMD5(senha);
	}

	public static String getAdmPerm() {
		return admPerm;
	}

	public static String getProfPerm() {
		return profPerm;
	}

	public static String getAluPerm() {
		return aluPerm;
	}

	public static String getNomeProf() {
		return nomeProf;
	}

	public static String getNomeTurma() {
		return nomeTurma;
	}

	public static String getLastStage() {
		return lastStage;
	}

}
