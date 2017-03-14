/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.google.gson.Gson;
import com.tuanbanhdanem.projectgraduationchatserver.chatserver.pojos.message.Message;
import com.tuanbanhdanem.projectgraduationchatserver.chatserver.pojos.message.messagetype.MessageType;
import io.socket.client.IO;
import io.socket.client.Socket;
import java.net.URISyntaxException;

/**
 *
 * @author tuan
 */
public class Client {

    public static void a(String[] args) {
        try {
            Socket socket = IO.socket("http://localhost:"+ 9119);
            socket.on(Socket.EVENT_CONNECT, (Object... os) -> {
                System.out.println("connect success");
            });
            socket.on(Socket.EVENT_DISCONNECT, (Object... os) -> {
                System.out.println("disconnect");
            });
            socket.on(Socket.EVENT_MESSAGE, (Object... args1) -> {
                System.out.println("msg from server : " + args1[0]);
            });

            socket.connect();
            
            while (socket.connected()) {                
                
                socket.connect();
                
                
            }
            socket.send("hello");
            try {
                Thread.sleep(3000);
                System.out.println("hihi");
                Message msg = new Message("client", "server", MessageType.PP, "hello");
                Gson gson = new Gson();
                String json = gson.toJson(msg);
                System.out.println("json: " + json);
//                socket.emit(Socket.EVENT_MESSAGE, msg);
                socket.emit(Socket.EVENT_MESSAGE, msg);
                System.out.println("sended");

            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                System.out.println(ex.toString());
            }
            
            socket.emit(Socket.EVENT_DISCONNECT, "disconnect");
            socket.disconnect();
        } catch (URISyntaxException ex) {
            System.out.println(ex.toString());
        }
    }    
    
    public static void main(String[] args) {
        
        Message msg = new Message("client", "server", MessageType.PP, "hello");
        Gson gson = new Gson();
        String json = gson.toJson(msg);
        System.out.println("json: " + json);
    }
}
