/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver;

import com.tuanbanhdanem.projectgraduationchatserver.chatserver.socketserver.imp.SocketServer;

/**
 *
 * @author tuantran
 */
public class Core {
    
    private static SocketServer socketServer;
    
    static {
        socketServer = new SocketServer();
    }
    
    public static void main(String[] args) {
        socketServer.startListen();;
    }
    
}
