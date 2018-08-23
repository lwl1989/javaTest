package Annotations;

public class Sys implements SysInterface{

    //Override  重写
    @Override
    public String test() {
        return "你好啊";
    }

    @Override
    public Integer test1() {
        return Integer.valueOf(3);
    }
    //忽略过期警告   接口内指定了 @Deprecated     Deprecation
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Sys sys = new Sys();

        System.out.println(sys.test1());
    }
}
