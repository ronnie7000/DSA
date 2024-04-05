package Trees;

import java.util.ArrayList;
import java.util.Stack;

public class ZigzagTraversal {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return null;

        ArrayList<Integer> list;
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        TreeNode x;

        st1.push(root);

        while (!st1.isEmpty() || !st2.isEmpty()) {

            list = new ArrayList<>();

            while (!st1.isEmpty()) {
                x = st1.pop();
                list.add(x.val);

                if (x.left != null) {
                    st2.push(x.left);
                }
                if (x.right != null) {
                    st2.push(x.right);
                }
            }
            if (list.size() != 0)
                result.add(list);

            list = new ArrayList<>();

            while (!st2.isEmpty()) {
                x = st2.pop();
                list.add(x.val);

                if (x.right != null) {
                    st1.push(x.right);
                }
                if (x.left != null) {
                    st1.push(x.left);
                }
            }
            if (list.size() != 0)
                result.add(list);
        }
        return result;
    }
}