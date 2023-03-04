package br.com.java.controle;

import javax.inject.Named;

import java.io.Serializable;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import br.com.java.dao.ContarProdutoNoCarrinhoDao;
import br.com.java.dao.ListarProdutoNoCarrinhoDao;
import br.com.java.dao.impl.ContarProdutoNoCarrinhoDaoImpl;
import br.com.java.modelo.*;

@Named(value = "carrinho")
@SessionScoped
public class CarrinhoBean implements Serializable{
	
	Usuario usuario = new Usuario();
	CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
	ListarProdutoNoCarrinhoDao listarProdutoNoCarrinhoDao = new ListarProdutoNoCarrinhoDao();
	
	private ArrayList<Produto> carrinhoCompras = listarProdutoNoCarrinhoDao.obterCarrinhoCompras(usuario.getId());
	
	public Boolean ProdutoNoCarrinho(Produto produto) {
		
//		if (ObterCarrinhoQuantidade(produto.getId()) == 0) {
//			
//			return false;
//		}
		
		return false;
		
	}

	public int ObterCarrinhoQuantidade(int produtoId) {
		
		for(Produto p : carrinhoCompras) {
			
			if (p.getId() == produtoId) {
				
				return p.getNumNoCarrinho();	
			}
		}
		
		return 0;
	}
	
	public void PegarProdutoNoCarrinho(Produto produto) {
		
////		Usuario usuario = new Usuario();
////		usuario.setId(14L);
////		produto.setId(1);
////		produto.setQuantidade(121);
//		
//		contarProdutoNoCarrinhoDaoImpl.contarProdutoNoCarrinho();

	
	}	
}
