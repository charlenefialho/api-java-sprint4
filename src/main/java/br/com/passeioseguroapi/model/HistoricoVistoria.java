package br.com.passeioseguroapi.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.passeioseguroapi.dao.VistoriaDAO;

public class HistoricoVistoria extends Vistoria {
	private List<HistoricoVistoria> vistorias;

	public HistoricoVistoria() {

	}

	public HistoricoVistoria(int codVistoria, Date dataVistoria, String status, String cpfSegurado, int idBicicleta) {
		super(codVistoria, dataVistoria, status, cpfSegurado, idBicicleta);

	}

	public HistoricoVistoria(List<HistoricoVistoria> vistorias) {
		setVistorias(vistorias);
	}

	public List<HistoricoVistoria> getVistorias() {
		return vistorias;
	}

	public void setVistorias(List<HistoricoVistoria> vistorias) {
		this.vistorias = vistorias;
	}

}
