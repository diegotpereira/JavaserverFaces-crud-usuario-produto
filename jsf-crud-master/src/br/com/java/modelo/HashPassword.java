package br.com.java.modelo;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.logging.*;

public class HashPassword {
	
	private Password password;

	public Password getPassword(Password password) {
		return password;
	}

	public void setPassword(Password password) {
		this.password = password;
	}
	
	public Password obterHashPassword(Password tempPassword) {
		
		if (tempPassword.getSalt() == null) {
			
			tempPassword.setSalt(getSalt());
		}
		
		MessageDigest md;
		
		try {
			
			md = MessageDigest.getInstance("SHA-512");
			
			md.update(tempPassword.getSalt().getBytes(StandardCharsets.UTF_8));
			byte[] bytes = md.digest(tempPassword.getPassword().getBytes(StandardCharsets.UTF_8));
			
			tempPassword.setHashedPassword(ByteToString(bytes));
			
		} catch (NoSuchAlgorithmException ex) {
			// TODO: handle exception
			Logger.getLogger(HashPassword.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return tempPassword;
	}

	private String getSalt() {
		// TODO Auto-generated method stub
		final Random r = new SecureRandom();
        byte[] salt = new byte[8];
        r.nextBytes(salt);
        return ByteToString(salt);
	}
	
	private String ByteToString(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
           sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    
    }

}
