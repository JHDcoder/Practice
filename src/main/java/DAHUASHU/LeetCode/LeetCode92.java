package DAHUASHU.LeetCode;

public class LeetCode92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //由于反转的可能从第一个节点开始，故用头插法，先将pre移动到m前，rear为n节点，再把pre后的逐个插入到rear后，rear后的头插法
        ListNode nhead=new ListNode(-1);
        ListNode pre=nhead;
        ListNode rear=nhead;
        nhead.next=head;
        while(m-->1)
            pre=pre.next;
        while(n-->=1)
            rear=rear.next;
        while(pre.next != rear){
            ListNode temp = pre.next;//保存一下pre的next，也就是要放到后面去的节点
            pre.next = pre.next.next;
            temp.next = rear.next;
            rear.next = temp;
        }
        return nhead.next;
    }
}
