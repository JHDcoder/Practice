package DAHUASHU.Sort;


//解决的问题
//1.查找第一个值等于给定值得元素
public class binarysearch1 {
    public int bsearch1(int [] a,int n,int value){
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low+((high-low)>>1);
            if(a[mid]>value){
                high=mid-1;
            }else if(a[mid]<value){
                low=mid+1;
            }else{
                /*
                 我们重点看第 11 行代码。如果 mid 等于 0，那这个元素已经是数组的第一个元素，那它
                 肯定是我们要找的；如果 mid 不等于 0，但 a[mid] 的前一个元素 a[mid-1] 不等于
                 value，那也说明 a[mid] 就是我们要找的第一个值等于给定值的元素。
                 如果经过检查之后发现 a[mid] 前面的一个元素 a[mid-1] 也等于 value，那说明此时的
                 a[mid] 肯定不是我们要查找的第一个值等于给定值的元素。那我们就更新 high=mid-1，
                 因为要找的元素肯定出现在 [low, mid-1] 之间。
                 */
                if((mid==0)||a[mid-1]!=value) return mid;
                else high=mid-1;
            }
        }
        return -1;
    }
    //2.查找最后一个值等于给定值得元素
    public int bsearch2(int [] a,int n,int value){
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid=low+((high-low)>>1);
            if(a[mid]>value){
                high=mid-1;
            }else if(a[mid]<value){
                low=mid+1;
            }else{
               if((mid==n-1)||a[mid+1]!=value) return mid;
               else low=mid+1;
            }
        }
        return -1;
    }

    //3.查找第一个大于等于等于给定值得元素
    public int bsearch3(int [] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || a[mid - 1] < value) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //4.查找最后一个小于等于给定值得元素
    public int bsearch4(int [] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high=mid-1;
            } else {
                if((mid==n-1)||a[mid+1]>value) return mid;
                else low=mid+1;
            }
        }
        return -1;
    }


}
