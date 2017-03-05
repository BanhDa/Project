/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.chatserver.socketserver.authentication.imp;

import com.corundumstudio.socketio.SocketIOClient;

/**
 *
 * @author tuantran
 */
public class UnAuthenticatedConnection {
    public SocketIOClient soc;
    public int TTL = 0;
    
//    private static final int ReadSocTimeOut = MessageIO.ReadSocLatency;
    
    public UnAuthenticatedConnection( SocketIOClient soc ){
        this.soc = soc;
//        try {
//            this.soc.wait(ReadSocTimeOut);
//        } catch( Exception ex ) {
//            Util.addErrorLog(ex);
//        }
    }
}
