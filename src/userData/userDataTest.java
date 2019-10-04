package userData;

public class userDataTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDataManager testUManager = new UserDataManager();
		//System.out.println(testUManager.passwordCheck("admin0", "admin"));
		//System.out.println(testUManager.getUserList().get(0).getUserName());
		testUManager.addUser("Matthew", "Guidi", "ggBro");
		System.out.println(testUManager.login("admin", "admin"));
		System.out.println(testUManager.login("mguid1", "ggBro"));
		
	}

}
