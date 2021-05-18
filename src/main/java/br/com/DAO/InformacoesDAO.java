package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.Entities.Informacoes;
import br.com.jdbc.ConnectionDB;

public class InformacoesDAO {

	Connection con;

	public InformacoesDAO() {
		con = ConnectionDB.getConnection();
	}

	public boolean criarInfo(Informacoes i) {
		String sql = " INSERT INTO Informacoes (id_usuario, cpf, telefone, estado, cidade, rua, numero_casa, complemento, referencia, cep, cadastrado) "
				+ " VALUES (?,?,?,?,?,?,?,?,?,?,?) ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i.getId_usuario());
			ps.setLong(2, i.getCpf());
			ps.setString(3, i.getTelefone());
			ps.setString(4, i.getEstado());
			ps.setString(5, i.getCidade());
			ps.setString(6, i.getRua());
			ps.setInt(7, i.getNumero_casa());
			ps.setString(8, i.getComplemento());
			ps.setString(9, i.getReferencia());
			ps.setInt(10, i.getCep());
			ps.setInt(11, 1);

			if (ps.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean editInfo(Informacoes i) {
		String sql = " UPDATE Informacoes SET cpf = ?, telefone = ?, estado = ?, cidade = ?, rua = ?, numero_casa = ?, complemento = ?, referencia = ?, "
				+ " cep = ? WHERE id_usuario = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, i.getCpf());
			ps.setString(2, i.getTelefone());
			ps.setString(3, i.getEstado());
			ps.setString(4, i.getCidade());
			ps.setString(5, i.getRua());
			ps.setInt(6, i.getNumero_casa());
			ps.setString(7, i.getComplemento());
			ps.setString(8, i.getReferencia());
			ps.setInt(9, i.getCep());
			ps.setInt(10, i.getId_usuario());

			if (ps.executeUpdate() == 1) {
				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public Informacoes selecInfo(int id) {
		String sql = " SELECT * FROM Informacoes WHERE id_usuario = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Informacoes i = new Informacoes();
				i.setId(rs.getInt("id"));
				i.setId_usuario(rs.getInt("id_usuario"));
				i.setCpf(rs.getLong("cpf"));
				i.setTelefone(rs.getString("telefone"));
				i.setEstado(rs.getString("estado"));
				i.setCidade(rs.getString("cidade"));
				i.setRua(rs.getString("rua"));
				i.setNumero_casa(rs.getInt("numero_casa"));
				i.setComplemento(rs.getString("complemento"));
				i.setReferencia(rs.getString("referencia"));
				i.setCep(rs.getInt("cep"));
				i.setCadastrado(rs.getInt("cadastrado"));

				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean testInfo(int i) {
		String sql = " SELECT * FROM Informacoes WHERE id_usuario = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean testInfoCast(int i) {
		String sql = " SELECT * FROM Informacoes WHERE id_usuario = ? AND cadastrado = 1 ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, i);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
