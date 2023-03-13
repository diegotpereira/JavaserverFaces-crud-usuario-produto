package br.com.java.modelo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String genero;
	private Date dataNascimento;
	private int ano;
	public Produto produto;
	
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

	public int getAno() {
		
//		Usuario usuario = new Usuario();
		
		Date dataAtual = new Date();
//        Date nascimento = getDataNascimento();
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int ano1 = Integer.parseInt(sdf.format(dataNascimento));
        int ano2 = Integer.parseInt(sdf.format(dataAtual));
        ano = ano2 - ano1;
        
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}
