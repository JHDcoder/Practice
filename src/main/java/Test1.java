//阿里在线测试
public class Test1 {
    public static void main(String[] args) {
        Thread t1=new Thread(new thread("A"));
        Thread t2=new Thread(new thread("B"));
        Thread t3=new Thread(new thread("C"));
        t1.start();
        t2.start();
        t3.start();
    }
}

class thread implements Runnable{
    private String name;
    static int n=1;
    public thread(String name){
        this.name=name;
    }

    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(n>100)
                    break;

                if(name.equals('A')){
                    if(n%3==1){
                        System.out.println("此时的线程名字为"+name+n);
                        n++;
                    }
                }

                if(name.equals('B')){
                    if(n%3==2){
                        System.out.println("此时的线程名字为"+name+n);
                        n++;
                    }
                }

                if(name.equals('C')){
                    if(n%3==0){
                        System.out.println("此时的线程名字为"+name+n);
                        n++;
                    }
                }
            }
        }
    }
}


