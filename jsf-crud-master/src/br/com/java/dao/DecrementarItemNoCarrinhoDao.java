package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.java.conexao.Conexao;

public class DecrementarItemNoCarrinhoDao {
	
	static Connection con = Conexao.getConnection();
	
	public boolean decrementarItemNoCarrinho(int produtoId, long usuarioId) {
		
		int contar = 0;

		String SQL = "UPDATE CARRINHOCOMPRAS SET QUANTIDADE = QUANTIDADE - 1 WHERE USUARIOID = ? AND PRODUTOID = ?";
		
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			
			ps.setLong(1, usuarioId);
			ps.setInt(2, produtoId);
			
			contar = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return (contar > 0);
		
	}

}
