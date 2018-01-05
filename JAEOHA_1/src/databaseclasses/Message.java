/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseclasses;

import java.io.File;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import javafx.scene.image.Image;

/**
 *
 * @author abanoub samy
 */
public class Message implements Serializable{
    
    private Integer messageId;
    private String messageText;
    private Date messageTime;
    private Blob file;
//    private Image img;
    private Integer fileType;
    private Integer senderId;
    private Integer chatId;
    private String messageColor;
    private Integer fontSize;
    private String fontType;

    public Message() {
    }

    
    public Message(Integer messageId,String messageText,Date messageTime,Blob file, Image img, Integer fileType, 
            Integer senderId,Integer chatId,String messageColor, Integer fontSize, String fontType) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.messageTime = messageTime;
        this.file = file;
//        this.img = img;
        this.fileType = fileType;
        this.senderId = senderId;
        this.chatId = chatId;
        this.messageColor = messageColor;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }
    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Date getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    public Blob getFile() {
        return file;
    }

    public void setFile(Blob file) {
        this.file = file;
    }

    /*public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }*/

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }
    
    public String getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(String messageColor) {
        this.messageColor = messageColor;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontType() {
        return fontType;
    }

    public void setFontType(String fontType) {
        this.fontType = fontType;
    } 
}
