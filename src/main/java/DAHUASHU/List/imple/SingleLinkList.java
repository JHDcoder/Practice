package DAHUASHU.List.imple;

import DAHUASHU.List.List;

import java.util.Stack;

//没有检验过是否每个函写的正确
public class SingleLinkList implements List {
    private Node head;
    private int size;
    @Override
    public void init() {
        this.head=null;
        this.size=0;
    }
    @Override
    public boolean isEmpty() {
        if(size==0)
            return true;
        else
            return false;
    }
    @Override
    public int size() {return size;}

    @Override
    //在位置为idx后面插入节点,节点从1开始
    public void insert(int idx, int num) {
        Node node=new Node(num);
        if(idx==1){
            intsertAthead(num);
            size++;
        }
        if(idx==size){
           insertAtLast(num);
           size++;
        }

        if(idx<1||idx>size)
            return;

        if(head==null)
            head.next=node;
        else {
            //此为idx>1&&<size
            int pos=1;
            Node curr=head;
            while(pos!=idx){
                curr=curr.next;
                pos++;
            }
            node.next=curr.next;
            curr.next=node;
            size++;
        }
    }

    public void intsertAthead(int num){
        Node node=new Node(num);
        size++;
        if(head==null)
            head.next=node;
        else{
            Node next=head.next;
            head.next=node;
            node.next=next;
        }
    }


    public void insertAtLast(int num){
        Node node =new Node(num);
        size++;
        if(head==null)
            head.next=node;
        else {
            Node curr=head;
            while(curr!=null){
                curr=curr.next;
            }
            curr.next=node;
        }
    }

    @Override
    public int delete(int idx) {
        return 0;
    }
    //删除位置为idx的节点
    public void deleteByindex(int idx){
        Node pre=null;
        Node curr=head;
        if(head==null)
            return;
        if(idx==1){
            head.next=null;
        }
        if(idx==size){
            int pos=1;
            while (pos!=size){
                pre=curr;
                curr=curr.next;
                pos++;
            }
            pre.next=null;
            size--;
        }
        else {
            int pos=1;
            while (pos!=size){
                pre=curr;
                curr=curr.next;
                pos++;
            }
            pre.next=curr.next;
            size--;
        }
    }

    public void update(int idx, int num) {
        if(idx<1||idx>size)
            return;
        if(idx==1)
            head.next.data=num;
        if(idx==size){
            int pos=1;
            Node curr=head;
            while (pos!=idx){
                curr=curr.next;
                pos++;
            }
        }

    }
    @Override
    public void find(int num) {}

    public boolean find1(int num){
        Node curr=head;
        if(curr==null)
            return false;
        while (curr.next!=null){
            if(curr.data==num)
                return true ;
            curr=curr.next;
        }
        return false;
    }

    @Override
    public void print() {
    }

    public void print(Node node){
        if(node!=null)
            System.out.println(node.data);
    }
    //反转单链表
    public Node reverse(Node head){

        if(head==null)
            return head;
        Node curr=head;
        Node pre=null;
        while (curr!=null){
            Node next=curr.next;
            curr.next=pre;
            pre=curr;
            curr=next;
        }
        return pre;
    }


    //反向输出单链表所有值..递归方法
    public void reverseOutput(Node head){
        if(head==null)
            return;
        Node curr=head;
        if(curr.next==null){
            System.out.println(curr.data);
        }
        reverse(curr.next);
    }
    //反向输出单链表所有值，用栈结构实现
    public void reverseOutput1(Node head){
        if(head==null)
            return;
        Node curr=head;
        Stack<Integer> s=new Stack<Integer>();
        if(curr!=null){
            s.push(curr.data);
        }
        while(s.size()!=0){
            System.out.println(s.pop());
        }
    }

}
