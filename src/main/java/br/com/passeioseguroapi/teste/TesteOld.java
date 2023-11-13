package br.com.passeioseguroapi.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.passeioseguro.model.BicicletaEletrica;
import br.com.passeioseguro.model.BicicletaSemMotor;
import br.com.passeioseguro.model.HistoricoVistoria;
import br.com.passeioseguro.model.MidiaVistoria;
import br.com.passeioseguro.model.Segurado;

public class TesteOld {

	public static void main(String[] args) {
		/*----------------------Teste classe Segurado------------------------------*/
		
		Segurado segurado = new Segurado(1292,"Charlene","charlene@gmail.com","(11)999999999","av paulista","12345678912","123456");
		
		System.out.println("\n----------Print dos atributos de teste da classe Segurado-----------------");
		System.out.println("\nId Segurado: "  + segurado.getIdSegurado() +
				"\nNome: " + segurado.getNome() +
				"\nEmail: " + segurado.getEmail() +
				"\nTelefone: " + segurado.getTelefone()+
				"\nEndereco: " + segurado.getEmail()+
				"\nCPF: " + segurado.getCpf() +
				"\nsenha: " + segurado.getSenha() +"\n");
		
		/*System.out.println("----Teste método de realizarLogin e possiveis saidas-----");
		//saida para  Senha incorreta
		System.out.println(segurado.realizarLogin("12345678912", "12345"));
		//saida para  cpf incorreto
		System.out.println(segurado.realizarLogin("1234567891", "123456"));
		//saida para  cpf e senha incorretos
		System.out.println(segurado.realizarLogin("1234567891", "12345"));
		//saida para senha e cpf corretos 
		System.out.println(segurado.realizarLogin("12345678912", "123456"));*/
		
		
		/*--------------------Teste classe BicicletaSemMotor------------------------*/
		BicicletaSemMotor bicicleta = new BicicletaSemMotor(25,segurado,"Caloi","Explorer Sport",
				"Mountain Bike",2,"Nova",2023,"005914662",2500,"CAL45678",150,100,88.90,1);
		
		System.out.println("\n----------Print dos atributos de teste de Bicicleta Sem Motor-----------------");
		
		System.out.println("Id Bicicleta: " + bicicleta.getIdBicicletaSemMotor() +"\nDono da bicicleta: " + bicicleta.getSegurado().getNome()+ 
				"\nMarca: " + bicicleta.getMarca() + "\nModelo: " + bicicleta.getModelo() +
				"\nModalidade: " + bicicleta.getModalidade()+ "\nNumero de rodas: " + bicicleta.getQuantidadeRodas()+"\nEstado de uso: " + bicicleta.getEstadoUso() +
				"\nAno de compra: " + bicicleta.getAnoCompra() +"\nValor da bicicleta: " + bicicleta.getValorDeMercado()+ 
				"\nNumero da nota fiscal: " + bicicleta.getNumeroNotaFiscal() + "\nNumero de série da bicicleta: " + bicicleta.getNumeroSerie() +
				"\nValor do GPS: " + bicicleta.getValorGps() +"\nValor do ciclo computador: " + bicicleta.getValorCicloComputador()+
				"\nValor do Velocimetro: " + bicicleta.getValorVelocimetroDigital() );
		
		System.out.println("Valor total bicicleta com valor acessorios: " 
		+ bicicleta.calcularValorTotalBicicleta());
		
		/*--------------------Teste classe BicicletaEletrica------------------------*/
		BicicletaEletrica bicicletaEletrica = new BicicletaEletrica(12,segurado,"Trek","Powerfly 5","Mountain Bike",
				2,"Nova",2023,"123456",12000,"ABC12345",0,200,28.90,"Bosch",250,3000,"Shimano",250,1800,1);
		
		System.out.println("\n----------Print dos atributos de teste de bicicleta Elétrica-----------------");
	
		System.out.println("\nId Bicicleta: " + bicicletaEletrica.getIdBicicletaEletrica() +"\nDono da bicicleta: " + bicicletaEletrica.getSegurado().getNome()+ 
				"\nMarca: " + bicicletaEletrica.getMarca() + "\nModelo: " + bicicletaEletrica.getModelo() +
				"\nModalidade: " + bicicletaEletrica.getModalidade()+ "\nNumero de rodas: " + bicicletaEletrica.getQuantidadeRodas()+"\nEstado de uso: " + bicicletaEletrica.getEstadoUso() +
				"\nAno de compra: " + bicicletaEletrica.getAnoCompra() +"\nValor da bicicleta: " + bicicletaEletrica.getValorDeMercado()+ 
				"\nNumero da nota fiscal: " + bicicletaEletrica.getNumeroNotaFiscal() + "\nNumero de série da bicicleta: " + bicicletaEletrica.getNumeroSerie() +
				"\nValor do GPS: " + bicicletaEletrica.getValorGps() +"\nValor do ciclo computador: " + bicicletaEletrica.getValorCicloComputador()+
				"\nValor do Velocimetro: " + bicicletaEletrica.getValorVelocimetroDigital() +"\nMarca do motor: " + bicicletaEletrica.getMarcaMotor() +
				"\nPotencia do motor: " + bicicletaEletrica.getPotenciaMotor() +"\nValor do motor: " + bicicletaEletrica.getValorMotor() +
				"\nMarca da bateria: " + bicicletaEletrica.getMarcaBateria()+"\nPotencia da bateria: " + bicicletaEletrica.getPotenciaBateria() +
				"\nValor da bateria: " + bicicletaEletrica.getValorBateria());
		
		System.out.println("Valor Total dos acessórios: " + bicicletaEletrica.calcularValorToTalAcessorio());
		System.out.println("Valor total da bicicleta Eletrica com valor dos acessórios: " + bicicletaEletrica.calcularValorTotalBicicleta());
		
		/*------------------------TESTE Classe MidiaVistoria---------------------*/
			//Formatações hora e data
			Calendar c = Calendar.getInstance();
			Date dataHora = c.getTime();
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			//dateFormat.format(dataHora);
			
			SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
			//hora.format(dataHora);
			
			System.out.println("\n----------Print dos atributos de teste de midia vistoria-----------------");
			
			MidiaVistoria midiaVistoria = new MidiaVistoria();
			midiaVistoria.setIdMidia(1);
			midiaVistoria.setData(dataHora);
			midiaVistoria.setHora(dataHora);
			midiaVistoria.setImagem("imagens/imagem1.jpg");
			midiaVistoria.setDescricao("Selim");
			System.out.println("\nData da Vistoria: " + dateFormat.format(midiaVistoria.getData()) +
					"\nId da midia: " + midiaVistoria.getIdMidia() +
					"\nData da imagem anexada: " + dateFormat.format(midiaVistoria.getData()) +
					"\nHora da imagem anexada: " + hora.format(midiaVistoria.getHora()) +
					"\nCaminho da imagem: " + midiaVistoria.getImagem() +
					"\nDescrição da midia: " + midiaVistoria.getDescricao());
			
			
		
		
		/*-------------------Teste Classe HistoricoVistoria----------------------*/
			
			/*
			HistoricoVistoria vistoria = new HistoricoVistoria(1234,dataHora,"finalizado");
			HistoricoVistoria vistoria2 = new HistoricoVistoria(1234,dataHora,"finalizado");
			HistoricoVistoria vistoria3 = new HistoricoVistoria(1234,dataHora,"finalizado");
			
			List<HistoricoVistoria> listaVistorias = new ArrayList<HistoricoVistoria>();
			listaVistorias.add(vistoria);
			listaVistorias.add(vistoria2);
			listaVistorias.add(vistoria3);
			
			HistoricoVistoria vistorias = new HistoricoVistoria(listaVistorias);
			//listagem de vistorias
			System.out.println("\n----------Listagem de vistorias-----------------");
				vistorias.listarVistoria();*/
		}
	
	

}
