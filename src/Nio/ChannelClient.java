package Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ChannelClient {

    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9001));
            // capacity: 容量
            // position: 位置
            // limit:  读写长度   读 == 写模式下的position  写 == capacity
            // mark:  具体位置  调用reset()则恢复到此位置
            //mark <= position <= limit <= capacity
            ByteBuffer b = ByteBuffer.allocate(10);
            b.put("abcdsada".getBytes(Charset.forName("UTF-8")));
            b.flip();
            System.out.println(b);
            b.get();
            b.mark();
            System.out.println(b);
            b.get();
            b.get();
            System.out.println(b);
            b.reset();
            System.out.println(b);
            b.clear();   //clear不是清空  而是恢复到初始位置
            //todo: 此处神坑
            //public final Buffer clear() {
            //        position = 0;
            //        limit = capacity;
            //        mark = -1;
            //        return this;
            //sa
            // }
            //java.nio.HeapByteBuffer[pos=0 lim=3 cap=10]
            //java.nio.HeapByteBuffer[pos=1 lim=3 cap=10]
            //java.nio.HeapByteBuffer[pos=3 lim=3 cap=10]
            //java.nio.HeapByteBuffer[pos=1 lim=3 cap=10]
            sc.write(b);   //发送的是从当前position发到到末尾
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
