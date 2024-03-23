package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class RightViewBT {
    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> solve(TreeNode root) {
        if(root == null)
            return null;

        Deque<TreeNode> dq = new LinkedList<>();
        TreeNode last = root;

        dq.offer(root);

        while(!dq.isEmpty()){
            TreeNode x = dq.pollFirst();
            if(x.left != null)
                dq.offer(x.left);
            
            if(x.right != null)
                dq.offer(x.right);

            if(x == last){
                result.add(x.val);
                last = dq.peekLast();
            }
        }
        return result;
    }
}
