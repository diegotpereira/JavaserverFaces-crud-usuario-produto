package br.com.java.controle;

import javax.inject.Named;

import java.io.Serializable;
import java.util.*;

import javax.enterprise.context.SessionScoped;

import br.com.java.modelo.*;

@Named(value = "carrinho")
@SessionScoped
public class CarrinhoBean implements Serializable{
	
	
	private ArrayList<Produto> carrinhoCompras;
	

	
	
	public Boolean ProdutoNoCarrinho(Produto produto) {
		
//		if (ObterCarrinhoQuantidade(produto.getId()) == 0) {
//			
//			return false;
//		}
		
		System.out.println("++");
		return true;
		
	}

	public int ObterCarrinhoQuantidade(int produtoId) {
		
		for(Produto p : carrinhoCompras) {
			
			if (p.getId() == produtoId) {
				
				return p.getNumNoCarrinho();	
			}
		}
		
		return 0;
	}
	
	
}
