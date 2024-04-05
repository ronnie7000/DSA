package Trees;

public class InvertBT {
    public TreeNode invertTree(TreeNode A) {
        solve(A);
        return A;
    }

    public void solve(TreeNode root){
        if(root == null)    
            return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        solve(root.left);
        solve(root.right);
    }
}
