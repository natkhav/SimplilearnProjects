package lockedMeApp;

/* LocedMeMain is the main class to run LockedMe application.
* 
*/
public class ApplicationMain {

	public static void main(String[] args) {
		
		// Calling methods from FileActions, MenuOptions and ApplicationFlow classes
		FileActions.createFolder("Data");
		
		MenuOptions.welcomeScreen();
		
		ApplicationFlow.mainMenuFlow();

	} //End of Main

} // End of Class
