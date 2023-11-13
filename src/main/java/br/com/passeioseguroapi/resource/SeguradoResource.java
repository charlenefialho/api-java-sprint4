package br.com.passeioseguroapi.resource;

import java.sql.SQLException;

import br.com.passeioseguroapi.exception.BadInfoException;
import br.com.passeioseguroapi.model.Segurado;
import br.com.passeioseguroapi.service.SeguradoService;
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

@Path("/segurado")
public class SeguradoResource {
	private SeguradoService service;

	public SeguradoResource() throws ClassNotFoundException, SQLException {
		service = new SeguradoService();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Segurado segurado, @Context UriInfo uriInfo) {
		try {
			service.cadastrarSegurado(segurado);
			return Response.status(Response.Status.CREATED).entity("Segurado Cadastrado com sucesso.").build();
		} catch (BadInfoException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno no servidor").build();
		}
	}

	@GET
	@Path("/{cpf}")
	@Produces(MediaType.APPLICATION_JSON)
	public Segurado buscar(@PathParam("cpf") String cpf) throws ClassNotFoundException, SQLException, BadInfoException {
		return service.buscarSegurado(cpf);
	}

}
