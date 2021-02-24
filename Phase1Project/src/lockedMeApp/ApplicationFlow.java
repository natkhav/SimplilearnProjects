package lockedMeApp;
import java.util.List;
import java.util.Scanner;

/* ApplicationFlow Class contains the two switches 
 * Switch #1 specifies options in the Main Menu and loops inside the do/while loop
 * Switch #2 specifies options in the Sub-Menu and also loops inside the do/while loop
 */
public class ApplicationFlow {
	
	public static void mainMenuFlow() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				//Main menu flow
				MenuOptions.mainMenuOptions();
				int input = sc.nextInt();
				
				// Switch  #1 - organizes 3 Main Menu options				
				switch (input) {
				// case 1. Calls displayAllFiles method form the FileActions class to display files in the directory
				case 1:
					FileActions.displayAllFiles("Data");
					break;
				// case 2. Calls subMenuFlow method from the ApplicationFlow class to display sub-menu options
				case 2:
					ApplicationFlow.subMenuFlow();
					break;
				// case 3. Exits the application
				case 3:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("Please select a valid option from the menu.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				mainMenuFlow();
			} 
		} while (running == true);
	}
	
	//Sub-menu flow
	public static void subMenuFlow() {
		boolean running = true;
		Scanner sc = new Scanner(System.in);
		do {
			try {
				MenuOptions.subMenuOptions();
				FileActions.createFolder("Data");
				
				int input = sc.nextInt();
				switch (input) {
				
				// Switch #2 - organizes 5 Sub-Menu options	
				// case 1. Prompts user to add file to the directory
				case 1:
					System.out.println("Enter the name of the file to be added to the \"Data\" folder");
					String fileToAdd = sc.next();
					
					FileActions.addFile(fileToAdd, sc);
					
					break;
				// case 2. Prompts user to delete file from the directory
				case 2:
					System.out.println("Enter the name of the file to be deleted from \"Data\" folder");
					String fileToDelete = sc.next();
					
					FileActions.createFolder("Data");
					List<String> filesToDelete = FileActions.displayFileLocations(fileToDelete, "Data");
					
					String deletionPrompt = "\nSelect index of which file to delete?"
							+ "\n(Enter 0 if you want to delete all elements)";
					System.out.println(deletionPrompt);
				
					int idx = sc.nextInt();
					
					if (idx != 0) {
						FileActions.deleteFile(filesToDelete.get(idx - 1));
					} else {
						for (String path : filesToDelete) {
							FileActions.deleteFile(path);
						}
					}
					
					break;
				// case 3. Prompts user to search specific file in the directory
				case 3:
					System.out.println("Enter the name of the file to be searched from \"Data\" folder");
					String fileName = sc.next();
					
					FileActions.createFolder("Data");
					FileActions.displayFileLocations(fileName, "Data");
				
					break;
				// case 4. Offers user to go to Man menu
				case 4:
					return;
				// case 5. Exits the application
				case 5:
					System.out.println("Program exited successfully.");
					running = false;
					sc.close();
					System.exit(0);
				default:
					System.out.println("Please select a valid option from the menu.");
				}
			} catch (Exception e) {
				System.out.println(e.getClass().getName());
				subMenuFlow();
			}
		} while (running == true);
	}	

}// End of Class