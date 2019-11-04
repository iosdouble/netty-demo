package com.nh.charp02.nio;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/**
 * @Classname TiemClientHandle
 * @Description TODO
 * @Date 2019/8/1 11:21 AM
 * @Created by nihui
 */
public class TiemClientHandle implements Runnable {

    private String host;
    private int port;
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public TiemClientHandle(String host, int port) {
        this.host = host==null?"127.0.0.1":host;
        this.port = port;
        try {
            selector =Selector.open();
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Override
    public void run() {

    }
}
