package DAHUASHU.LeetCode;
/*
删除链表中等于给定值 val 的所有节点。

示例:

输入: 1->2->6->3->4->5->6, val = 6
输出: 1->2->3->4->5
 */
public class LeetCode203 {
    public ListNode removeElements(ListNode head, int val) {
       if(head==null)
           return null;
       ListNode res=removeElements(head.next,val);
       if(head.val==val){
           return res;
       }else{
           head.next=res;
           return head;
       }
    }
}
