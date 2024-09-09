//-----------------------------------------------------
// Title: Binary Search Tree (BST) Class 
// Author: Ahmet Can Öztürk
// ID: 11146244104
// Section: 02
// Author: Elif Alptekin
// ID: 31376233198
// Section: 04
// Assignment: 3
// Description: This class contains Node class (Captains), BST attributes and constructers, 
// addCaptain(), isAvailable(), displayCaptain(), finish(), deleteCaptain(), printAllCaptains() functions. 
//-----------------------------------------------------
public class BinarySearchTree {
    
        // Attribute of BST
        public Node root;
    
    // Node class it has 6 attributes
	// We thought as nodes are captains.
	static class Node {

		public int id;
		public Node left, right;
		public String name;
		public boolean available;
		public int star;

        // Constructor of node class
		public Node(int id, String name, boolean available, int star) {

			this.id = id;
			this.left = null;
			this.right = null;
			this.name = name;
			this.available = true;
			this.star = 0;
		}
	}


    // BST Constructors
	public BinarySearchTree() {
		root = null;
	}
	public BinarySearchTree(int id, String name, boolean available, int star) {
		root = new Node(id, name, available, star);
	}
	
    //  That method calls the insertCaptain method
	public void addCaptain(int id, String name, boolean available, int star) {

		root = insertCaptain(root, id, name, available, star);
	}
    
    // The method provive to add captains on the BST.
    // Method compare captains id's, then insert into BST in the correct order.
	Node insertCaptain(Node root, int id, String name, boolean available, int star) {
		// If the tree is empty,
		// return a new node
		if (root == null) {
			root = new Node(id, name, available, star);
			return root;
		}

		// Otherwise, recur down the tree
		else if (id < root.id)
			root.left = insertCaptain(root.left, id, name, available, star);
		else if (id > root.id)
			root.right = insertCaptain(root.right, id, name, available, star);

		// Return the (unchanged) node pointer
		return root;
	}

	// These are helper function to check methods (Print)
	// Have no effect on output
	void inorder() {
		inorderRec(root);
	}
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.id + " ");
			inorderRec(root.right);
		}
	}
	
    // That method checks the availability of captains recursively.
    // The method checks the root node if is null then that means there isn't product with this id,
    // there is if statement which is checking availability is equal to 0 or not then print availability.
	public Node isAvailable(Node root, int key) {

		if (root == null) {
			System.out.println("IsAvailable: Couldn't find any captain with ID number " + key +"\n");
			return root;
		}

		if (root.id == key) {
			if (root.available == true) {
				System.out.println("IsAvailable: Reserve a new Ride with captain " + root.id +"\n");
				root.available = false;
				return root;
			} else {
				System.out
						.println("IsAvailable: The captain " + root.name + " is not available. He is on another ride!" +"\n");
				return root;
			}
		} else {
			if (root.id > key) {
				return isAvailable(root.left, key);
			} else {
				return isAvailable(root.right, key);
			}

		}

	}
    
    // Finish method provide to end captains' rides (Change their availability condition as true)
    // Also if meet the condition it will print captain's informations
    // That method working recursively.
	public Node finish(Node root, int key) {
		if (root == null) {
			System.out.println("Finish: Couldn't find any captain with ID number "+ key);
			return root;
		}
		
		if (root.id == key) {
			if (root.available == true) {
				System.out.println("Finish: The captain "+ root.name +" is not in a ride"); 
				return root;
			} else {
				root.available = true; // Change availability
				
				if(root.name.equals("Ahmet")) // Increase star condition for Ahmetsss
					root.star++;
			
			// Print captain's informations
				System.out.println("Finish: Finish ride with captain "+key);
				System.out.print("		       ID: ");
				System.out.println(root.id);
				System.out.print("		       Name: ");
				System.out.println(root.name);
				System.out.print("		       Available: ");
				System.out.println("True");						
				System.out.print("		       Rating star: ");
				System.out.println(root.star);
				return root;
			}
		} else {
			if (root.id > key) {
				return finish(root.left, key);
			} else {
				return finish(root.right, key);
			}

		}

	}
	
	// That method provide to print captain's informations with captain id parameter.
	public Node displayCaptain(Node root, int key) {

		if (root == null) {
			System.out.println("Display Captain: Couldn't find any captain with ID number " + key +"\n");
			return root;
		}

		if (root.id == key) {
			System.out.println("Display Captain:");
			System.out.print("		       ID: ");
			System.out.println(root.id);
			System.out.print("		       Name: ");
			System.out.println(root.name);
			System.out.print("		       Available: ");
			System.out.println(root.available);
			System.out.print("		       Rating star: ");
			System.out.println(root.star+"\n");
			return root;
		} else {
			if (root.id > key) {
				return displayCaptain(root.left, key);
			} else {
				return displayCaptain(root.right, key);
			}

		}

	}
	
	// That method call deleteCap()
	void deleteCaptain(int id) {
		root = deleteCap(root, id); }
	 
    
    
     //That method provide to delete captains with parameter (root node and captain's id).
     //To find the delete node, if statements compare root.id with id then find and delete it from BST.
     // A recursive method to delete an existing key in BST
    Node deleteCap(Node root, int id)
    {
        /* Base Case: If the tree is empty */
        if (root == null) {
        	System.out.println("Delete Captain: Couldn't find any captain with ID number "+id);
            return root;
        }
 
        /* Otherwise, recur down the tree */
        if (id < root.id)
            root.left = deleteCap(root.left, id);
        else if (id > root.id)
            root.right = deleteCap(root.right, id);
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
             if (root.left == null) {
        		System.out.println("Delete Captain:The captain Can left CCR");
                return root.right;}
            else if (root.right == null) {
        		System.out.println("Delete Captain:The captain Can left CCR");
                return root.left;}
 
            // Delete the inorder successor
            root.right = deleteCap(root.right, root.id);
        }
        return root;
    }
    
    
    
    public void printAllCaptains(Node root) {
    	
    	if (root == null)
			return;

    	printAllCaptains(root.left);

    	System.out.println("--CAPTAIN:");
    	System.out.print("		       ID: ");
		System.out.println(root.id);
		System.out.print("		       Name: ");
		System.out.println(root.name);
		System.out.print("		       Available: ");
		if(root.available == true) {
			System.out.println("True");
		}
		else {
			System.out.println("False");

		}
		System.out.print("		       Rating star: ");
		System.out.println(root.star);

		printAllCaptains(root.right);
    	
    }
	
}
