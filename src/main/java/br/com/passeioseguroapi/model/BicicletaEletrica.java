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
			double valorBateria, ModeloPreDefinido modeloPreDefinido) {
		super(segurado, marca, modelo, modalidade, quantidadeRodas, estadoUso, anoCompra, numeroNotaFiscal,
				valorDeMercado, numeroSerie, valorGps, valorCicloComputador, valorVelocimetroDigital,
				modeloPreDefinido);
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

}
