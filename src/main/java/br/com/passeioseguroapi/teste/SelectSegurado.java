package br.com.passeioseguroapi.teste;

import java.sql.Connection;

import br.com.passeioseguroapi.connectionfactory.*;
import br.com.passeioseguroapi.dao.SeguradoDAO;

public class SelectSegurado {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		
		SeguradoDAO seguradoDao = new SeguradoDAO(con);
		
		String cpfExemplo = "11111111111";
		
		System.out.println(seguradoDao.buscarSegurado(cpfExemplo).getNome());
		
		Conexao.fecharConexao(con);

	}

}
