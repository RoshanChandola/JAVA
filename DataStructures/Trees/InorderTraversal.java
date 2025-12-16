import java.util.*;
class BinaryTree {
    static Scanner sc=new Scanner(System.in);
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    static TreeNode create() {
        TreeNode root = null;
        System.out.println("Enter node value (-1 for null): ");
        int val=sc.nextInt();
        if(val == -1) {
            return null;
        }
        root =new TreeNode(val);
        System.out.println("Enter left child of " + val);
        root.left = create();
        System.out.println("Enter right child of " + val);
        root.right = create();
        return root;       
    }
}
class InorderTraversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) 
            return result;
        inorderTraversal(root.left);    
        result.add(root.val);           
        inorderTraversal(root.right);  
        return result;
    }
}
