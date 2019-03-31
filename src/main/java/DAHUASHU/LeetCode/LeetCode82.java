package DAHUASHU.LeetCode;
/*
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
 */
public class LeetCode82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode nhead=new ListNode(-1);
        ListNode curr=head;
        ListNode pre=nhead;
        nhead.next=head;
        while(pre!=null&&curr!=null&&curr.next!=null){
            if(curr.val==curr.next.val){
                while(curr!=null&&curr.next!=null&&curr.val==curr.next.val){
                    curr=curr.next;
                }
                pre.next=curr.next;
                curr=pre.next;

            }else{
                pre=pre.next;
                curr=curr.next;
            }
        }
        return nhead.next;
    }
}
