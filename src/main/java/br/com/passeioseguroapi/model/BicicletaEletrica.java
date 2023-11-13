package br.com.passeioseguroapi.model;

import br.com.passeioseguroapi.dao.BicicletaEletricaDAO;

public class BicicletaEletrica extends Bicicleta {
	private int idBicicletaEletrica;
	private String marcaMotor;
	private int potenciaMotor;
	private double valorMotor;
	private String marcaBateria;
	private int potenciaBateria;
	private double valorBateria;

	public BicicletaEletrica() {

	}

	public BicicletaEletrica(int idBicicletaEletrica, Segurado segurado, String marca, String modelo, String modalidade,
			int quantidadeRodas, String estadoUso, int anoCompra, String numeroNotaFiscal, double valorDeMercado,
			String numeroSerie, double valorGps, double valorCicloComputador, double valorVelocimetroDigital,
			String marcaMotor, int potenciaMotor, double valorMotor, String marcaBateria, int potenciaBateria,
			double valorBateria, int idModeloPreDefinido) {
		super(segurado, marca, modelo, modalidade, quantidadeRodas, estadoUso, anoCompra, numeroNotaFiscal,
				valorDeMercado, numeroSerie, valorGps, valorCicloComputador, valorVelocimetroDigital,
				idModeloPreDefinido);
		setIdBicicletaEletrica(idBicicletaEletrica);
		setMarcaMotor(marcaMotor);
		setPotenciaMotor(potenciaMotor);
		setValorMotor(valorMotor);
		setMarcaBateria(marcaBateria);
		setPotenciaBateria(potenciaBateria);
		setValorBateria(valorBateria);
	}

	public String getMarcaBateria() {
		return marcaBateria;
	}

	public void setMarcaBateria(String marcaBateria) {
		this.marcaBateria = marcaBateria;
	}

	public int getPotenciaBateria() {
		return potenciaBateria;
	}

	public void setPotenciaBateria(int potenciaBateria) {
		this.potenciaBateria = potenciaBateria;
	}

	public double getValorBateria() {
		return valorBateria;
	}

	public void setValorBateria(double valorBateria) {
		this.valorBateria = valorBateria;
	}

	public int getIdBicicletaEletrica() {
		return idBicicletaEletrica;
	}

	public void setIdBicicletaEletrica(int idBicicletaEletrica) {
		this.idBicicletaEletrica = idBicicletaEletrica;
	}

	public String getMarcaMotor() {
		return marcaMotor;
	}

	public void setMarcaMotor(String marcaMotor) {
		this.marcaMotor = marcaMotor;
	}

	public int getPotenciaMotor() {
		return potenciaMotor;
	}

	public void setPotenciaMotor(int potenciaMotor) {
		this.potenciaMotor = potenciaMotor;
	}

	public double getValorMotor() {
		return valorMotor;
	}

	public void setValorMotor(double valorMotor) {
		this.valorMotor = valorMotor;
	}

	@Override
	public double calcularValorTotalBicicleta() {
		double valorTotal = calcularValorToTalAcessorio() + getValorDeMercado() + getValorBateria() + getValorMotor();
		return valorTotal;
	}

	public String registrarBicicleta(BicicletaEletrica bicicleta, BicicletaEletricaDAO bicicletaDao) {
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

	public String validarRegistroBicicleta(BicicletaEletrica bicicleta) {

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
