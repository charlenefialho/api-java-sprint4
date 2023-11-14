package br.com.passeioseguroapi.resource;

import java.sql.SQLException;

import br.com.passeioseguroapi.exception.BadInfoException;
import br.com.passeioseguroapi.model.BicicletaEletrica;
import br.com.passeioseguroapi.model.BicicletaSemMotor;
import br.com.passeioseguroapi.service.BicicletaService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

@Path("/bicicleta")
public class BicicletaResource {
	private BicicletaService service;
	
	public BicicletaResource() throws ClassNotFoundException, SQLException {
		service = new BicicletaService();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(BicicletaSemMotor bicicleta, @Context UriInfo uriInfo) {
		try {
			service.cadastrarBicicleta(bicicleta);
			return Response.status(Response.Status.CREATED).entity("Bicicleta cadastrada com sucesso.").build();
		} catch (BadInfoException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno no servidor").build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno no servidor").build();
		}
	}
	
	
	@POST
	@Path("/eletrica")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(BicicletaEletrica bicicleta, @Context UriInfo uriInfo) {
		try {
			service.cadastrarBicicletaElectrica(bicicleta);
			return Response.status(Response.Status.CREATED).entity("Bicicleta cadastrada com sucesso.").build();
		} catch (BadInfoException e) {
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno no servidor").build();
		} catch (Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro interno no servidor").build();
		}
	}
}
