package br.com.passeioseguroapi.teste;

import java.sql.Connection;

import br.com.passeioseguroapi.connectionfactory.*;
import br.com.passeioseguroapi.dao.SeguradoDAO;
import br.com.passeioseguroapi.model.Segurado;

public class ModificarSegurado {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		
		SeguradoDAO seguradoDao = new SeguradoDAO(con);
		
		Segurado segurado = new Segurado("Charlene", "charlene@gmail.com", "(11)999999999", "avenida paulista",
				"11111111111");
		
		System.out.println(segurado.atualizarSegurado(segurado, seguradoDao));
		
		Conexao.fecharConexao(con);

	}

}
