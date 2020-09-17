import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {
	
	public static boolean isValidPassword(String passwordString) throws LengthException, 
																		NoDigitException,
																		NoUpperAlphaException, 
																		NoLowerAlphaException, 
																		NoSpecialSymbolException, 
																		InvalidSequenceException {
		
		boolean validPassword = true; 
		boolean digit = false; 
		boolean upper = false; 
		boolean lower = false; 
		boolean sequence = false; 
		boolean special = false;
		
		if (passwordString.length() < 6) {
			validPassword = false;
			throw new LengthException();
		}
		
		Pattern specialChar = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
		Matcher hasSpecial = specialChar.matcher(passwordString);
		
		if(hasSpecial.find()) {
			special = true;
		}
		
		for(int x = 0; x < passwordString.length(); x++) {
			char a = passwordString.charAt(x);
			
			if(x > 1 && passwordString.charAt(x) == a && passwordString.charAt(x-1) == a && passwordString.charAt(x-2) == a) {
				sequence = true;
			}
			if(Character.isDigit(a)){
				digit = true;
			}
			if(Character.isUpperCase(a)){
				upper = true;
			}
			if(Character.isLowerCase(a)){
				lower = true;
			}
		}
		
		if(sequence == true) {
			validPassword = false;
			throw new InvalidSequenceException();
		}
		if(digit == false) {
			validPassword = false;
			throw new NoDigitException();
		}
		if(upper == false) {
			validPassword = false;
			throw new NoUpperAlphaException();
		}
		if(lower == false) {
			validPassword = false;
			throw new NoLowerAlphaException();
		}
		
		return validPassword;
	}
	
	public static boolean isWeakPassword(String passwordString) {
		return (passwordString.length() >= 6 && passwordString.length() <= 9);
	}
	
	public static ArrayList<String> validPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalid = new ArrayList<String>();
		
		for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception ex) {
                invalid.add(password + " " + ex.getMessage() + "\n");
            }
        }

        return invalid;
	}
}