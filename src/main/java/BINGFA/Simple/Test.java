package BINGFA.Simple;

import java.util.concurrent.atomic.AtomicInteger;
////有三个线程ID分别是A、B、C,请用多线编程实现，在屏幕上循环打印10次ABCABC
public class Test {
    public static void main(String[] args) {
        MajusculeABC maj = new MajusculeABC();
        Thread t_a = new Thread(new Thread_ABC(maj , 'A'));
        Thread t_b = new Thread(new Thread_ABC(maj , 'B'));
        Thread t_c = new Thread(new Thread_ABC(maj , 'C'));
        t_a.start();
        t_b.start();
        t_c.start();
    }
}

class MajusculeABC {
    public AtomicInteger total = new AtomicInteger(0);
    //请补充代码
    public void printMajuscule(Character word){
        System.out.print(word);
        total.incrementAndGet();
    }

}

class Thread_ABC implements Runnable {
    //请补充代码
    private Character name;
    private  final MajusculeABC majusculeABC;

    public Thread_ABC(final MajusculeABC majusculeABC, Character name) {
        this.majusculeABC = majusculeABC;
        this.name = name;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (majusculeABC) {
                if (name.equals('A')) {
                    if (majusculeABC.total.get() % 3 != 0) {
                        try {
                            majusculeABC.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        majusculeABC.printMajuscule(name);
                        count--;
                        majusculeABC.notifyAll();
                    }
                }
                if (name.equals('B')) {
                    if (majusculeABC.total.get() % 3 != 1) {
                        try {
                            majusculeABC.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        majusculeABC.printMajuscule(name);
                        count--;
                        majusculeABC.notifyAll();
                    }
                }
                if (name.equals('C')) {
                    if (majusculeABC.total.get() % 3 != 2) {
                        try {
                            majusculeABC.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        majusculeABC.printMajuscule(name);
                        count--;
                        majusculeABC.notifyAll();
                    }
                }
            }
        }
    }
}
