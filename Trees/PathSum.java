package Trees;

public class PathSum {
    public int hasPathSum(TreeNode A, int B) {
        if (A == null)
            return 0;
        if (A.left == null && A.right == null)
            if (A.val == B)
                return 1;
        int l = hasPathSum(A.left, B - A.val);
        int r = hasPathSum(A.right, B - A.val);
        if (l == 1 || r == 1)
            return 1;
        return 0;
    }
}
