package Trees;

public class EqualPartition {
    int ans = 0;
    long total = 0;

    public int solve(TreeNode A) {
        if (A == null)
            return 0;
    
        total = getSum(A);
        if (total % 2 == 1)
            return 0;

        traverse(A);
        return ans;
    }

    public long getSum(TreeNode root) {
        if (root == null)
            return (long) 0;
        return (long) root.val + getSum(root.left) + getSum(root.right);
    }

    public long traverse(TreeNode root) {
        if (root == null)
            return (long) 0;

        long l = traverse(root.left);
        long r = traverse(root.right);
        long currTotal = l + r + (long) root.val;

        if (currTotal == (long) (total / 2))
            ans = 1;
        return currTotal;
    }
}
