package br.com.passeioseguroapi.model;

public class Bicicleta {
	private Segurado segurado;
	private String marca;
	private String modelo;
	private String modalidade;
	private int quantidadeRodas;
	private String estadoUso;
	private int anoCompra;
	private String numeroNotaFiscal;
	private double valorDeMercado;
	private String numeroSerie;
	private double valorGps;
	private double valorCicloComputador;
	private double valorVelocimetroDigital;
	private int idModeloPreDefinido;
	
	public Bicicleta() {
		
	}
	
	public Bicicleta(Segurado segurado, String marca, String modelo, String modalidade, int quantidadeRodas,
			String estadoUso, int anoCompra, String numeroNotaFiscal, double valorDeMercado, String numeroSerie,
			double valorGps, double valorCicloComputador, double valorVelocimetroDigital,int idModeloPreDefinido) {
		setSegurado(segurado); 
		setMarca(marca);
		setModelo(modelo);
		setModalidade(modalidade);
		setQuantidadeRodas(quantidadeRodas);
		setEstadoUso(estadoUso);
		setAnoCompra(anoCompra);
		setNumeroNotaFiscal(numeroNotaFiscal);
		setValorDeMercado(valorDeMercado);
		setNumeroSerie(numeroSerie);
		setValorGps(valorGps);
		setValorCicloComputador(valorCicloComputador);
		setValorVelocimetroDigital(valorVelocimetroDigital);
		setIdModeloPreDefinido(idModeloPreDefinido);
	}
	
	public Bicicleta(Segurado segurado, String marca, String modelo, String modalidade, int quantidadeRodas,
			String estadoUso, int anoCompra, String numeroNotaFiscal, double valorDeMercado, String numeroSerie,
			int idModeloPreDefinido) {
		setSegurado(segurado); 
		setMarca(marca);
		setModelo(modelo);
		setModalidade(modalidade);
		setQuantidadeRodas(quantidadeRodas);
		setEstadoUso(estadoUso);
		setAnoCompra(anoCompra);
		setNumeroNotaFiscal(numeroNotaFiscal);
		setValorDeMercado(valorDeMercado);
		setNumeroSerie(numeroSerie);
		setIdModeloPreDefinido(idModeloPreDefinido);
	}

	public int getIdModeloPreDefinido() {
		return idModeloPreDefinido;
	}

	public void setIdModeloPreDefinido(int idModeloPreDefinido) {
		this.idModeloPreDefinido = idModeloPreDefinido;
	}

	public Segurado getSegurado() {
		return segurado;
	}
	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public int getQuantidadeRodas() {
		return quantidadeRodas;
	}
	public void setQuantidadeRodas(int quantidadeRodas) {
		this.quantidadeRodas = quantidadeRodas;
	}
	public String getEstadoUso() {
		return estadoUso;
	}
	public void setEstadoUso(String estadoUso) {
		this.estadoUso = estadoUso;
	}
	public int getAnoCompra() {
		return anoCompra;
	}
	public void setAnoCompra(int anoCompra) {
		this.anoCompra = anoCompra;
	}
	public String getNumeroNotaFiscal() {
		return numeroNotaFiscal;
	}
	public void setNumeroNotaFiscal(String numeroNotaFiscal) {
		this.numeroNotaFiscal = numeroNotaFiscal;
	}
	public double getValorDeMercado() {
		return valorDeMercado;
	}
	public void setValorDeMercado(double valorDeMercado) {
		this.valorDeMercado = valorDeMercado;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public double getValorGps() {
		return valorGps;
	}
	public void setValorGps(double valorGps) {
		this.valorGps = valorGps;
	}
	public double getValorCicloComputador() {
		return valorCicloComputador;
	}
	public void setValorCicloComputador(double valorCicloComputador) {
		this.valorCicloComputador = valorCicloComputador;
	}
	public double getValorVelocimetroDigital() {
		return valorVelocimetroDigital;
	}
	public void setValorVelocimetroDigital(double valorVelocimetroDigital) {
		this.valorVelocimetroDigital = valorVelocimetroDigital;
	}

	
	public double calcularValorToTalAcessorio() {
		double soma = getValorGps() + getValorVelocimetroDigital() + getValorCicloComputador();
		return soma;
	}
	
	public double calcularValorTotalBicicleta() {
		double valorTotal = calcularValorToTalAcessorio() + getValorDeMercado();
		return valorTotal;
	}
	
	
	
	
}
