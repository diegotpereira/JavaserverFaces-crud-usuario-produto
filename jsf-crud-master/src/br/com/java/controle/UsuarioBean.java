package br.com.java.controle;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.com.java.dao.BuscarPorUsuarioNomeDao;
import br.com.java.dao.BuscarUsuarioPorIdDao;
import br.com.java.modelo.Password;
import br.com.java.modelo.Usuario;
import br.com.java.modelo.HashPassword;

@Named(value = "usuario")
@SessionScoped
public class UsuarioBean implements Serializable{
	
	private boolean logado = false;
	private boolean Admin = false;
	private String username;
	private String password;
	private Usuario usuario;
	
	private HashPassword hashPassword;
	
	public boolean isLogado() {
		return logado;
	}
	
	
	public String Login() {
		
		Usuario tempusuario = new Usuario();
		
		BuscarPorUsuarioNomeDao buscarPorUsuarioNomeDao = new BuscarPorUsuarioNomeDao();
		BuscarUsuarioPorIdDao buscarUsuarioPorIdDao = new BuscarUsuarioPorIdDao();
		
		tempusuario.setUserName("user1");
		tempusuario.setId(23l);
		
		
		
		if (tempusuario.getId() != -1) {
			
			this.usuario = buscarUsuarioPorIdDao.buscarUsuarioPorId(tempusuario.getId());
			
			
		} else if(tempusuario.getUserName() != null){
			
			this.usuario = buscarPorUsuarioNomeDao.BuscarPorUsuarioNome(tempusuario.getUserName());
		}
		
		Password tempPassword = new Password();
		
		tempPassword.setPassword("123");
		tempPassword.setSalt("0b36e479912b4274");
		
		tempPassword = hashPassword.obterHashPassword(tempPassword);
		this.setAdmin(true);
		
		usuario.getPassword();
//		password
		
		// if(this.User.getPassword().getHashedPassword().equals(tempPassword.getHashedPassword())){
		if (this.usuario.getPassword().getHashedPassword().equals(tempPassword.getHashedPassword())) {
			
			tempusuario	.setLogado(true);
			
			System.out.println("teste");
			
			return "HomeP";
			
		} else {
			
			this.usuario.setLogado(false);
			
			FacesContext.getCurrentInstance().addMessage("LerBean", new FacesMessage("As credenciais de login não estão corretas!!!"));
			
			return "LoginP";
		}
//		return usuario;
	}
	
	public void setLogado(boolean logado) {
		this.logado = logado;
	}
	public boolean isAdmin() {
		return Admin;
	}
	public void setAdmin(boolean admin) {
		Admin = admin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public HashPassword getHashPassword() {
		return hashPassword;
	}
	public void setHashPassword(HashPassword hashPassword) {
		this.hashPassword = hashPassword;
	}
}
