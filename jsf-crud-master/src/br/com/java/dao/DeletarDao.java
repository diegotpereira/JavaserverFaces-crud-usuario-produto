package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.java.conexao.Conexao;

public class DeletarDao {
	
	static Connection con = Conexao.getConnection();
	
	public void deletar(Long id) {
		
		String SQL = "DELETE FROM USUARIOS WHERE id = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setLong(1, id);
			ps.execute();
			
//			con.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
