package br.com.java.dao;

import java.sql.*;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Loja;
import br.com.java.modelo.Produto;

public class ListarProdutoPorIdDao {
	
	static Connection con = Conexao.getConnection();
	
	public Produto pesquisarProdutoPorId(Produto produto) {
		
//		Produto produto = new Produto();
		Loja loja = new Loja();
		
		
		
		
		
		try {
			
			String SQL = "SELECT PRODUTO.ID,PRODUTO.STATUS, PRODUTO.NOME, PRODUTO.LOJAID, PRODUTO.PRECO, PRODUTO.DESCRICAO, LOJA.ID AS LOJAID, LOJA.NOME AS LOJANOME"
					+ "FROM PRODUTOS "
					+ "INNER JOIN LOJA ON PRODUTO.LOJAID = LOJA.ID"
					+ "WHERE PRODUTO.ID = ?"
					+ "FETCH FIRST 25 ROWS ONLY";
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			ps.setInt(1, rs.getInt("produtoId"));
			
			
			
			
			if (rs.next()) {
				
				loja.setID(rs.getInt("lojaid"));
				loja.setNome(rs.getString("nome"));
				
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getBigDecimal("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setLoja(produto.getLoja());
				
				
				
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return produto;
		
	}

}
