package Trees;

public class DeleteBST {
    public TreeNode solve(TreeNode A, int B) {
        if (A == null) return null;

        if (B < A.val) {
            A.left = solve(A.left, B);
        } else if (B > A.val) {
            A.right = solve(A.right, B);
        } else {
            if (A.left == null) {
                return A.right;
            } else if (A.right == null) {
                return A.left;
            } else {
                A.val = findMax(A.left);
                A.left = solve(A.left, A.val);
            }
        }
        return A;
    }

    private int findMax(TreeNode node) {
        while (node.right != null)
            node = node.right;
        return node.val;
    } 
}
