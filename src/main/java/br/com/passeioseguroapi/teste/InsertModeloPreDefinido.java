package br.com.passeioseguroapi.teste;

import java.sql.Connection;

import br.com.passeioseguro.conexao.Conexao;
import br.com.passeioseguro.dao.ModeloPreDefinidoDAO;
import br.com.passeioseguro.model.ModeloPreDefinido;


public class InsertModeloPreDefinido {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();
		
		ModeloPreDefinidoDAO modeloPreDefinidoDAO = new ModeloPreDefinidoDAO(con);
		
		ModeloPreDefinido modeloPreDefinido = new ModeloPreDefinido(1,"Trek","Powerfly 5");
		
		System.out.println(modeloPreDefinidoDAO.inserirModeloPreDefinido(modeloPreDefinido));
		
		
		Conexao.fecharConexao(con);

	}

}
