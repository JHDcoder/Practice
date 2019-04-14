package DAHUASHU.Sort;

public class BubbleSort {
   public void bubblesort(int [] a,int n){
       if(n<=1) return;
       for(int i=0;i<n;++i){
           //提前退出冒泡循环的标志位
           boolean flag=false;
           for(int j=0;j<n-i-1;++j){
               if(a[j]>a[j+1]){//交换
                   int temp=a[j];
                   a[j]=a[j+1];
                   a[j+1]=temp;
                   flag=true;//表示有数据交换
               }
           }
           if(!flag) break;//没有数据交换，提前退出循环
       }
   }
}
