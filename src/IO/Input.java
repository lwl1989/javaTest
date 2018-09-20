package IO;

import java.io.*;

public class Input {

    public static void main(String[] args) throws Exception {
        //todo: 按照理解 长度应该不一致才对 我需要去读取一致二进制文件进行对比
        File f = new File("/Users/wenglong11/Downloads/yaf-3.0.7/yaf.c");
        //字节流
        InputStream is = new FileInputStream(f);
        //字符流
        InputStreamReader isr = new FileReader(f);

        System.out.println(f.length());
        System.out.println();
        byte b[] = new byte[(int)f.length()] ;
        int temp = 0;
        int len = 0;
        while ((temp = is.read()) != -1) {
            //System.out.println();
            b[len] = (byte) temp;
            len++;
            //System.out.println("内容为:"+new String(b));
        }
        System.out.println("长度为"+len);
        //System.out.println("内容为:"+new String(b));
        char[] c = new char[(int) f.length()];
        len = 0;
        while ((temp =isr.read()) != -1) {
            //System.out.println(temp);
            if(temp > 126) {
                System.out.println(temp);
                continue;
            }
            c[len] = (char) temp;
            len++;
        }

        System.out.println("长度为"+len);
        //System.out.println(c[10000]);
        //System.out.println("内容为:"+new String(c));
    }
}
