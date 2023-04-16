package Entite;

/**
 * @author François BONNET 
 *
 */
public class EmailValidation {
	
	/**
	 * 
	 *             Input: a character 
	 *             Output: a boolean 
	 *             Function: It takes as input a character to verify
	 *             and outputs a boolean to indicate if it is an 
	 *             alphanumeric character
	 * 
	 */

	public static boolean isAlphanumeric(char character) {
		
		if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')
				|| (character >= '0' && character <= '9')) {
			return (true);
		} else {
			return (false);
		}
	}
	
	/**
	 * 
	 *             Input: a character 
	 *             Output: a boolean 
	 *             Function: It takes as input a character to verify
	 *             and outputs a boolean to indicate if it is an 
	 *             alphanumeric character
	 * 
	 */

	public static boolean isAlphabetic(char character) {
		
		if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z')) {
			return (true);
		} else {
			return (false);
		}
	}
	
	/**
	 * 
	 *             Input: a character 
	 *             Output: a boolean 
	 *             Function: It takes as input a character to verify 
	 *             and outputs a boolean to indicate if it is a
	 *             valid character to use in the prefix of an email
	 *             address
	 * 
	 */

	public static boolean isValidPrefixChar(char character) {
		
		if (isAlphanumeric(character) || character == '_' || character == '-' || character == '.') {
			return (true);
		} else {
			return (false);
		}
	}
	
	/**
	 * 
	 *             Input: a character 
	 *             Output: a boolean 
	 *             Function: It takes as input a character to verify 
	 *             and outputs a boolean to indicate if it is a
	 *             valid character to use in the prefix of an email
	 *             address while not being alphanumeric
	 * 
	 */

	public static boolean isValidPrefixCharNonAlphanumeric(char character) {
		
		if (character == '_' || character == '-' || character == '.') {
			return (true);
		} else {
			return (false);
		}
	}
	
	/**
	 * 
	 *             Input: a character
	 *             Output: a boolean 
	 *             Function: It takes as input a character to verify 
	 *             and outputs a boolean to indicate if it is a
	 *             valid character to use in the domain of an email
	 *             address
	 * 
	 */

	public static boolean isValidDomainChar(char character) {
		
		if (isAlphanumeric(character) || character == '-' || character == '.') {
			return (true);
		} else {
			return (false);
		}
	}
	
	/**
	 * 
	 *             Input: a character 
	 *             Output: a boolean 
	 *             Function: It takes as input a character to verify 
	 *             and outputs a boolean to indicate if it is a
	 *             valid character to use in the domain of an email
	 *             address while not being alphanumeric
	 * 
	 */

	public static boolean isValidDomainCharNonAlphanumeric(char character) {
		
		if (character == '-' || character == '.') {
			return (true);
		} else {
			return (false);
		}
	}
	
	/**
	 * 
	 *             Input: a string 
	 *             Output: a boolean 
	 *             Function: It takes as input a string to verify
	 *             and outputs a boolean to indicate if an email
	 *             address has one and only one @ 
	 * 
	 */

	public static boolean exactlyOneAt(String possibleEmailAddress) {
		
		int count = 0;
		
		//for loop to go through the possible email address
		for (int i = 0; i < possibleEmailAddress.length(); i++) {
			if (possibleEmailAddress.charAt(i) == '@') {
				count++;
			}
		}
		
		if (count == 1) {
			return (true);
		} else {
			return (false);
		}
	}
	
	/**
	 * 
	 *             Input: a string 
	 *             Output: a string 
	 *             Function: Takes as input a possible email address
	 *             and outputs the prefix of this email address
	 * 
	 */

	public static String getPrefix(String possibleEmailAddress) {
		
		int rankOfTheAt = 0;
		String prefixOfThePossibleEmailAddress = "";

		//for loop to go through the possible email address
		for (int i = 0; i < possibleEmailAddress.length(); i++) {
			
			if (possibleEmailAddress.charAt(i) == '@') {
				rankOfTheAt = i;
			}
		}
		//for loop to get all the characters of the prefix
		for (int i = 0; i < rankOfTheAt; i++) {
			prefixOfThePossibleEmailAddress += possibleEmailAddress.charAt(i);
		}
		
		return (prefixOfThePossibleEmailAddress);
	}
	
	/**
	 * 
	 *             Input: a string 
	 *             Output: a string
	 *             Function: Takes as input a possible email address
	 *             and outputs the domain of this email address
	 * 
	 */

	public static String getDomain(String possibleEmailAddress) {
		
		boolean theAtIsPassed = false;
		String domainOfThePossibleEmailAddress = "";
		
		//for loop to go through the possible email address
		for (int i = 0; i < possibleEmailAddress.length(); i++) {
			
			//Once the at is passed we get all the characters of the domain
			//of the possible email address
			if (theAtIsPassed) {
				domainOfThePossibleEmailAddress += possibleEmailAddress.charAt(i);
			}
			
			if (possibleEmailAddress.charAt(i) == '@') {
				theAtIsPassed = true;
			}
		}
		
		return (domainOfThePossibleEmailAddress);
	}
	
	/**
	 * 
	 *             Input: a string to verify
	 *             Output: a boolean 
	 *             Function: Takes as input a prefix of a possible 
	 *             email address and outputs a boolean to indicate
	 *             if it is a valid prefix
	 * 
	 */

	public static boolean isValidPrefix(String prefixOfThePossibleEmailAddress) {
		
		boolean areAllCharactersAcceptable = true;
		
		if (prefixOfThePossibleEmailAddress.length() == 0) {
			return (false);
		}
		
		if (!isAlphanumeric(prefixOfThePossibleEmailAddress.charAt(0)) || !isAlphanumeric(
				prefixOfThePossibleEmailAddress.charAt(prefixOfThePossibleEmailAddress.length() - 1))) {
			return (false);
		}
		
		//for loop to go through the prefix of the possible email address
		for (int i = 0; i < prefixOfThePossibleEmailAddress.length() - 1; i++) {
			
			if (!isValidPrefixChar(prefixOfThePossibleEmailAddress.charAt(i))) {
				areAllCharactersAcceptable = false;
			}
			
			//verifying if two following characters are non alphanumeric
			if (isValidPrefixCharNonAlphanumeric(prefixOfThePossibleEmailAddress.charAt(i))
					&& isValidPrefixCharNonAlphanumeric(prefixOfThePossibleEmailAddress.charAt(i + 1))) {
				areAllCharactersAcceptable = false;
			}
		}
		
		return (areAllCharactersAcceptable);
	}
	
	/**
	 * 
	 *             Input: a string to verify
	 *             Output: a boolean 
	 *             Function: Takes as input a domain of a possible 
	 *             email address and outputs a boolean to indicate
	 *             if it is a valid domain
	 * 
	 */

	public static boolean isValidDomain(String domainOfThePossibleEmailAddress) {
		
		boolean containsAPeriod = false;
		boolean areAllCharactersAcceptable = true;
		int rankOfTheLastPeriod = 0;
		
		if (domainOfThePossibleEmailAddress.length() == 0) {
			return (false);
		}
		
		if (!isAlphanumeric(domainOfThePossibleEmailAddress.charAt(0)) || !isAlphanumeric(
				domainOfThePossibleEmailAddress.charAt(domainOfThePossibleEmailAddress.length() - 1))) {
			return (false);
		}
		
		//for loop to go through the domain of the possible email address
		for (int i = 0; i < domainOfThePossibleEmailAddress.length() - 1; i++) {
			
			if (!isValidDomainChar(domainOfThePossibleEmailAddress.charAt(i))) {
				areAllCharactersAcceptable = false;
			}

			//verifying if two following characters are non alphanumeric
			if (isValidDomainCharNonAlphanumeric(domainOfThePossibleEmailAddress.charAt(i))
					&& isValidDomainCharNonAlphanumeric(domainOfThePossibleEmailAddress.charAt(i + 1))) {
				areAllCharactersAcceptable = false;
			}
			
			if (domainOfThePossibleEmailAddress.charAt(i) == '.') {
				containsAPeriod = true;
				rankOfTheLastPeriod = i;
			}
		}
		
		if (containsAPeriod) {
			
			//for loop to go through the characters behind the last period
			for (int i = rankOfTheLastPeriod + 1; i < domainOfThePossibleEmailAddress.length(); i++) {
				
				if (!isAlphabetic(domainOfThePossibleEmailAddress.charAt(i))) {
					areAllCharactersAcceptable = false;
				}
			}
			
			//Verifying if there are at least two characters behind the last period
			if ((domainOfThePossibleEmailAddress.length() - 1 - rankOfTheLastPeriod) < 2) {
				areAllCharactersAcceptable = false;
			}
		}
		
		return (areAllCharactersAcceptable && containsAPeriod);
	}
	
	/**
	 * 
	 *             Input: a string to verify
	 *             Output: a boolean 
	 *             Function: Takes as input a possible email
	 *             address and outputs a boolean to indicate
	 *             if it is a valid email address
	 * 
	 */

	public static boolean isValidEmail(String possibleEmailAddress) {
		
		if (!exactlyOneAt(possibleEmailAddress)) {
			return (false);
		}
		
		if (!isValidPrefix(getPrefix(possibleEmailAddress))) {
			return (false);
		}
		
		if (!isValidDomain(getDomain(possibleEmailAddress))) {
			return (false);
		}
		
		return (true);
	}
}