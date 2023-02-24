package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.faces.context.FacesContext;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Usuario;

public class AlterarDao {
	
	static Connection con = Conexao.getConnection();
	
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

}
