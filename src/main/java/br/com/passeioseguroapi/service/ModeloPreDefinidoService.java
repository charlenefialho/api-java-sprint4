package br.com.passeioseguroapi.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.passeioseguroapi.connectionfactory.ConnectionFactory;
import br.com.passeioseguroapi.dao.ModeloPreDefinidoDAO;
import br.com.passeioseguroapi.exception.BadInfoException;
import br.com.passeioseguroapi.model.ModeloPreDefinido;


public class ModeloPreDefinidoService {
	private ModeloPreDefinidoDAO modeloPreDefinidoDao;

	public ModeloPreDefinidoService() throws ClassNotFoundException, SQLException {
		Connection con = ConnectionFactory.getConnection();
		modeloPreDefinidoDao = new ModeloPreDefinidoDAO(con);
	}
	
	public List<ModeloPreDefinido> listar() throws ClassNotFoundException, SQLException, BadInfoException {
		return modeloPreDefinidoDao.buscarModelosPreDefinidos();
	}
}
