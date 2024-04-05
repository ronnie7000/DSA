package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonNodesBSTs {
    long mod = 1000000007;
    long ans = 0;    

    ArrayList<Integer> res = new ArrayList<>();
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    public int solve(TreeNode A, TreeNode B){
        if(A == null || B == null)
            return 0;

        inorderTraversal(A);
        inorderTraversal(B);

        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(val > 1)
                ans = (ans % mod + (long)key % mod) % mod;
            else    
                continue;
        }
        
        return (int) ans;
    }

    public void inorderTraversal(TreeNode root){
        if(root == null)
            return;
        inorderTraversal(root.left);
        hm.put(root.val, hm.getOrDefault(root.val, 0) + 1 );
        inorderTraversal(root.right);
    }
}
