package com.nh.charp01.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class TimeClinet {
    public static void main(String[] args) {
        int port = 8080;
        if (args!=null&&args.length>0){
            port = Integer.valueOf(args[0]);
        }

        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;

        try{
            for (int i = 0; i <10; i++) {

                socket = new Socket("127.0.0.1", port);

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("QUERY TIME OVER");

                System.out.println("Send order  2 server succeed.");


                String resp = in.readLine();
                System.out.println("Now is " + resp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out!=null){
                out.close();
                out =null;
            }
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
