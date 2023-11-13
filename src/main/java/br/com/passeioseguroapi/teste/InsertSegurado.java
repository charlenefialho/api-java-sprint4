package br.com.passeioseguroapi.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.passeioseguroapi.connectionfactory.*;
import br.com.passeioseguroapi.dao.ModeloPreDefinidoDAO;
import br.com.passeioseguroapi.dao.SeguradoDAO;
import br.com.passeioseguroapi.model.Segurado;

public class InsertSegurado {

	public static void main(String[] args) throws SQLException {
		Connection con = Conexao.abrirConexao();
		
		SeguradoDAO seguradoDao = new SeguradoDAO(con);
		
		Segurado segurado = new Segurado("Charlene ", "charlene@gmail.com", "(11)999999999", "paulista",
				"48384595054", "12345678");
		
		
		//System.out.println(segurado.registrarSegurado(segurado, seguradoDao));
		
		seguradoDao.inserirSegurado(segurado);
		
		Conexao.fecharConexao(con);

	}

}
