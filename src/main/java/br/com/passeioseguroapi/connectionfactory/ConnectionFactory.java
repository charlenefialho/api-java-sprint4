package br.com.passeioseguroapi.connectionfactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Cria conexões com o banco de dados
public class ConnectionFactory {

	// static -> método pertence a classe e não ao objeto
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		// Abrir a conexão com o banco
		String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(url, "rm552252", "200305");
		return conn;

	}
}
