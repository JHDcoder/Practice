package DAHUASHU.LeetCode;

public class LeetCode101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null&&root.right==null) return true;
        return isSame(root,root);
    }
    private boolean isSame(TreeNode node1,TreeNode node2){
        if(node1==null&&node2==null)
            return true;
        if(node1==null||node2==null)
            return false;
        if(node1.val==node2.val)
            return isSame(node1.left,node2.right)&&isSame(node1.right,node2.left);
        return false;
    }
}
