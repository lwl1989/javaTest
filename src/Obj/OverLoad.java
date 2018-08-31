package Obj;

import java.util.Arrays;
import java.util.Random;

public class OverLoad {


    public static void main(String[] args) {
        OverLoad overLoad = new OverLoad();

        overLoad.print();
        overLoad.print(231);
        overLoad.print("你好啊");

        // 调用方法并将返回值保存在变量中
        int[] nums = overLoad.getArray(8);

        // 将数组转换为字符串并输出
        System.out.println(Arrays.toString(nums));
        int[] scores = { 89 , -23 , 64 , 91 , 119 , 52 , 73};
        overLoad.getTopn(scores,3);
    }

    public void print() {
        System.out.println("无参的print方法");
    }

    public void print(String name) {
        System.out.println("带有一个字符串参数的print方法，参数值为：" + name);
    }

    public void print(int age) {
        System.out.println("带有一个整型参数的print方法，参数值为：" + age);
    }

    /*
     * 功能：创建指定长度的int型数组，并生成100以内随机数为数组中的每个元素赋值
     * 定义一个带参带返回值的方法，通过参数传入数组的长度，返回赋值后的数组
     */
    public int[] getArray(int length) {
        // 定义指定长度的整型数组
        int[] nums = new int[length];

        // 循环遍历数组赋值
        for (int i=0;i<length;i++) {

            nums[i] = (int)(Math.random()  * 100);
            // 产生一个100以内的随机数，并赋值给数组的每个成员


        }
        return nums; // 返回赋值后的数组
    }

    public void getTopn(int[] scores, int n) {
        if(scores.length < n ) {
            System.out.println("分数个数太少");
        }else{
            int[] nums = new int[n];
            Arrays.sort(scores);


            for (int i = 0, j = 0; i < scores.length && j < n; i++) {
                if(scores[i] < 0 || scores[i] > 100) {
                    continue;
                }
                nums[j] = scores[i];
                j++;

            }
            System.out.println(Arrays.toString(nums));
        }
    }
}

