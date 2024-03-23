package Trees;

import java.util.ArrayList;
import java.util.HashMap;

public class PostorderInorderBT {
    ArrayList<Integer> inOrder = new ArrayList<>();
    ArrayList<Integer> postOrder = new ArrayList<>();
    HashMap<Integer, Integer> hm = new HashMap<>();

    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        this.inOrder = A;
        this.postOrder = B;
        int N = A.size();

        for(int i=0; i<N; i++){
            hm.put(A.get(i), i);
        }
        return build(0, N-1, N-1);
    }

    public TreeNode build(int iL, int iR, int pR){
        if(iL > iR)
            return null;
        
        TreeNode root = new TreeNode(postOrder.get(pR));
        int idx = hm.get(root.val);
        int cntR = iR - idx;
        int pM = pR - cntR;
        root.left = build(iL, idx - 1, pM - 1);
        root.right = build(idx + 1, iR, pR - 1);
        return root;
    }
}
