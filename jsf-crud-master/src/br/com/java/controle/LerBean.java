package br.com.java.controle;


import java.io.Serializable;
import java.sql.*;
import java.util.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.java.dao.UsuarioDao;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class LerBean implements Serializable{
	
	private List<Usuario> lista;
	private UsuarioDao usuarioDao;
	
	public List<Usuario> getLista() {
			
			this.lista = this.getUsuarioDao().buscarTodos();
			
			return lista;
			
	}
	
	public UsuarioDao getUsuarioDao() {
			
			if (this.usuarioDao == null) {
				
				this.usuarioDao = new UsuarioDao();
			}
			return usuarioDao;
		}
}
