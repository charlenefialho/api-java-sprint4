package br.com.passeioseguroapi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.passeioseguroapi.model.Segurado;

public class SeguradoDAO {
	private Connection con;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

	// construtor
	public SeguradoDAO(Connection con) {
		setCon(con);
	}

	public void inserirSegurado(Segurado segurado)throws SQLException {
		
			String sql = "insert into segurado(cpf, nome, email, senha,  tel_segurado, end_segurado) values(?,?,?,?,?,?)";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, segurado.getCpf());
			ps.setString(2, segurado.getNome());
			ps.setString(3, segurado.getEmail());
			ps.setString(4, segurado.getSenha());
			ps.setString(5, segurado.getTelefone());
			ps.setString(6, segurado.getEndereco());

			if (ps.executeUpdate() > 0) {
				System.out.println("Inserido com sucesso");
			} else {
               System.out.println("Erro ao inserir");
			}
	}
	
	public boolean isSeguradoJaCadastrado(String Cpf) {
		String sql = "SELECT cpf FROM segurado WHERE cpf = ?";

		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, Cpf);
			ResultSet rs = ps.executeQuery();

			return rs.next();
		} catch (SQLException e) {
			return false;
		}
	}

	public Segurado buscarSegurado(String cpf) {
		String sql = "SELECT * FROM segurado WHERE cpf = ? ";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Segurado segurado = new Segurado();
				segurado.setCpf(rs.getString("cpf"));
				segurado.setNome(rs.getString("nome"));
				segurado.setEmail(rs.getString("email"));
				segurado.setSenha(rs.getString("senha"));
				segurado.setIdSegurado(rs.getInt("id_segurado"));
				segurado.setTelefone(rs.getString("tel_segurado"));
				segurado.setEndereco(rs.getString("end_segurado"));
				return segurado;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// método modificar com where
	public String modificarSegurado(Segurado segurado) {
		String sql = "update segurado set nome = (?), email = (?), senha = (?), tel_segurado= (?), end_segurado = (?) where cpf = (?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, segurado.getNome());
			ps.setString(2, segurado.getEmail());
			ps.setString(3, segurado.getSenha());
			ps.setString(4, segurado.getTelefone());
			ps.setString(5, segurado.getEndereco());
			ps.setString(6, segurado.getCpf());
			if (ps.executeUpdate() > 0) {
				return "Modificado com sucesso";
			} else {
				return "Erro ao modificar";
			}

		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String deletarSegurado(Segurado segurado) {
		try {
			String sql = "delete from segurado s where s.cpf = (?)";
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, segurado.getCpf());

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
