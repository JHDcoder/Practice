package DAHUASHU.LeetCode;

public class LeetCode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        if(isleaf(root.left)) return root.left.val+sumOfLeftLeaves(root.right);
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right);
    }

    private boolean isleaf(TreeNode node){
        if(node==null) return false;
        return node.left==null&&node.right==null;
    }
}
