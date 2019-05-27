package Thread;

public class SynchronizedObjectAction{
    static MissRequestNumAsync m1 = new MissRequestNumAsync();

    static SyncObjArea a1 = new SyncObjArea();
    static SyncObjMethod m5 = new SyncObjMethod();

    public static void main(String[] args) {
        System.out.println("锁的运用");
        System.out.println("能够保证同一时刻，最多只有一个线程执行该段代码，以达到并发安全的效果");
        System.out.println("主要用于同时刻对线程间对任务进行锁");


        System.out.println("synchronized是JAVA的原生关键字，是JAVA中最基本的互斥手段");
        System.out.println("是并发编程中的元老角色");

        System.out.println("不使用并发的后果");

        //消失的请求数
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m1);
        t1.start();
        t2.start();


        MissRequestSync m2 = new MissRequestSync();
        MissRequestSync m3 = new MissRequestSync();
        m2.run();
        m3.run();

        //查看结果
        //如果不上锁，会导致线程不安全（结果会不符合预期）
        System.out.println(MissRequestNumAsync.i);
        System.out.println(MissRequestSync.i);

        System.out.println("锁的分类");
        System.out.println("对象锁 和 类锁");

        System.out.println("对象锁： 1. 方法锁(this) 2.同步代码块锁");
        System.out.println("类锁：   1.静态锁  2.class对象");

        Thread t3 = new Thread(a1);
        Thread t4 = new Thread(a1);
        t3.start();
        t4.start();

        while (t3.isAlive() || t4.isAlive()) {

        }
        System.out.println("同步代码块线程执行完毕");

        Thread t5 = new Thread(m5);
        Thread t6 = new Thread(m5);
        t5.start();
        t6.start();

        while (t5.isAlive() || t6.isAlive()) {

        }
        System.out.println("方法锁形式 默认就是this 线程执行完毕");


        Thread t7 = new Thread(new SyncClassStatic());
        Thread t8 = new Thread(new SyncClassStatic());
        t7.start();
        t8.start();

        while (t7.isAlive() || t8.isAlive()) {

        }
        System.out.println("类锁，静态锁运行完毕");



        Thread t9 = new Thread(new SyncClassObj());
        Thread t10 = new Thread(new SyncClassObj());
        t9.start();
        t10.start();

        while (t9.isAlive() || t10.isAlive()) {

        }
        System.out.println("类锁，class对象运行完毕");
    }



}

class MissRequestNumAsync implements Runnable {
    static public int i = 0;
    @Override
    public void run() {
        for (int j = 0; j < 100000; j ++) {
            i++;
        }
    }
}


class MissRequestSync{
    static public int i = 0;
    public void run() {
        for (int j = 0; j < 100000; j ++) {
            i++;
        }
    }
}

//代码块锁
//劣势：太多锁会增加业务复杂度
//解决方式： 成熟的工具类
//调试：  thread.getStats();
class SyncObjArea implements Runnable{
    static public int i = 0;
    Object sleepLock1 = new Object();
    Object sleepLock2 = new Object();
    @Override
    public void run() {
        //这里有抢占机制
        synchronized (sleepLock1) {
            System.out.println("我是同步代码块锁1");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
        //这里有抢占机制
        synchronized (sleepLock2) {
            System.out.println("我是同步代码块锁2");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }
}

//方法锁
class SyncObjMethod implements Runnable {
    static public int i = 0;
    @Override
    public void run() {
      method();
    }

    public synchronized void method(){
        System.out.println("我是方法锁");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}


//类锁
//!!!! java类有很多对象 ，但是只有一个class对象 !!!!
//所以，类锁，就是针对当前类的Class对象的锁
//整个系统全局同步用类锁
//局部锁用对象锁
//对比下，则为  mysql 表锁和行锁一样  （锁的颗粒度，性能）
//类锁同一时刻只能被一个对象获取
//实现方式1  synchronized放在static方法上(静态锁)
//实现方式2：synchronized放在class对象上

//静态锁

class SyncClassStatic implements Runnable {
    @Override
    public void run() {
        method();
    }

    public static synchronized void method() {
        System.out.println("我是类锁中静态锁");
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"运行结束");
    }
}



//class对象锁
class SyncClassObj implements Runnable{
    @Override
    public void run() {
        method();
    }

    private void method(){
        synchronized (SyncClassObj.class) {
            System.out.println("我是类锁中class对象锁");
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"运行结束");
        }
    }
}