package util;

/**
 * Purpose of this class is to auto-generate a user name using the first and last name of a person.
 * @version v1.0
 * @author Michael Campos
 */
public class UsernameUtil {
	private static final int LAST_NAME_LENGTH = 4;
	
	/**
	 * Doesn't include numbers at the end of the user name.  Takes the first four letters
	 * of the last name (if there is four letters) and takes the first character of the first name.
	 * @param firstName First name of the user
	 * @param lastName Last name of the user
	 * @return returns the username of this new user
	 * @author Michael Campos	
	 */
	public static String emitUsername(String firstName, String lastName) {
		String username = "";
		username += Character.toLowerCase(firstName.charAt(0));
		if (lastName.length() >= LAST_NAME_LENGTH) {
			username += lastName.substring(0, LAST_NAME_LENGTH);
		} else {
			username += lastName;
		}
		// We need to add an index to this as well. Index = the size of the user list so it goes to the end of the array
		// No deletions allowed!!!
		
		return username;
	}
	
	
}
