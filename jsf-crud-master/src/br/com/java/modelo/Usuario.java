package br.com.java.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.java.dao.UsuarioDao;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String genero;
	private Date dataNascimento;
	private UsuarioDao usuarioDao;
	
	public Usuario() {
		super();
	}
	
	public Usuario(Long id, String nome, String genero, Date datanascimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = datanascimento;
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
	
	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String inserirUsuario(Usuario usuario) {
		
		return UsuarioDao.inserirUsuario(usuario);
	}
	

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
