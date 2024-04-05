package Trees;

public class SumBT {
    int ans = 1;
    public int solve(TreeNode A) {
        if(A == null)
            return 1;
        getSum(A);
        return ans;
    }

    public int getSum(TreeNode root){
        //Lead Node
        if(root.left == null && root.right == null)
            return root.val;
        
        int lsum = 0;
        if(root.left != null)    
            lsum = getSum(root.left);
        
        int rsum = 0;
        if(root.right != null)
            rsum = getSum(root.right);

        if((lsum + rsum) != root.val){
            ans = 0;
        }
        return lsum + rsum + root.val;
    }
}
