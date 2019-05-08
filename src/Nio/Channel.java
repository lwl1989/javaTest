package Nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Objects;

public class Channel {

    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(9001));
            serverSocketChannel.configureBlocking(false);
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
               // socketChannel.configureBlocking(false);
                if(!Objects.isNull(socketChannel)) {
                    Channel.readMessage(socketChannel);
                }
                //System.out.println(socketChannel);

            }
        }catch (IOException e) {
            System.out.println("bind error");
        }
    }

    public static void readMessage(SocketChannel sc)
    {
        ByteBuffer b = ByteBuffer.allocate(3);
        try {
            sc.read(b);
            System.out.println(new String(b.array()));  //接受的是定长   容量长度的信息
        }catch (IOException e) {

        }
    }
}
