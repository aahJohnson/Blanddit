package view;

public class userBean {
	private static String username;
	private static String password;

	public static String getUsername() { // gives the username
		return username;
	}
	
	public static String getPassword() { // gives the password (!!!)
		return password;
	}
	
	public void setUsername(String username) { // sets the username
		userBean.username = username;
	}
	
	public void setPassword(String password) { // sets the password
		userBean.password = password;
	}
}