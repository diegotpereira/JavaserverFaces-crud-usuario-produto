package br.com.java.controle;

import java.io.Serializable;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.java.dao.ListarLojaDao;
import br.com.java.dao.ListarProdutoPorIdDao;
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
	ListarProdutoPorIdDao listarProdutoPorIdDao = new ListarProdutoPorIdDao();
	private Produto exibirProduto;;
	
	private int pagina = 1;
	
	@PostConstruct
    private void init(){
        
        
		pesquisarProdutos();
    
    }

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

	public Produto getProduto() {
		
		if (produto == null) {
			
			produto = new Produto();
		}
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String exibirProduto(Produto produto, int pagina) {
		
		this.pagina = pagina;
		
		exibirProduto = listarProdutoPorIdDao.pesquisarProdutoPorId(produto);
		
		return "ExibirP";
	}
	
	public void pesquisarProdutos() {
		
//		produto = listarProdutoPorIdDao.pesquisarProdutoPorId();
	}

	public Produto getExibirProduto() {
		return exibirProduto;
	}

	public void setExibirProduto(Produto exibirProduto) {
		this.exibirProduto = exibirProduto;
	}

	public int getPagina() {
		return pagina;
	}

	public void setPagina(int pagina) {
		this.pagina = pagina;
	}
	
	public String getvoltarPagina() {
		
		switch (pagina) {
		case 0: 
			
		case 1: 
			
			    return "ProdutoP";
		default:
			
			return null;
		}
	}
}
