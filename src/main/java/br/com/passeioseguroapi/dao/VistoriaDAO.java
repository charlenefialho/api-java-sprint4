package br.com.passeioseguroapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.passeioseguroapi.model.HistoricoVistoria;
import br.com.passeioseguroapi.model.Segurado;
import br.com.passeioseguroapi.model.Vistoria;

public class VistoriaDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	public VistoriaDAO(Connection con) {
		setCon(con);
	}

	public String inserirVistoria(Vistoria vistoria) {
		try {
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(vistoria.getDataVistoria().getTime());
			String sql = "insert into vistoria(id_vistoria, data_hora_vistoria, status_vistoria,seg_cpf,bicicleta_id_bicicleta) values(?,?,?,?,?)";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setInt(1, vistoria.getCodVistoria());
			ps.setTimestamp(2, sqlDate );
			ps.setString(3, vistoria.getStatus());
			ps.setString(4, vistoria.getCpfSegurado());
			ps.setInt(5, vistoria.getIdBicicleta());

			if (ps.executeUpdate() > 0) {
				return "Inserido com sucesso";
			} else {
				return "Erro ao inserir";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}

	}

	public List<HistoricoVistoria> buscarVistorias(Segurado segurado) {
		String sql = "SELECT * FROM vistoria where seg_cpf = ?";
		List<HistoricoVistoria> listaVistorias = new ArrayList<HistoricoVistoria>();
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, segurado.getCpf());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				HistoricoVistoria vistoria = new HistoricoVistoria();
				vistoria.setCodVistoria(rs.getInt("id_vistoria"));
				vistoria.setDataVistoria(rs.getDate("data_hora_vistoria"));
				vistoria.setStatus(rs.getString("status_vistoria"));
				vistoria.setIdBicicleta(rs.getInt("bicicleta_id_bicicleta"));
				listaVistorias.add(vistoria);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return listaVistorias;
	}

}
