package br.com.java.controle;


import java.io.Serializable;
import java.sql.*;
import java.util.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.java.dao.ListarDao;
import br.com.java.dao.UsuarioDao;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class LerBean implements Serializable{
	
	private List<Usuario> lista;
	private ListarDao listarDao = new ListarDao();
	
	public List<Usuario> getLista() {
			
//		lista = getListarDao().buscarTodos();
		lista = listarDao.buscarTodos();
		
		return lista;
			
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
