package br.com.passeioseguroapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.passeioseguroapi.model.BicicletaSemMotor;
import br.com.passeioseguroapi.model.ModeloPreDefinido;

public class BicicletaSemMotorDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	// construtor da classe
	public BicicletaSemMotorDAO(Connection con) {
		setCon(con);
	}

	// Método inserir bicicleta sem motor
	public String inserirBicicleta(BicicletaSemMotor bicicleta) {
		if (isBicicletaExiste(bicicleta.getIdBicicletaSemMotor())) {
			return "Essa bicicleta Já foi cadastrada.";
		}

		String sql = "insert into bicicleta(" + "id_bicicleta," + "marca_bike," + "modelo_bike," + "modalidade_bike,"
				+ "quantidade_rodas," + "estado_uso," + "ano_compra," + "valor_mercado," + "nota_fiscal," + "seg_cpf,"
				+ "model_pre_def_id_modelo," + "vlr_gps," + "vlr_ciclo_computador," + "vlr_velocimetro_digital,"
				+ "nmr_serie) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, bicicleta.getIdBicicletaSemMotor());
			ps.setString(2, bicicleta.getMarca());
			ps.setString(3, bicicleta.getModelo());
			ps.setString(4, bicicleta.getModalidade());
			ps.setInt(5, bicicleta.getQuantidadeRodas());
			ps.setString(6, bicicleta.getEstadoUso());
			ps.setInt(7, bicicleta.getAnoCompra());
			ps.setDouble(8, bicicleta.getValorDeMercado());
			ps.setString(9, bicicleta.getNumeroNotaFiscal());
			ps.setString(10, bicicleta.getSegurado().getCpf());
			ps.setInt(11, bicicleta.getModeloPreDefinido().getIdModelo());
			ps.setDouble(12, bicicleta.getValorGps());
			ps.setDouble(13, bicicleta.getValorCicloComputador());
			ps.setDouble(14, bicicleta.getValorVelocimetroDigital());
			ps.setString(15, bicicleta.getNumeroSerie());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}

	}
	
	// Método modificar bicicleta sem motor
		public String modificarBicicleta(BicicletaSemMotor bicicleta) {

			String sql = "update segurado set id_bicicleta = (?), marca_bike = (?), modelo_bike = (?), modalidade_bike = (?)," +
					"quantidade_rodas = (?), estado_uso = (?), ano_compra = (?), valor_mercado = (?), nota_fiscal = (?), seg_cpf = (?)," +
					 "model_pre_def_id_modelo = (?), vlr_gps = (?), vlr_ciclo_computador = (?), vlr_velocimetro_digital = (?),"+
					 "nmr_serie = (?)";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setInt(1, bicicleta.getIdBicicletaSemMotor());
				ps.setString(2, bicicleta.getMarca());
				ps.setString(3, bicicleta.getModelo());
				ps.setString(4, bicicleta.getModalidade());
				ps.setInt(5, bicicleta.getQuantidadeRodas());
				ps.setString(6, bicicleta.getEstadoUso());
				ps.setInt(7, bicicleta.getAnoCompra());
				ps.setDouble(8, bicicleta.getValorDeMercado());
				ps.setString(9, bicicleta.getNumeroNotaFiscal());
				ps.setString(10, bicicleta.getSegurado().getCpf());
				ps.setInt(11, bicicleta.getModeloPreDefinido().getIdModelo());
				ps.setDouble(12, bicicleta.getValorGps());
				ps.setDouble(13, bicicleta.getValorCicloComputador());
				ps.setDouble(14, bicicleta.getValorVelocimetroDigital());
				ps.setString(15, bicicleta.getNumeroSerie());

				if (ps.executeUpdate() > 0) {
					return "Inserido com sucesso";
				} else {
					return "Erro ao inserir";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}

		}
	
	//Método de buscar uma bicicleta
	public BicicletaSemMotor buscarBicicleta(int idBicicleta) {
		String sql = "SELECT id_bicicleta FROM bicicleta WHERE id_bicicleta = ?";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, idBicicleta);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				BicicletaSemMotor bicicleta = new BicicletaSemMotor();
				bicicleta.setIdBicicletaSemMotor(rs.getInt("id_bicicleta"));
				bicicleta.setMarca(rs.getString("marca_bike"));
				bicicleta.setModelo(rs.getString("modelo_bike"));
				bicicleta.setModalidade(rs.getString("modalidade_bike"));
				bicicleta.setQuantidadeRodas(rs.getInt("quantidade_rodas"));
				bicicleta.setEstadoUso(rs.getString("estado_uso"));
				bicicleta.setAnoCompra(rs.getInt("ano_compra"));
				bicicleta.setValorDeMercado(rs.getDouble("valor_mercado"));
				bicicleta.setNumeroNotaFiscal(rs.getString("nota_fiscal"));
				bicicleta.setNumeroSerie(rs.getString("nmr_serie")); 
				bicicleta.setValorGps(rs.getDouble("vlr_gps"));
				bicicleta.setValorCicloComputador(rs.getDouble("vlr_ciclo_computador"));
				bicicleta.setValorVelocimetroDigital(rs.getDouble("vlr_velocimetro_digital"));
				
				int codigoModeloPreDefinido = rs.getInt("model_pre_def_id_modelo");
			
				if (codigoModeloPreDefinido != 0) {
					ModeloPreDefinido modeloPreDefinido = new ModeloPreDefinido();
					modeloPreDefinido.setIdModelo(codigoModeloPreDefinido);
					bicicleta.setModeloPreDefinido(modeloPreDefinido);
				}
				
				return bicicleta;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	// método deletar com where
	public String deletarBicicleta(BicicletaSemMotor bicicleta){
		String sql = "delete from bicicleta b where b.id_bicicleta = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			if (isBicicletaExiste(bicicleta.getIdBicicletaSemMotor())) {
				ps.setInt(1, bicicleta.getIdBicicletaSemMotor());
				if (ps.executeUpdate() > 0) {
					return "Deletado com sucesso";
				} else {
					return "Erro ao deletar";
				}
			} else {
				throw new Exception("Bicicleta não encontrada.");
			}

		} catch (SQLException e) {
			return e.getMessage();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	private boolean isBicicletaExiste(int idBicicleta) {
		String sql = "SELECT id_bicicleta FROM bicicleta WHERE id_bicicleta = ?";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, idBicicleta);
			ResultSet rs = ps.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			return false;
		}
	}
}
