package br.com.java.dao;

import java.sql.*;

import br.com.java.conexao.Conexao;

public class ProdutoEstaNoCarrinhoDao {
	
	static Connection con = Conexao.getConnection();
	
	public boolean produtoEstaNoCarrinho(int produtoId, long usuarioId) {
		
		boolean existe = false;
		
		String SQL = "SELECT CARRINHOCOMPRAS.QUANTIDADE FROM CARRINHOCOMPRAS WHERE PRODUTOID = ? AND USUARIOID = ?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs;
			
			ps.setInt(1, produtoId);
			ps.setLong(2, usuarioId);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				
				existe = true;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return existe;
	}

}
