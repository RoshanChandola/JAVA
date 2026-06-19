package AdvDS.BinaryTree;
import java.util.Scanner;

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
    }
}

public class BinaryTree {
    Node root;

    // Build tree using -1 as null marker
    public Node buildTree(Scanner sc) {
        System.out.print("Enter node value (-1 for null): ");
        int val = sc.nextInt();

        if (val == -1) return null;

        Node node = new Node(val);
        System.out.println("Enter left child of " + val);
        node.left = buildTree(sc);

        System.out.println("Enter right child of " + val);
        node.right = buildTree(sc);

        return node;
    }

    // Display tree with indentation
    public void display(Node node, String indent) {
        if (node == null) return;
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

        System.out.println("Build your tree:");
        tree.root = tree.buildTree(sc);

        System.out.println("\nTree Structure:");
        tree.display(tree.root, "");
    }
}
