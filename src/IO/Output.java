package IO;

import java.io.*;

public class Output {
    public static void main(String[] args) throws Exception {
        File f = new File("/Users/wenglong11/tttttt.text");
        //字节流
        OutputStream ws = new FileOutputStream(f);
        //字符流
        OutputStreamWriter osw = new FileWriter(f,true);

        ws.write(String.valueOf("这是通过字节流写入\n").getBytes());
        ws.flush();
        osw.write("这是通过字符流写入\n");
        osw.flush();


    }
}
