package Algorithm.BagHeapStack;


import Std.StdIn;
import Std.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag {
    public static void main(String[] args) {
        int[] v = {9,3,2,1,5,6};
        int[] w = {3,5,1,7,9,2};

        int cap = 20;

        int[][] vw = new int[w.length][cap];

        for(int i = 0; i < w.length; i++) {
            for(int j=0;j < cap; j++) {
                if(j<w[i]) {
                    if(i == 0) {
                        vw[i][j] = 0;
                    }else{
                        vw[i][j] = vw[i-1][j];
                    }
                }else{
                    if(i == 0) {
                        vw[i][j] = w[i];
                    }else{
                        //比较价值  假定取消上次装载，并且加上 本次装载物品的总价值，取其最大
                        //前i-1个物品的最优解与第i个物品的价值之和更大
                        if(vw[i-1][j]>vw[i-1][j-w[i]]+v[i]){
                             vw[i][j]=vw[i-1][j];
                        } else {
                            vw[i][j]=vw[i-1][j-w[i]]+v[i];
                        }
                    }
                }
            }
        }

        for(int i = 0 ; i < vw.length; i ++) {
            for (int j = 0; j < vw[i].length; j++) {
                System.out.print(vw[i][j]+"\t");
            }
            System.out.println();
        }

    }
}