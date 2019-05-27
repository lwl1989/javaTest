package Thread;

public class SynchronizedObject implements  Runnable{
    static SynchronizedObject s1 = new SynchronizedObject();

    Object lock1 = new Object();
    Object lock2 = new Object();
    public static void main(String[] args) {
        SyncExc s1= new SyncExc();
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


class SyncObjLock implements Runnable {


    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")) {
            syncMethod();
        }else{
            asyncMethod();
        }
    }

    private synchronized void syncMethod()
    {
        System.out.println("我被锁了");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }

    private void asyncMethod()
    {
        System.out.println("我没被锁");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }


}


class SyncDiff implements Runnable{
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")) {
            syncMethod1();
        }else{
            syncMethod2();
        }
    }


    private synchronized void syncMethod1()
    {
        System.out.println("我被锁了，我是方法1");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }


    private synchronized void syncMethod2()
    {
        System.out.println("我被锁了,我是方法2");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}

class SyncStaticOrNo implements Runnable {
    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("Thread-0")) {
            syncMethod1();
        }else{
            syncMethod2();
        }
    }


    private synchronized void syncMethod1()
    {
        System.out.println("我被对象锁");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }


    private static synchronized void syncMethod2()
    {
        System.out.println("我是类锁");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}


class SyncExc implements Runnable{


    @Override
    public void run() {
            method1();
    }

    private synchronized void method1()
    {
        System.out.println(Thread.currentThread().getName()+"开始");
        try{
            Thread.sleep(3000);
        }catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("");
//        System.out.println("运行结束");
    }

}