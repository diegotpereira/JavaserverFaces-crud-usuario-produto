package br.com.java.modelo;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.java.modelo.Password;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashPassword {
    private static final String ALGORITHM = "SHA-256";
    
    private Password password;
    
	public HashPassword(Password password) {
	
	    this.password = password;
    }
	
    public HashPassword() {}

    public Password obterHashPassword(Password password) {
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            byte[] salt = hexStringToByteArray(password.getSalt());
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getPassword().getBytes());
            password.setHashedPassword(byteArrayToHexString(hashedPassword));
            return password;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private String byteArrayToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}

//public class HashPassword {
//	
//	Password password;
//	
//	public HashPassword(Password password) {
//		
//		this.password = password;
//	}
//
//	public Password getPassword(Password password) {
//		return password;
//	}
//
//	public void setPassword(Password password) {
//		this.password = password;
//	}
//	
//	public Password obterHashPassword(Password tempPassword) {
//		
//		if (tempPassword.getSalt() == null) {
//			
//			tempPassword.setSalt(getSalt());
//		}
//		
//		MessageDigest md;
//		
//		try {
//			
//			md = MessageDigest.getInstance("SHA-512");
//			
//			md.update(tempPassword.getSalt().getBytes(StandardCharsets.UTF_8));
//			byte[] bytes = md.digest(tempPassword.getPassword().getBytes(StandardCharsets.UTF_8));
//			
//			tempPassword.setHashedPassword(ByteToString(bytes));
//			
//		} catch (NoSuchAlgorithmException ex) {
//			// TODO: handle exception
//			Logger.getLogger(HashPassword.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		
//		return tempPassword;
//	}
//
//	private String getSalt() {
//		// TODO Auto-generated method stub
//		final Random r = new SecureRandom();
//        byte[] salt = new byte[8];
//        r.nextBytes(salt);
//        return ByteToString(salt);
//	}
//	
//	private String ByteToString(byte[] bytes){
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i< bytes.length ;i++){
//           sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
//        }
//        return sb.toString();
//    
//    }
//
//}
