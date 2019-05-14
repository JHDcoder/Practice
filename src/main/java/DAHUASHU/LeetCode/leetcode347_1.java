package DAHUASHU.LeetCode;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class leetcode347_1 {
    private class Freq implements Comparable<Freq>{
        int e,freq;

        public Freq(int e,int freq){
            this.e=e;
            this.freq=freq;
        }

        public int compareTo(Freq another){
            if(this.freq<another.freq)
                return 1;
            else if(this.freq>another.freq)
                return -1;
            else
                return 0;
        }
    }
    public class Array<E> {
        private E [] data;
        private int size;

        public Array(int capacity){
            data=(E[])new Object[capacity];
            size=0;
        }

        public Array(E [] arr){
            data=(E [])new Object[arr.length];
            for(int i=0;i<arr.length;i++)
                data[i]=arr[i];
            size=arr.length;
        }

        public Array(){
            this(10);
        }

        public int getSize(){
            return size;
        }

        public int getCapacity(){
            return data.length;
        }

        public boolean isEmpty(){
            return size==0;
        }

        public void addLast(E e){
            add(size,e);
        }

        public void addFirst(E e){
            add(0,e);
        }

        public void add(int index,E e){


            if(index<0||index>size)
                throw new IllegalArgumentException("add failed");

            if(size==data.length)
                resize(2*data.length);

            for(int i=size-1;i>=index;i--)
                data[i+1]=data[i];

            data[index]=e;
            size++;
        }

        public E get(int index){
            if(index<0||index>=size)
                throw new IllegalArgumentException("failed");
            return data[index];
        }

        public void set(int index,E e){
            if(index<0||index>=size)
                throw new IllegalArgumentException("failed");
            data[index]=e;
        }

        public boolean contains(E e){
            for(int i=0;i<size;i++){
                if(data[i].equals(e))
                    return true;
            }
            return false;
        }

        public int find(E e){
            for(int i=0;i<size;i++){
                if(data[i].equals(e))
                    return i;
            }
            return -1;
        }

        public E removeFirst(){
            return remove(0);
        }

        public E removeLast(){
            return remove(size-1);
        }

        public E remove(int index){
            if(index<0||index>=size)
                throw new IllegalArgumentException("failed");
            E ret=data[index];
            for(int i=index+1;i<size;i++){
                data[i-1]=data[i];
            }
            size--;
            data[size]=null;

            //防止复杂度震荡
            if(size==data.length/4 && data.length/2!=0)
                resize(data.length/2);
            return ret;
        }

        public void removeElement(E e){
            int index=find(e);
            if(index!=-1)
                remove(index);
        }


        @Override
        public String toString(){
            StringBuilder res=new StringBuilder();
            res.append(String.format("Array: size=%d,capacity=%d\n",size,data.length));
            res.append("[");
            for(int i=0;i<size;i++){
                res.append(data[i]);
                if(i!=size-1)
                    res.append(", ");
            }
            res.append("]");
            return res.toString();
        }


        private void resize(int newCapacity){
            E [] newData=(E[]) new Object[newCapacity];
            for(int i=0;i<size;i++)
                newData[i]=data[i];
            data=newData;
        }

        public void swap(int i,int j){
            E t=data[i];
            data[i]=data[j];
            data[j]=t;
        }

    }
    public class MaxHeap<E extends Comparable<E>> {
        private Array<E> data;

        public MaxHeap(int capacity){
            data=new Array<>(capacity);
        }

        public MaxHeap(){
            data=new Array<>();
        }

        public int size(){
            return data.getSize();
        }

        public boolean isEmpty(){
            return data.isEmpty();
        }

        private  int parent(int index){
            if(index==0)
                throw new IllegalArgumentException("index 0");
            return (index-1)/2;
        }

        private int leftChild(int index){
            return index*2+1;
        }

        private int rightChild(int index){
            return index*2+2;
        }

        public void add(E e){
            data.addLast(e);
            siftUp(data.getSize()-1);
        }

        private void siftUp(int k){
            while(k>0&&data.get(parent(k)).compareTo(data.get(k))<0){
                data.swap(parent(k),k);
                k=parent(k);
            }
        }

        public E findMax(){
            if(data.getSize()==0)
                throw new IllegalArgumentException("can not");
            return data.get(0);
        }

        public E extractMax(){
            E ret=findMax();

            data.swap(0,data.getSize()-1);
            data.removeLast();

            siftDown(0);

            return ret;
        }

        private void siftDown(int k){
            while(leftChild(k)<data.getSize()){
                int j=leftChild(k);
                if(j+1<data.getSize()&&data.get(j+1).compareTo(data.get(j))>0){
                    j=rightChild(k);
                }
                if(data.get(k).compareTo(data.get(j))>=0)
                    break;
                data.swap(k,j);
                k=j;
            }
        }

        /*
        replace 取出最大元素后，放入一个新元素
        实现：可以先extractMax,在add，两次O（logN）的操作
        实现：可以直接将堆顶元素替换以后siftDown，一次O（logN）
         */
        public E replace(E e){
            E ret=findMax();

            data.set(0,e);
            siftDown(0);
            return ret;
        }

    /*
    heapify将任意数组整理成堆的形状
     */

        public MaxHeap(E [] arr){
            data=new Array<>(arr);
            for(int i=parent(arr.length-1);i>=0;i--)
                siftDown(i);
        }


    }
    public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
        private MaxHeap<E> maxHeap;
        public PriorityQueue(){
            maxHeap=new MaxHeap<>();
        }

        @Override
        public int getSize() {
            return maxHeap.size();
        }

        @Override
        public boolean isEmpty() {
            return maxHeap.isEmpty();
        }

        @Override
        public void enqueue(E e) {
            maxHeap.add(e);
        }

        @Override
        public E dequeue() {
            return maxHeap.extractMax();
        }

        @Override
        public E getFront() {
            return maxHeap.findMax();
        }
    }
    public interface Queue<E> {
        int getSize();
        boolean isEmpty();
        void enqueue(E e);
        E dequeue();
        E getFront();
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:nums){
            if(map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }

        PriorityQueue<Freq> pq=new PriorityQueue<>();
        for(int key:map.keySet()){
            if(pq.getSize()<k)
                pq.enqueue(new Freq(key,map.get(key)));
            else if(map.get(key)>pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key,map.get(key)));
            }
        }
        LinkedList<Integer> res=new LinkedList<>();
        while(!pq.isEmpty())
            res.add(pq.dequeue().e);
        return res;
    }
}
