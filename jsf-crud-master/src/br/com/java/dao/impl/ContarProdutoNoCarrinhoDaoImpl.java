package br.com.java.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.java.conexao.Conexao;
import br.com.java.dao.ContarProdutoNoCarrinhoDao;
import br.com.java.modelo.CarrinhoDeCompras;
import br.com.java.modelo.Loja;
import br.com.java.modelo.Produto;
import br.com.java.modelo.Usuario;

public class ContarProdutoNoCarrinhoDaoImpl {
	
static Connection con = Conexao.getConnection();
	
	public int contarProdutoNoCarrinho(int produtoid, long usuarioid) {
		
		int contar = 0;
//		int produtoId = 1;
//		int usuarioId = 1;
		
		List<CarrinhoDeCompras> lista = new ArrayList<CarrinhoDeCompras>();
		
		String SQL = "SELECT CARRINHOCOMPRAS.QUANTIDADE FROM CARRINHOCOMPRAS,PRODUTOS WHERE PRODUTOID = ? AND USUARIOID = ? AND PRODUTO.ID = PRODUTOID AND PRODUTO.STATUS = FALSE	";
		
		try {
			
			Produto produto = new Produto();
			Usuario usuario = new Usuario();
			
			PreparedStatement ps = con.prepareStatement(SQL);
			ResultSet rs = null;
			
			produto.setId(rs.getInt("id"));
			usuario.setId(rs.getLong("id"));
			
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
	
	public ArrayList<Produto> GetShoppingCart(){
		
		
    ArrayList<Produto> Products = new ArrayList<Produto>();
        
        Produto Product;
        Loja Loja;
        long UserID = 23;
        
        String SQL = "SELECT PRODUTO.ID, PRODUTO.NOME, PRODUTO.PRECO, PRODUTO.DESCRICAO, CARRINHOCOMPRAS.QUANTIDADE "
                + "FROM PRODUTO, CARRINHOCOMPRAS,USUARIOS "
                + "WHERE PRODUTO.ID = CARRINHOCOMPRAS.PRODUTOID "
                + "AND USUARIOS.ID = CARRINHOCOMPRAS.USUARIOID "
                + "AND USUARIOS.ID = ? "
                + "AND CARRINHOCOMPRAS.QUANTIDADE != 0 "
                + "AND PRODUTO.STATUS = FALSE "
                + "ORDER BY PRODUTO.ID";

        
        try {
        	
        	PreparedStatement stmt = con.prepareStatement(SQL);
			ResultSet rs = stmt.executeQuery();

    
            stmt.setLong(1, UserID);

            while(rs.next())
            {
                Loja = new Loja();
	            Produto produto = new Produto();
				
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getBigDecimal("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setDescricao(rs.getString("descricao"));
				produto.setStatus(rs.getBoolean("status"));
				produto.setLoja(produto.getLoja());
				
				Products.add(produto);
            }
            
        } catch (SQLException ex) {
//            Logger.getLogger(UserRowGateway.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        
        
        return Products;
		
	}

}