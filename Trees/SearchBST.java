package Trees;

public class SearchBST {
    public int solve(TreeNode A, int B) {
        if(A == null)
            return 0;
        TreeNode temp = A;
        while(temp != null){
            if(temp.val == B)
                return 1;
            if(temp.val < B)
                temp = temp.right;
            else
                temp = temp.left;
        }
        return 0;
    }
}
