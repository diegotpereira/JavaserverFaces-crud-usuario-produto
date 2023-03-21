package br.com.java.controle;


import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import br.com.java.dao.BuscarPorUsuarioNomeDao;
import br.com.java.dao.BuscarUsuarioPorIdDao;
import br.com.java.dao.ListarDao;
import br.com.java.modelo.HashPassword;
import br.com.java.modelo.Password;
import br.com.java.modelo.Usuario;

@Named(value = "usuario")
@RequestScoped
public class LerBean implements Serializable{
	
	private List<Usuario> lista;
	private ListarDao listarDao = new ListarDao();
	Usuario usuario;
	int ano;
	
	private boolean logado = false;
	private boolean Admin = false;
	private String username;
	private String password;
	
//	private HashPassword hashPasswors;
//	
//	public boolean isLogado() {
//		return logado;
//	}
//
//	public void setLogado(boolean logado) {
//		this.logado = logado;
//	}
//
//	public boolean isAdmin() {
//		return Admin;
//	}
//
//	public void setAdmin(boolean admin) {
//		Admin = admin;
//	}
//	
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}

	public List<Usuario> getLista() {
			
//		lista = getListarDao().buscarTodos();
		lista = listarDao.buscarTodos();
		
		return lista;
			
	}
	
//	public int getCalcularAno(ActionEvent e) {
//		
//		String SQL = "SELECT IDADE FROM USUARIOS WHERE ID = ?";
//		
//		Date dataAtual = new Date();
//        Date nascimento = usuario.getDataNascimento();
//        
//        
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
//        int ano1 = Integer.parseInt(sdf.format(nascimento));
//        int ano2 = Integer.parseInt(sdf.format(dataAtual));
//        ano = ano2 - ano1;
//		
//		return ano;
//	}
	
	

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
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
	
//	public String Login() {
//		
//		Usuario tempusuario = new Usuario();
//		
//		BuscarPorUsuarioNomeDao buscarPorUsuarioNomeDao = new BuscarPorUsuarioNomeDao();
//		BuscarUsuarioPorIdDao buscarUsuarioPorIdDao = new BuscarUsuarioPorIdDao();
//		
//		tempusuario.setUserName("user1");
//		tempusuario.setId(23l);
//		
//		
//		
//		if (tempusuario.getId() != -1) {
//			
//			this.usuario = buscarUsuarioPorIdDao.buscarUsuarioPorId(tempusuario.getId());
//			
//			
//		} else if(tempusuario.getUserName() != null){
//			
//			this.usuario = buscarPorUsuarioNomeDao.BuscarPorUsuarioNome(tempusuario.getUserName());
//		}
//		
//		Password tempPassword = new Password();
//		
//		tempPassword.setPassword("123");
//		tempPassword.setSalt("0b36e479912b4274");
//		
//		tempPassword = hashPasswors.obterHashPassword(tempPassword);
//		this.setAdmin(true);
//		
//		usuario.getPassword();
////		password
//		
//		// if(this.User.getPassword().getHashedPassword().equals(tempPassword.getHashedPassword())){
//		if (this.usuario.getPassword().getHashedPassword().equals(tempPassword.getHashedPassword())) {
//			
//			tempusuario	.setLogado(true);
//			
//			System.out.println("teste");
//			
//			return "HomeP";
//			
//		} else {
//			
//			this.usuario.setLogado(false);
//			
//			FacesContext.getCurrentInstance().addMessage("LerBean", new FacesMessage("As credenciais de login não estão corretas!!!"));
//			
//			return "LoginP";
//		}
////		return usuario;
//	}
	
	
}






















