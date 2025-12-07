import java.util.*;
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
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
