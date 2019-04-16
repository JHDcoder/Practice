package JVM;

import java.util.ArrayList;
import java.util.List;

public class GCTest {
    /*
    阿里实习面试的时候被问了一道GC相关的编程题： 当时要求写出伪代码触发若干次YoungGC,
    再触发若干次FullGC，触发若干次YoungGC，最后再触发FullGC。
当时没有意识到具体要怎么做，只是谈了一下YoungGC和FullGC。后来又看到了这样一道题：
请写一段程序，让其运行时的表现为触发5次ygc，然后3次fgc，然后3次ygc，然后1次fgc，
请给出代码以及启动参数。意识到要通过设置JVM参数和写程序分配内存来触发出对应顺序的GC序列。
     */


    /*
    为了快速GC，堆的大小不宜过大，以M为单位，分配的单位最好为个数，分配起来方便。
所以堆大小设置为10M，新生代设置为2M，老年代设置为8M。
因为新生代的Eden:From Survivor:To Survivor比为8:1:1，所以大概可以分配的最大内存大小为1.8M，也就是说第一次分配1M进去，
之后进行5次1M的分配就可以触发5次YGC，并将5M内存分配担保到老年代。
然后将大对象直接在老年代分配的阈值选择为2M，只需要进行3次5M的分配就可以触发3次FGC，结束后老年代里会有5M。
然后先分配1M内存到新生代，然后再进行3次1M的分配就可以触发3次YGC，第2次YGC之后，老年代有7M被占用。
第3次1M分配比较特殊，会先引发1次YGC，然后再分配担保1M到老年代，而此时老年代已经有7M被占用，从而引发老年代FGC来清理到之前已经不存活的5M，从而为分配担保腾出空间。
     */


    /*
    堆的大小：-Xms10M -Xmx10M
    新生代大小：-Xmn2M
    大对象直接在老年代分配的阈值（2M）：-XX:PretenureSizeThreshold=2097152
     打开GC日志详情输出：-XX:+PrintGCDetails
    选择串行GC：-XX:+UseSerialGC
    注：打开串行GC是为了保证在单线程下串行GC来达到理想效果
     */

    public static void main(String[] args) {
        // 先进行一次FGC，保证空间的干净
        System.gc();

        // 引用对象，保证对象存活
        List list = new ArrayList();
        // 预先分配1M，为后面5次YGC做准备
        alloc(1,list);

        // 进行5次1M的分配，触发5次YGC和5次分配担保
        alloc(1,list);
        alloc(1,list);
        alloc(1,list);
        alloc(1,list);
        alloc(1,list);

        // 五次分配担保使得老年代有5M被占用

        // 使之前5个对象不再被引用，准备对老年代被占用空间进行回收
        list=null;

        // 进行3次5M的分配，直接分配到老年代，引发3次FGC
        byte[] bytes = new byte[1024*1024*5];
        // 分配完之后保证不存活，以便被回收掉
        bytes = null;

        bytes = new byte[1024*1024*5];
        bytes = null;

        bytes = new byte[1024*1024*5];
        bytes = null;

        // 此时老年代有5M被占用

        list = new ArrayList();
        // 预先分配1M，为后面3次YGC做准备
        alloc(1,list);

        // 进行3次1M分配，触发3次YGC和3次分配担保
        alloc(1,list);
        alloc(1,list);
        // 2次分配担保加上之前就被占用的5M 使得老年代有7M被占用

        // 第3次分配担保比较特殊，先是触发1次YGC，然后分配担保1M到老年代，之后由于老年代已经有7M，然后触发1次FGC来为分配担保腾出空间
        alloc(1,list);
    }

    // 分配 size MB的内存并用List对象引用
    private static void alloc(int size,List list){
        byte[] bytes = new byte[1024*1024*size];
        list.add(bytes);
    }
}
