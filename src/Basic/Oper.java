package Basic;

import java.util.ArrayList;
import java.util.Arrays;

public class Oper {

    public static char[] opeator = {'+','-','*','/','='};
    public static void main(String[] args) {
        String str = "3x+3=10";
        char[] charArray = str.toCharArray();

        ArrayList<String> arr = new ArrayList<>();
        String s = "";
        for(char ch : charArray) {
            if(!indexOf(ch)) {
                s= s.concat(""+ch);
            }else{
                arr.add(s);
                s="";
                arr.add(""+ch);
            }
        }
        if(s!="") {
            arr.add(s);
        }

        System.out.println(arr.toString());


    }

    public static boolean indexOf(char ch) {
        for(char c : opeator) {
            if(ch==c) {
                return true;
            }
        }
        return false;
    }
}
