package br.com.java.dao;

import java.sql.*;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Loja;
import br.com.java.modelo.Produto;

public class ListarProdutoPorIdDao {
	
	static Connection con = Conexao.getConnection();
	
	public Produto pesquisarProdutoPorId(int produtoId, Produto produto) {
		
//		Produto produto = null;
		
		Loja loja;
		
		String SQL = "SELECT PRODUTOS.ID,PRODUTOS.STATUS, PRODUTOS.NOME, PRODUTOS.LOJAID, PRODUTOS.PRECO, PRODUTOS.DESCRICAO, LOJA.ID AS LOJAID, LOJA.NOME AS LOJANOME"
				+ "FROM PRODUTOS "
				+ "INNER JOIN LOJA ON PRODUTOS.LOJAID = LOJA.ID"
				+ "WHERE PRODUTOS.ID = ?"
				+ "FETCH FIRST 25 ROWS ONLY";
		
		PreparedStatement ps;
		
		try {
			
			ps = con.prepareStatement(SQL);
			ps.setInt(1, produtoId);
			
			ResultSet rs = ps.executeQuery();
						
			System.out.println(produto.getId());
			System.err.println(produto.getNome());
			
			
			
			if (rs.next()) {
				
				loja = new Loja();
				produto = new Produto();
								
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
