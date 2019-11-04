package com.nh.charp02.nio;

/**
 * @Classname TimeServer
 * @Description TODO
 * @Date 2019/8/1 10:50 AM
 * @Created by nihui
 */
public class TimeServer {

    public static void main(String[] args){
        int port = 8080;
        if (args!=null && args.length>0){
            try{
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer,"NIO-MultiplexerTimeServer-001").start();
    }
}
