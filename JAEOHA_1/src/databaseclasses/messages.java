/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseclasses;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;
import javafx.scene.image.Image;

/**
 *
 * @author abanoub samy
 */
public class messages {
    
    private int messageId;
    private String messageText;
    private Date messageTime;
    private File file;
    private Image img;
    private int fileType;
    private int senderId;
    private int chatId;
    private String messageColor;
    private int fontSize;
    private String fontType;

    public messages(int messageId, String messageText, Date messageTime, File file, Image img, int fileType, int senderId, int chatId, String messageColor, int fontSize, String fontType) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.messageTime = messageTime;
        this.file = file;
        this.img = img;
        this.fileType = fileType;
        this.senderId = senderId;
        this.chatId = chatId;
        this.messageColor = messageColor;
        this.fontSize = fontSize;
        this.fontType = fontType;
    }

    /**
     * @return the messageId
     */
    public int getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    /**
     * @return the messageText
     */
    public String getMessageText() {
        return messageText;
    }

    /**
     * @param messageText the messageText to set
     */
    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    /**
     * @return the messageTime
     */
    public Date getMessageTime() {
        return messageTime;
    }

    /**
     * @param messageTime the messageTime to set
     */
    public void setMessageTime(Date messageTime) {
        this.messageTime = messageTime;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the img
     */
    public Image getImg() {
        return img;
    }

    /**
     * @param img the img to set
     */
    public void setImg(Image img) {
        this.img = img;
    }

    /**
     * @return the fileType
     */
    public int getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(int fileType) {
        this.fileType = fileType;
    }

    /**
     * @return the senderId
     */
    public int getSenderId() {
        return senderId;
    }

    /**
     * @param senderId the senderId to set
     */
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    /**
     * @return the chatId
     */
    public int getChatId() {
        return chatId;
    }

    /**
     * @param chatId the chatId to set
     */
    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    /**
     * @return the messageColor
     */
    public String getMessageColor() {
        return messageColor;
    }

    /**
     * @param messageColor the messageColor to set
     */
    public void setMessageColor(String messageColor) {
        this.messageColor = messageColor;
    }

    /**
     * @return the fontSize
     */
    public int getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize the fontSize to set
     */
    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     * @return the fontType
     */
    public String getFontType() {
        return fontType;
    }

    /**
     * @param fontType the fontType to set
     */
    public void setFontType(String fontType) {
        this.fontType = fontType;
    }
    
    
    
    
}
