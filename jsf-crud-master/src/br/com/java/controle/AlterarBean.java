package br.com.java.controle;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.java.dao.*;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class AlterarBean implements Serializable{
	
	Usuario usuario = new Usuario();
	
	public String alterarUsuario(Long id) {
		
		AlterarDao alterarDao = new AlterarDao();
		
		
		usuario = alterarDao.alterarUsuario(id);
		
		return "alterar.xhtml";
	}

	public Usuario getUsuario() {
		
		if (this.usuario == null) {
			
			usuario = new Usuario();
		}
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
