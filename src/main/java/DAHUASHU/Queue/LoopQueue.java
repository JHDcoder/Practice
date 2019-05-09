package DAHUASHU.Queue;

public class LoopQueue<E> implements Queue<E> {
    private E [] data;
    private int front,tail;
    private int size;

    public LoopQueue(int capacity){
        //要浪费一个存储
        data=(E[]) new Object[capacity+1];
        front=0;
        tail=0;
        size=0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length-1;
    }

    public boolean isEmpty(){
        return front==tail;
    }



    public void enqueue(E e){
        if((tail+1)%data.length==front)
            resize(getCapacity()*2);
        data[tail]=e;
        tail=(tail+1)%data.length;
        size++;
    }

    public E dequeue(){
        if(isEmpty())
            throw new IllegalArgumentException("failed");
        E ret=data[front];
        data[front]=null;
        front=(front+1)%data.length;
        size--;
        if(size==getCapacity()/4&&getCapacity()/2!=0)
            resize(getCapacity()/2);
        return ret;
    }

    private void resize(int newCapacity){
        E [] newData= (E[]) new Object[newCapacity+1];
        for(int i=0;i<size;i++)
            newData[i]=data[(i+front)%data.length];
        data=newData;
        front=0;
        tail=size;
    }

    @Override
    public int getsize() {
        return size;
    }

    @Override
    public E getFront() {
       if(isEmpty())
           throw new IllegalArgumentException("failed");
       return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Queue: size=%d,capacity=%d\n",size,getCapacity()));
        res.append("front [");
        for(int i=front;i!=tail;i=(i+1)%data.length){
            res.append(data[i]);
            if((i+1)%data.length!=tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
