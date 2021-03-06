package DAHUASHU.SegmentTree;

import java.util.HashMap;
import java.util.Map;

public class SegmentTree<E> {



    private E [] tree;
    private E [] data;
    private Merger<E> merger;
    public SegmentTree(E [] arr,Merger<E> merger){
        Map<Integer,Integer> map=new HashMap<>();

        this.merger=merger;
        data=(E [])new Object[arr.length];
        for(int i=0;i<arr.length;i++)
            data[i]=arr[i];

        tree=(E [])new Object[4*arr.length];
        buildSegmentTree(0,0,data.length-1);
    }

    //[l....r]的线段树
    private void buildSegmentTree(int treeIndex,int l,int r){
        if(l==r){
            tree[treeIndex]=data[l];
            return;
        }

        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);

        int mid=l+(r-l)/2;
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

    }


    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index<0||index>=data.length)
            throw  new IllegalArgumentException("index");
        return data[index];
    }

    private int leftChild(int index){
        return 2*index+1;
    }

    private int rightChild(int index){
        return 2*index+2;
    }

    public E query(int queryL,int queryR){
        if(queryL<0||queryL>=data.length||queryR<0||queryR>=data.length||queryL>queryR)
            throw new IllegalArgumentException("index is illegal");
        return query(0,0,data.length-1,queryL,queryR);
    }

    private E query(int treeIndex,int l,int r,int querL,int queryR){
        if(l==querL&&r==queryR){
            return tree[treeIndex];
        }

        int mid=l+(r-l)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);

        if(querL>=mid+1)
            return query(rightTreeIndex,mid+1,r,querL,queryR);
        else if(queryR<=mid)
            return query(leftTreeIndex,l,mid,querL,queryR);
        E leftresult=query(leftTreeIndex,l,mid,querL,mid);
        E rightresult=query(rightTreeIndex,mid+1,r,mid+1,queryR);
        return merger.merge(leftresult,rightresult);
    }

    public void set(int index,E e){
        if(index<0||index>=data.length)
            throw new IllegalArgumentException("index");
        data[index]=e;
        set(0,0,data.length-1,index,e);
    }

    private void set(int treeIndex,int l,int r,int index,E e){
        if(l==r){
            tree[treeIndex]=e;
            return;
        }

        int mid=l+(r-l)/2;
        int leftTreeIndex=leftChild(treeIndex);
        int rightTreeIndex=rightChild(treeIndex);

        if(index>=mid+1)
            set(rightTreeIndex,mid+1,r,index,e);
        else
            set(leftTreeIndex,l,mid,index,e);

        tree[treeIndex]=merger.merge(tree[leftTreeIndex],tree[rightTreeIndex]);

    }



    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append('[');
        for(int i=0;i<tree.length;i++){
            if(tree[i]!=null)
                res.append(tree[i]);
            else
                res.append("null");
            if(i!=tree.length-1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }


}
