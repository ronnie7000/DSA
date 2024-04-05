package Trees;

import java.util.ArrayList;

public class MorrisInorderTraversal {
    ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> solve(TreeNode A) {
        if (A == null)
            return res;
        getPath(A);
        return res;
    }

    public void getPath(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            // left is null then consume and go right
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode temp = curr.left;
                while (temp.right != null && temp.right != curr)
                    temp = temp.right;
                // Create link
                if (temp.right == null) {
                    temp.right = curr;
                    curr = curr.left;
                }
                // Delete link
                else if (temp.right == curr) {
                    temp.right = null;
                    res.add(curr.val);
                    curr = curr.right;
                }
            }
        }
    }
}