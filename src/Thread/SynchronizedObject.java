package Thread;

public class SynchronizedObject implements  Runnable{
    static SynchronizedObject s1 = new SynchronizedObject();

    Object lock1 = new Object();
    Object lock2 = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(s1);
        Thread t2 = new Thread(s1);
        t1.start();
        t2.start();


    }

    @Override
    public void run() {
        //对象锁是可以同时进行的
        //t0 lock1 锁 -》 t0 释放 lock1 -> t0 lock2 and  t1 lock1
        String tName =Thread.currentThread().getName();
        synchronized (lock1) {
            System.out.println(tName+"lock 1对象锁代码块模式锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name:" + tName);
        }
        synchronized (lock2) {
            System.out.println(tName+"lock 2对象锁代码块模式锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name:" + Thread.currentThread().getName());
        }
//
//        synchronized (this) {  //代码块模式锁：多线程异步互斥
//            System.out.println("代码块模式锁");
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println("Thread name:" + Thread.currentThread().getName());
//        }
//    }
    }
}
