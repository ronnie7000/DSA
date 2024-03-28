package Trees;

public class NodeRangeBST {
    int count = 0;
    public int solve(TreeNode A, int B, int C) {
        getCount(A, B, C);
        return count;
    }

    public void getCount(TreeNode root, int min, int max){
        if(root == null)
            return;

        if(min <= root.val && root.val <= max)
            count++;

        getCount(root.left, min, max);
        getCount(root.right, min, max);
    }
}
