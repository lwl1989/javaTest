package Thread;

public class Join
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread t = new Thread(new Runnable() {
            public void run()
            {
                System.out.println("First task started");
                System.out.println("Sleeping for 2 seconds");
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.out.println("First task completed");
            }
        });
        Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                System.out.println("Second task completed");
            }
        });
        t.start();
        t.join();
        t1.start();
        t1.join();
        //去掉join 将会先结束主线程
        System.out.println("over");
    }
}