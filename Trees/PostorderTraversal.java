package Trees;

import java.util.ArrayList;

public class PostorderTraversal{

    static ArrayList<Integer> res = new ArrayList<>();

    public static ArrayList<Integer> postorderTraversal(TreeNode A) {
        getPath(A);
        return res;
    }

    public static void getPath(TreeNode root){
        if(root == null)
            return;
        getPath(root.left);
        getPath(root.right);
        res.add(root.val);
    }
        
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        ArrayList<Integer> ans = postorderTraversal(root);
        for(int val : ans)
            System.out.println(val);
    }
}