package br.com.java.dao;

import java.sql.*;
import java.util.*;

import br.com.java.conexao.Conexao;
import br.com.java.modelo.Produto;

public class ProdutoListarDao {
	
	static Connection con = Conexao.getConnection();
	
	public List<Produto> listarProdutos() {
		
		String SQL = "SELECT * FROM PRODUTOS";
		
		List<Produto> lista = new ArrayList<Produto>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Produto produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getBigDecimal("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setStatus(rs.getBoolean("status"));
				produto.setLoja(produto.getLoja());
				
				lista.add(produto);
			}
			
			if (!rs.next()) {
				
				System.out.println("Não existem dados no banco para serem exibidos");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return lista;	
	}
}
