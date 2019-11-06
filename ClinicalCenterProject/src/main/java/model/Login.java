package model;

public class Login {
	private String userName;
	private String password1;
	private String password2;
	
	public Login() {
		super();
	}

	public Login(String userName, String password1, String password2) {
		super();
		this.userName = userName;
		this.password1 = password1;
		this.password2 = password2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	
	
	
	
}
