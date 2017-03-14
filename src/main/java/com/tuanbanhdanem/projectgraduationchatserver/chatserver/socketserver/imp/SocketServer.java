/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.chatserver.socketserver.imp;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.google.gson.JsonObject;
import com.tuanbanhdanem.projectgraduationchatserver.chatserver.pojos.message.Message;
import com.tuanbanhdanem.projectgraduationchatserver.chatserver.socketserver.IServer;
import com.tuanbanhdanem.projectgraduationchatserver.utils.config.ServerConfig;
import io.socket.client.Socket;

/**
 *
 * @author tuantran
 */
public class SocketServer implements IServer{

    
    
    @Override
    public void run() {
        try {

            Configuration config = new Configuration();
            config.setHostname( ServerConfig.SERVER_HOST );
            config.setPort( ServerConfig.SERVER_PORT );

            SocketIOServer server = new SocketIOServer(config);
            server.addEventListener(Socket.EVENT_CONNECT, String.class, (SocketIOClient client, String data, AckRequest ackSender) -> {
                System.out.println("new connect to server");
            });
            server.addEventListener(Socket.EVENT_MESSAGE, JsonObject.class, (SocketIOClient client,  JsonObject data, AckRequest ackSender) -> {
                System.out.println("gson : " + data);
                Message msg = Message.gson.fromJson(data, Message.class);
                System.out.println("client send message : " + msg);
                client.sendEvent(Socket.EVENT_MESSAGE, "server receiver data success: \'" + msg +  "\'" ); 
            });

//            server.addEventListener(Socket.EVENT_MESSAGE, String.class, (SocketIOClient client, String data, AckRequest ack) -> {
//                System.out.println("data : " + data);
//            });
            server.addEventListener(Socket.EVENT_DISCONNECT, String.class, (SocketIOClient client, String data, AckRequest ack) -> {
                    System.out.println("disconnect");
                });
//
//            server.addEventListener("A", String.class, (SocketIOClient client, String data, AckRequest ack) -> {
//                System.out.println("event A : " + data);
//            });
            server.start();
            System.out.println("start server in port : " + server.getConfiguration().getPort());
    //        config.setWorkerThreads(0);
    //        config.setSocketConfig(new SocketConfig());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void startListen() {
        Thread thread = new Thread(new SocketServer());
        
        thread.start();
    }
    
    public static void main(String[] args) {
        SocketServer serverer = new SocketServer();
        serverer.run();
    }

}
