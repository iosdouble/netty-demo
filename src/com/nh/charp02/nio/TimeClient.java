package com.nh.charp02.nio;

/**
 * @Classname TimeClinet
 * @Description TODO
 * @Date 2019/8/1 11:16 AM
 * @Created by nihui
 */
public class TimeClient {
    public static void main(String[] args){
        int port = 8080;
        if (args != null && args.length>0) {
            try {
                port = Integer.valueOf(args[0]);
            }catch (NumberFormatException e){

            }
        }

        new Thread (new TiemClientHandle("127.0.0.1",port),"TimeClient-001").start();
    }
}
