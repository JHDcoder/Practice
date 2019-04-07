package DAHUASHU.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode671 {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        int smallest=root.val;
        int second=Integer.MAX_VALUE;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode tmp=q.poll();
            if(tmp.val<second&&tmp.val>smallest)
                second=tmp.val;

            if(tmp.left!=null)
                q.add(tmp.left);
            if(tmp.right!=null)
                q.add(tmp.right);
        }
        return second==Integer.MAX_VALUE?-1:second;
    }
}
