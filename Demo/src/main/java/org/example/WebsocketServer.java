package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.sql.SQLOutput;
import java.util.Random;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import static java.lang.Thread.sleep;

public class WebsocketServer extends WebSocketServer {


    public static int time;
    public WebsocketServer(int port) throws UnknownHostException {
        super(new InetSocketAddress(port));
    }

    public WebsocketServer(InetSocketAddress address) {
        super(address);
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        conn.send("Welcome to the server!"); // This method sends a message to the new client
        broadcast("new connection: " + handshake.getResourceDescriptor()); // This method sends a message to all clients connected
        System.out.println(conn.getRemoteSocketAddress().getAddress().getHostAddress() + " entered the room!");

    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        broadcast(conn + " has left the room!");
        System.out.println(conn + " has left the room!");
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        System.out.println(conn.getRemoteSocketAddress()+": "+message);
//        String tmp=new String();
//        while(true){
//            BufferedReader reader=GetInfo.getInfo();
//            try {
//                while((tmp=reader.readLine())!=null){
//                    broadcast(tmp+"\n");
//                }
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//            try {
//                sleep(time);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//            if(conn.isClosed())break;
//        }
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ex.printStackTrace();
        if (conn != null) {
            // some errors like port binding failed may not be assignable to a specific
            // websocket
        }
    }

    @Override
    public void onStart() {
        System.out.println("Server started!");
        setConnectionLostTimeout(0);
        setConnectionLostTimeout(100);
    }

}
