/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tuanbanhdanem.projectgraduationchatserver.chatserver.pojos.message;

import com.google.gson.Gson;
import com.tuanbanhdanem.projectgraduationchatserver.chatserver.pojos.message.messagetype.MessageType;
import com.tuanbanhdanem.projectgraduationchatserver.utils.Util;
import com.tuanbanhdanem.projectgraduationchatserver.utils.dateformat.DateFormat;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author tuan
 */
public class Message implements Comparable<Message>{

    public static Gson gson = new Gson();
    
    private String id;
    private String from;
    private String to;
    private MessageType msgType;
    private Date originTime;
    private String value;
    private Long serverTime;
    private long readTime;
    private String ip;

    public Message(String from, String to, MessageType msgType, String value) {
        this.originTime = new Date(Util.currentTime());
        this.id = from + '&' + to + '&' + DateFormat.format_yyyyMMddHHmmssSSS(this.originTime);
        this.from = from;
        this.to = to;
        this.msgType = msgType;
        this.value = value;
    }
    
    public Message( Date clientTime, String from, String to, MessageType type, String value ){
        this.originTime = clientTime;
        this.id = from + "&" + to + "&" + DateFormat.format_yyyyMMddHHmmssSSS( this.originTime );
        this.from = from;
        this.to = to;
        this.msgType = type;
        this.value = value;
    }
    
    public Message( String from, String to, MessageType msgType, String value, long serverTime ){
        this.serverTime = serverTime;
        this.id = from + "&" + to + "&" + DateFormat.format_yyyyMMddHHmmssSSS( this.serverTime );
        this.from = from;
        this.to = to;
        this.msgType = msgType;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public MessageType getMsgType() {
        return msgType;
    }

    public String getValue() {
        return value;
    }

    public Long getServerTime() {
        return serverTime;
    }

    public long getReadTime() {
        return readTime;
    }
    
    public void setReadTime(long readTime) {
        this.readTime = readTime;
    }

    public String getIp() {
        return ip;
    }
    
    
    
    @Override
    public int compareTo(Message o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", from=" + from + ", to=" + to + ", msgType=" + msgType + ", originTime=" + originTime + ", value=" + value + ", serverTime=" + serverTime + ", readTime=" + readTime + ", ip=" + ip + '}';
    }
    
//    public JSONObject toJsonObject() {
//        gson.
//    }
    
}
