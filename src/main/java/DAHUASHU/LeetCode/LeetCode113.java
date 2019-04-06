package DAHUASHU.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode113 {
    List<List<Integer>> ans=new ArrayList<>();

    public void robot(TreeNode node, int sum,List<Integer> res){
        if(node==null)
            return;
        if(node.left==null&&node.right==null&&sum==node.val){
            //拼答案
            res.add(node.val);
            ans.add(new ArrayList<>(res));
            res.remove(res.size()-1);
            return;
        }
        res.add(node.val);
        robot(node.left,sum-node.val,res);
        robot(node.right,sum-node.val,res);
        res.remove(res.size()-1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans.clear();
        List<Integer> l=new ArrayList<>();
        robot(root,sum,l);
        return ans;
    }
}
