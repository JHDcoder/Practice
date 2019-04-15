package DAHUASHU.Sort;

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
