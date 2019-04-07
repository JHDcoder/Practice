package DAHUASHU.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<Double> res=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int count=q.size();
            double sum=0;
            for(int i=0;i<count;i++){
                TreeNode node=q.poll();
                sum=sum+node.val;
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(sum/count);
        }
        return res;
    }
}
