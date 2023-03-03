package org.example;

import java.io.*;
import java.util.Properties;

import static java.lang.Thread.sleep;

/**
 * author:eifying
 * date:2023/3/3
 */
public class App
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        InputStream input=new FileInputStream("./config.properties");
        Properties properties=new Properties();
        properties.load(input);
        //读取配置
        int port = Integer.parseInt(properties.getProperty("port"));
        GetInfo.exe=properties.getProperty("exe");
        int time=Integer.parseInt(properties.getProperty("time"));
        GetInfo.time=time;
        WebsocketServer.time=time;
        //
        WebsocketServer s = new WebsocketServer(port);
        s.start();
        System.out.println("ChatServer started on port: " + s.getPort());
        System.out.println("exec: "+GetInfo.exe);

//        String tmp=new String();
//        while(true){
//            BufferedReader reader=GetInfo.getInfo();
//            try {
//                while((tmp=reader.readLine())!=null){
//                    s.broadcast(tmp+"\n");
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                sleep(time);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }

    }
}
