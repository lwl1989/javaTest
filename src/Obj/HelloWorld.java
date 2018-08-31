package Obj;

import java.util.Arrays;

public class HelloWorld {

    public void print() {
        System.out.println("Hello World");
    }

    public void showMyLove() {
        System.out.println("I love coding");
    }

    // 定义一个返回值为double类型的方法
    public    double      calcAvg() {

        double java = 92.5;
        double php = 83.0;
        return  (java + php) / 2; // 计算平均值

        // 使用return返回值
       // return avg;

    }
    /*
     * 功能：输出学生年龄的最大值
     * 定义一个无参的方法，返回值为年龄的最大值
     * 参考步骤：
     * 1、定义一个整形数组 ages ，保存学生年龄，数组元素依次为 18 ,23 ,21 ,19 ,25 ,29 ,17
     * 2、定义一个整形变量 max ,保存学生最大年龄，初始时假定数组中的第一个元素为最大值
     * 3、使用 for 循环遍历数组中的元素，并与假定的最大值比较，如果比假定的最大值要大，则替换当前的最大值
     * 4、使用 return 返回最大值
     */
    public int getMaxAge() {

        int[] ages = {18 ,23 ,21 ,19 ,25 ,29 ,17};
        int max = ages[0];
        for(int i = 1; i<ages.length;i++) {
            if(max < ages[i]) {
                max = ages[i];
            }
        }

        return max;
    }

    public void calcAvg1(int x, int y) {
        System.out.println((double)(x+y)/2);
    }

    public void calcAvg2(double x, double y) {
        System.out.println((x+y)/2);
    }

    /*
     * 功能：将考试成绩排序并输出，返回成绩的个数
     * 定义一个包含整型数组参数的方法，传入成绩数组
     * 使用Arrays类对成绩数组进行排序并输出
     * 方法执行后返回数组中元素的个数
     */
    public int sort(int[] scores){
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));

        //返回数组中元素的个数
        return scores.length;
    }

    public static void main(String[] args) {

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.print();
        helloWorld.showMyLove();
        // 调用hello对象的calcAvg()方法，并将返回值保存在变量avg中
        double avg = helloWorld.calcAvg();

        System.out.println("平均成绩为：" + avg);

        // 调用方法并将返回值保存在变量中
        int maxScore = helloWorld.getMaxAge();

        // 输出最大年龄
        System.out.println("最大年龄为：" + maxScore);

        helloWorld.calcAvg1(94, 81);
        helloWorld.calcAvg2(94, 81);

        int[] scores={79,52,98,81};

        //调用方法，传入成绩数组，并获取成绩的个数
        int count= helloWorld.sort(scores);

        System.out.println("共有"+count+"个成绩信息！");
    }


}
