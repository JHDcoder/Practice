package DAHUASHU.Sort;
//主要有插入和删除堆顶元素
public class Heap {
    private int [] a;//数组，下标从1开始存储
    private int n;//堆可以存储的最大数据个数
    private int count;//堆中已存储的数据个数

    public Heap(int capacity){
        a=new int[capacity+1];
        n=capacity;
        count=0;
    }

    public void insert(int data){
        if(count>=n) return; //堆满了
        ++count;
        a[count]=data;
        int i=count;
        while(i/2>0&&a[i]>a[i/2]){   //自下而上堆化
            swap(a,i,i/2);  //swap()交换
            i=i/2;
        }
    }

    public void removeMax(){
        if(count==0) return;
        a[1]=a[count];
        --count;
        heapify(a,count,1);
    }

    public  void buildHeap(int [] a,int n){
        for(int i=n/2;i>=1;i--){
            heapify(a,n,i);
        }
    }

    private void heapify(int [] a,int n,int i){//自上往下的堆化
        while (true){
            int maxPos=i;
            if(2*i<=n&&a[i]<a[i*2]) maxPos=i*2;
            if(2*i+1<=n&&a[maxPos]<a[i*2]) maxPos=i*2+1;
            if(maxPos==i) break;
            swap(a,i,maxPos);
            i=maxPos;
        }

    }


    private static void swap(int [] a,int m,int n){
        int temp=a[m];
        a[m]=a[n];
        a[n]=temp;
    }


}
