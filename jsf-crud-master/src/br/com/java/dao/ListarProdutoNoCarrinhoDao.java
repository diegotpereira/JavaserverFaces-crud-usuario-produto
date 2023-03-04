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
		
		String SQL = "SELECT PRODUTO.ID, PRODUTO.NOME, PRODUTO.PRECO, PRODUTO.DESCRICAO, CARRINHOCOMPRAS.QUANTIDADE"
				+ "FROM PRODUTO, CARRINHOCOMPRAS,USUARIOS"
				+ "WHERE PRODUTO.ID = CARRINHOCOMPRAS.PRODUTOID"
				+ "AND USUARIOS.ID = CARRINHOCOMPRAS.USUARIOID"
				+ "AND USUARIOS.ID = ?"
				+ "AND CARRINHOCOMPRAS.QUANTIDADE != 0" 
				+ "AND PRODUTO.STATUS = FALSE"
				+ "ORDER BY PRODUTO.ID";

		

		try {
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				loja = new Loja();
				
				
				
//				produtos.add(produto);
			}

		} catch (SQLException ex) {
//			Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
		}

		return produtos;
	}

}
