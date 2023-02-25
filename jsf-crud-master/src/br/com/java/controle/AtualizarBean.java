package br.com.java.controle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.java.dao.AtualizarDao;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class AtualizarBean {
	
public String atualizarUsuario(Usuario usuario) {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		try {
			
//			UsuarioDao usuarioDao = new UsuarioDao();
//			usuarioDao.atualizarUsuario(usuario);
			
			AtualizarDao atualizarDao = new AtualizarDao();
			atualizarDao.atualizarUsuario(usuario);
//			usuario = new Usuario();
			fc.addMessage(null, new FacesMessage("Dados Alterados com sucesso"));
			
		} catch (Exception e) {
			// TODO: handle exception
			fc.addMessage(null, new FacesMessage("Erro: " + e.getMessage()));
		}
		
		return "index.xhtml";
		
	}

}
