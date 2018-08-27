package Learn1;

import java.util.*;

/**
 * 二分查找法是指
 * 在一个 有序 的数组中查找一个数，每次查找将数组一分为二
 * 判断其中间字段大小
 * 判断是否为中间值，如果相等直接返回，不过不等则将数组再次拆散数组
 * 时间复杂度： O(log2n)
 *
 * 总共有n个元素，
 *
 * 渐渐跟下去就是n,n/2,n/4,....n/2^k，其中k就是循环的次数
 *
 * 由于你n/2^k取整后>=1
 *
 * 即令n/2^k=1
 *
 * 可得k=log2n,（是以2为底，n的对数）
 *
 * 所以时间复杂度可以表示O()=O(logn)
 */
public class BinarySearch {

    //欧几里得算法  2个数的最大公约数  辗转相除法
    //用较小数除以较大数 ，再用余数 去除除数 递归直至余数为0 则最后的被除数为最大公约数
    //1997 615 =>  1997 = 3x615+152   615 = 4x152 + 7   152 = 21 x 7 + 5 ......
    public static int gcd(int x, int y)
    {
        if(x==0 || y==0) {
            return 0;
        }
        if(x < y) {
            int temp =  x;
            x = y;
            y = temp;
        }
        //System.out.println(x+"\t"+y);
        int n = x%y;
        if(n == 0) {
            return y;
        }

        return gcd(y, n);
    }

    public static int gcd1(int x, int y)
    {
        if(x==0 || y==0) {
            return 0;
        }
        if(x==y) {
            return x;
        }
        if(x < y) {
            int temp =  x;
            x = y;
            y = temp;
        }
        int z = Math.abs(y-x);
        return gcd1(z,y);
    }
    //gcd(a,a)=a
    //gcd(ka,kb)=k gcd(a,b)，也就是最大公约数运算和倍乘运算可以交换。
    // 特殊地，当k=2时，说明两个偶数的最大公约数必然能被2整除。
    //当k与b互为质数，gcd(ka,b)=gcd(a,b)，也就是约掉两个数中只有其中一个含有的因子不影响最大公约数。
    // 特殊地，当k=2时，说明计算一个偶数和一个奇数的最大公约数时，可以先将偶数除以2。
    public static int stein(int a, int b)
    {
        if(a==0 || b==0) {
            return  a==0 ? b : a;
        }
        int ans=1;//储存第一步中约掉的若干个2
        int gcd;//储存最终返回的结果
        while((a&1)==0  &&  (b&1)==0)//如果ab均为偶数则用2约简
        {
            a/=2;
            b/=2;
            ans*=2;
        }
        //用这种方法有可能减少数字的位数，简化计算，可以省略。

        while(a!=b)//判断两数是否相等，也可以理解为直到所得的减数和差相等为止
            if(a>b)
                a-=b;//以较大的数减较小的数
            else
                b-=a;//以较大的数减较小的数
        gcd=a*ans; //求第一步中约掉的若干个2与第二步中等数的乘积

        return gcd;//返回gcd
    }

    public static int rank(int key, int[] a,int len)
    {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            for (int i = 0; i < len; i++) {
                System.out.printf("\t");
            }
            //System.out.println(lo+""+hi+""+(++len));
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) {
                hi = mid -1;
            }else if (key > a[mid]) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(gcd(1997, 615));
        System.out.println(gcd1(1997,615));
        System.out.println(stein(1997, 615));

        System.out.println(gcd(24, 15));
        System.out.println(gcd1(24,15));
        System.out.println(stein(24,15));
        System.exit(1);
        int[] whiteList = {44,433,1,3,45,6,324,5234,4356,345,234};
        Scanner sc = new Scanner(System.in);
//        int i=0;
//        System.out.println("请输入你的数组（长度10）");
//        while(i < 10) {
//            whiteList[i] = sc.nextInt();
//            System.out.println(i+" "+whiteList[i]);
//            i++;
//        }
        Arrays.sort(whiteList);


        System.out.println("请输入你要查找的值");
        int key = sc.nextInt();
        System.out.println(BinarySearch.rank(key, whiteList,0));
    }
}
