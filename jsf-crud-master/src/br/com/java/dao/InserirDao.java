package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Usuario;

public class InserirDao {
	
	static Connection con = Conexao.getConnection();
	
    public String inserirUsuario(Usuario usuario) {
		
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
}
