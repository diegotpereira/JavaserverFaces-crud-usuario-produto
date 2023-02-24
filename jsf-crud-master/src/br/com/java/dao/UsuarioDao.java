package br.com.java.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.faces.context.FacesContext;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Usuario;

public class UsuarioDao {
	
	static Connection con = Conexao.getConnection();
	
	public static String inserirUsuario(Usuario usuario) {
		
		int resultado = 0;
		String navegacao = "";
		String SQL = "INSERT INTO USUARIOS (nome, genero, dataNascimento) VALUES (?, ?, ?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getGenero());
			ps.setDate(3, new java.sql.Date (usuario.getDataNascimento().getTime()));
			ps.execute();
			ps.close();
			
			System.out.println("Usuário cadastrado com sucesso!");
			
		} catch (SQLException e) {
			// TODO: handle exception
			
			System.err.println("Erro: " + e.getMessage());
		}
		
		if (resultado != 0) {
			
			navegacao = "index.xhtml?faces-redirect=true";
			
		} else {
			
			navegacao = "cadastrar.xhtml?faces-redirect=true";
		}
		
		return navegacao;
	}
	

//	public void alterarUsuario(Usuario usuario) {
//		// TODO Auto-generated method stub
//		
//	}
	
	public Usuario alterarUsuario(Long id) {
		
        String SQL = "SELECT * FROM USUARIOS WHERE ID = ?";
        
        Map<String, Object> secao = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        
        Usuario usuario = new Usuario();
        
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs;
			
			ps.setLong(1, id);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				usuario = new Usuario();
				
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
			}
			
			
			
			secao.put("editarObj", usuario);
			
			rs.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return usuario;
	}
	
	public Usuario atualizarUsuario(Usuario usuario) throws SQLException {
		
		try {
			
			String SQL = "UPDATE USUARIOS SET NOME = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(SQL);
			
			ps.setString(1, usuario.getNome());
			ps.setLong(2, usuario.getId());
			ps.executeUpdate();
			
			System.out.println("Usuário atualizado com sucesso!");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} 
		
		return usuario;
		
	}
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
