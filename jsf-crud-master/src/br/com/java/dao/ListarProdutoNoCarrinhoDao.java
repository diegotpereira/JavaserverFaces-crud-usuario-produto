package br.com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Loja;
import br.com.java.modelo.Produto;

public class ListarProdutoNoCarrinhoDao {
	
	static Connection con = Conexao.getConnection();

	public ArrayList<Produto> obterCarrinhoCompras(Long usuarioId) {
		
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		
		Produto produto;
		Loja loja;
		
		try {
//			String SQL = "SELECT PRODUTO.ID, CARRINHOCOMPRAS.QUANTIDADE FROM PRODUTOS, CARRINHOCOMPRAS, USUARIOS WHERE PRODUTO.ID = CARRINHOCOMPRAS.PRODUTOID AND AND USUARIOS.ID = CARRINHOCOMPRAS.USUARIOID AND USUARIOS.ID = ?";
			

			String SQL = "SELECT PRODUTOS.ID, PRODUTOS.NOME, PRODUTOS.PRECO, PRODUTOS.DESCRICAO, CARRINHOCOMPRAS.QUANTIDADE FROM PRODUTOS, CARRINHOCOMPRAS, USUARIOS WHERE PRODUTOS.ID = CARRINHOCOMPRAS.PRODUTOID AND USUARIOS.ID = CARRINHOCOMPRAS.USUARIOID AND USUARIOS.ID = ? AND CARRINHOCOMPRAS.QUANTIDADE != 0 AND PRODUTOS.STATUS = FALSE";
			
			PreparedStatement ps = con.prepareStatement(SQL);
			
			ps.setLong(1, usuarioId);
			ResultSet rs = ps.executeQuery();
			
			

			while (rs.next()) {
				
				loja = new Loja();
				produto = new Produto();
//				produto = new Produto(
//						rs.getInt("id"), 
//						rs.getString("nome"), 
//						rs.getBigDecimal("preco"), 
//						rs.getInt("quantidade"), 
//						rs.getString("descricao"), 
//						rs.getBoolean(0), loja);
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getBigDecimal("preco"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setLoja(produto.getLoja());
				
				produto.setNumNoCarrinho(rs.getInt("quantidade"));	
				
				produtos.add(produto);
				
			}

		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}

		return produtos;
	}
}
