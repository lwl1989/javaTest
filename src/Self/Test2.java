package Self;

public class Test2 {

    //2018-8-21 滴滴面试题
    public static void main(String[] args) {


        Linked l1 = new Linked(1);
        Linked l2 = new Linked(2);
        Linked l3 = new Linked(3);
        Linked l4 = new Linked(4);
        Linked l5 = new Linked(5);
        Linked l6 = new Linked(6);
        Linked l7 = new Linked(7);
        Linked l8 = new Linked(8);
        Linked l9 = new Linked(9);

        l1.addNode(l2);
        l2.addNode(l3);
        l3.addNode(l4);
        l4.addNode(l5);
        l5.addNode(l6);
        l6.addNode(l7);
        l7.addNode(l8);
        l8.addNode(l9);
        l9.addNode(l3);

        Linked ll1 = l1;
        Linked ll2 = l1;
        Linked t = null;

        boolean isLoop = false;

        //判断一个链表是否回环
        //使用2个值进行确定  一个是步增为2 一个步增为1  当 步增为2的恒等于步增为1的时候  则表示链表内部有闭环
        //因为步增为2转了一拳又转回来了
        int i = 0;
        int j = 1;
        while (ll1.hasNext()) {

            if(!isLoop) {
                ll1 = ll1.getNext();
                if(ll2.hasNextSec()) {
                    ll2 = ll2.getNext().getNext();
                    if (ll1.equals(ll2)) {
                        t = ll2;
                        isLoop = true;
                        System.out.println("loop");
                    }
                }
                j++;  //相遇点
            }

            if(isLoop) {
                i++;  //环长
                ll1 = ll1.getNext();
                if (ll1.equals(t)) {
                    System.out.println(i);
                    break;
                }
            }
        }
        // 入口等于 相遇点 减去环长
        //长度 =  链表到入口a + 环长度 l

        if(!isLoop) {
            System.out.println("no loop");
        }
        if(isLoop) {
            System.out.println(j + "  " + (j-i) +" ");
        }else{
            System.out.println(j);
        }
    }


}
