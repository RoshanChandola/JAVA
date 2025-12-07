import java.util.*;

class Bst {

    // Node structure
    class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    // Insert a key in the BST
    Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    // Search a key in BST
    boolean search(Node root, int key) {
        if (root == null)
            return false;
        if (root.key == key)
            return true;
        if (key < root.key)
            return search(root.left, key);
        return search(root.right, key);
    }

    // Find minimum key node
    Node findMin(Node root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    // Delete a key from BST
    Node delete(Node root, int key) {
        if (root == null)
            return null;

        if (key < root.key) {
            root.left = delete(root.left, key);
        } 
        else if (key > root.key) {
            root.right = delete(root.right, key);
        } 
        else {
            // Case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: One child
            else if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            // Case 3: Two children
            Node minNode = findMin(root.right);
            root.key = minNode.key;
            root.right = delete(root.right, minNode.key);
        }
        return root;
    }

    // Traversals
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.key + " ");
        }
    }

    // MAIN — Non-menu program
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Bst tree = new Bst();
        System.out.println("Enter the element to be inserted:\nfor exit enter -1");

        while(true)
        {
            int key=sc.nextInt();
            if(key==-1)
                break;
          tree.root = tree.insert(tree.root,key);
        }
        // Insert elements
        
       

        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root);

        System.out.println("\nPreorder Traversal:");
        tree.preorder(tree.root);

        System.out.println("\nPostorder Traversal:");
        tree.postorder(tree.root);

        // Search an element
        int keyToSearch = 4;
        System.out.println("\n\nSearching " + keyToSearch + ": " +
                           (tree.search(tree.root, keyToSearch) ? "Found" : "Not Found"));

        // Delete an element
        int keyToDelete = 10;
        System.out.println("Deleting " + keyToDelete);
        tree.root = tree.delete(tree.root, keyToDelete);

        System.out.println("Inorder after deletion:");
        tree.inorder(tree.root);
    }
}
