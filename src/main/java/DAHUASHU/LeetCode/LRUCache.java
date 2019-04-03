package DAHUASHU.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    int capacity;//LRUcache容量
    Node head; // head指向最老的
    Node tail;  // tail指向的是最近使用的

    Map<Integer,Node> map=new HashMap<Integer,Node>();//map是用来记录一个键值对，对应使用的和找到这个Node

    class Node{   //Node结构
        Node pre;
        Node next;
        int key;
        int value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head=new Node(0,0);
        tail=new Node(0,0);
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        Node node=map.get(key);
        if(node!=null){  //如果找到这个值，处理这个节点的前后节点指向，并把它放到尾节点
            node.pre.next=node.next;
            node.next.pre=node.pre;
            appendAtTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        Node node=map.get(key);
        if(node!=null){    //如果node不为空,就要更新这个值，并处理这个节点的前后指向，再把它放到tail处
            node.value=value;
            map.put(key,node);
            node.pre.next=node.next;
            node.next.pre=node.pre;
            appendAtTail(node);
            return;
        }

        if(capacity==map.size()){  //如果此时缓存满了，就要去掉最老的节点，调整head指向
            Node tmp=head.next;//先把要删的搞个指针指一下
            head.next=tmp.next;
            head.next.pre=head;
            map.remove(tmp.key);
        }

        //如果缓存没满，插入新节点就放入tail所指的地方
        Node node1=new Node(key,value);
        map.put(key,node1);
        appendAtTail(node1);
    }

    private void appendAtTail(Node node){
        //首先处理node的前驱和后继，再处理后继节点的前驱和前驱节点的后继
        node.next=tail;
        node.pre=tail.pre;
        tail.pre.next=node;//前面节点的后继
        tail.pre=node;//后继节点的前驱
    }
}
