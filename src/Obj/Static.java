package Obj;


public class Static {
    static{
        //相当于可以做一堆初始化的事情
        S2 s2 = new S2();
        s2.instance = "789";
       //String ff = "222";
    }
    //static修饰符的特点：
    //
    //1.属于类不属于对象，随着所在类的加载而加载（当JVM把字节码加载进JVM的时候，static修饰的成员已经在内存中存在了）
    //2.优先于对象存在（对象是手动通过new创建出来的）
    //3.static修饰的成员被该类型的所有对象共享（根据该类创建处理的任何对象，都可以访问static成员）
    //
    //4.直接使用类名访问static成员，也可以用对象访问
    //（表面上可以通过对象去访问static，编译后本质还是永类名访问的，和对象没有任何关系。）
    public static String instance = "";

    public static String getInstance() {
        return instance;
    }


    public static void main(String[] args) {
        Static.instance = "123";
        System.out.println(Static.instance);

        Static s = new Static();
        s.instance = "457";

        System.out.println(s.instance);
        System.out.println(Static.instance);

        Static s1 = new Static();

        System.out.println(s1.instance);


        S2 s2 = new S2();

        System.out.println(s2.instance);
        System.out.println(s1.instance);
    }

}

