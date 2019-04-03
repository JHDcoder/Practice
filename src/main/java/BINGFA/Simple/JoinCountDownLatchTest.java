package BINGFA.Simple;

//countDownLatch允许一个或多个线程等待其他线程完成操作
public class JoinCountDownLatchTest {
    public static void main(String[] args) throws InterruptedException{
        Thread paser1=new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread paser2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 finish");
            }
        });

        paser1.start();
        paser2.start();
        paser1.join();
        paser2.join();
        System.out.println("all parser finish");
    }

}
