package br.com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.Entities.Usuario;
import br.com.jdbc.ConnectionDB;

public class LoginDAO {

	
	Connection con;
	
	public LoginDAO() {
		con = ConnectionDB.getConnection();
	}
	
	public Usuario buscarUsuario(String login) {
		String sql = " SELECT * FROM Usuario WHERE email = ? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("id"));
				u.setNome(rs.getString("nome"));
				u.setSobrenome(rs.getString("sobrenome"));
				u.setEmail(rs.getString("email"));
				u.setSenha(rs.getString("senha"));
				u.setPrioridade(rs.getInt("prioridade"));
				u.setAtivo(rs.getInt("ativo"));
				
				return u;
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
}
