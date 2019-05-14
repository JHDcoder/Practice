package DAHUASHU.PriorityQueue;

import DAHUASHU.Heap.MaxHeap;
import DAHUASHU.Queue.Queue;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;
    public PriorityQueue(){
        maxHeap=new MaxHeap<>();
    }

    @Override
    public int getsize() {
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
