package Trees;

import java.util.ArrayList;

public class TwoSum {
    ArrayList<Integer> list = new ArrayList<Integer>();

    public int t2Sum(TreeNode A, int B) {
        inorderTraversal(A);
        int left = 0, right = list.size() - 1;

        while(left < right){
            int x = list.get(left);
            int y = list.get(right);
            int sum = x + y;

            if(sum == B)
                return 1;
            else if(sum < B){
                left ++;
            }
            else{
                right --;
            }
        }
        return 0;
    }

    public void inorderTraversal(TreeNode root){
        if(root == null)
            return;
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }
}
