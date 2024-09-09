//-----------------------------------------------------
// Title: Main (Driver) Class 
// Author: Ahmet Can Öztürk
// ID: 11146244104
// Section: 02
// Author: Elif Alptekin
// ID: 31376233198
// Section: 04
// Assignment: 3
// Description: This is our driver class, it provides for creating objects and reading text files
// also called the functions with the if statements.
//-----------------------------------------------------
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
	    
	    //Taking text file name with scanner
	    Scanner keyboard = new Scanner(System.in);
		String file = keyboard.nextLine();
		
		// Creating BST object
		BinarySearchTree bst = new BinarySearchTree();
		
		System.out.println("--------------- WELCOME TO CDRC SYSTEM ---------------");
		
		
		// We read a text file with BufferedReader and created an array that holds 
		// the text file's elements separately. The while loop's if statements supply 
		// the necessary parameters to the called functions.
		
		String nextLine = "";
		String [] info;
		String func;
		
		BufferedReader inFile = new BufferedReader(new FileReader(file));

		while ((nextLine = inFile.readLine()) != null) {

			info = nextLine.trim().split("\\s+"); // Splitting string on multiple spaces
			func = info[0];

			if (func.equals("Add_Captain")) {
				System.out.println("Add Captain: Add a new captain record in the System\n");
				
				System.out.print("		       ID: ");
				System.out.println(info[1]);
				System.out.print("		       Name: ");
				System.out.println(info[2]);
				System.out.print("		       Available: ");
				System.out.println("True");
				System.out.print("		       Rating star: ");
				System.out.println("0");
				System.out.println("----------------------------------------------------------------");

				bst.addCaptain(Integer.parseInt(info[1]), info[2], true, 0); // call addCaptain function
			}

			if (func.equals("Is_Available")) {
				bst.isAvailable(bst.root, Integer.parseInt(info[1])); 
				System.out.println("----------------------------------------------------------------"); 
			}
			
			if (func.equals("Display_captain")) {
				bst.displayCaptain(bst.root, Integer.parseInt(info[1]));
				System.out.println("----------------------------------------------------------------"); 
			}
			
			if (func.equals("Finish")) {
				bst.finish(bst.root, Integer.parseInt(info[1]));
				System.out.println("----------------------------------------------------------------");
			}
			
			if (func.equals("Delete_captain")) {
				bst.deleteCaptain(Integer.parseInt(info[1]));
				System.out.println("----------------------------------------------------------------");
			}
			
			if (func.equals("Display_all_captains")) {
				System.out.println("----------ALL CAPTAINS----------");
				bst.printAllCaptains(bst.root);

			}
			
			if (func.equals("Quit")) {
				System.out.println("\nThank you for using CDRC, Good Bye!");
				System.exit(0); // Exit program
			}

		}

		inFile.close(); // close BufferedReader

	}

}
