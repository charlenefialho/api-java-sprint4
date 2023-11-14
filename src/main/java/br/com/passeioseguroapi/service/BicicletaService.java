package br.com.passeioseguroapi.service;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.passeioseguroapi.connectionfactory.ConnectionFactory;
import br.com.passeioseguroapi.dao.BicicletaEletricaDAO;
import br.com.passeioseguroapi.dao.BicicletaSemMotorDAO;
import br.com.passeioseguroapi.exception.BadInfoException;
import br.com.passeioseguroapi.model.BicicletaEletrica;
import br.com.passeioseguroapi.model.BicicletaSemMotor;

public class BicicletaService {
	private BicicletaSemMotorDAO bicicletaSemMotorDAO;
	private BicicletaEletricaDAO bicicletaEletricaDAO;

	public BicicletaService() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnection();
		bicicletaSemMotorDAO = new BicicletaSemMotorDAO(con);
		bicicletaEletricaDAO = new BicicletaEletricaDAO(con);
	}

	public void cadastrarBicicleta(BicicletaSemMotor bicicleta)
			throws BadInfoException, ClassNotFoundException, SQLException {
		String mensagem = validarRegistroBicicleta(bicicleta);
		if (mensagem != null) {
			throw new BadInfoException(mensagem);
		} else {
			bicicletaSemMotorDAO.inserirBicicleta(bicicleta);

		}

	}

	public void cadastrarBicicletaElectrica(BicicletaEletrica bicicletaEletrica)
			throws BadInfoException, ClassNotFoundException, SQLException {
		String mensagem = validarRegistroBicicletaEletrica(bicicletaEletrica);
		if (mensagem != null) {
			throw new BadInfoException(mensagem);
		} else {
			bicicletaEletricaDAO.inserirBicicleta(bicicletaEletrica);

		}

	}

	public String validarRegistroBicicleta(BicicletaSemMotor bicicleta) {

		if (validarCamposObrigatoriosbicicleta(bicicleta) != null) {
			return validarCamposObrigatoriosbicicleta(bicicleta);
		} else if (!isPrecoMinimoValido(bicicleta.getValorDeMercado())) {
			return "Só aceitamos bicicletas com valor a partir de R$ 3.0000,00";
		}

		return null;
	}

	private static String validarCamposObrigatoriosbicicleta(BicicletaSemMotor bicicleta) {
		if (bicicleta.getMarca() == null || bicicleta.getMarca().isEmpty()) {
			return "CPF é obrigatório.";
		} else if (bicicleta.getModelo() == null || bicicleta.getModelo().isEmpty()) {
			return "Nome é obrigatório";
		} else if (bicicleta.getModalidade() == null || bicicleta.getModalidade().isEmpty()) {
			return "Email é obrigatório";
		} else if (bicicleta.getQuantidadeRodas() == 0) {
			return "Senha é obrigatório";
		} else if (bicicleta.getEstadoUso() == null || bicicleta.getEstadoUso().isEmpty()) {
			return "Telefone é obrigatório";
		} else if (bicicleta.getAnoCompra() == 0) {
			return "Ano de compra é obrigatório";
		} else if (bicicleta.getValorDeMercado() == 0) {
			return "Valor de mercado é obrigatório";
		} else if (bicicleta.getNumeroNotaFiscal() == null || bicicleta.getNumeroNotaFiscal().isEmpty()) {
			return "número da nota fiscal é obrigatório";
		} else if (bicicleta.getNumeroSerie() == null || bicicleta.getNumeroSerie().isEmpty()) {
			return "número de série é obrigatório";
		} else if (bicicleta.getAnoCompra() == 0) {
			return "ano da compra é obrigatório";
		} else if (bicicleta.getModeloPreDefinido().getIdModelo() == 0) {
			return "id do modelo pré definido é obrigatório";
		}

		return null;
	}

	private static boolean isPrecoMinimoValido(Double valorDeMercado) {
		if (valorDeMercado < 3000) {
			return false;
		} else {
			return true;
		}
	}

	public String validarRegistroBicicletaEletrica(BicicletaEletrica bicicleta) {

		if (validarCamposObrigatoriosbicicleta(bicicleta) != null) {
			return validarCamposObrigatoriosbicicleta(bicicleta);
		} else if (!isPrecoMinimoValido(bicicleta.getValorDeMercado())) {
			return "Só aceitamos bicicletas com valor a partir de R$ 3.0000,00.";
		} else if (!isPotenciaValida(bicicleta)) {
			return "A potência aceita é só de até 250W.";
		}

		return null;
	}

	public boolean isPotenciaValida(BicicletaEletrica bicicletaEletrica) {
		int potenciaBateria = bicicletaEletrica.getPotenciaBateria();
		int potenciaMotor = bicicletaEletrica.getPotenciaMotor();
		if (potenciaBateria > 250) {
			return false;
		} else if (potenciaMotor > 250) {
			return false;
		} else {
			return true;
		}
	}

	private static String validarCamposObrigatoriosbicicleta(BicicletaEletrica bicicleta) {
		if (bicicleta.getMarca() == null || bicicleta.getMarca().isEmpty()) {
			return "CPF é obrigatório.";
		} else if (bicicleta.getModelo() == null || bicicleta.getModelo().isEmpty()) {
			return "Nome é obrigatório";
		} else if (bicicleta.getModalidade() == null || bicicleta.getModalidade().isEmpty()) {
			return "Email é obrigatório";
		} else if (bicicleta.getQuantidadeRodas() == 0) {
			return "Senha é obrigatório";
		} else if (bicicleta.getEstadoUso() == null || bicicleta.getEstadoUso().isEmpty()) {
			return "Telefone é obrigatório";
		} else if (bicicleta.getAnoCompra() == 0) {
			return "Ano de compra é obrigatório";
		} else if (bicicleta.getValorDeMercado() == 0) {
			return "Valor de mercado é obrigatório";
		} else if (bicicleta.getNumeroNotaFiscal() == null || bicicleta.getNumeroNotaFiscal().isEmpty()) {
			return "número da nota fiscal é obrigatório";
		} else if (bicicleta.getNumeroSerie() == null || bicicleta.getNumeroSerie().isEmpty()) {
			return "número de série é obrigatório";
		} else if (bicicleta.getAnoCompra() == 0) {
			return "ano da compra é obrigatório";
		} else if (bicicleta.getModeloPreDefinido().getIdModelo() == 0) {
			return "id do modelo pré definido é obrigatório";
		}

		return null;
	}
}
