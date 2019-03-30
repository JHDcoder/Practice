package DAHUASHU.List.imple;

import DAHUASHU.List.List;

/*
public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next=null;
    }
}
 */

//用rear表示指向最后节点的尾指针
public class recycleLinkList implements List {
    public   Node head;
    public   Node rear;//尾指针，循环链表的尾节点的next指向头节点,
    // 单链表循环判断是next为空，而循环链表为next不等于头结点
    private  int size;//循环链表大小
    @Override
    public void init() {
        this.head=null;
        this.rear=null;
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
    public int size() {
        return size;
    }

    @Override
    //在位置为idx后面插入节点,节点从1开始
    public void insert(int idx, int num) {
        Node node =new Node(num);
        size++;
        if(head==null){
            head.next=node;
            rear=head.next;//尾指针
        }
        //如果插入的为头位置
        if(idx==1){
            Node next=head.next;
            head.next=node;
            node.next=next;
        }
        //如果插入到末尾，改变尾指针指向


    }

    @Override
    public int delete(int idx) {
        return 0;
    }

    @Override
    public void update(int idx, int num) {

    }

    @Override
    public void find(int num) {

    }

    @Override
    public void print() {

    }
}
