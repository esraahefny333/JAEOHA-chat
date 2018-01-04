/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseclasses;

/**
 *
 * @author abanoub samy
 */
public class ChatMembers {
    
    private Integer chatId;
    private Integer memberId;

    public ChatMembers() {
    }

    public ChatMembers(Integer chatId, Integer memberId) {
        this.chatId = chatId;
        this.memberId = memberId;
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
     * @return the memberId
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * @param memberId the memberId to set
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
     
    
    
}
