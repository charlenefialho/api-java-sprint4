package br.com.passeioseguroapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.passeioseguroapi.model.ModeloPreDefinido;

public class ModeloPreDefinidoDAO {

	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public ModeloPreDefinidoDAO(Connection con) {
		setCon(con);
	}

	public String inserirModeloPreDefinido(ModeloPreDefinido modeloPreDefinido) {
		try {
			String sql = "insert into model_pre_def(id_modelo, pre_marca_nm, pre_modelo_nm) values(?,?,?)";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, modeloPreDefinido.getIdModelo());
			ps.setString(2, modeloPreDefinido.getNomeMarca());
			ps.setString(3, modeloPreDefinido.getNomeModelo());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public List<ModeloPreDefinido> buscarModelosPreDefinidos() {
		String sql = "SELECT * FROM model_pre_def";
		List<ModeloPreDefinido> modelos = new ArrayList<>();

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ModeloPreDefinido modeloPreDefinido = new ModeloPreDefinido();
				modeloPreDefinido.setIdModelo(rs.getInt("id_modelo"));
				modeloPreDefinido.setNomeMarca(rs.getString("pre_marca_nm"));
				modeloPreDefinido.setNomeModelo(rs.getString("pre_modelo_nm"));
				modelos.add(modeloPreDefinido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modelos;
	}

	public String deletarModeloPreDefinido(ModeloPreDefinido modeloPreDefinido) {
		try {
			String sql = "delete from model_pre_def m where m.id_modelo = (?)";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, modeloPreDefinido.getIdModelo());

			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao Deletar";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}

	}
}
