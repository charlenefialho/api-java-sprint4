package br.com.passeioseguroapi.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.passeioseguroapi.exception.BadInfoException;
import br.com.passeioseguroapi.model.ModeloPreDefinido;
import br.com.passeioseguroapi.service.ModeloPreDefinidoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/modelopredefinido")
public class ModeloPreDefinidoResource {
	private ModeloPreDefinidoService service;

	public ModeloPreDefinidoResource() throws ClassNotFoundException, SQLException {
		service = new ModeloPreDefinidoService();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ModeloPreDefinido> listar() throws ClassNotFoundException, SQLException, BadInfoException{
		return service.listar();
	}
}
