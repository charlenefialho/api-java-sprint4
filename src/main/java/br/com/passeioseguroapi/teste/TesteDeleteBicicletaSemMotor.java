package br.com.passeioseguroapi.teste;

import java.sql.Connection;

import br.com.passeioseguro.conexao.Conexao;
import br.com.passeioseguro.dao.BicicletaSemMotorDAO;
import br.com.passeioseguro.model.BicicletaSemMotor;
import br.com.passeioseguro.model.Segurado;

public class TesteDeleteBicicletaSemMotor {

	public static void main(String[] args) throws Exception {
		Connection con = Conexao.abrirConexao();

		BicicletaSemMotorDAO bicicletaDAO = new BicicletaSemMotorDAO(con);

		Segurado segurado = new Segurado(1292, "Charlene", "charlene@gmail.com", "(11)999999999", "av paulista",
				"12345678912", "123456");

		BicicletaSemMotor bicicleta = new BicicletaSemMotor(26, segurado, "X-Caliber 8", "Trek", "Mountain Bike", 1,
				"Nova", 2023, "005914662", 2500, "CAL45678", 150, 100, 88.90, 1);

		System.out.println(bicicletaDAO.deletarBicicleta(bicicleta));

		Conexao.fecharConexao(con);

	}

}
