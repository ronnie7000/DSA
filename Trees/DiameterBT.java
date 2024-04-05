package Trees;

public class DiameterBT {
    int ans = 0;
    public int solve(TreeNode A) {
        if(A == null || (A.left == null && A.right == null))
            return ans;
        getHeight(A);
        return ans;
    }

    public int getHeight(TreeNode root){
        if(root == null)
            return -1;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        ans = Math.max(ans, lh + rh + 2);
        return Math.max(lh, rh) + 1;
    } 
}
