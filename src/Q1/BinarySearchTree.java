//-----------------------------------------------------
// Title: Binary Search Tree (BST) Class 
// Author: Ahmet Can Öztürk
// ID: 11146244104
// Section: 02
// Author: Elif Alptekin
// ID: 31376233198
// Section: 04
// Assignment: 3
// Description: This class contains Node class (Products), BST attributes and constructers, 
// insertProduct() and isAvailable() functions 
//-----------------------------------------------------
public class BinarySearchTree {
    
    // Attribute of BST
	public Node root;
	
	
	// Node class it has 5 attributes
	// We thought as nodes are products
	static class Node {

		public int id;
		public Node left, right;
		public String name;
		public int piece;

		// Constructor
		public Node(int id, String name, int piece) {
		    
			this.id = id;
			this.left = null;
			this.right = null;
			this.name = name;
			this.piece = piece;
		}
	}

    // BST Constructors
	public BinarySearchTree() {
		root = null; //
	}
	public BinarySearchTree(int id, String name, int piece) { 
		root = new Node(id, name, piece);
		}

    // That method checks the availability of products recursively.
    // The method checks the root node if is null then that means there isn't product with this id,
    // there is if statement which is checking piece is equal to 0 or not then print stock availability.
		public Node isAvailable (Node root, int key) {
			
			if(root == null) {  // Check BST is Empty or Not
				System.out.println("\nThe product is out of stock!!!");
				return root;
			}
			
			if(root.id == key) {
				if(root.piece != 0) {
					System.out.println("\nThere are "+ root.piece +" products");
					return root;
				}
				else {
					System.out.println("\nThe product is out of stock!!!");
					return root;
				}
			}
			else {
				if(root.id > key) {
						return isAvailable(root.left,key);
				}
				else {
					return isAvailable(root.right,key);
				}
			}
		}



    //  That method calls the insertProducts method
	public void addProduct(int id, String name, int piece) {
		root = insertProduct(root, id, name, piece);
	}

    // The method provive to add products on the BST.
    // Method compare product ids, then insert into BST in the correct order.
	Node insertProduct(Node root,int id, String name, int piece)
    {
        // If the tree is empty,
        // return a new node
        if (root == null) {
            root = new Node(id,name,piece);
            return root;
        }
  
        // Otherwise, recur down the tree
        else if (id < root.id)
            root.left = insertProduct(root.left, id,name,piece);
        else if (id > root.id)
            root.right = insertProduct(root.right, id,name,piece);
  
        // Return the (unchanged) node pointer
        return root;
    }
	
	// These are helper function to check methods
	// Have no effect on output
	void inorder() { inorderRec(root); }
	
	void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.id + " ");
            inorderRec(root.right);
        }
    }

}
