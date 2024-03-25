package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class DeserializeBT {
    public TreeNode solve(ArrayList<Integer> A) {
        if (A.size() == 0)
            return null;

        int i = 1;
        Deque<TreeNode> dq = new LinkedList<>();
        TreeNode root = new TreeNode(A.get(0));
        dq.offer(root);

        while (!dq.isEmpty()) {
            TreeNode x = dq.poll();
            if (x == null)
                continue;

            int left_val = A.get(i);
            int right_val = A.get(i + 1);

            i += 2;

            if (left_val != -1)
                x.left = new TreeNode(left_val);
            else
                x.left = null;

            if (right_val != -1)
                x.right = new TreeNode(right_val);
            else
                x.right = null;

            dq.offer(x.left);
            dq.offer(x.right);
        }
        return root;
    }
}
