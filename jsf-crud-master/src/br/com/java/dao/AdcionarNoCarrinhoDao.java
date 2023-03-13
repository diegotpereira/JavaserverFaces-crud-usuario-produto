package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.java.conexao.Conexao;

public class AdcionarNoCarrinhoDao {
	
	static Connection con = Conexao.getConnection();
	
	public Boolean adcionarNoCarrinho(int produtoId, long usuarioId) {
		
		int contar = 0;
		String SQL = "INSERT INTO CARRINHOCOMPRAS (USUARIOID, PRODUTOID, QUANTIDADE) VALUES (?, ?, 1)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
//			ResultSet rs = ps.executeQuery();
			
			ps.setLong(1, 23);
			ps.setInt(2, produtoId);
			
			contar = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return (contar > 0);
	}

}
