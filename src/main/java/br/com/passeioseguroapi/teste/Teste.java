package br.com.passeioseguroapi.teste;

import java.sql.Connection;
import java.util.Calendar;
import java.util.Date;

import br.com.passeioseguro.conexao.Conexao;
import br.com.passeioseguro.dao.BicicletaEletricaDAO;
import br.com.passeioseguro.dao.BicicletaSemMotorDAO;
import br.com.passeioseguro.dao.ModeloPreDefinidoDAO;
import br.com.passeioseguro.dao.SeguradoDAO;
import br.com.passeioseguro.dao.VistoriaDAO;
import br.com.passeioseguro.model.BicicletaEletrica;
import br.com.passeioseguro.model.BicicletaSemMotor;
import br.com.passeioseguro.model.HistoricoVistoria;
import br.com.passeioseguro.model.ModeloPreDefinido;
import br.com.passeioseguro.model.Segurado;
import br.com.passeioseguro.model.Vistoria;

public class Teste {

	public static void main(String[] args) {
		Connection con = Conexao.abrirConexao();

		// OBS:Futuramente os IDs serão auto incrementados, não havendo problema de
		// duplicidade

		// Cada Método implementado está comentado, para testar bascar descomentar um
		// por vez.

		/*----------------------- Instanciamento Classes DAO ------------------------*/
		SeguradoDAO seguradoDao = new SeguradoDAO(con);
		BicicletaSemMotorDAO bicicletaDAO = new BicicletaSemMotorDAO(con);
		BicicletaEletricaDAO bicicletaEletricaDAO = new BicicletaEletricaDAO(con);
		ModeloPreDefinidoDAO modeloPreDefinidoDAO = new ModeloPreDefinidoDAO(con);
		VistoriaDAO vistoriadao = new VistoriaDAO(con);

		/*-------------------------- Segurado ------------------------*/
		// Intanciamento de Segurado
		Segurado segurado = new Segurado("Charlene", "charlene@gmail.com", "(11)999999999", "paulista", "67763204036",
				"12345678");

		// Cadastro de Segurado
		// System.out.println(segurado.registrarSegurado(segurado, seguradoDao));

		// Atualizar Segurado
		Segurado seguradoAtualizado = new Segurado("Charlene Aparecida", "charlene@gmail.com", "(11)999999999",
				"paulista", "67763204036", "12345678");
		// System.out.println(segurado.atualizarSegurado(seguradoAtualizado,
		// seguradoDao));

		/*-------------------------- Bicicicleta Sem Motor ------------------------*/
		// Instanciamento de Bicicleta sem motor
		BicicletaSemMotor bicicleta = new BicicletaSemMotor(25, segurado, "X-Caliber 8", "Trek", "Mountain Bike", 1,
				"Nova", 2023, "005914662", 2500, "CAL45678", 150, 100, 88.90, 1);

		// Cadastro de bicicleta sem motor
		// System.out.println(bicicletaDAO.inserirBicicleta(bicicleta));

		/*-------------------------- Bicicleta Elétrica ------------------------*/
		// Instanciamento de Bicicleta Elétrica
		BicicletaEletrica bicicletaEletrica = new BicicletaEletrica(1, // idBicicletaEletrica
				segurado, "Trek", // marca
				"Powerfly", // modelo
				"Mountain Bike", // modalidade
				2, // quantidadeRodas
				"Usada", // estadoUso
				2021, // anoCompra
				"NF123456", // numeroNotaFiscal
				2500.0, // valorDeMercado
				"B12345", // numeroSerie
				100.0, // valorGps
				50.0, // valorCicloComputador
				30.0, // valorVelocimetroDigital
				"MotorTech", // marcaMotor
				250, // potenciaMotor
				300.0, // valorMotor
				"BateriaCor", // marcaBateria
				500, // potenciaBateria
				200.0, // valorBateria
				1 // idModeloPreDefinido
		);
		// System.out.println(bicicletaEletricaDAO.inserirBicicleta(bicicletaEletrica));

		/*-------------------------- Modelo pré definido ------------------------*/
		// Instanciamento de Modelo Pré-definido
		ModeloPreDefinido modeloPreDefinido = new ModeloPreDefinido(1, "Trek", "Powerfly 5");

		// Cadastrar modelo pré definido
		// System.out.println(modeloPreDefinido.registrarModeloPreDefinido(modeloPreDefinido,
		// modeloPreDefinidoDAO));

		/*-------------------------- Vistoria ------------------------*/
		// Formatações hora e data
		Calendar c = Calendar.getInstance();
		Date dataHora = c.getTime();

		// Instanciamento de vistoria
		Vistoria vistoria = new Vistoria(10, dataHora, "Finalizado", segurado.getCpf(),
				bicicleta.getIdBicicletaSemMotor());

		// Cadastrar vistoria
		// System.out.println(vistoria.registrarVistoria(vistoria, vistoriadao));

		/*-------------------------- historico de vistoria ------------------------*/
		// Intanciamento do historico
		HistoricoVistoria histVistoria = new HistoricoVistoria();

		// listar vistorias
		// System.out.println(histVistoria.listarVistorias(segurado, vistoriadao));

		Conexao.fecharConexao(con);
	}

}
