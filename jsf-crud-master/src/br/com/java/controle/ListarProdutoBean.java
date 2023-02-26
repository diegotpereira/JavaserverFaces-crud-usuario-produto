package br.com.java.controle;

import java.io.Serializable;
import java.util.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.java.dao.ListarLojaDao;
import br.com.java.dao.ProdutoListarDao;
import br.com.java.modelo.Loja;
import br.com.java.modelo.Produto;

@Named (value = "produto")
@RequestScoped
public class ListarProdutoBean implements Serializable{
	
	private List<Produto> produtos;
	ProdutoListarDao produtoListarDao = new ProdutoListarDao();
	Produto produto = new Produto();
	private List<Loja> lojas;
	ListarLojaDao listarLojaDao = new ListarLojaDao();
	
//	public ListarProdutoBean() {
//		
//		this.produto.setLoja(new Loja());
//	}

	public List<Produto> getProdutos() {
		
		produtos = produtoListarDao.listarProdutos();
		
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
    public List<Loja> getLojas() {
		
		lojas = listarLojaDao.listarLojas();
		
		return lojas;
	}
}
