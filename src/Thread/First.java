package Thread;

import java.util.Random;

public class First{
    protected int product = 10;
    int MIN_PRODUCT = 10;
    int MAX_PRODUCT = 100;
    public static void main(String[] args) {
        First first = new First();
        Thread t1 = new ThreadRun(first);
        Thread t2 = new ThreadRun(first);
        t1.run();
        t2.run();
    }

    static class ThreadRun extends Thread{
        First first;
        ThreadRun(First first) {
            this.first = first;
        }

        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    sleep(3000);
                    int num =  (new Random()).nextInt();
                    System.out.println(num);
                    if(num%2==0) {
                        this.first.produce();
                    }else{
                        this.first.comsume();
                    }
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 生产者
     */
    public synchronized void produce()
    {
        if(this.product >= MAX_PRODUCT) {
            try{
                wait();
                System.out.println("产品已满,请稍候再生产");
            }catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        this.product ++;
        System.out.println("生产者生产"+this.product+"个产品");
        notifyAll();
    }

    /**
     * 消费者
     */
    public synchronized void comsume()
    {
        if(this.product < MIN_PRODUCT) {
            try {
                wait();
                System.out.println("缺货");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println("消费者取走了第"+this.product+"个产品");
        this.product -- ;
        notifyAll();
    }



}
