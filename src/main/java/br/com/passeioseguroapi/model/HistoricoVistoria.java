package br.com.passeioseguroapi.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.passeioseguroapi.dao.VistoriaDAO;

public class HistoricoVistoria extends Vistoria{
	private List<HistoricoVistoria> vistorias;
	

	public HistoricoVistoria() {
		
	}
	
	public HistoricoVistoria(int codVistoria, Date dataVistoria, String status, String cpfSegurado, int idBicicleta) {
		super(codVistoria,dataVistoria,status,cpfSegurado,idBicicleta);
		
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
	
	//Exemplo printando no console , mas quando for criado o service será retornado 
	//a lista no lugar da string
	public String listarVistorias(Segurado segurado, VistoriaDAO vistoriaDao) {
		String msg = "";
		try {
			List<HistoricoVistoria> Listavistorias = vistoriaDao.buscarVistorias(segurado);
			for(HistoricoVistoria v: Listavistorias) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String data = sdf.format(v.getDataVistoria());
				 msg += "\nCódigo da vistoria: " + v.getCodVistoria()+
						"\nData da Vistoria: " + data +
						"\nStatus da Vistoria: " + v.getStatus() +
						"\nId da bicicleta: " + v.getIdBicicleta() + "\n";
			}
			return msg;
		}catch (Exception e) {
			return e.getMessage();
		}
		
	}
	
}
