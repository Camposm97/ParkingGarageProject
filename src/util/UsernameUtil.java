package util;

public class UsernameUtil {
	private static final int LAST_NAME_LENGTH = 4;
	
	/**
	 * Doesn't include numbers at the end of the user name.  Takes the first four letters
	 * of the last name (if there is four letters) and takes the first character of the first name.
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public static String emitUsername(String firstName, String lastName) {
		String username = "";
		if (lastName.length() >= LAST_NAME_LENGTH) {
			username += lastName.substring(0, LAST_NAME_LENGTH);
		} else {
			username += lastName;
		}
		username += Character.toLowerCase(firstName.charAt(0));
		return username;
	}
	
	
}
