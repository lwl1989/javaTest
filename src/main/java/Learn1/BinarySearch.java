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

    public static int rank(int key, int[] a)
    {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            System.out.println(lo+" "+hi+" "+mid);
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
        int[] whiteList = new int[10];
        Scanner sc = new Scanner(System.in);
        int i=0;
        System.out.println("请输入你的数组（长度10）");
        while(i < 10) {
            whiteList[i] = sc.nextInt();
            System.out.println(i+" "+whiteList[i]);
            i++;
        }
        Arrays.sort(whiteList);


        System.out.println("请输入你要查找的值");
        int key = sc.nextInt();
        System.out.println(BinarySearch.rank(key, whiteList));
    }
}
