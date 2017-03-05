/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.chatserver.socketserver.authentication;

import com.tuanbanhdanem.projectgraduationchatserver.chatserver.socketserver.authentication.imp.UnAuthenticatedConnection;

/**
 *
 * @author tuantran
 */
public interface IAuthenPool {
    public void put( UnAuthenticatedConnection con , int flag);
    
    public UnAuthenticatedConnection poll();
    
    public void startAuthService();
    
    public int getAuthenNumber();
    
    public void putSocket(String soc);
    
    public void remove(String soc);
    
    public int getSocNumber();
}
