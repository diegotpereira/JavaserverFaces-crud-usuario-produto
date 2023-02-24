package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Usuario;

public class ListarDao {
	
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
				usuario.setGenero(rs.getString("genero"));
				usuario.setDataNascimento(rs.getDate("dataNascimento"));
				
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

}
