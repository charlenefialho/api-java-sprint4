package br.com.passeioseguroapi.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.passeioseguroapi.connectionfactory.ConnectionFactory;
import br.com.passeioseguroapi.dao.VistoriaDAO;
import br.com.passeioseguroapi.model.HistoricoVistoria;
import br.com.passeioseguroapi.model.Vistoria;

public class VistoriaService {
	private VistoriaDAO vistoriaDAO;
	
	public VistoriaService() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnection();
		vistoriaDAO = new VistoriaDAO(con);
	}
	
	public void cadastrarVistoria(Vistoria vistoria) throws SQLException  {
		vistoriaDAO.inserirVistoria(vistoria);
	}
	
	public List<HistoricoVistoria> listarHistorico(String cpf) {
		return vistoriaDAO.buscarVistorias(cpf);
	}
}
