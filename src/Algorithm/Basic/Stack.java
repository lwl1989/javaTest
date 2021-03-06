package Algorithm.Basic;

import java.util.ArrayList;

//栈 LIFO(last input first out)  先进
//todo: 要使用能比较的泛型 必须继承 Comparable
//todo: 最小值原文  https://mp.weixin.qq.com/s/tLaRUCEgtQwoFdELZlcsZA
public class Stack<T extends Comparable> {
    public T min = null;
    private ArrayList<T> values;
    private ArrayList<T> support;  //存贮最小值辅助空间
    private ArrayList<Integer> reference;  //存贮最小值索引辅助空间

    {
        values = new ArrayList<T>();
        support = new ArrayList<T>();
        reference = new ArrayList<Integer>();
    }

    public void push(T value) {
        values.add(value);
        //优化方案案 用空间换时间，用辅助队列加速
        if (support.isEmpty()) {
            support.add(value);
        } else {
            T t = support.get(support.size() - 1);
            if (t.compareTo(value) > 0) {
                support.add(value);
            } else {
                support.add(t);
            }
        }

        //优化方案案 把空间替换成存储索引，并且减低冗余
        // 比如  3 5 7 2 0   =》 存贮的索引为  1 4 5
        if (reference.isEmpty()) {
            reference.add(values.size());
        } else {
            //获取上一个最小值的pos
            int pos = reference.get(reference.size() - 1);
            T t = values.get(pos);
            if (t.compareTo(value) > 0) {
                reference.add(values.size());
            }
        }
    }

    public T pop() {
        int pos = values.size() - 1;
        T t = values.remove(values.size() - 1);
        //优化方案1： 如果元素出栈后要重新判断最小值（可能最小值已经被出栈了）
        if (t.equals(min)) {
            min = null;
            for (T t1 : values) {
                if (min == null) {
                    min = t1;
                } else {
                    if (min.compareTo(t1) > 0) {
                        min = t1;
                    }
                }
            }
        }
        System.out.println("单独记录min:" + min);
        System.out.println("空间 O(1) 时间 O(n),如果数据重复，会减少使用空间");
        System.out.println();

        System.out.println("辅助队列记录min:" + support.get(support.size() - 1));
        System.out.println("空间 O(n) 时间 O(1)");
        System.out.println();

        System.out.println("辅助队列2记录min topN(索引),减少了topN的空间复杂度");
        System.out.println("空间 O(n) 时间 O(1),如果数据重复，会减少使用空间");
        if (pos == reference.get(reference.size() - 1)) {
            reference.remove(reference.size() - 1);

        }
        pos = reference.get(reference.size() - 1);
        System.out.println("辅助队列2记录min:" + values.get(pos - 1));
        System.out.println();
        return t;
    }

    public T getMin() throws Exception {
        //增加异常处理 防止空指针
        if (support.isEmpty()) {
            throw new Exception("It's empty");
        }
        return support.get(support.size() - 1);
    }

    public boolean hasNext() {
        return !values.isEmpty();
    }

    public static void main(String[] args) {
        char[] chars = {'{', '[', '{', '}', ']', '(', ')', '}'};

        Stack stack = new Stack();
        //第一种方式 用一个额外空间记录最小值
        for (char c : chars) {
            if (stack.min == null) {
                stack.min = c;
            } else {
                if ((Character) stack.min
                        < c) {
                    stack.min = c;
                }
            }
            stack.push(c);
        }
        char c;
//        while (stack.hasNext()) {
//            c = (char) (stack.pop());
//            System.out.println(c);
//        }

        //stack.pop();
        c = (char) (stack.pop());
        System.out.println();
        System.out.println("min:" + stack.min);
        try {
            System.out.println("min:" + stack.getMin());

        } catch (Exception e) {

        }
        //只能记录一个最小值
        //那假如要获取最小的3个值？？？

        //用一个辅助队列记录

    }
}
