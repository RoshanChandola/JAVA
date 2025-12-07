import java.util.Scanner;
class Node{
    int val;
    Node left,right;
    Node(int item)
    {
        val=item;
        left=right=null;
    }
}
class BinaryTree{
    static Scanner sc=new Scanner(System.in);
    static Node create()
    {
         Node root=null;
         System.out.println("enter the value");
         int val=sc.nextInt();
         if(val==-1)
         {
             return null;
         }
         root=new Node(val);
            System.out.println("enter the left data of: "+root.val);
            root.left=create();
            System.out.println("enter the right data of:"+root.val);
            root.right=create();
            return root ;   
    }
    static void inorder(Node root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root=create();
        System.out.println("inorder traversal:");
        inorder(root);
    }
}