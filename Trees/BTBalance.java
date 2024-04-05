package Trees;

public class BTBalance {
    int balanced = 1;

    public int getHeight(TreeNode root){
        if(root == null)
            return -1;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);

        if( Math.abs(leftH - rightH) > 1 )
            balanced = 0;

        return (Math.max(leftH, rightH) + 1);
    }

    public int isBalanced(TreeNode A) {
        balanced = 1;
        getHeight(A);
        return balanced;
    }
}
