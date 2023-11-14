package br.com.passeioseguroapi.resource;

import java.sql.SQLException;
import java.util.List;

import br.com.passeioseguroapi.exception.BadInfoException;
import br.com.passeioseguroapi.model.HistoricoVistoria;
import br.com.passeioseguroapi.model.Segurado;
import br.com.passeioseguroapi.model.Vistoria;
import br.com.passeioseguroapi.service.VistoriaService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/vistoria")
public class VistoriaResource {
	private VistoriaService service;

	public VistoriaResource() throws ClassNotFoundException, SQLException {
		service = new VistoriaService();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Vistoria vistoria, @Context UriInfo uriInfo) {
		try {
			service.cadastrarVistoria(vistoria);
			return Response.status(Response.Status.CREATED).entity("Vistoria cadastrada com sucesso.").build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno no servidor").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno no servidor").build();
		}
	}
	
	@GET
	@Path("/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<HistoricoVistoria> listar(@PathParam("cpf") String cpf) throws ClassNotFoundException, SQLException, BadInfoException{
		return service.listarHistorico(cpf);
	}
}
