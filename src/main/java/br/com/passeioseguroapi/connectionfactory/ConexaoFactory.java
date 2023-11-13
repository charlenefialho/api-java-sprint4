package br.com.passeioseguroapi.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	public static void main(String[] args) throws SQLException {
		Connection conexao = null;
		//Na linha abaixo, estou armazenando o caminho do BD na vari�vel url
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		conexao = DriverManager.getConnection(url, "rm552252", "200305");
		System.out.println("Abriu a conexão.");
		conexao.close();
		System.out.println("fechou a conexão.");

	}

}
