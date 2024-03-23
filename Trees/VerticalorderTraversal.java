package Trees;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class VerticalorderTraversal {
    class Pair{
        TreeNode node;
        int level;

        public Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        if(root == null)
            return null;
        
        Deque<Pair> dq = new LinkedList<>();
        dq.offer(new Pair(root, 0));
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<Integer, ArrayList<Integer>>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        while(!dq.isEmpty()){
            Pair p = dq.pollFirst();
            
            min = Math.min(min, p.level);
            max = Math.max(max, p.level);

            ArrayList<Integer> list = hm.getOrDefault(p.level, new ArrayList<>());
            list.add(p.node.val);
            hm.put(p.level, list);

            if(p.node.left != null)
                dq.offer(new Pair(p.node.left, p.level - 1));
            if(p.node.right != null)
                dq.offer(new Pair(p.node.right, p.level + 1));
        }

        for(int i = min; i <= max; i++){
            result.add(hm.get(i));
        }
        return result;
    }
}
