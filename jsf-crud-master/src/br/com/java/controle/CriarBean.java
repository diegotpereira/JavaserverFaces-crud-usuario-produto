package br.com.java.controle;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.java.dao.InserirDao;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class CriarBean implements Serializable{
	
	Usuario usuario;
	private InserirDao inserirDao;
	
	
	public String criar() {
		
		getInserirDao().inserirUsuario(usuario);
		
		return "index";
			
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

	public InserirDao getInserirDao() {
		
		if (this.inserirDao == null) {
			
			this.inserirDao = new InserirDao();
		}
		return inserirDao;
	}

	public void setInserirDao(InserirDao inserirDao) {
		this.inserirDao = inserirDao;
	}
}
