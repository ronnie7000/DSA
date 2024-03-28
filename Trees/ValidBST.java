package Trees;

public class ValidBST {
    public int isValidBST(TreeNode A) {
        boolean ans = check(A, Long.MIN_VALUE, Long.MAX_VALUE);
        if(ans)
            return 1;
        return 0;
    }

    public boolean check(TreeNode root, long min, long max){
        if(root == null)
            return true;
        long val = (long)root.val;

        if(val < min || val >= max)
            return false;
        boolean l = check(root.left, min, val);
        boolean r = check(root.right, val, max);
        return l && r;
    }
}
