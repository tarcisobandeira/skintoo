package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.Entities.Produtos;
import br.com.jdbc.ConnectionDB;

public class ProdutosDAO {

	Connection con;

	public ProdutosDAO() {
		con = ConnectionDB.getConnection();
	}

	public List<Produtos> listaProdutos() {
		List<Produtos> list = new ArrayList<Produtos>();
		String sql = " SELECT * FROM Produtos ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produtos p = new Produtos();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setEndereco(rs.getString("endereco"));
				p.setAtivo(rs.getInt("ativo"));

				list.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("SkinToo:Carregou os produtos.");
		return list;
	}
	
	public List<Produtos> listaProdutosPub() {
		List<Produtos> list = new ArrayList<Produtos>();
		String sql = " SELECT * FROM Produtos WHERE ativo = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Produtos p = new Produtos();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setQuantidade(rs.getInt("quantidade"));
				p.setEndereco(rs.getString("endereco"));
				p.setAtivo(rs.getInt("ativo"));

				list.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("SkinToo:Carregou os produtos.");
		return list;
	}

	public boolean inserir(Produtos p) {
		String sql = " INSERT INTO Produtos (nome,quantidade,endereco,ativo) VALUES (?,?,?,?) ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getQuantidade());
			ps.setString(3, null);
			ps.setInt(4, 1);

			if (ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateImgProc(Produtos p) {
		String sql = " UPDATE Produtos SET endereco = ? WHERE id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getEndereco());
			ps.setInt(2, p.getId());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	public boolean updateProc(Produtos p) {
		String sql = " UPDATE Produtos SET nome = ?, quantidade = ?, endereco = ? WHERE id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setInt(2, p.getQuantidade());
			ps.setString(3, p.getEndereco());
			ps.setInt(4, p.getId());

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	public boolean desativarProc(int id) {
		String sql = " UPDATE Produtos SET ativo = 2 WHERE id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	public boolean ativarProc(int id) {
		String sql = " UPDATE Produtos SET ativo = 1 WHERE id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
