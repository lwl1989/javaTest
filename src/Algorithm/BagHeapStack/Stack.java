package Algorithm.BagHeapStack;

import java.util.ArrayList;

//栈 LIFO(last input first out)  先进
public class Stack <T> {
    private ArrayList values;
    {
        values = new ArrayList();
    }

    public void put(T value) {
        values.add(value);
    }

    public T get() {
       return (T)values.remove(values.size() - 1);
    }

    public boolean hasNext() {
        return !values.isEmpty();
    }

    public static void main(String[] args) {
        char[] chars = {'{','[','{','}',']','(',')','}'};

        Stack stack = new Stack();
        for(char c : chars) {
            stack.put(c);
        }
        char c;
        while (stack.hasNext()) {
            c = (char) (stack.get());
            System.out.println(c);
        }
    }
}
