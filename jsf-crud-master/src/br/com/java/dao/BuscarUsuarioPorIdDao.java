package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Password;
import br.com.java.modelo.Usuario;

public class BuscarUsuarioPorIdDao {
	
	static Connection con = Conexao.getConnection();
	
	public Usuario buscarUsuarioPorId(long usuarioId) {
		
		
		Usuario usuario = null;
		Password password = null;
		
		String SQL = "SELECT USUARIOS.ID AS USUARIOID, USUARIOS.NOME, USUARIOS.ADMIN, USUARIOS.SALT, USUARIOS.PASSWORD"
				   + "FROM USUARIOS"
				   + "WHERE USUARIOS.ID = ? ";
		
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			
			ps.setLong(1, usuarioId);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				
				password = new Password();
				password.setPassword(rs.getString("password"));
				password.setSalt(rs.getString("salt"));
				
				usuario = new Usuario();
				usuario.setPassword(password);
				usuario.setNome(rs.getString("nome"));
				usuario.setUserName(rs.getString("usuarionome"));
				usuario.setAdmin(rs.getBoolean("ADMIN"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return usuario;
	}

}
