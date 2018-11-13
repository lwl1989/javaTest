package Thread;

import java.util.Random;

public class First{
    protected static int product = 10;
    int MIN_PRODUCT = 10;
    int MAX_PRODUCT = 100;
    public static void main(String[] args) {
        First first = new First();
        Thread t1 = new ThreadRun(first, true);
        Thread t2 = new ThreadRun(first, false);
        t1.start();
        t2.start();
    }

    static class ThreadRun extends Thread{
        First first;
        boolean produce;
        ThreadRun(First first, boolean produce) {
            this.first = first;
            this.produce = produce;
        }

        @Override
        public void run() {
            super.run();
            //System.out.println(this.produce);
            while (true) {
                try {
                    sleep(1000);
                    int num =  (new Random()).nextInt();
                    //System.out.println(num);
                    if(num%2==0){
                        if (this.produce) {
                            this.first.produce();
                        } else {
                            this.first.comsume();
                        }
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
        if(First.product >= MAX_PRODUCT) {
            try{
                wait();
                System.out.println("产品已满,请稍候再生产");
            }catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        First.product ++;
        System.out.println("生产者生产"+First.product+"个产品");
        notifyAll();
    }

    /**
     * 消费者
     */
    public synchronized void comsume()
    {
        if(First.product < MIN_PRODUCT) {
            try {
                wait();
                System.out.println("缺货");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println("消费者取走了第"+First.product+"个产品");
        First.product -- ;
        notifyAll();
    }



}
