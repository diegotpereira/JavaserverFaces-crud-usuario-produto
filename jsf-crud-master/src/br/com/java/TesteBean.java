package br.com.java;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named
@SessionScoped
public class TesteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
		private String name;
	
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

}
