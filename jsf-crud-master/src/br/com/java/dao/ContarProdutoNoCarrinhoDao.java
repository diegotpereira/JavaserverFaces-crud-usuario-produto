package br.com.java.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.CarrinhoDeCompras;
import br.com.java.modelo.Produto;
import br.com.java.modelo.Usuario;

public class ContarProdutoNoCarrinhoDao {	
	
	static Connection con = Conexao.getConnection();
	
	public int contarProdutoNoCarrinho(int produtoId, Long usuarioId) {
		
		int contar = 0;
		String SQL = "SELECT CARRINHOCOMPRAS.QUANTIDADE FROM CARRINHOCOMPRAS,PRODUTOS WHERE PRODUTOID = ? AND USUARIOID = ? AND PRODUTOS.ID = PRODUTOID AND PRODUTOS.STATUS = FALSE";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			
			ps.setInt(1, produtoId);
			ps.setLong(2, usuarioId);
			
			ResultSet rs = ps.executeQuery();
			
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
