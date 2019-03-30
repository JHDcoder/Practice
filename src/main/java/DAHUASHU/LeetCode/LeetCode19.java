package DAHUASHU.LeetCode;
/*
删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode nhead=new ListNode(-1);//删除链表用头插法比较好，避免空指针
        nhead.next=head;
        int count=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            count++;
        }
        ListNode curr1=nhead;
        int s=count-n;
        while(s>0){
            curr1=curr1.next;
            s--;
        }
        curr1.next=curr1.next.next;
        return nhead.next;
    }
}
