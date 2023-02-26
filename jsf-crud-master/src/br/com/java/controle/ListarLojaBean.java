//package br.com.java.controle;
//
//import java.io.Serializable;
//import java.util.*;
//
//import javax.enterprise.context.RequestScoped;
//import javax.inject.Named;
//
//import br.com.java.dao.ListarLojaDao;
//import br.com.java.modelo.Loja;
//
//@Named 
//@RequestScoped
//public class ListarLojaBean implements Serializable{
//	
//	private List<Loja> lojas;
//	ListarLojaDao listarLojaDao = new ListarLojaDao();
//	Loja loja = new Loja();
////	private int ID;
////	private String nome;
//	
//	public List<Loja> getLojas() {
//		
//		lojas = listarLojaDao.listarLojas();
//		
//		return lojas;
//	}
//	
//	public ListarLojaDao getListarLojaDao() {
//		
//		if (listarLojaDao == null) {
//			
//			listarLojaDao = new ListarLojaDao();
//		}
//		return listarLojaDao;
//	}
//
//	public void setListarLojaDao(ListarLojaDao listarLojaDao) {
//		this.listarLojaDao = listarLojaDao;
//	}
//
//	public Loja getLoja() {
//		
//		if (this.loja == null) {
//			
//			this.loja = new Loja();
//		}
//		return loja;
//	}
//
//	public void setLoja(Loja loja) {
//		this.loja = loja;
//	}
//
//	public void setLojas(List<Loja> lojas) {
//		this.lojas = lojas;
//	}
//
////	public int getID() {
////		return ID;
////	}
////
////	public void setID(int iD) {
////		ID = iD;
////	}
////
////	public String getNome() {
////		return nome;
////	}
////
////	public void setNome(String nome) {
////		this.nome = nome;
////	}
//}
