package com.nh.charp01.bio;

import java.io.*;
import java.net.Socket;

public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        BufferedReader in = null;
        PrintWriter out = null;

        try{
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);

            String currentTime = null;
            String body = null;
            while (true){
                body = in.readLine();
                if (body==null){
                    break;
                }
                System.out.println("The time server receive order : "+body);
                currentTime = "QUERY TIME OVER".equalsIgnoreCase(body)? new java.util.Date(System.currentTimeMillis()).toString():"BAD ORDER";
                out.println(currentTime);
            }
        }catch (Exception e){
            if (in!=null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out!=null){
                out.close();
                out = null;
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                socket = null;

            }
        }
    }
}
