package planner.manager;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.UUID;

import planner.db.AccountData;
import planner.model.Account;

public class UserValidationMgr {
	
	private static byte[] hashBytes;

	static String filename = "src/planner/db/accounts.txt";
	
	public static Account compareUserPass(String username, String passwordToBeHash, String accountType)
	{
		String salt;
		ArrayList al;
		String securePassword;
		
		try {
			
			al = AccountData.readAccounts(filename);

		for (int i = 0; i < al.size(); i++) {
			
			//create user object to iterate
			Account user = (Account) al.get(i);
			
			//retrieve salt from text data
            salt = user.getSalt();
            
            //hash user password input with salt
			securePassword = hashing(passwordToBeHash, salt);
			
			//compare user input hash with hash retrieved from text data
			if (username.toLowerCase().equals(user.getUsername().toLowerCase()) && securePassword.equals(user.getPassword())) {
				if (user.getAccountType().equals(accountType)){
					return user;
				}
			}
		}
		return null;
		
		} catch (IOException e) {
			System.out.println("IOException > " + e.getMessage());
		}

		return null;
	}
		
	public static String generateSalt() {
		String salt;
		// random alphanumeric generator
		salt = UUID.randomUUID().toString();
		return salt;
	}

	public static String hashing(String passwordToBeHash, String salt)
	{
		String hashPassword = "";
		
		try {
			//generate salt
			if (salt.equals(""))
			{
			salt = generateSalt();
			}
			
			StringBuilder sb = new StringBuilder(passwordToBeHash);
			
			// Prepend salt to passwordToBeHash
			String passwordWithSaltToBeHash = sb.insert(0, salt).toString();
			
		
			
			// create SHA-512 Message Digest Instance
			MessageDigest sha512algo = MessageDigest.getInstance("SHA-512");

			// Get hash in decimal format
			StringBuilder sb2 = new StringBuilder();
			hashBytes = sha512algo.digest(passwordWithSaltToBeHash.getBytes());
			
			for (int i = 0; i < hashBytes.length; i++) {
				// convert it to hexadecimal format
				sb2.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			hashPassword = sb2.toString();

		} catch (Exception e) {
			System.out.println("IOException > " + e.getMessage());
		}

		return hashPassword;
	}



}