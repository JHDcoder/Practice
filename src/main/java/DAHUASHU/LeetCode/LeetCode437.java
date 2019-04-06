package DAHUASHU.LeetCode;




public class LeetCode437 {
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        return pathSum(root.left,sum)+pathSum(root.right,sum)+oneRootpathSum(root,sum);
    }
    private int oneRootpathSum(TreeNode node,int sum){
        if(node==null)
            return 0;
        sum=sum-node.val;
        return (sum == 0 ? 1 : 0) + oneRootpathSum(node.left, sum) + oneRootpathSum(node.right, sum);

    }
}
