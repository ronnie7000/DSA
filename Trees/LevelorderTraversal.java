package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class LevelorderTraversal {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

    public ArrayList<ArrayList<Integer>> solve(TreeNode root) {
        if(root == null)
            return null;

        Deque<TreeNode> dq = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        TreeNode last = root;

        dq.offer(root);

        while(!dq.isEmpty()){
            TreeNode x = dq.pollFirst();
            list.add(x.val);

            if(x.left != null)
                dq.offer(x.left);
            
            if(x.right != null)
                dq.offer(x.right);

            if(x == last){
                result.add(new ArrayList<>(list));
                list.clear();
                last = dq.peekLast();
            }
        }
        return result;
    }
}
