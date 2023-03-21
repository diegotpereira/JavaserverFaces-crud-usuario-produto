package br.com.java.modelo;

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
		return HashedPassword;
	}

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
