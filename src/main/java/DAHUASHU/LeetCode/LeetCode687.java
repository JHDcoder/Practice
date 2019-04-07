package DAHUASHU.LeetCode;

public class LeetCode687 {
    int path=0;
    public int longestUnivaluePath(TreeNode root) {
        count(root);
        return path;
    }
    private int count(TreeNode root){
        if(root==null) return 0;

        int left=count(root.left);
        int right=count(root.right);
        int leftpath,rightpath;
        if(root.left!=null && root.val==root.left.val)
            leftpath=left+1;
        else
            leftpath=0;

        if(root.right!=null&&root.val==root.right.val)
            rightpath=right+1;
        else
            rightpath=0;
        path=Math.max(path,leftpath+rightpath);

        return Math.max(leftpath,rightpath);



    }
}
