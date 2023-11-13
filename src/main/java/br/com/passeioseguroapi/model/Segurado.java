package br.com.passeioseguroapi.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.passeioseguroapi.dao.SeguradoDAO;

public class Segurado extends Pessoa {
	private int idSegurado;
	private String cpf;
	private String senha;

	public Segurado() {

	}

	public Segurado(int idSegurado, String nome, String email, String telefone, String endereco, String cpf,
			String senha) {
		super(nome, email, telefone, endereco);
		setIdSegurado(idSegurado);
		setCpf(cpf);
		setSenha(senha);
	}

	public Segurado(String nome, String email, String telefone, String endereco, String cpf, String senha) {
		super(nome, email, telefone, endereco);
		setCpf(cpf);
		setSenha(senha);
	}

	public Segurado(String nome, String email, String telefone, String endereco, String cpf) {
		super(nome, email, telefone, endereco);
		setCpf(cpf);

	}

	public int getIdSegurado() {
		return idSegurado;
	}

	public void setIdSegurado(int idSegurado) {
		this.idSegurado = idSegurado;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	/*
	 * Método que será aprimorado futuramente
	 * 
	 * public String realizarLogin(String cpfLogin, String senhaLogin) { if
	 * (cpfLogin != getCpf() && senhaLogin != getSenha()) { String mensagem =
	 * "CPF e senha estão incorretos"; return mensagem; } else if (cpfLogin !=
	 * getCpf()) { String mensagem = "CPF incorreto"; return mensagem;
	 * 
	 * } else if (senhaLogin != getSenha()) { String mensagem = "Senha incorreta";
	 * return mensagem; } else { String mensagem = "Olá seja bem-vindo," +
	 * getNome(); return mensagem; } }
	 */

	// No caso o cpf no forms ele não poderia ser modificado
	// e na hora do post eu pegaria o cpf e os outro atributos através do token de
	// autenticação
	// mas aqui estarei utilizando o que virá do constrututor mesmo para fazer busca
	// dos valores
	// de segurado já cadastrado e colocar os valores default do que o usuário não
	// modificou.
	public String atualizarSegurado(Segurado segurado, SeguradoDAO seguradoDao) {
		try {
			Segurado seguradoInfos = seguradoDao.buscarSegurado(segurado.getCpf());
			if (seguradoInfos != null) {
				String mensagem = validarRegistroSegurado(segurado);
				if (mensagem == null) {
					mensagem = seguradoDao.modificarSegurado(InserirValoresPadrao(segurado, seguradoInfos));
				} else {
					throw new Exception(mensagem);
				}
				return mensagem;
			} else {
				throw new Exception("Segurado não encontrado.");
			}
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public String validarRegistroSegurado(Segurado segurado) {

		if (validarCamposObrigatoriosSegurado(segurado) != null) {
			return validarCamposObrigatoriosSegurado(segurado);
		} else if (!isCpfValido(segurado.getCpf())) {
			return "CPF inválido.";
		} else if (!isSenhaValida(segurado.getSenha())) {
			return "A senha deve ter no mínimo 8 caracteres.";
		}else if(!isEmailValido(segurado.getEmail())) {
			return "Email inválido.";
		}

		return null;
	}

	public static boolean isEmailValido(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	
	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

	private static Segurado InserirValoresPadrao(Segurado segurado, Segurado seguradoInfos) {
		if (segurado.getNome() == null || segurado.getNome().isEmpty()) {
			segurado.setNome(seguradoInfos.getNome());
		} else if (segurado.getEmail() == null || segurado.getEmail().isEmpty()) {
			segurado.setEmail(seguradoInfos.getEmail());
		} else if (segurado.getSenha() == null || segurado.getSenha().isEmpty()) {
			segurado.setSenha(seguradoInfos.getSenha());
		} else if (segurado.getTelefone() == null || segurado.getTelefone().isEmpty()) {
			segurado.setTelefone(seguradoInfos.getTelefone());
		} else if (segurado.getEndereco() == null || segurado.getEndereco().isEmpty()) {
			segurado.setEndereco(seguradoInfos.getEndereco());
		}

		return segurado;
	}

	private static String validarCamposObrigatoriosSegurado(Segurado segurado) {
		if (segurado.getCpf() == null || segurado.getCpf().isEmpty()) {
			return "CPF é obrigatório.";
		} else if (segurado.getNome() == null || segurado.getNome().isEmpty()) {
			return "Nome é obrigatório";
		} else if (segurado.getEmail() == null || segurado.getEmail().isEmpty()) {
			return "Email é obrigatório";
		} else if (segurado.getSenha() == null || segurado.getSenha().isEmpty()) {
			return "Senha é obrigatório";
		} else if (segurado.getTelefone() == null || segurado.getTelefone().isEmpty()) {
			return "Telefone é obrigatório";
		} else if (segurado.getEndereco() == null || segurado.getEndereco().isEmpty()) {
			return "Endereço é obrigatório";
		}

		return null;
	}

	private static boolean isSenhaValida(String senha) {
		return senha.length() >= 8;
	}

	private static boolean isCpfValido(String cpf) {
		// Remove caracteres não numéricos do CPF
		cpf = cpf.replaceAll("[^0-9]", "");

		// Verifica se o CPF tem 11 dígitos
		if (cpf.length() != 11) {
			return false;
		}

		// Calcula o primeiro dígito verificador
		int soma = 0;
		for (int i = 0; i < 9; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
		}
		int primeiroDigitoVerificador = 11 - (soma % 11);
		if (primeiroDigitoVerificador >= 10) {
			primeiroDigitoVerificador = 0;
		}

		// Verifica o primeiro dígito verificador
		if (Character.getNumericValue(cpf.charAt(9)) != primeiroDigitoVerificador) {
			return false;
		}

		// Calcula o segundo dígito verificador
		soma = 0;
		for (int i = 0; i < 10; i++) {
			soma += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
		}
		int segundoDigitoVerificador = 11 - (soma % 11);
		if (segundoDigitoVerificador >= 10) {
			segundoDigitoVerificador = 0;
		}

		// Verifica o segundo dígito verificador
		if (Character.getNumericValue(cpf.charAt(10)) != segundoDigitoVerificador) {
			return false;
		}

		// Se passou por todas as verificações, o CPF é válido
		return true;
	}

}
