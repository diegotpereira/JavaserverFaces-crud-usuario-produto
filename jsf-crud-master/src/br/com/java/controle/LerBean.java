package br.com.java.controle;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import br.com.java.dao.ListarDao;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class LerBean implements Serializable{
	
	private List<Usuario> lista;
	private ListarDao listarDao = new ListarDao();
	Usuario usuario;
	int ano;
	
	public List<Usuario> getLista() {
			
//		lista = getListarDao().buscarTodos();
		lista = listarDao.buscarTodos();
		
		return lista;
			
	}
	
//	public int getCalcularAno(ActionEvent e) {
//		
//		String SQL = "SELECT IDADE FROM USUARIOS WHERE ID = ?";
//		
//		Date dataAtual = new Date();
//        Date nascimento = usuario.getDataNascimento();
//        
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//        int ano1 = Integer.parseInt(sdf.format(nascimento));
//        int ano2 = Integer.parseInt(sdf.format(dataAtual));
//        ano = ano2 - ano1;
//		
//		return ano;
//	}
	
	

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Usuario getUsuario() {
		
		if (this.usuario == null) {
			
			this.usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
//	public ListarDao getListarDao() {
//		
//		if (this.listarDao == null) {
//			
//			this.listarDao = new ListarDao();
//		}
//		return listarDao;
//	}
//
//	public void setListarDao(ListarDao listarDao) {
//		this.listarDao = listarDao;
//	}
}
