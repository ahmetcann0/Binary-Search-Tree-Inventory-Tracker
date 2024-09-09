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

	public static void main(String[] args) throws NumberFormatException, IOException {
   
        //Taking text file name with scanner
        Scanner keyboard = new Scanner(System.in);
        String file = keyboard.nextLine();
        
        // Creating BST object
		BinarySearchTree bst = new BinarySearchTree();

		System.out.println("--------------- WELCOME TO ITS SYSTEM ---------------");
		
		
		
		// We read a text file with BufferedReader and created an array that holds 
		// the text file's elements separately. The while loop's if statements supply 
		// the necessary parameters to the called functions.
        
		String nextLine = "";
		String[] info;
		String func ;

		BufferedReader inFile = new BufferedReader(new FileReader(file));
		while ((nextLine = inFile.readLine()) != null) {

			info = nextLine.trim().split("\\s+"); // Splitting string on multiple spaces 
				func = info[0];

			if (func.equals("Add_product")) {

				System.out.println("Create Product:\n" + "");
			    System.out.print("		       ID: ");
				System.out.println(info[1]);
			    System.out.print("		       Name: ");
				System.out.println(info[2]);
			    System.out.print("		       Piece: ");
				System.out.println(info[3]);

				bst.addProduct(Integer.parseInt(info[1]), info[2], Integer.parseInt(info[3])); // called addProduct function
			}

			if (func.equals("Is_Available")) {
			    
				bst.isAvailable(bst.root,Integer.parseInt(info[1])); // called isAvailable function
				
			}
			
			if (func.equals("Quit")) {
				System.out.println("\nThank you for using ITS, Good Bye!"); 
				System.exit(0); // Exit program
				}

		}

			inFile.close(); // close BufferedReader
			
			//bst.inorder();// print binary tree (L-V-R)

	}

}
