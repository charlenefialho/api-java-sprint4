package br.com.passeioseguroapi.teste;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import br.com.passeioseguro.conexao.Conexao;
import br.com.passeioseguro.dao.BicicletaSemMotorDAO;
import br.com.passeioseguro.dao.ModeloPreDefinidoDAO;
import br.com.passeioseguro.model.BicicletaSemMotor;
import br.com.passeioseguro.model.ModeloPreDefinido;
import br.com.passeioseguro.model.Segurado;

public class TesteInsertBicicletaSemMotor {

	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		BicicletaSemMotorDAO bicicletaDAO = new BicicletaSemMotorDAO(con);

		Segurado segurado = new Segurado("Charlene ", "charlene@gmail.com", "(11)999999999", "paulista",
				"11111111111", "12345678");
		
		//os atributos "X-Caliber 8", "Trek", 1, viriam da opção selecionada la no front-end , a partir da listargem
		//sa lista de modelos pre-definidos,mas para exemplo aqui está mockado.
		
		BicicletaSemMotor bicicleta = new BicicletaSemMotor(26, segurado, "Trek", "Powerfly 5", "Mountain Bike", 1,
				"Nova", 2023, "005914662", 2500, "CAL45678", 150, 100, 88.90, 1);

		System.out.println(bicicletaDAO.inserirBicicleta(bicicleta));

		Conexao.fecharConexao(con);
	}

}
