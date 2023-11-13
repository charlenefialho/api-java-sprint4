package br.com.passeioseguroapi.model;

import br.com.passeioseguroapi.dao.BicicletaSemMotorDAO;

public class BicicletaSemMotor extends Bicicleta {
	private int idBicicletaSemMotor;

	public BicicletaSemMotor() {

	}

	public BicicletaSemMotor(int idBicicletaSemMotor, Segurado segurado, String marca, String modelo, String modalidade,
			int quantidadeRodas, String estadoUso, int anoCompra, String numeroNotaFiscal, double valorDeMercado,
			String numeroSerie, double valorGps, double valorCicloComputador, double valorVelocimetroDigital,
			int idModeloPreDefinido) {
		super(segurado, marca, modelo, modalidade, quantidadeRodas, estadoUso, anoCompra, numeroNotaFiscal,
				valorDeMercado, numeroSerie, valorGps, valorCicloComputador, valorVelocimetroDigital,
				idModeloPreDefinido);
		setIdBicicletaSemMotor(idBicicletaSemMotor);

	}

	public BicicletaSemMotor(int idBicicletaSemMotor, Segurado segurado, String marca, String modelo, String modalidade,
			int quantidadeRodas, String estadoUso, int anoCompra, String numeroNotaFiscal, double valorDeMercado,
			String numeroSerie, int idModeloPreDefinido) {
		super(segurado, marca, modelo, modalidade, quantidadeRodas, estadoUso, anoCompra, numeroNotaFiscal,
				valorDeMercado, numeroSerie, idModeloPreDefinido);
		setIdBicicletaSemMotor(idBicicletaSemMotor);
	}

	public int getIdBicicletaSemMotor() {
		return idBicicletaSemMotor;
	}

	public void setIdBicicletaSemMotor(int idBicicletaSemMotor) {
		this.idBicicletaSemMotor = idBicicletaSemMotor;
	}

	@Override
	public double calcularValorTotalBicicleta() {
		double valorTotal = calcularValorToTalAcessorio() + getValorDeMercado();
		return valorTotal;
	}

	public String registrarBicicleta(BicicletaSemMotor bicicleta, BicicletaSemMotorDAO bicicletaDao) {
		try {
			String mensagem = validarRegistroBicicleta(bicicleta);
			if (mensagem == null) {
				return bicicletaDao.inserirBicicleta(bicicleta);
			} else {
				throw new Exception(mensagem);
			}
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	public String atualizarBicicletaSemMotor(BicicletaSemMotor bicicleta, BicicletaSemMotorDAO bicicletaDao) {
		try {
			BicicletaSemMotor bicicletaInfos = bicicletaDao.buscarBicicleta(bicicleta.getIdBicicletaSemMotor());
			if (bicicletaInfos != null) {
				String mensagem = bicicletaDao.modificarBicicleta(InserirValoresPadrao(bicicleta, bicicletaInfos));
				return mensagem;
			} else {
				throw new Exception("Bicicleta não encontrada.");
			}
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public  String validarRegistroBicicleta(BicicletaSemMotor bicicleta) {

		if (validarCamposObrigatoriosbicicleta(bicicleta) != null) {
			return validarCamposObrigatoriosbicicleta(bicicleta);
		} else if (!isPrecoMinimoValido(bicicleta.getValorDeMercado())) {
			return "Só aceitamos bicicletas com valor a partir de R$ 3.0000,00";
		}

		return null;
	}
	
	private static BicicletaSemMotor InserirValoresPadrao(BicicletaSemMotor bicicleta, BicicletaSemMotor bicicletaInfos) {
		if (bicicleta.getMarca() == null || bicicleta.getMarca().isEmpty()) {
			bicicleta.setMarca(bicicletaInfos.getMarca());
		} else if (bicicleta.getModelo() == null || bicicleta.getModelo().isEmpty()) {
			bicicleta.setModelo(bicicletaInfos.getModelo());
		} else if (bicicleta.getModalidade() == null || bicicleta.getModalidade().isEmpty()) {
			bicicleta.setModalidade(bicicletaInfos.getModalidade());
		} else if (bicicleta.getQuantidadeRodas() == 0) {
			 bicicleta.setQuantidadeRodas(bicicletaInfos.getQuantidadeRodas());
		} else if (bicicleta.getEstadoUso() == null || bicicleta.getEstadoUso().isEmpty()) {
			 bicicleta.setEstadoUso(bicicletaInfos.getEstadoUso());
		} else if (bicicleta.getAnoCompra() == 0) {
			 bicicleta.setAnoCompra(bicicletaInfos.getAnoCompra());
		} else if (bicicleta.getValorDeMercado() == 0) {
			 bicicleta.setValorDeMercado(bicicletaInfos.getValorDeMercado());
		} else if (bicicleta.getNumeroNotaFiscal() == null || bicicleta.getNumeroNotaFiscal().isEmpty()) {
			 bicicleta.setNumeroNotaFiscal(bicicletaInfos.getNumeroNotaFiscal());
		} else if (bicicleta.getNumeroSerie() == null || bicicleta.getNumeroSerie().isEmpty()) {
			 bicicleta.setNumeroSerie(bicicletaInfos.getNumeroSerie());
		} else if (bicicleta.getAnoCompra() == 0) {
			 bicicleta.setAnoCompra(bicicletaInfos.getAnoCompra());
		} else if (bicicleta.getIdModeloPreDefinido() == 0) {
			 bicicleta.setIdModeloPreDefinido(bicicletaInfos.getIdModeloPreDefinido());
		}

		return bicicleta;
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
			return "Endereço é obrigatório";
		} else if (bicicleta.getValorDeMercado() == 0) {
			return "Endereço é obrigatório";
		} else if (bicicleta.getNumeroNotaFiscal() == null || bicicleta.getNumeroNotaFiscal().isEmpty()) {
			return "Endereço é obrigatório";
		} else if (bicicleta.getNumeroSerie() == null || bicicleta.getNumeroSerie().isEmpty()) {
			return "Endereço é obrigatório";
		} else if (bicicleta.getAnoCompra() == 0) {
			return "Endereço é obrigatório";
		} else if (bicicleta.getIdModeloPreDefinido() == 0) {
			return "Endereço é obrigatório";
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

}