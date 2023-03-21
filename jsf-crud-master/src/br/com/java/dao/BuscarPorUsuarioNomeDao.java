package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Password;
import br.com.java.modelo.Usuario;

public class BuscarPorUsuarioNomeDao {
	
	static Connection con = Conexao.getConnection();
	
	public Usuario BuscarPorUsuarioNome(String username) {
		
		Usuario usuario = null;
		
		Password password = null;
		
		String SQL = "SELECT USUARIOS.ID AS USUARIOID, USUARIOS.ADMIN, USUARIOS.USERNAME, USUARIOS.SALT, USUARIOS.PASSWORD, "
				+ "FROM USUARIOS "
				+ "WHERE LOWER(USUARIOS.USUARIONOME) = LOWER(?) ";
		
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				password = new Password();
				password.setPassword(rs.getString("password"));
				password.setSalt(rs.getString("salt"));
				
				usuario = new Usuario();
				usuario.setPassword(password);
				usuario.setId(rs.getLong("usuarioid"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUserName(rs.getString("username"));
				usuario.setAdmin(rs.getBoolean("admin"));
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		
		
		return usuario;
		
	}

}
