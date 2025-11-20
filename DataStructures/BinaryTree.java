import java.util.Scanner;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class BinaryTree {
    static Scanner sc=new Scanner(System.in);
    static TreeNode create()
    {
       TreeNode root=null;
       System.out.println("enter the value");
        
         int val=sc.nextInt();
            if(val==-1)
            {
                return null;
            }
            root=new TreeNode(val);
            System.out.println("enter the left data of: "+root.value);
            root.left=create();
            System.out.println("enter the right data of:"+root.value);
            root.right=create();
            return root;
    }
    static void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.value+" ");
        inorder(root.right);
    }
    static void preorder(TreeNode root)
    {
        if(root==null)
        {
            return;
    
        }
        System.out.print(root.value+" ");
        preorder(root.left);
        preorder(root.right);
    }
    static void postorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        
        postorder(root.left);
        postorder(root.right);
         System.out.print(root.value+" ");
    }
    
    static int height(TreeNode root) {
    if (root == null) {
        return 0;
    }

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return Math.max(leftHeight, rightHeight) + 1;
}
public static void main(String[] args) {
        TreeNode root = create();
      System.out.println("Height of tree = " + height(root));
      System.out.println("the inorder of tree");
      inorder(root);
      System.out.println();
      System.out.println("the preorder of tree");
      preorder(root);
      System.out.println();
      System.out.println("the postorder of tree");
      postorder(root);

    }

    
}
