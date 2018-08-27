package Learn1;

public class Test {
    public static void main(String[] args) {

        System.out.println(Exp(6));
        System.out.println(mystery(2,25));
        System.out.println(mystery(3,11));
        System.out.println("hello world");
        // n == INT_MIN and INT_MAX == 2147483647
        // 2147483648  in 32bit machine   MAX is 2147483647
        // 2147483647 + 1 = 2147483648  => -2147483648
        System.out.println(Math.abs(-2147483648));

        int x = 3;

        System.out.println(x<3.1);
        System.out.println(3.1>x);


        System.out.println(14%-3);
        System.out.println(-14%3);
    }

    public static String Exp(int x) {
        if(x<=0) return "";
        return Exp(x-3)+x+Exp(x-2)+x;
    }

    public static int mystery(int a, int b)
    {
        System.out.println(a+""+b);
        if(b==0) return 0;
        if(b%2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }
}
