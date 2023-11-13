package br.com.passeioseguroapi.teste;

import java.sql.Connection;

import br.com.passeioseguro.conexao.Conexao;
import br.com.passeioseguro.dao.SeguradoDAO;
import br.com.passeioseguro.model.Segurado;

public class DeleteSegurado {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		
		SeguradoDAO seguradoDao = new SeguradoDAO(con);
		
		Segurado segurado = new Segurado("Charlene", "charlene@gmail.com", "(11)999999999", "paulista",
				"06487165034", "12345678");
		
		
		System.out.println(seguradoDao.deletarSegurado(segurado));
		
		Conexao.fecharConexao(con);

	}

}
