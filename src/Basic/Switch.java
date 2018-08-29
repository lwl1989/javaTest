package Basic;

public class Switch {
    public static void main(String[] args) {
        char today='日';



        switch(today) {
            case '一':
            case '三':
            case '五':
                System.out.println("未成年");
                break;
            case '二':
            case '四':
            case '六':
                System.out.println("吃油条");
                break;
            case '日':
                System.out.println("吃主席套餐");
                break;
            default:
                System.out.println("日期错误");
        }
    }
}
