	package br.com.java.controle;

import javax.inject.Named;

import java.io.Serializable;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

import br.com.java.conexao.Conexao;
import br.com.java.dao.AdcionarNoCarrinhoDao;
import br.com.java.dao.ContarProdutoNoCarrinhoDao;
import br.com.java.dao.DecrementarItemNoCarrinhoDao;
import br.com.java.dao.IncrementarItemNoCarrinhoDao;
import br.com.java.dao.ListarProdutoNoCarrinhoDao;
import br.com.java.dao.ProdutoEstaNoCarrinhoDao;
import br.com.java.dao.impl.ContarProdutoNoCarrinhoDaoImpl;
import br.com.java.modelo.*;

@Named(value = "carrinho")
@SessionScoped
public class CarrinhoBean implements Serializable{
	
	static Connection con = Conexao.getConnection();
	
	ListarProdutoNoCarrinhoDao listarProdutoNoCarrinhoDao = new ListarProdutoNoCarrinhoDao();
	ContarProdutoNoCarrinhoDao contarProdutoNoCarrinhoDao = new ContarProdutoNoCarrinhoDao();
	DecrementarItemNoCarrinhoDao decrementarItemNoCarrinhoDao = new DecrementarItemNoCarrinhoDao();
	AdcionarNoCarrinhoDao adcionarNoCarrinhoDao = new AdcionarNoCarrinhoDao();
	ProdutoEstaNoCarrinhoDao produtoEstaNoCarrinhoDao = new ProdutoEstaNoCarrinhoDao();
	IncrementarItemNoCarrinhoDao incrementarItemNoCarrinhoDao = new IncrementarItemNoCarrinhoDao();
	
	
	private ArrayList<Produto> carrinhoCompras;
	Usuario usuario = new Usuario();
	long usuarioId = 23;
	
	public ArrayList<Produto> getCarrinhoCompras() {
		
		return this.carrinhoCompras;
	}
	
	@PostConstruct
    private void init(){
		atualizarCarrinhoCompras();
    
    }
	
	public void atualizarCarrinhoCompras() {
		
		this.carrinhoCompras = listarProdutoNoCarrinhoDao.obterCarrinhoCompras(usuarioId);
	}

	public int ObterCarrinhoQuantidade(int produtoId) {
		
		for(Produto p : carrinhoCompras) {
			
			if (p.getId() == produtoId) {
				
				return p.getNumNoCarrinho();
			}
		}
		
		return 0;
		
	}
	
	public Boolean ProdutoNoCarrinho(Produto produto) {
		
		if (produto == null) {
			
			produto = new Produto();
		}
		
		if (ObterCarrinhoQuantidade(produto.getId()) == 0) {
			
			return false;
			
		} else {
			
			return true;
		}
		
	}
	
	public void PegarProdutoNoCarrinho(Produto produto) {
		
		this.usuario.setProduto(produto);
		
		int contar = (int) contarProdutoNoCarrinhoDao.contarProdutoNoCarrinho(produto.getId(), usuarioId);
		boolean sucesso = false;
		
		if(contar > 0) {
			
			sucesso = (boolean) decrementarItemNoCarrinhoDao.decrementarItemNoCarrinho(produto.getId(), usuarioId);
			
		} else {
			
			sucesso = false;
			
		}
		
		atualizarCarrinhoCompras();
	}
	
	public void AdcionarNoCarrinho(Produto produto) {
		
		usuario.setProduto(produto);
		
//		if (produto ==  null) {
//			
//			produto = new Produto();
//		}
		
		boolean existes = (boolean) produtoEstaNoCarrinhoDao.produtoEstaNoCarrinho(usuario.produto.getId(), usuarioId);
		boolean sucesso = false;
		
		if (!existes) {
			
			
			sucesso = (boolean) adcionarNoCarrinhoDao.adcionarNoCarrinho(produto.getId(), usuarioId);
		} else {
			
			sucesso = (boolean) incrementarItemNoCarrinhoDao.incrementarItemNoCarrinho(produto.getId(), usuarioId);
		}
		
		atualizarCarrinhoCompras();
	}

	public Usuario getUsuario() {
		
		if (usuario == null) {
			
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
