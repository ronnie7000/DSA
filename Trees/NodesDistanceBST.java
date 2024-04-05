package Trees;

public class NodesDistanceBST {
    int ans = 0;
    public int solve(TreeNode A, int B, int C) {
        if(A == null)
            return 0;

        TreeNode lca = getLCA(A, B, C);
        getDistance(lca, B);
        getDistance(lca, C);

        return ans;
    }

    public TreeNode getLCA(TreeNode root, int x, int y){
        while(root != null){
            if(root.val < x && root.val < y)
                root = root.right;
            else if(root.val > x && root.val > y)
                root = root.left;
            else
                return root;
        }
        return null;
    }

    public void getDistance(TreeNode root, int val){
        while(root != null){
            if(root.val == val)
                return;
            else if(root.val < val){
                ans++;
                root = root.right;
            }
            else{
                ans++;
                root = root.left;
            }
        }
    }
}
