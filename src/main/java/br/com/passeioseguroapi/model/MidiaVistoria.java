package br.com.passeioseguroapi.model;

import java.util.Date;


public class MidiaVistoria extends Vistoria{
	private int idMidia;
	private Date data;
	private Date hora;
	private String imagem;
	private String descricao;
	private int idvistoria;
	
	public MidiaVistoria() {
		
	}

	public MidiaVistoria(int idMidia,Date data,Date hora,String imagem,String descricao,int idvistoria) {
		setIdMidia(idMidia);
		setData(data);
		setHora(hora);
		setImagem(imagem);
		setDescricao(descricao);
		setIdvistoria(idvistoria);
		
	}
	
	public MidiaVistoria(int codVistoria, Date dataVistoria, String status,String cpfSegurado,int idBicicleta,int idMidia,Date data,Date hora,String imagem,String descricao,int idvistoria) {
		super(codVistoria,dataVistoria,status,cpfSegurado,idBicicleta);
		setIdMidia(idMidia);
		setData(data);
		setHora(hora);
		setImagem(imagem);
		setDescricao(descricao);
		setIdvistoria(idvistoria);
		
	}
	public int getIdvistoria() {
		return idvistoria;
	}

	public void setIdvistoria(int idvistoria) {
		this.idvistoria = idvistoria;
	}

	public int getIdMidia() {
		return idMidia;
	}
	public void setIdMidia(int idMidia) {
		this.idMidia = idMidia;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
