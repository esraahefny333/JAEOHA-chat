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
    
    private Integer messageId;
    private String messageText;
    private Date messageTime;
    private File file;
    private Image img;
    private Integer fileType;
    private Integer senderId;
    private Integer chatId;
    private String messageColor;
    private Integer fontSize;
    private String fontType;

    public messages() {
    }

    
    
    public messages(Integer messageId, String messageText, Date messageTime, File file, Image img, Integer fileType, Integer senderId, Integer chatId, String messageColor, Integer fontSize, String fontType) {
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
    public Integer getMessageId() {
        return messageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(Integer messageId) {
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
    public Integer getFileType() {
        return fileType;
    }

    /**
     * @param fileType the fileType to set
     */
    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    /**
     * @return the senderId
     */
    public Integer getSenderId() {
        return senderId;
    }

    /**
     * @param senderId the senderId to set
     */
    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    /**
     * @return the chatId
     */
    public Integer getChatId() {
        return chatId;
    }

    /**
     * @param chatId the chatId to set
     */
    public void setChatId(Integer chatId) {
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
    public Integer getFontSize() {
        return fontSize;
    }

    /**
     * @param fontSize the fontSize to set
     */
    public void setFontSize(Integer fontSize) {
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