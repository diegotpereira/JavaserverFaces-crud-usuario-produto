package br.com.java.dao;

import java.sql.*;
import java.util.Map;

import javax.faces.context.FacesContext;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Usuario;

public class AtualizarDao {
	
	static Connection con = Conexao.getConnection();
	
    public Usuario atualizarUsuario(Usuario usuario) throws SQLException {
		
		try {
			
			String SQL = "UPDATE USUARIOS SET NOME = ?, GENERO = ?, DATANASCIMENTO = ? WHERE id = ?";
			PreparedStatement ps = con.prepareStatement(SQL);
			
			Map<String, Object> secao = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
			
			ps.setString(1, usuario.getNome());
			ps.setString(2, usuario.getGenero());
			ps.setDate(3, new java.sql.Date (usuario.getDataNascimento().getTime()));
			ps.setLong(4, usuario.getId());
			
			secao.put("editarObj", usuario);
			ps.executeUpdate();
			
			System.out.println("Usuário atualizado com sucesso!");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} 
		
		return usuario;
		
	}
}
