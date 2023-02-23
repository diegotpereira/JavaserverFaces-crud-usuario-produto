package br.com.java.controle;

import javax.inject.Named;

import br.com.java.dao.UsuarioDao;
import br.com.java.modelo.Usuario;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class UsuarioControle implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<Usuario> lista;
	private UsuarioDao usuarioDao;
	private Usuario usuario;
	
	public List<Usuario> getLista() {
		
		this.lista = this.getUsuarioDao().buscarTodos();
		
		return lista;
	}
	
	public String criar() {
		
		getUsuarioDao().inserirUsuario(usuario);
		usuario = new Usuario();
		
		return "index";
	}
	
//	public void setLista(List<Usuario> lista) {
//		this.lista = lista;
//	}
//	
	public UsuarioDao getUsuarioDao() {
		
		if (this.usuarioDao == null) {
			
			this.usuarioDao = new UsuarioDao();
		}
		return usuarioDao;
	}
//	
//	public void setUsuarioDao(UsuarioDao usuarioDao) {
//		this.usuarioDao = usuarioDao;
//	}
//	
//	public Usuario getUsuario() {
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
}
