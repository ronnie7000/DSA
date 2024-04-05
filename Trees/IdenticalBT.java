package Trees;

public class IdenticalBT {
    int ans = 1;

    public int isSameTree(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return 1;
        checkEqual(A, B);
        return ans;
    }

    public void checkEqual(TreeNode A, TreeNode B) {
        if (A == null && B == null)
            return;

        if (A == null || B == null) {
            ans = 0;
            return;
        }
        if (A.val == B.val) {
            checkEqual(A.left, B.left);
            checkEqual(A.right, B.right);
        } else {
            ans = 0;
            return;
        }
    }
}
