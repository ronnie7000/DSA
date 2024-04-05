package Trees;

public class NextPointerBT {
    public void connect(TreeNode root) {
        if(root == null)
            return;

        TreeNode r = root;
        while(r != null && r.left != null){
            TreeNode temp = r;
            while(r != null){
                r.left.next = r.right;
                if(r.next != null)
                    r.right.next = r.next.left;
                r = r.next;
            }
            r = temp.left;
        }
    } 
}
