package br.com.java.controle;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.java.dao.UsuarioDao;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class CriarBean implements Serializable{
	
	private Usuario usuario;
	private UsuarioDao usuarioDao;
	
	public String criar() {
		
		usuarioDao.inserirUsuario(usuario);
		
		return "index";
			
	}
	
//    public UsuarioDao getUsuarioDao() {
//		
//		if (this.usuarioDao == null) {
//			
//			this.usuarioDao = new UsuarioDao();
//		}
//		return usuarioDao;
//	}
    
    public Usuario getUsuario() {
		
		if (this.usuario == null) {
			
			this.usuario = new Usuario();
		}
		
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
