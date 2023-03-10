package br.com.java.controle;

import java.io.Serializable;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.java.dao.AlterarDao;
import br.com.java.dao.DeletarDao;
import br.com.java.modelo.Usuario;

@Named
@RequestScoped
public class DeletarBean implements Serializable{
	
public String alterarUsuario(Long id) {
	
		Usuario usuario = new Usuario();
			
		AlterarDao alterarDao = new AlterarDao();
			
			
		usuario = alterarDao.alterarUsuario(id);
			
		return "deletar.xhtml";
	}

	public String excluir(Long id) throws SQLException {
		
		FacesContext fc = FacesContext.getCurrentInstance();
		
		DeletarDao deletarDao = new DeletarDao();
		deletarDao.deletar(id);
		
		return "index.xhtml?faces-redirect=true";
	}
}
