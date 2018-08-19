package Learn1;

public class Test {
    public static void main(String[] args) {
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
}
