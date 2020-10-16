package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Class for the input of the file
public class FileInput {
	
	private Scanner in;
	
	public FileInput(String fileName) {
		
	try {
		in = new Scanner(new File(fileName));
	}
	catch (FileNotFoundException e) {
		//.err stands for error output stream it's used when theres an error in the probram
		System.err.println("Could not find the file "+fileName);
	  }
	} // end of FileInput constructor
	
	public String readFromFile() {
		if (in.hasNextLine())
			return in.nextLine();
		else return null;
	}
	//Closing your program is good practice
	public void closeFile() {

	}
}
