package br.com.passeioseguroapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.passeioseguroapi.model.BicicletaEletrica;

public class BicicletaEletricaDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	// construtor da classe
	public BicicletaEletricaDAO(Connection con) {
		setCon(con);
	}

	// Método inserir bicicleta eletrica
	public String inserirBicicleta(BicicletaEletrica bicicleta) {
		if (isBicicletaJaCadastrada(bicicleta.getIdBicicletaEletrica())) {
			return "Essa bicicleta Já foi cadastrada.";
		}

		String sql = "insert into bicicleta(" + "id_bicicleta," + "marca_bike," + "modelo_bike,"
				+ "modalidade_bike," + "quantidade_rodas," + "estado_uso," + "ano_compra," + "valor_mercado,"
				+ "nota_fiscal," + "seg_cpf," + " model_pre_def_id_modelo,"+"vlr_gps," + "vlr_ciclo_computador," 
				+ "vlr_velocimetro_digital,"+ " id_bicicleta_eletrica," + "marca_bateria," +
				  "potencia_bateria," + "valor_bateria," + "marca_motor," + "potencia_motor," +
				  "valor_motor," + "nmr_serie) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bicicleta.getIdBicicletaEletrica());
			ps.setString(2, bicicleta.getMarca());
			ps.setString(3, bicicleta.getModelo());
			ps.setString(4, bicicleta.getModalidade());
			ps.setInt(5, bicicleta.getQuantidadeRodas());
			ps.setString(6, bicicleta.getEstadoUso());
			ps.setInt(7, bicicleta.getAnoCompra());
			ps.setDouble(8, bicicleta.getValorDeMercado());
			ps.setString(9, bicicleta.getNumeroNotaFiscal());
			ps.setString(10, bicicleta.getSegurado().getCpf());
			ps.setInt(11, bicicleta.getIdModeloPreDefinido());
			ps.setDouble(12, bicicleta.getValorGps());
			ps.setDouble(13, bicicleta.getValorCicloComputador());
			ps.setDouble(14, bicicleta.getValorVelocimetroDigital());
			ps.setDouble(15, bicicleta.getIdBicicletaEletrica());
			ps.setString(16, bicicleta.getMarcaBateria());
			ps.setDouble(17, bicicleta.getPotenciaBateria());
			ps.setDouble(18, bicicleta.getValorBateria());
			ps.setString(19, bicicleta.getMarcaMotor());
			ps.setDouble(20, bicicleta.getPotenciaMotor());
			ps.setDouble(21, bicicleta.getValorMotor());
			ps.setString(22, bicicleta.getNumeroSerie());
			

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	private boolean isBicicletaJaCadastrada(int idBicicleta) {
		String sql = "SELECT id_bicicleta FROM bicicleta WHERE id_bicicleta_eletrica = ?";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, idBicicleta);
			ResultSet rs = ps.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			return false;
		}
	}

	// método deletar com where
	public String deletarBicicletaComWhere(BicicletaEletrica bicicleta) {
		String sql = "delete from bicicleta b where b.id_bicicleta_eletrica = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bicicleta.getIdBicicletaEletrica());
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}
}
