package br.com.passeioseguroapi.model;

import java.util.Date;

import br.com.passeioseguroapi.dao.VistoriaDAO;

public class Vistoria {
	private int codVistoria;
	private Date dataVistoria;
	private String status;
	private String cpfSegurado;
	private int idBicicleta;

	public Vistoria() {

	}

	public Vistoria(int codVistoria, Date dataVistoria, String status, String cpfSegurado, int idBicicleta) {
		setCodVistoria(codVistoria);
		setDataVistoria(dataVistoria);
		setStatus(status);
		setCpfSegurado(cpfSegurado);
		setIdBicicleta(idBicicleta);
	}

	public int getCodVistoria() {
		return codVistoria;
	}

	public void setCodVistoria(int codVistoria) {
		this.codVistoria = codVistoria;
	}

	public Date getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(Date dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCpfSegurado() {
		return cpfSegurado;
	}

	public void setCpfSegurado(String cpfSegurado) {
		this.cpfSegurado = cpfSegurado;
	}

	public int getIdBicicleta() {
		return idBicicleta;
	}

	public void setIdBicicleta(int idBicicleta) {
		this.idBicicleta = idBicicleta;
	}


}
