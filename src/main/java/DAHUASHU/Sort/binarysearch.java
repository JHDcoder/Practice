package DAHUASHU.Sort;
/*
二分查找只能用在插入、删除操作不频繁，一次排序多次查找的场景中。针对动态
变化的数据集合，二分查找将不再适用。

1. 如何编程实现“求一个数的平方根”？要求精确到小数点后 6 位。
2. 我刚才说了，如果数据使用链表存储，二分查找的时间复杂就会变得很高，那查找的时
间复杂度究竟是多少呢？如果你自己推导一下，你就会深刻地认识到，为何我们会选择
用数组而不是链表来实现二分查找了。

 */
public class binarysearch {
    //二分查找的非递归写法
    public int bsearch(int [] a,int n,int value){
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low+((high-low)>>1);
            if(a[mid]==value){
                return mid;
            }else if(a[mid]<value){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    //二分查找的递归写法
    public int brsearch(int [] a,int n,int value){
        return bsearchInternally(a,0,n-1,value);
    }
    private int bsearchInternally(int [] a,int low,int high,int value){
        if(low>high) return -1;

        int mid=low+((high-low)>>1);
        if(a[mid]==value){
            return mid;
        }else if(a[mid]<value){
            return bsearchInternally(a,mid+1,high,value);
        }else {
            return bsearchInternally(a,low,high-1,value);
        }
    }
}
