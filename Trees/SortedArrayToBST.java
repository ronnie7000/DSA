package Trees;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(final int[] A) {
        int n = A.length;
        return buildTree(A, 0, n-1);
    }

    public TreeNode buildTree(int[] A, int left, int right){
        if(left > right)
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = buildTree(A, left, mid - 1);
        root.right = buildTree(A, mid + 1, right);
        return root;
    }
}
