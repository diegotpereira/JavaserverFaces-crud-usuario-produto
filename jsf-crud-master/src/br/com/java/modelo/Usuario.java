package br.com.java.modelo;

import java.io.Serializable;

import br.com.java.dao.UsuarioDao;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private UsuarioDao usuarioDao;
	
	public Usuario() {
		super();
	}
	
	public Usuario(Long id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String inserirUsuario(Usuario usuario) {
		
//		return usuarioDao.inserirUsuario(usuario);
		return UsuarioDao.inserirUsuario(usuario);
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
