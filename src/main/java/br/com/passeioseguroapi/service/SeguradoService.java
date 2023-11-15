package br.com.passeioseguroapi.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.passeioseguroapi.connectionfactory.ConnectionFactory;
import br.com.passeioseguroapi.dao.SeguradoDAO;
import br.com.passeioseguroapi.exception.BadInfoException;
import br.com.passeioseguroapi.model.Segurado;
import br.com.passeioseguroapi.util.JwtManager;

public class SeguradoService {
	private SeguradoDAO seguradoDao;

	public SeguradoService() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnection();
		seguradoDao = new SeguradoDAO(con);
	}

	public void cadastrarSegurado(Segurado segurado) throws BadInfoException, ClassNotFoundException, SQLException {
		String mensagem = validarRegistroSegurado(segurado);
		if (mensagem != null) {
			throw new BadInfoException(mensagem);
		} else {
			seguradoDao.inserirSegurado(segurado);

		}

	}

	public String autenticarSegurado(String cpf, String senha)
			throws BadInfoException, ClassNotFoundException, SQLException {
		Segurado segurado = seguradoDao.buscarSegurado(cpf);
		if (segurado != null && senha.equals(segurado.getSenha())) {
			return JwtManager.generateToken(cpf);
		} else {
			throw new BadInfoException("Senha e/ou CPF inválidos.");
		}
	}

	public Segurado buscarSegurado(String cpf) throws ClassNotFoundException, SQLException, BadInfoException {
		return seguradoDao.buscarSegurado(cpf);
	}

	public String validarRegistroSegurado(Segurado segurado) {

		if (validarCamposObrigatoriosSegurado(segurado) != null) {
			return validarCamposObrigatoriosSegurado(segurado);
		} else if (!isCpfValido(segurado.getCpf())) {
			return "CPF inválido.";
		} else if (!isSenhaValida(segurado.getSenha())) {
			return "A senha deve ter no mínimo 8 caracteres.";
		} else if (!isEmailValido(segurado.getEmail())) {
			return "Email inválido.";
		} else if (seguradoDao.isSeguradoJaCadastrado(segurado.getCpf())) {
			return "Já existe um cadastro com esse CPF.";
		}

		return null;
	}

	public static boolean isEmailValido(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

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
