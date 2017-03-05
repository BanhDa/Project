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
import com.corundumstudio.socketio.listener.DataListener;
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
        Configuration config = new Configuration();
        config.setHostname( ServerConfig.SERVER_HOST );
        config.setPort( ServerConfig.SERVER_PORT );
        
        SocketIOServer server = new SocketIOServer(config);
        server.addEventListener(Socket.EVENT_CONNECTING, String.class, (SocketIOClient client, String data, AckRequest ackSender) -> {
            System.out.println("new connect to server");
        });
        server.addEventListener(Socket.EVENT_MESSAGE, String.class, (SocketIOClient client, String data, AckRequest ackSender) -> {
            System.out.println("client send message : " + data);
            client.sendEvent(Socket.EVENT_MESSAGE, "server receiver data success: \'" + data +  "\'" ); 
        });
        server.startAsync();
//        config.setWorkerThreads(0);
//        config.setSocketConfig(new SocketConfig());
        
    }
    
    @Override
    public void startListen() {
        Thread thread = new Thread(new SocketServer());
        
        thread.start();
    }

}
