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
	
	public List<Produtos> listaProdutos(){
		List<Produtos> list = new ArrayList<Produtos>();
		String sql = " SELECT * FROM Produtos ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Produtos p = new Produtos();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setQuantidade(rs.getInt("quantidade"));
				
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
}
