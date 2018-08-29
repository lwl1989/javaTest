package Basic;

public class Loop {

    public static void main(String[] args) {

        int i = 1; // 代表 1 - 5 之间的数字

        // 当变量小于等于 5 时执行循环
        while (i<6) {

            // 输出变量的值，并且对变量加 1，以便于进行下次循环条件判断
            System.out.println(i);
            i++;
        }

        int sum = 0; // 保存 1-50 之间偶数的和

        int num = 2; // 代表 1-50 之间的偶数
        //do while 至少执行一次
        do {
            //实现累加求和

            sum += num;

            num = num + 2; // 每执行一次将数值加2，以进行下次循环条件判断
        } while (num<=50); // 满足数值在 1-50 之间时重复执行循环

        System.out.println(" 50以内的偶数之和为：" + sum );

        sum = 0; // 保存不能被3整除的数之和

        // 循环变量 i 初始值为 1 ,每执行一次对变量加 1，只要小于等于 100 就重复执行循环
        for (i = 1; i<101             ; i++        ) {

            // 变量 i 与 3 进行求模（取余），如果不等于 0 ，则表示不能被 3 整除
            if (i % 3 != 0) {
                sum = sum + i; // 累加求和
            }
        }

        System.out.println("1到100之间不能被3整除的数之和为：" + sum);

        // 保存累加值
        sum = 0;

        // 从1循环到10
        for (i = 1; i <= 10; i++) {

            // 每次循环时累加求和
            sum = sum + i;

            // 判断累加值是否大于20，如果满足条件则退出循环
            if (sum>20) {

                System.out.print("当前的累加值为:" + sum);
                break;
                //退出循环

            }
        }

        sum = 0; // 保存累加值

        for (i = 1; i <= 10; i++) {

            // 如果i为奇数,结束本次循环，进行下一次循环
            if (i%2!=0) {
                continue;
            }

            sum = sum + i;
        }

        System.out.print("1到10之间的所有偶数的和为：" + sum);
        System.out.println();
        System.out.println("打印直角三角形");

        // 外层循环控制行数
        for (i = 1; i < 4; i++             ) {

            // 内层循环控制每行的*号数
            // 内层循环变量的最大值和外层循环变量的值相等
            for (int j = 1;j<=i;j++              ) {

                System.out.print("*");
            }

            // 每打印完一行后进行换行
            System.out.println();
        }

        num = 999;
        int count = 0;


        if (num >= 0  && num<=999999999){
            while(num != 0){
                count++;
                num/=10;
            }
            System.out.println("它是个"+ count+"位的数！");
        } else{
            System.out.println("输入有误！");
        }

        // 变量保存成绩
        int score = 53;

        // 变量保存加分次数
        count = 0;


        //打印输出加分前成绩
        System.out.println("加分前成绩"+score);


        // 只要成绩小于60，就循环执行加分操作，并统计加分次数
        while(score<60) {
            score++;
            count++;
        }

        System.out.println("加分后成绩"+score);
        System.out.println("共加了"+count+"次");


    }
}
