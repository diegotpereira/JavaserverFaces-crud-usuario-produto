package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.java.conexao.Conexao;

public class ContarProdutoNoCarrinhoDao {
	
static Connection con = Conexao.getConnection();
	
	public int produtoEstaNoCarrinho(int produtoId, int usuarioId) {
		
		int contar = 0;
		
		String SQL = "SELECT CARRINHOCOMPRAS.QUANTIDADE FROM CARRINHOCOMPRAS,PRODUTO WHERE PRODUTOID = ? AND USUARIOID = ? AND PRODUTO.ID = PRODUTOID AND PRODUTO.DISABLED = FALSE";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs;
			
			ps.setInt(1, produtoId);
			ps.setInt(2, usuarioId);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				contar += rs.getInt("quantidade");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return contar;
	}
	

}
