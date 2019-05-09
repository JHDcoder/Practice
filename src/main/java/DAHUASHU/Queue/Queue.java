package DAHUASHU.Queue;

public interface Queue<E> {
    int getsize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
