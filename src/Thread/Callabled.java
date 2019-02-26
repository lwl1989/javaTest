package Thread;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;



/**
 *
 （1）Callable规定的方法是call()，而Runnable规定的方法是run().
 （2）Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。
 （3）call()方法可抛出异常，而run()方法是不能抛出异常的。
 （4）运行Callable任务可拿到一个Future对象， Future表示异步计算的结果。
 它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。
 通过Future对象可了解任务执行情况，可取消任务的执行，还可获取任务执行的结果。
 Callable是类似于Runnable的接口，实现Callable接口的类和实现Runnable的类都是可被其它线程执行的任务。
 */
public class Callabled implements Callable {

    public static void main(String[] args) {
        Callabled c = new Callabled();
        FutureTask<Chuju> result = new FutureTask<Chuju>(c);
        new Thread(result).start();
        try{
            System.out.println("------------------------------------");

            Shicai sc = new Shicai();
            System.out.println("食材到手坐等厨具");
            Chuju c1 = result.get();
            System.out.println("厨具到手 天下我有");
            cook(c1,sc);

            System.out.println("------------------------------------");
        }catch (Exception e) {

        }

    }
    @Override
    public Object call() throws Exception {
        Chuju chuju = new Chuju();
        Thread.sleep(2000);  // 模拟购买食材时间
        System.out.println("厨具到手");
        return chuju;
    }

    //  用厨具烹饪食材
    static void cook(Chuju chuju, Shicai shicai) {}

    // 厨具类
    static class Chuju {}

    // 食材类
    static class Shicai {}
}
