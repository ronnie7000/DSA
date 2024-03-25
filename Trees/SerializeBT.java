package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeBT {
    ArrayList<Integer> result = new ArrayList<Integer>();

    public ArrayList<Integer> solve(TreeNode root) {
        if (root == null)
            return null;

        Deque<TreeNode> dq = new LinkedList<>();
        dq.offer(root);

        while (!dq.isEmpty()) {
            TreeNode x = dq.pollFirst();

            if (x == null) {
                result.add(-1);
            } else {
                result.add(x.val);

                if (x.left != null)
                    dq.offer(x.left);
                else {
                    TreeNode newObj = null;
                    dq.offer(newObj);
                }
                if (x.right != null)
                    dq.offer(x.right);
                else {
                    TreeNode newObj = null;
                    dq.offer(newObj);
                }
            }
        }
        return result;
    }
}
