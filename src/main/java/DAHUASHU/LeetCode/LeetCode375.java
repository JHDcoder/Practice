package DAHUASHU.LeetCode;

public class LeetCode375 {
    public int rob(TreeNode root) {
        if(root==null) return 0;
        return robot(root);
    }
    private int robot(TreeNode node){
        if(node==null) return 0;
        int a1=node.val;
        //取当前这个点
        if(node.left!=null)
            a1=a1+robot(node.left.left)+robot(node.left.right);
        if(node.right!=null)
            a1=a1+robot(node.right.left)+robot(node.right.right);

        //不取当前这个点
        int a2=robot(node.left)+robot(node.right);
        return Math.max(a1,a2);
    }
}
