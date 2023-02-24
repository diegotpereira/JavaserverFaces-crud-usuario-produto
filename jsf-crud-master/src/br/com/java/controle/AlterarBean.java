package br.com.java.controle;

import java.io.Serializable;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.java.dao.UsuarioDao;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class AlterarBean implements Serializable{
	
	public String alterarUsuario(Long id) {
		
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = new Usuario();
		
		usuario = usuarioDao.alterarUsuario(id);
		
		return "alterar.xhtml";
	}
	
	public String atualizarUsuario(Usuario usuario) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			
			UsuarioDao usuarioDao = new UsuarioDao();
			usuarioDao.atualizarUsuario(usuario);
//			usuario = new Usuario();
			fc.addMessage(null, new FacesMessage("Dados Alterados com sucesso"));
			
		} catch (Exception e) {
			// TODO: handle exception
			fc.addMessage(null, new FacesMessage("Erro: " + e.getMessage()));
		}
		
		return "index.xhtml";
		
	}
//    public Usuario getUsuario() {
//		
//		if (this.usuario == null) {
//			
//			this.usuario = new Usuario();
//		}
//		
//		return usuario;
//	}
//	
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
	
//    public UsuarioDao getUsuarioDao() {
//		
//		if (this.usuarioDao == null) {
//			
//			this.usuarioDao = new UsuarioDao();
//		}
//		return usuarioDao;
//	}

}
