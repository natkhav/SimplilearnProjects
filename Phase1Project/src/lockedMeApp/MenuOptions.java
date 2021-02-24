package lockedMeApp;

/*The MenuOption class contains 3 methods:
 * welcomeScreen(); mainMenuOptions(); subMenuOptions(); 
 * All these methods are to be called in AppFlow class  
 */


public class MenuOptions {

	// ******************welcomScreen method**********************
	//displays information about the application
	//it's purpose and a developer's name
	
	public static void welcomeScreen() {
		//Print name of the application it's purpose and the developer's name	
		System.out.println("-----------------------------------------");
		System.out.println("      *** WELCOME TO LOCKEDME ***        "
				    + "\n-----------------------------------------"
					+ "\nWith this application users can: "
					+ "\n\t-See all files in the directory"
					+ "\n\t-Search directory for particular file"
					+ "\n\t-Add file to the directory"
					+ "\n\t-Remove file from the directory"
					+ "\n\t-Switch between Main and Sub menus\n"
					+ "\nDeveloper: Natalia Khavlina");
	}
	
	// *******************mainMenuOptions method*********************
	// displays options in the main menu of the application
	
	public static void mainMenuOptions() {
		String mainMenu = "\n-----------------------------------------"
				        + "\n             Main Menu                   "
				        + "\n-----------------------------------------\n"
				        + "\n1. Open Directory " 
				        + "\n2. Open Directory Sub-Menu "
				        + "\n3. Exit application\n"
				        + "\n-----------------------------------------"
				        + "\nSelect your option, and click 'Enter'"; 
		System.out.println(mainMenu);

	}
    
	//************************subMenuoptions method**********************
	//displays options in sub-menu of "Open Sub-Menu" option in main menu
	
	public static void subMenuOptions() {
		String subMenu = "\n----------------------------------------"
			            + "\n             Sub-Menu                   "
			            + "\n----------------------------------------\n"
			            + "\n1. Add a file to directory" 
			            + "\n2. Delete a file from directory"
			            + "\n3. Search for a file in directory" 
			            + "\n4. Go back to Main Menu" 
			            + "\n5. Exit program\n"
			            + "\n-----------------------------------------"
			            + "\nSelect your option, and click 'Enter'";

		System.out.println(subMenu);
	}

} // End of Class
