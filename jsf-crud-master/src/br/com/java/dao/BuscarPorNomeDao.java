package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Usuario;

public class BuscarPorNomeDao {
	
	static Connection con = Conexao.getConnection();
	
    public Usuario buscarPorNome(String nome) {
		
		String SQL = "SELECT * FROM USUARIOS WHERE NOME = ?";
		
		Usuario usuario = null;
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs;
			ps.setString(1, nome);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				usuario = new Usuario();
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
			}
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return usuario;
	}

}
