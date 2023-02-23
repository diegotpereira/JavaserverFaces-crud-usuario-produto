package br.com.java.dao;

import java.sql.*;
import java.util.*;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Usuario;

public class UsuarioDao {
	
	static Connection con = Conexao.getConnection();
	
	public List<Usuario> buscarTodos() {
		
		String SQL = "SELECT * FROM USUARIOS";
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				
				lista.add(usuario);
			}
			
			if (!rs.next()) {
				
				System.out.println("Não existem dados no banco para serem exibidos");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;
	}
	
	public static String inserirUsuario(Usuario usuario) {
		
		int resultado = 0;
		String navegacao = "";
		String SQL = "INSERT INTO USUARIOS (nome) VALUES (?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setString(1, usuario.getNome());
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
}