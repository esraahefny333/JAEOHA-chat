/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseclasses;

import java.io.Serializable;

/**
 *
 * @author abc
 */
public class Chat implements Serializable{

    private Integer chatId,chatType;
    private String  chatName;

    public Chat()
    {}
    
    public Chat(Integer chatId,String chatName,Integer chatType)
    {
        this.chatId=chatId;
        this.chatName=chatName;
        this.chatType=chatType;
        
    }

    public Integer getChatType() {
        return chatType;
    }

    public void setChatType(Integer chatType) {
        this.chatType = chatType;
    }
    
    public Chat(String chatName,Integer chatType)
    {
        this.chatName=chatName;
        this.chatType=chatType;
    }
    
    
    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }
}