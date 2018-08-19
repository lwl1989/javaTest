package Learn1;

/**
 * 练习题
 */
public class Exercises {
    public static void main(String[] args) {
        System.out.println((0+15)/2); //7
        System.out.println(2.0e-6*100000000.1);// 200.0000002
        System.out.println(true && false || true && true); //true

        System.out.println((1+2.236)/2); // 3.236/2  => 1.618
        System.out.println(1+2+3+4.0);// 10.0
        System.out.println(4.1>=4); //true
        System.out.println(1+2+"3");//3   此时先1+2 =》 3   然后将3转为字符串和后面的字符串拼接   得到结果   33


//        int f = 0;
//        int g = 1;
//        //f2 = f0 + f1  g2 = g0 + g1 以此类推
//        for (int i = 0; i < 15; i++) {
//            f = f + g;
//            g = f - g;
//            System.out.println(f+"   "+g);
//        }

        double t = 9.0;
        while (Math.abs(t - 9.0/t) > 0.001) {
            t = (9.0/t + 5) / 2.0;
        }
        System.out.printf("%.5f\n", t);
        // 9 - 1 >
        // t = 1+5/2 => 3
        // 3-3 ! > over

        int sum = 0;
        for (int i = 1; i < 1000; i++) {
            for (int j = 0 ; j < i ; j ++) {
                sum ++;
            }
        }

        System.out.println(sum); // 1 + 2 + 3 => 999  999*(1+999)/2=499500
        //i*=2  =>  1023


        System.out.println('b'+'c');
        System.out.println((char)('a'+4));


        //将任意整数转换成二进制字符串
        int N = 100;
        String s = "";
        while (N>0) {
            s = N%2 + s;
            N = N/2;
        }
        System.out.println(s);
        int arry[][] = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
    }

    public static void swapLine(int[][] arr) {
        for (int i = 0; i < arr.length - 1; i ++) {
            //内层循环（列循环）循环的起始点 = 外层循环+1；比从j=0循环节省了循环次数，提高效率。
            //对角线不需要换 所以 j = i 是不需要交换的
            for (int j = i+1; j < arr[i].length; j++) {
                int t = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = t;
            }
        }
    }

//编写一个静态方法histogram()，接受一个整型数组a[] 和一个整数M 为参数并返回一个大小
//为M的数组，其中第i个元素的值为整数i在参数数组中出现的次数。如果a[]中的值均在0到M-1
//之间，返回数组中所有元素之和应该和a.length 相等。
    public static int[] histogram(int[] a,int M)
    {
        int[] h = new int[M];
        int N = a.length;
        for(int i=0;i<N;i++)
        {
            h[a[i]]++;
        }
        return h;
    }
}
