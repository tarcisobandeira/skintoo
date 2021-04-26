package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import br.com.Entities.Usuario;
import br.com.jdbc.ConnectionDB;

public class CadastroDAO {
	
	Connection con;
	
	public CadastroDAO() {
		con = ConnectionDB.getConnection();
	}
	
	public boolean inserir(Usuario u) {
		String sql = " INSERT INTO Usuario(nome, sobrenome, email, senha, prioridade, ativo) VALUES (?,?,?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getNome());
			ps.setString(2, u.getSobrenome());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getSenha());
			ps.setInt(5, 1);
			ps.setInt(6, 2);
			
			if(ps.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return false;
	}
	
}
