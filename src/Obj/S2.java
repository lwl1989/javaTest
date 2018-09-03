package Obj;

class S2 extends Static{

    public static String instance = "456";
    //1.静态方法的调用不是通过实例对象进行的，所以它没有this指针。
    //2.子类不能重写父类的静态方法，可声明与父类静态方法相同的方法将父类静态方法覆盖。
    public static String getInstance() {
        return instance;
    }
}
