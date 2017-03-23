package planner.model;
import java.io.Serializable;

public class Account implements Serializable {
	private String username ;
	private String password ;
	private String accountType ;

	public Account(String user, String pass, String type)  {
		username = user ;
		password = pass ;
		accountType = type ;
	}
	
	public String getUsername() { 
		return username; 
	}
	
	public String getPassword() { 
		return password; 
	}
	
	public String getAccountType() { 
		return accountType; 
	}

	public boolean equals(Object obj) {
		if (obj instanceof Account) {
			Account acc = (Account)obj;
			return (getUsername().equals(acc.getUsername()));
		}
		return false;
	}
}