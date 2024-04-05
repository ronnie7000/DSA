package Trees;

import java.util.ArrayList;

public class InorderTraversal{

    static ArrayList<Integer> res = new ArrayList<>();

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        getPath(A);
        return res;
    }

    public static void getPath(TreeNode root){
        if(root == null)
            return;
        getPath(root.left);
        res.add(root.val);
        getPath(root.right);
    }
        
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        ArrayList<Integer> ans = inorderTraversal(root);
        for(int val : ans)
            System.out.println(val);
    }
}