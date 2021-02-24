package lockedMeApp;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*Class FileActions contains all methods needed to perform actions of files/directory such as:
 *  -Creating a new directory
 *  -Displaying all files in the directory
 *  -Adding new file to the directory
 *  -Deleting a file from the directory
 */

public class FileActions {
	
	//***************** createFolder method  *************************
	// Creates an empty folder is its not already present
	
	public static void createFolder(String folderName) {
		File file = new File(folderName);

		// If file doesn't exist, create the main folder
		if (!file.exists()) {
			file.mkdirs();
		}
	}
	
	//***************** displayAllFiles method**************
	//Displays all files/folders in the directory in ascending order
	
	public static void displayAllFiles(String path) {
		FileActions.createFolder("Data");


		// listFilesInDirectory displays files along with folder structure
		List<String> filesListNames = FileActions.listFilesInDirectory(path, 0, new ArrayList<String>());

		//System.out.println("Displaying all files in ascending order\n");
		Collections.sort(filesListNames);

		filesListNames.stream().forEach(System.out::println);
	}
	
	// ************** listAllFiles method ******************
	//Lists all files in directory if directory is populated with files
	
	public static List<String> listFilesInDirectory(String path, int indentationCount, List<String> fileListNames) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		Collections.sort(filesList);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				System.out.print(" ".repeat(indentationCount * 2));

				if (file.isDirectory()) {
					System.out.println("`-- " + file.getName());

					// Recursively indent and display the files
					fileListNames.add(file.getName());
					listFilesInDirectory(file.getAbsolutePath(), indentationCount + 1, fileListNames);
				} else {
					System.out.println("|-- " + file.getName());
					fileListNames.add(file.getName());
				}
			}
		} else {
			System.out.print(" ".repeat(indentationCount * 2));
			System.out.println("\nThis Directory is Empty."
					+ "\nTo add files, please go back"
					+ "\nand select option '2' from Main Menu.");
		}
		System.out.println();
		return fileListNames;
	}
	
	// ******************** displayfileLocation method **********************
	// displays specific file during search operation
	
	public static List<String> displayFileLocations(String fileName, String path) {
		List<String> fileListNames = new ArrayList<>();
		FileActions.searchFile(path, fileName, fileListNames);

		if (fileListNames.isEmpty()) {
			System.out.println("\n\n Couldn't find any file with given file name \"" + fileName + "\"\n\n");
		} else {
			System.out.println("\n\nFound file at below location(s):");

			List<String> files = IntStream.range(0, fileListNames.size())
					.mapToObj(index -> (index + 1) + ": " + fileListNames.get(index)).collect(Collectors.toList());

			files.forEach(System.out::println);
		}

		return fileListNames;
	}
	
	//******************* searchFile method ****************************
	//Searches directory for a user specific file
	
	public static void searchFile(String path, String fileName, List<String> fileListNames) {
		File dir = new File(path);
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		if (files != null && files.length > 0) {
			for (File file : filesList) {

				if (file.getName().startsWith(fileName)) {
					fileListNames.add(file.getAbsolutePath());
				}
				if (file.isDirectory()) {
					searchFile(file.getAbsolutePath(), fileName, fileListNames);
				}
			}
		}
	}

	// ********************* addFile method ******************************
	//Prompts user to add file to the directory
	
	public static void addFile(String fileToAdd, Scanner sc) {
		FileActions.createFolder("Data");
		Path pathToFile = Paths.get("./Data/" + fileToAdd);
		try {
			Files.createDirectories(pathToFile.getParent());
			Files.createFile(pathToFile);
			System.out.println(fileToAdd + " created successfully");

			System.out.println("\nWould you like to add some content to the file? (Y/N)");
			String choice = sc.next().toLowerCase();

			sc.nextLine();
			if (choice.equals("y")) {
				System.out.println("\n\nInput content and press enter\n");
				String content = sc.nextLine();
				Files.write(pathToFile, content.getBytes());
				System.out.println("\nContent written to file " + fileToAdd);
				System.out.println("\nContent can be read using Notepad or Notepad++");
			}

		} catch (IOException e) {
			System.out.println("\nFailed to create file " + fileToAdd);
			System.out.println(e.getClass().getName());
		}
	}
	
	// ********************* deleteFile method ****************************
	// Prompts user to delete specific file from directory
			
	public static void deleteFile(String path) {

		File currFile = new File(path);
		File[] files = currFile.listFiles();

		if (files != null && files.length > 0) {
			for (File file : files) {

				String fileName = file.getName() + " at " + file.getParent();
				if (file.isDirectory()) {
					deleteFile(file.getAbsolutePath());
				}

				if (file.delete()) {
					System.out.println(fileName + " deleted successfully");
				} else {
					System.out.println("Failed to delete " + fileName);
				}
			}
		}

		String currFileName = currFile.getName() + " at " + currFile.getParent();
		if (currFile.delete()) {
			System.out.println(currFileName + " deleted successfully");
		} else {
			System.out.println("Failed to delete " + currFileName);
		}
	}

} // End of Class
