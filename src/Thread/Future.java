package Thread;

//两个线程不需要要进行数据交互
//但是两个事情都干完才能干第三件事
// 思路  =》  开启多个线程 当任务完成之后

/**
 * 先上一个场景：假如你突然想做饭，但是没有厨具，也没有食材。网上购买厨具比较方便，食材去超市买更放心。

 实现分析：在快递员送厨具的期间，我们肯定不会闲着，可以去超市买食材。所以，在主线程里面另起一个子线程去网购厨具。

 但是，子线程执行的结果是要返回厨具的，而run方法是没有返回值的。所以，这才是难点，需要好好考虑一下。

 */
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Future {

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        // 第一步 网购厨具
        CommonCook.OnlineShopping thread = new CommonCook.OnlineShopping();
        thread.start();
        thread.join();  // 保证厨具送到
        // 第二步 去超市购买食材
        Thread.sleep(2000);  // 模拟购买食材时间
        CommonCook.Shicai shicai = new CommonCook.Shicai();
        System.out.println("第二步：食材到位");
        // 第三步 用厨具烹饪食材
        System.out.println("第三步：开始展现厨艺");
        CommonCook.cook(thread.chuju, shicai);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");

        Future.selfFuture();
    }

    /**
     * 这个继承体系中的核心接口是Future。Future的核心思想是：
     * 一个方法f，计算过程可能非常耗时，等待f返回，显然不明智。
     * 可以在调用f的时候，立马返回一个Future，可以通过Future这个数据结构去控制方法f的计算过程。
     * @throws Exception
     */
    public static void selfFuture() throws Exception
    {
        long startTime = System.currentTimeMillis();
        // 第一步 网购厨具
        Callable<FutureCook.Chuju> onlineShopping = new Callable<FutureCook.Chuju>() {

            @Override
            public FutureCook.Chuju call() throws Exception {
                System.out.println("第一步：下单");
                System.out.println("第一步：等待送货");
                Thread.sleep(5000);  // 模拟送货时间
                System.out.println("第一步：快递送到");
                return new FutureCook.Chuju();
            }

        };
        FutureTask<FutureCook.Chuju> task = new FutureTask<FutureCook.Chuju>(onlineShopping);
        new Thread(task).start();
        // 第二步 去超市购买食材
        Thread.sleep(2000);  // 模拟购买食材时间
        FutureCook.Shicai shicai = new FutureCook.Shicai();
        System.out.println("第二步：食材到位");
        // 第三步 用厨具烹饪食材
        if (!task.isDone()) {  // 联系快递员，询问是否到货
            System.out.println("第三步：厨具还没到，心情好就等着（心情不好就调用cancel方法取消订单）");
        }
        FutureCook.Chuju chuju = task.get();
        System.out.println("第三步：厨具到位，开始展现厨艺");
        FutureCook.cook(chuju, shicai);

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }
    static class CommonCook {



        // 网购厨具线程
        static class OnlineShopping extends Thread {

            Chuju chuju;

            @Override
            public void run() {
                System.out.println("第一步：下单");
                System.out.println("第一步：等待送货");
                try {
                    Thread.sleep(5000);  // 模拟送货时间
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第一步：快递送到");
                chuju = new Chuju();
            }

        }

        //  用厨具烹饪食材
        static void cook(Chuju chuju, Shicai shicai) {}

        // 厨具类
        static class Chuju {}

        // 食材类
        static class Shicai {}
    }


    static class FutureCook {

        //  用厨具烹饪食材
        static void cook(Chuju chuju, Shicai shicai) {}

        // 厨具类
        static class Chuju {}

        // 食材类
        static class Shicai {}

    }
}

