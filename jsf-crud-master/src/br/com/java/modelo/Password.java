package br.com.java.modelo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {
	
	private String password;
	private String password2;
	private String HashedPassword;
    private String Salt;
    
    public Password() {
		
    	this.password = null;
    	this.HashedPassword = null;
    	this.Salt = null;
	}
    
	public Password(String password, String hashedPassword, String salt) {
		super();
		this.password = password;
		HashedPassword = hashedPassword;
		Salt = salt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	public String getHashedPassword() {
	      try {
	         // Obtem uma instância do algoritmo de hash SHA-256
	         MessageDigest md = MessageDigest.getInstance("SHA-256");
	         // Calcula o hash da senha
	         byte[] hashedPassword = md.digest(password.getBytes());
	         // Converte o hash para uma representação hexadecimal
	         StringBuilder sb = new StringBuilder();
	         for (byte b : hashedPassword) {
	            sb.append(String.format("%02x", b));
	         }
	         return sb.toString();
	      } catch (NoSuchAlgorithmException e) {
	         // Se o algoritmo SHA-256 não estiver disponível, lançar uma exceção
	         throw new RuntimeException("Erro ao gerar hash da senha", e);
	      }
	   }

//	public String getHashedPassword() {
//		
//		if (this.password == null || this.Salt == null) {
//			
//		}
//		
//		try {
//            MessageDigest md = MessageDigest.getInstance("SHA-256"); // instancia o algoritmo SHA-256
//            byte[] hashedPassword = md.digest(password.getBytes()); // calcula o hash da senha
//            StringBuilder sb = new StringBuilder(); // cria um StringBuilder para armazenar o hash em formato hexadecimal
//            for (byte b : hashedPassword) {
//                sb.append(String.format("%02x", b));
//            }
//            return sb.toString(); // retorna o hash em formato hexadecimal
//        } catch (NoSuchAlgorithmException e) {
//            throw new RuntimeException("Erro ao gerar hash da senha", e);
//        }
//		
//	}

	public void setHashedPassword(String hashedPassword) {
		HashedPassword = hashedPassword;
	}

	public String getSalt() {
		return Salt;
	}

	public void setSalt(String salt) {
		Salt = salt;
	}
}
