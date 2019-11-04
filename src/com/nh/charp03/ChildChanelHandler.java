package com.nh.charp03;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

/**
 * @Classname ChildChanelHandler
 * @Description TODO
 * @Date 2019/11/4 6:44 PM
 * @Created by nihui
 */
public class ChildChanelHandler extends ChannelInitializer<SocketChannel> {



    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new TimeServerHandler());
    }
}
