package Thread;


public class RunnableTest implements Runnable{

    protected String string;
    public RunnableTest(String string) {
        this.string = string;
    }
    public static void main(String[] args) {
                RunnableTest r1 = new RunnableTest("1111");
                Runnable r2 = new RunnableTest("2222");
                Thread t1 = new Thread(r1);
                t1.start();
                Thread t2 = new Thread(r2);
                t2.start();


    }

    /**
     * run方法异常有限定
     * 必须在里面捕获
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                Thread t3 = Thread.currentThread();
                System.out.println(t3.getName());
                System.out.println("run"+this.toString());
            }catch (Exception e) {

            }
        }
    }

    @Override
    public String toString() {
        return string;
    }
}
