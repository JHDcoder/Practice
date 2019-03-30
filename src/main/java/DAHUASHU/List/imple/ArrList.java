package DAHUASHU.List.imple;

import DAHUASHU.List.List;

/*
数组实现线性表
 */
public class ArrList implements List {
    int [] array=new int[100];
    private int size=0;

    public boolean isEmpty() {
        if(size==0)
            return true;
        else
            return false;
    }

    public void init() {
        size=0;
    }

    public int size() {
        return size;
    }


    //插入到第几个位置
    public void insert(int idx, int num) {

        //如果插入位置不合理，抛出异常
        //从最后一个位置向前遍历到idx，分别将其移动向后一个位置
        //将要插入的元素填入位置i处
        //表长加1
        if(idx<1||idx>array.length)
            throw new IndexOutOfBoundsException();

        if(idx<array.length){
            for(int i=size-1;i>=idx-1;i--){
                array[i+1]=array[i];
            }
        }
        array[idx-1]=num;
        size++;
    }

    //删除第几个位置的元素
    public int delete(int idx) {
        //如果删除位置不合理，抛出异常
        //取出删除元素，从删除元素位置开始遍历到最后一个元素，分别将他们向前移动一个位置，线性表位置减一
        if(size==0)
            throw new IndexOutOfBoundsException();
        if(idx<1||idx>array.length)
            throw new IndexOutOfBoundsException();
        int element=array[idx-1];
        for(int i=idx;i<size;i++){
            array[i-1]=array[i];
        }
        size--;
        return element;
    }

    //更新第几个元素
    public void update(int idx, int num) {

        if(idx<0||idx>array.length-1)
            throw new IndexOutOfBoundsException();
        array[idx-1]=num;
    }

    public void find(int num) {
        for(int i=0;i<size;i++){
            if(array[i]==num)
                System.out.println(num+"在第"+(i+1)+"个位置");

        }
    }

    @Override
    public void print() {
        for(int i=0;i<size;i++)
            System.out.print(" "+array[i]);
    }

    public static void main(String[] args) {
        ArrList aList=new ArrList();
        aList.insert(1,11);
        aList.insert(2,22);
        aList.insert(3,33);
        aList.print();


        System.out.println();
        aList.insert(2,232);
        aList.print();


        System.out.println();
        aList.delete(2);
        aList.print();

        System.out.println();
        aList.update(1,55);
        aList.print();

        System.out.println();
        aList.find(22);
        aList.print();

    }
}
